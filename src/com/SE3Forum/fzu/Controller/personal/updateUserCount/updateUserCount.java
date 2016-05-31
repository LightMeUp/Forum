package com.SE3Forum.fzu.Controller.personal.updateUserCount;

import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.sql.Date;
import java.util.Map;

/**
 * Created by Feng on 5/31/16.
 */
public class updateUserCount extends ActionSupport {
    private String username;
    private String sex;
    private File image;
    private String address;
    private Date birthdate;
    private String email;
    private String origin;
    private String qqnumber;
    private String mobile;
    private String imageFileName;
    private String ImageFileContentType;

    public String execute(){
        UserCountService service = new UserCountService();
        Map session  = (Map)ActionContext.getContext().get("session");
        UserCount userCount = (UserCount) session.get("user");
        try {
            if (!uploadImage(image)){
                return ERROR;
            }
            userCount.setHeadimage(imageFileName);
            userCount.setName(username);
            userCount.setSex(sex);
            userCount.setAddress(address);
            userCount.setBirthDate(birthdate);
            userCount.setEmail(email);
            userCount.setOrigin(origin);
            userCount.setQqnumber(qqnumber);
            userCount.setCellPhone(mobile);
            service.updateServcie(userCount);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }


    }

    public boolean  uploadImage(File file) throws Exception {
        File saved =new  File(Utils.getImageUploadFolder(),imageFileName);

        InputStream ins = null;
        OutputStream ops= null;
        try{
            saved.getParentFile().mkdirs();
            System.out.println(saved);
            ins= new FileInputStream(file);
            ops = new FileOutputStream(saved);

            byte[] b = new byte[1024];
            int len =0;
            while((len = ins.read(b))!=-1){
                ops.write(b,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if (ops!=null) ops.close();
            if (ins!=null)ins.close();
        }
        return true;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageFileContentType() {
        return ImageFileContentType;
    }

    public void setImageFileContentType(String imageFileContentType) {
        ImageFileContentType = imageFileContentType;
    }
}

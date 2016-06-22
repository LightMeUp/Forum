package com.SE3Forum.fzu.Controller.updateUserinfor;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Feng on 5/25/16.
 */
public class UpdateUserCount  extends ActionSupport{

    private String name;            //姓名
    private String sex;             //性别
    private Date  birthDate;         //出生日期
    private String qqnumber;         // QQ联系
    private String cellPhone;       //电话
    private String email;             //邮箱
    private String  origin;           //籍贯
    private String address;      // 地址
    private String year;
    private String month;
    private String day;

    private File image;
    private String imageContentType;
    private String imageFileName;


    public String execute(){
        HttpServletRequest request = ServletActionContext.getRequest();
        show();
        if (image!=null) {
            try {
                if (uploadImage(image) != true) {
                    System.out.println("file upload failed");
                    return ERROR;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ERROR;
            }
        }

            UserCount  userCount =(UserCount) request.getSession().getAttribute("user");
            imageFileName = userCount.getHeadimage();
            userCount.setName(name);
            userCount.setAddress(address);
            userCount.setSex(sex);
            userCount.setHeadimage(imageFileName);
            String birth= year+"-"+month+"-"+day;

            // 修改用户生日时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                 birthDate =dateFormat.parse(birth);
                userCount.setBirthDate(birthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            userCount.setQqnumber(qqnumber);
            userCount.setCellPhone(cellPhone);
            userCount.setEmail(email);
            userCount.setOrigin(origin);
            new UserCountService().updateServcie(userCount);
            request.getSession().setAttribute("user",userCount);
            return SUCCESS;
}


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }



    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    //uploadImage
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
            System.out.println("wen jian shangchuan chenggong");

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if (ops!=null) ops.close();
            if (ins!=null)ins.close();
        }
        return true;
    }

    public void show(){
        System.out.println("******************");
        System.out.println("file:"+image);
        System.out.println("name:"+name);
        System.out.println("sex:"+sex);
        System.out.println("birthday:"+year+"-"+month+"-"+day);
        System.out.println("qqnumber:"+qqnumber);
        System.out.println("mobile:"+cellPhone);
        System.out.println("email:"+email);
        System.out.println("origion:"+origin);
        System.out.println("******************");

    }
}

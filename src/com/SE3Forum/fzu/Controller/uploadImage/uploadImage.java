package com.SE3Forum.fzu.Controller.uploadImage;

import com.SE3Forum.fzu.Util.Utils;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Feng on 5/30/16.
 */
public class uploadImage  extends ActionSupport{
    private File image;
    private String imageContentType;
    private String imageFileName;

    public String execute(){
        try {
            System.out.println("image"+image);
            System.out.println("imageFile"+imageFileName);
            System.out.println("imageFileType"+imageContentType);
            uploadImage(image);
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            // 将图片的名字返回到页面
            JSONObject obj = new JSONObject();
            obj.put("fileName",imageFileName );
            response.getWriter().print(obj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return SUCCESS;
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
}

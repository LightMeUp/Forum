package com.SE3Forum.fzu.Controller.uploadFile;

import com.SE3Forum.fzu.Bean.Data.uploadFile;
import com.SE3Forum.fzu.Bean.users.UserCount;
import com.SE3Forum.fzu.Service.FilesService;
import com.SE3Forum.fzu.Service.UserCountService;
import com.SE3Forum.fzu.Util.Utils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by Feng on 5/25/16.
 */
public class uploadFileAction extends ActionSupport {
    private File file;
    private String fileContentType;
    private String fileFileName;


    public String execute(){

        System.out.println("upload files");
        String userId="";
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies= request.getCookies();
        System.out.println(cookies.length);
        if (Utils.isLogin(request.getCookies())){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("count")){
                    // 获取用户帐号
                    userId= cookie.getValue();
                    System.out.println(userId);
                }
            }
        }
        UserCount userCount = new UserCountService().findService(Integer.parseInt(userId));

        if (userCount==null){
            System.out.println("用户不存在");
            return ERROR;
        }



        System.out.println("save file");
        FilesService filesService = new FilesService();

        System.out.println("fileContentType:"+fileContentType);
        System.out.println("fileFileName:"+fileFileName);
        System.out.println("fileName"+file);

        try {
           if (uploadFiles(file)){
               uploadFile upload = new uploadFile();
               // 设置上传的用户
               upload.setUser(userCount);
               //设置上传日期
               upload.setUploadDate(Utils.getCurrentDate());
               // 设置文件名
               upload.setName(fileFileName);
               upload.setUuid(file.getName());
               filesService.addService(upload);
               return SUCCESS;
           }
            else {
               return ERROR;
           }
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
        // 创建文件uploadFile  将数据保存到数据库



    }
    public boolean  uploadFiles(File file) throws Exception {
        File saved =new  File(Utils.getFileUploadFolder(),fileFileName);

        InputStream ins = null;
        OutputStream ops= null;
        try{
            saved.getParentFile().mkdirs();
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}

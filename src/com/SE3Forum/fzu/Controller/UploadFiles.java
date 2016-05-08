package com.SE3Forum.fzu.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Feng on 5/3/16.
 */
@WebServlet(name = "UploadFiles")
public class UploadFiles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        int ThreadHoldSize  =1024*1024;
        fileItemFactory.setSizeThreshold(ThreadHoldSize);
        File resposity = new File(request.getContextPath()+"/UploadedFiles");
        System.out.println("文件上传目录:"+resposity);
        fileItemFactory.setRepository(resposity);

        ServletFileUpload servletFileUpload = new ServletFileUpload();
        servletFileUpload.setHeaderEncoding("UTF-8");

        try {
            List<FileItem> parseRequest = servletFileUpload.parseRequest(request);
            for (FileItem fileItem:parseRequest){
                if (!fileItem.isFormField()){
                    System.out.println("not a file");
                }
                else {
                    String clientName = fileItem.getName();
                    String filename;
                    if (clientName.contains("\\")) {
                        //如果包含"\"表示是一个带路径的名字,则截取最后的文件名
                        filename = clientName.substring(clientName.lastIndexOf("\\")).substring(1);
                    }else {
                        filename = clientName;
                    }
                    UUID randomUUID = UUID.randomUUID();
                    filename = randomUUID.toString()+filename;
                    int hashUUID =randomUUID.hashCode();
                                     String hexUUID = Integer.toHexString(hashUUID);
                                     //System.out.println(hexUUID);
                                     //获取将上传的文件存存储在哪个文件夹下的绝对路径
                                     String filepath=request.getContextPath()+"UploadedFiles";
                                     for (char c : hexUUID.toCharArray()) {
                                             filepath = filepath+"/"+c;
                                     }
                                     //如果目录不存在就生成八级目录
                                     File filepathFile = new File(filepath);
                                     if (!filepathFile.exists()) {
                                             filepathFile.mkdirs();
                                         }
                                    //从Request输入流中读取文件，并写入到服务器
                                   InputStream inputStream2 = fileItem.getInputStream();
                                     //在服务器端创建文件
                                     File file  = new File(filepath+"/"+filename);
                                     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

                                     byte[] buffer = new byte[10*1024];
                                     int len = 0;
                                     while ((len= inputStream2.read(buffer, 0, 10*1024))!=-1) {
                                             bos.write(buffer, 0, len);
                                         }
                                    System.out.println("文件上传成功");
                    //关闭资源
                                     bos.close();
                                     inputStream2.close();
                                 }
                         }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.SE3Forum.fzu.Struct.Actions;

import com.SE3Forum.fzu.Bean.Data.Files;
import com.SE3Forum.fzu.Bean.users.User;
import com.SE3Forum.fzu.Dao.FilesDao;
import com.SE3Forum.fzu.Struct.FormBeans.UploadForm;
import com.SE3Forum.fzu.Util.Utils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Feng on 5/9/16.
 */
public class uploadFileAction extends Action {
    public ActionForward execute (ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)throws Exception{
        UploadForm uploadForm = (UploadForm)form;
        uploadForm.setRealName(uploadForm.getFile().getFileName());

        if ("upload".equals(uploadForm.getAction())){
            return upload(mapping,uploadForm,request,response);
        }
        return mapping.getInputForward();
    }
    public ActionForward upload(ActionMapping mapping,ActionForm form,
                                HttpServletRequest request,HttpServletResponse response)throws  Exception{
        UploadForm uploadForm = (UploadForm)form;
        StringBuffer buffer = new StringBuffer();
        buffer.append("<style>body {font-size: 12px;}</style>");
        if (uploadForm.getFile()!=null && uploadForm.getFile().getFileSize() > 0){
            String fileUrl = Utils.getFileUploadFolder();
            File uploadFolder = new File(fileUrl);
            if (!uploadFolder.exists()){
                System.out.println("文件不存在");
               boolean tf = uploadFolder.mkdirs();
                if (tf ==false)
                    System.out.println("文件创建失败");
            }

            File file = new File(uploadFolder+"/",uploadForm.getFile().getFileName());
            if(file.exists()){
                System.out.println(file);
            }
            else {
                file.createNewFile();
            }
            OutputStream outputStream = null;
            InputStream inputStream = null;
            try{
                byte[] b = new byte[1024];
                int len =0;
                inputStream = uploadForm.getFile().getInputStream();
                outputStream = new FileOutputStream(file);
                while((len = inputStream.read(b))!=-1)
                    outputStream.write(b,0,len);
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                inputStream.close();
                outputStream.close();
            }
            buffer.append("文件:<a href=upload/"+file.getName()+"target=_blank>" +file.getName() +"</a><br />");
        }else {
            buffer.append("文件: 没有文件上传 <br />");
        }
        buffer.append("备注: "+uploadForm.getText() +"<br />");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(buffer.toString());
         return null;
    }
    // 数据库中保存文件信息, 生成上传记录
    public void recordFileAndSetUploadRecord(UploadForm uploadForm,User user){
        // 获取Form 中上传的文件
        FormFile file = uploadForm.getFile();

        //创建一个com.SE3Forum.fzu.Data.Files 对象
        Files uploadFile = new Files();

        System.out.println("file name "+ file.getFileName());
        // 设置Files对象 FileName
        uploadFile.setFileName(file.getFileName());

        // 生成一个uuid 用户本地文件保存,保证文件不会被同名覆盖
        file.setFileName(Utils.getRandomUUID().toString());
        System.out.println("set filename to uuid "+file.getFileName());
        uploadFile.setUuid(file.getFileName());

        // 设置上传文件的用户
        uploadFile.setUser(user);

        // 设置上传时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String uploadingDate= dateFormat.format(new java.util.Date());

        try {
            //设置数据上传时间
            uploadFile.setUploadingDate(new Date(dateFormat.parse(uploadingDate).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 设置过期时间
        uploadFile.setValidateDate(new Date(uploadForm.getEvaluateDate().getTime()));

        FilesDao filesDao = new FilesDao();
        // 文件保存至数据库
        filesDao.add(uploadFile);

    }
}

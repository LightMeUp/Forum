package com.SE3Forum.fzu.Struct.FormBeans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import java.util.Date;

/**
 * Created by Feng on 5/9/16.
 */
public class UploadForm extends ActionForm {
    private FormFile file;       // 文件
    private String action;       // 方法
    private String text;         //文件描述
    private String realName;     // 真实文件名
    private String uuid;         // 服务器保存的文件名
    private Date evaluateDate;  // 文件有效时间

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {


    }

    public Date getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(Date evaluateDate) {
        this.evaluateDate = evaluateDate;
    }
}

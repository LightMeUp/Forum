package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feng on 6/26/16.
 */
public class HWCheck extends ActionSupport{

    @Override
    public String execute() throws Exception {
        SchoolAssignmentService schoolAssignmenrtSevice=new SchoolAssignmentService();
        String table="schoolAssignment";
        List<SchoolAssignment> schoolAssignments=new ArrayList<>();
        schoolAssignments=schoolAssignmenrtSevice.listAllService(table);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("ZY",schoolAssignments);
        return SUCCESS;
    }
}

package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by zhu on 2016/6/23.
 */
public class ZY extends ActionSupport{
    @Override
    public String execute() throws Exception {
        SchoolAssignmentService schoolAssignmentService=new SchoolAssignmentService();
        HttpServletRequest request= ServletActionContext.getRequest();
      int  id=  Integer.parseInt(request.getParameter("id"));
       System.out.print(id);
        SchoolAssignment schoolAssignment=schoolAssignmentService.findService(SchoolAssignment.class,id);
        System.out.print(schoolAssignment);
        request.setAttribute("sa",schoolAssignment);
        return "success";
    }
}

package com.SE3Forum.fzu.Controller.GSQ;

import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment;
import com.SE3Forum.fzu.Service.EvaluationService;
import com.SE3Forum.fzu.Service.SchoolAssignmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Feng on 6/26/16.
 */
public class HWCheck2 extends ActionSupport{

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int id= Integer.parseInt(request.getParameter("id"));
        SchoolAssignment schoolAssignment= new SchoolAssignmentService().findService(SchoolAssignment.class,id);

        request.setAttribute("sa",schoolAssignment);
        return SUCCESS;
    }
}

package com.SE3Forum.fzu.Struct.Actions;

import com.SE3Forum.fzu.Service.TopicService;
import com.SE3Forum.fzu.Struct.FormBeans.TopicForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Feng on 5/17/16.
 */
public class TopicAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response )
    {
        TopicForm topicForm = (TopicForm)form;
        TopicService topicService = new TopicService();
        topicService.addService(topicForm.getTopic());
        return mapping.findForward("scuccess");
    }

}

package com.SE3Forum.fzu.Struct.Actions;

import com.SE3Forum.fzu.Struct.FormBeans.loginFormBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Feng on 5/5/16.
 */
public class loginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,
                                 HttpServletResponse response){
        loginFormBean loginForm = (loginFormBean)form;
        if (loginForm.getId() == null){
            return mapping.getInputForward();
        }
        else {
            return mapping.findForward("success");
        }
    }
}

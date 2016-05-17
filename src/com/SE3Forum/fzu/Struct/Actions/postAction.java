package com.SE3Forum.fzu.Struct.Actions;

/**
 * Created by Feng on 5/17/16.
 */
import com.SE3Forum.fzu.Service.postService;
import com.SE3Forum.fzu.Struct.FormBeans.postForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class postAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
    {



            return mapping.findForward("success");

    }


}

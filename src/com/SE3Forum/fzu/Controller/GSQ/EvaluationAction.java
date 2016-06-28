package com.SE3Forum.fzu.Controller.GSQ;
import com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation;
import com.SE3Forum.fzu.Service.EvaluationService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Feng on 6/28/16.
 */
public class EvaluationAction extends ActionSupport {
    private String evaluationId;
    private String evaluation;
    private String score;

    public String execute() throws IOException {
        System.out.println("id"+evaluationId);
       Evaluation  eva = (Evaluation) new EvaluationService().findService(Integer.parseInt(evaluationId));
        eva.setScore(Float.parseFloat(score));
        eva.setEvaluate(evaluation);
        new EvaluationService().updateServcie(eva);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.sendRedirect("/HWCheck");
        return null;

    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

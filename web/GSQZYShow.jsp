<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@ page import="com.SE3Forum.fzu.Dao.StudentDao" %>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation" %>
<%@ page import="com.SE3Forum.fzu.Service.EvaluationService" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    SchoolAssignment sa = (SchoolAssignment) request.getAttribute("sa");
    UserCount userCount = (UserCount) session.getAttribute("user");
    System.out.println("sa id"+sa.getId());
    Student student = (Student) new StudentDao().find(Student.class,userCount.getId());
    Evaluation evaluation = new EvaluationService().getEvaluationByStudentAndAssignment(student.getId(),sa.getId());
    System.out.println("evalu"+evaluation);
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>软件工程第<%=sa.getId()%>次作业</title>

	<meta name="description" content="Source code generated using layoutit.com">
	<meta name="author" content="LayoutIt!">

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
		.content{
			margin-top: 40px;
		}


		.siderbar{
			font-size: 20px;
			border: 1px solid #eeeeee;
			text-align: center;
		}

	</style>
</head>
<body>
<div class="container-fluid ">
	<%@include file="navigation.jsp"%>
	<div class="content">
		<!--
		<div class="col-md-3">
			<ul class="nav nav-tabs nav-stacked siderbar">
				<li>
					<a href="GSQHWCheck.jsp">查看作业</a>
				</li>
				<li>
					<a href="GSQHWCreate.jsp">发布作业</a>
				</li>
				<li>
					<a href="GSQGG.jsp">发布公告</a>
				</li>
				<li>
					<a href="GSQZYCreate.jsp">上传资源</a>
				</li>
			</ul>
		</div>
--><div class="col-md-3">
		<ul class="nav nav-tabs nav-stacked siderbar">
			<li>
				<a href="GSQindex.jsp">课程信息</a>
			</li>
			<li>
				<a href="/ZYShow">查看作业</a>
			</li>
            <li>
                <a href="/dataDownload.jsp">资料下载</a>
            </li>
		</ul>
	</div>
		<div class="col-md-8">
			<div class="jumbotron">
				<h3>Homework</h3>
					<div class="form-group">
						<s:iterator value="#request.sa" var="zy">
						<label>
							第
						</label>
							<s:property value="#zy.id"></s:property>
						</s:iterator>
						<label>
						次
						</label>
			</div>

					<div class="form-group">
						<s:iterator value="#request.sa" var="zy">
						<label>
							内容
						</label><br />
							<s:property value="#zy.content"></s:property>
						</s:iterator>
					</div>
                <div class="form-group">
                    <h3>我的答案</h3>
                    <table class="table table-bordered" >
                        <%if (!Utils.isAssignmentSubmitted(sa.getId(),student)){%>
                            <tr><td colspan="6" align="center">作业未提交</td></tr>
                        <%}else{ System.out.println("eee"+evaluation);%>
                        <tr>
                            <td>编号</td>
                            <td ><%=evaluation.getId()%></td>
                            <td>提交日期</td>
                            <td ><%=evaluation.getSubmitDate()%></td>
                            <td>成绩</td>
                            <td ><%=evaluation.getScore()%></td>
                        </tr>
                        <tr>
                            <td>评语</td>
                            <td colspan="5"><%=evaluation.getEvaluate()%></td>
                        </tr>
                        <tr>
                            <td>内容</td>
                            <td colspan="5"><%=evaluation.getContent()%></td>
                        </tr>


                        <%}%>
                        </tbody>
                    </table>
                </div>
					<div class="form-group">
						<form action="ZYUpload.action" method="post">
                            <input name="schoolAssignmentId" value="<%=sa.getId()%>" hidden="hidden"/>
							<script id="container" name="content" type="text/plain">

							</script>
                            <script type="text/javascript">
                                var editor = UE.getEditor('container');
                            </script>
                            <button type="submit" class="btn-success">提交</button>
						</form> </div>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

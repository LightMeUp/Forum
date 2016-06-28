<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	SchoolAssignment schoolAssignment = (SchoolAssignment) request.getAttribute("sa");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Bootstrap 3, from LayoutIt!</title>

	<meta name="description" content="Source code generated using layoutit.com">
	<meta name="author" content="LayoutIt!">

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
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
		<div class="col-md-3">
			<ul class="nav nav-tabs nav-stacked siderbar">
				<li>
					<a href="/TeacherIndex.jsp">课程介绍</a>
				</li>
				<li>
					<a href="/GSQZYCreate.jsp">发布作业</a>
				</li>
				<li>
					<a href="/sendNotificaion.jsp">发布通知</a>
				</li>
				<li>
					<a href="/HWCheck">查看作业</a>
				</li>
				<li>
					<a href="/dataDownload.jsp">资料下载</a>
				</li>
				<li>
					<a href="/">我的学生</a>
				</li>
			</ul>
		</div>
		<div class="col-md-8">
			<div class="col-md-12">
				<table class="table table-bordered">
					<tr>
						<td>作业编号</td>
						<td><%=schoolAssignment.getId()%></td>
						<td>发布时间</td>
						<td><%=Utils.parseDate(schoolAssignment.getPublishDate())%></td>
						<td>截止时间</td>
						<td><%=Utils.parseDate(schoolAssignment.getDeadLine())%></td>
					</tr>
					<tr>
						<td>提交人数</td>
						<td><%=schoolAssignment.getAssignmentNumbers()%></td>
						<td >发布人</td>
						<td colspan="2"><%=schoolAssignment.getTeacher().getId()%></td>
					</tr>
					<tr>
						<td>内容</td>
						<td colspan="5">
							<%=schoolAssignment.getContent()%>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<th>提交学生学号</th>
						<th>姓名</th>
						<th>提交时间</th>
						<th>查看</th>

					</thead>
					<tbody>
					 <%if(schoolAssignment.getEvaluations()==null || schoolAssignment.getAssignmentNumbers()==0){%>
						<tr><td colspan="3" align="center"><%="没有人提交作业"%></td></tr>
					<%}else{
						for(int i=0;i<schoolAssignment.getAssignmentNumbers();i++){
					%>
						<tr>
							<td><%=schoolAssignment.getEvaluations().get(i).getStudent().getId()%></td>
							<td><%=schoolAssignment.getEvaluations().get(i).getStudent().getName()%></td>
							<td><%=schoolAssignment.getEvaluations().get(i).getCreatedDate()%></td>
							<td><a href="/evaluation?evaluationId=<%=schoolAssignment.getEvaluations().get(i).getId()%>">查看</a> </td>
						</tr>
					<%}}%>

					</tbody>
				</table>
			</div>
		</div>

		<%--<div class="col-md-8">--%>
			<%--<div class="col-md-9">--%>
				<%--<table class="table">--%>
					<%--<thead>--%>
					<%--<tr class="tbhead">--%>
						<%--<th>--%>
							<%--学号--%>
						<%--</th>--%>
						<%--<th>--%>
							<%--作业提交情况--%>
						<%--</th>--%>
						<%--<th>--%>
							<%--提交日期--%>
						<%--</th>--%>
					<%--</tr>--%>
					<%--</thead>--%>
					<%--<tbody>--%>
					<%--&lt;%&ndash;--%>
					<%--<%List<SchoolAssignment> schoolAssignments= (List<SchoolAssignment>) request.getAttribute("ZY");%>--%>
					<%--<%for (int i=0;i<schoolAssignments.size();i++){%>--%>
						<%--<tr>--%>
							<%--<td>--%>
								<%--<%=schoolAssignments.get(i).getId()%>--%>
							<%--</td>--%>
						<%--</tr>--%>
					<%--<%}%>  &ndash;%&gt;--%>
					<%--<s:iterator value="#request.ET" id="et" status="st">--%>
						<%--<tr>--%>
							<%--<td>--%>
								<%--<s:property value="#et.student.id"/>--%>
							<%--</td>--%>
							<%--<td><a href="/Download" >查看</a></td>--%>
							<%--<td>--%>
								<%--<s:property value="#et.submitDate"></s:property>--%>
							<%--</td>--%>
						<%--</tr>--%>
					<%--</s:iterator>--%>
					<%--</tbody>--%>
				<%--</table>--%>
			<%--</div>--%>
		<%--</div>--%>

	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

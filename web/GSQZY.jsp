<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@ page import="com.SE3Forum.fzu.Dao.StudentDao" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List<SchoolAssignment> ZY= (List<SchoolAssignment>) request.getAttribute("ZY");
    UserCount userCount = (UserCount) session.getAttribute("user");
    Student student = (Student) new StudentDao().find(Student.class,userCount.getId());
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>我的作业</title>

	<meta name="description" content="Source code generated using layoutit.com">
	<meta name="author" content="LayoutIt!">

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<style type="text/css">
		.content{
			margin-top: 40px;
		}

		.siderbar li{
			list-style: none;
			text-decoration: none;
		}
		a{
			text-decoration: none;
		}
		ul li a{
			color: #34495e;
		}
		.col-md-8{
			border-right: 1px solid #eeeeee;
		}
		.block{
			margin-top: 60px;
		}

		.navbar-brand{
			font-size: 30px;
		}
		.tbhead{
			background-color:rgba(58,188,26,0.27);
		}
	</style>
</head>
<body>
<div class="container-fluid ">
	<!--
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
			</button> <a href="index.jsp" class="navbar-brand">软件工程课程中心</a>
		</div>

	</nav>-->
	<%@include file="navigation.jsp"%>
	<div class="content">
		<div>
			<div class="col-md-3">
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
                    <li>
                        <a href="/">教师信息</a>
                    </li>
				</ul>
			</div>
            <div class="col-md-8">
           <div class="col-md-12">
				<table class="table table-bordered">
					<thead>
					<tr class="tbhead">
						<th>
							#
						</th>
						<th>
							作业题目
						</th>
						<th>
							发布人
						</th>
						<th>
							发布日期
						</th>
						<th>
							截至日期
						</th>
						<th>
							提交状态
						</th>
					</tr>
					</thead>
					<tbody>
                    <%if (ZY==null || ZY.size() <1){%>
                    <tr><td colspan="6" align="center">没有作业发布</td></tr>
                    <%}else{
                        for (SchoolAssignment sa:ZY){%>
                    <tr>
                    <td><%=sa.getId()%></td>
                    <td><a href="/ZY?id=<%=sa.getId()%>">查看</a></td>
                    <td><%=sa.getTeacher().getId()%></td>
                    <td><%=sa.getPublishDate()%></td>
                    <td><%=sa.getDeadLine()%></td>
                    <td><%=Utils.isAssignmentSubmitted(sa.getId(),student)?"已提交":"未提交"%></td>
                    <%}}%>
                    </tr>
					</tbody>
				</table>
			</div>
            </div>
		</div>

	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

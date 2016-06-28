<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.SchoolAssignment" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    UserCount userCount = (UserCount) session.getAttribute("user");
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
					<a href="/GSQZYCreate.jsp">发布作业</a>
				</li>
                <li>
                    <a href="/sendNotificaion.jsp">发布通知</a>
                </li>

				<li>
					<a href="/HWCheck">查看作业</a>
				</li>
				<li>
					<a href="/showStudents?teacherId=<%=userCount.getId()%>">我的学生</a>
				</li>
                <li>
                    <a href="/dataDownload.jsp">资料下载</a>
                </li>
			</ul>
		</div>

		<div class="col-md-8">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" />
				</div>
				<button type="submit" class="btn btn-default">
					按学号查询
				</button>
				<button type="submit" class="btn btn-default">
					按作业查询
				</button>
			</form>
			<div class="col-md-12">
				<table class=" table table-bordered">
					<thead>
					<tr class="tbhead">
						<th>
							#
						</th>
						<th>
							作业提交情况
						</th>
						<th>
							发布日期
						</th>
						<th>
							截至日期
						</th>
						<th>
							提交人数
						</th>
					</tr>
					</thead>
					<tbody>
					<%--
					<%List<SchoolAssignment> schoolAssignments= (List<SchoolAssignment>) request.getAttribute("ZY");%>
					<%for (int i=0;i<schoolAssignments.size();i++){%>
						<tr>
							<td>
								<%=schoolAssignments.get(i).getId()%>
							</td>
						</tr>
					<%}%>  --%>

                    <%for(SchoolAssignment schoolAssignment:(List<SchoolAssignment>)request.getAttribute("ZY")){%>
                    <tr>
                        <td><%=schoolAssignment.getId()%>
                        </td>
                        <td><a href="/HWCheck2?id=<%=schoolAssignment.getId()%>">查看</a></td>
                        <td>
                            <%=Utils.parseDate(schoolAssignment.getPublishDate())%>
                        </td>
                        <td>
                            <%=Utils.parseDate(schoolAssignment.getDeadLine())%>
                        </td>
                        <td>
                            <%=schoolAssignment.getAssignmentNumbers()%>
                        </td>
                    </tr>
                    <%}%>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String date =Utils.parseDate(Utils.getCurrentDate());
    String[] dates = date.split(" ");
    String[] dates2= dates[0].split("-");
    UserCount userCount= (UserCount) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>发布作业</title>

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
                    <a href="/showStudents?teacherId=<%=userCount.getId()%>">我的学生</a>
                </li>

			</ul>
		</div>

		<div class="col-md-8">
			<div class="jumbotron">
				<h3>Homework</h3>

				<form role="form" action="ZYCreate" method="post">
					<div class="form-group">
						<label>
							作业内容
						</label>
						<script id="container" name="content" type="text/plain">

						</script>
                        <script type="text/javascript">
                            var editor = UE.getEditor('container');
                        </script>
					</div>
                    <div class="form-group">
                        作业截止时间

                    <select  name="year">
                        <% for (int i=Integer.parseInt(dates2[0]);i<2018;i++){%>
                        <option selected><%= i%></option>
                        <%}%>
                    </select>-
                        <select  name="month" >
                            <% for (int n=1;n<13;n++){
                                if (dates2[1].equals(""+n)|| dates2[1].equals("0"+n)){%>
                            <option selected><%= n%></option>
                            <%}else {%>
                            <option ><%= n%></option>

                            <%}}%>
                        </select>-
                        <select  name="day" >
                            <% for (int m=1;m<32;m++){
                                if (dates2[2].equals(""+m)||dates2[1].equals("0"+1)){%>
                            <option selected><%= m%></option>
                            <%}else {%>
                            <option ><%= m%></option>

                            <%}}%>
                        </select>
                    </div>
					<button type="submit" class="btn btn-default">
						发布新作业
					</button>
				</form>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

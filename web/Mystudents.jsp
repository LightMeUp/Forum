<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Teacher" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    Set<Student> students = (Set<Student>) request.getAttribute("students");
    UserCount userCount =(UserCount)session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>软件工程学生名单</title>

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
                    <a href="/GSQZYCreate.jsp">发布作业</a>
                </li>
                <li>
                    <a href="/sendNotification">发布通知</a>
                </li>
                <li>
                    <a href="/HWCheck">查看作业</a>
                </li>
                <li>
                    <a href="/HWCheck">资料下载</a>
                </li>
                <li>
                    <a href="/showStudents?teacherId=<%=userCount.getId()%>">我的学生</a>
                </li>

            </ul>
        </div>

        <div class="col-md-8">
            <div class="jumbotron">
                <h3>软件工程学生名单</h3>
                <table class="table-bordered table">
                    <thead>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                    <%if (students==null){%>
                    <tr>
                        <td colspan="3" align="center">没有学生信息</td>
                    </tr>
                    <%}else{%>
                    <%for(Student student:students){%>
                    <tr>
                        <td><%=student.getId()%></td>
                        <td><%=student.getName()%></td>
                        <td><a href="/personal/show?id=<%=student.getId()%>">查看</a> </td>
                    </tr>
                    <%}}%>
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

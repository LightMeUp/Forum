<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" %>
<%@ page import="com.SE3Forum.fzu.Service.TopicService" %>
<%@ page import="com.SE3Forum.fzu.Util.platForumType" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    UserCount userCount =(UserCount) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>软件工程课程中心</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style type="text/css">
        .content{
            margin-top: 35px;
        }

        .siderbar li{
            list-style: none;
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
        .jumbotron{
            border-top: 1px solid #eeeeee;
            background-color: #ffffff;
        }
        .navbar-brand{
            font-size: 30px;
        }
        .navbar-nav{
            float:right;
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
                    <a href="TeacherIndex.jsp">课程信息</a>
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
        <div class="col-md-9">
            <div class="col-md-9">
                <h3>课程介绍</h3>
                <div class="jumbotron">
                    <p style="font-size: 25px;">本课程主要讲授软件工程概述、软件需求、软件设计、软件构造、软件测试、软件维护、软件配置管理、软件工程管理、软件工程过程、软件工程工具与方法、软件质量、相关学科知识域等内容。
                    </p>
                </div>
            </div>
            <div class="col-md-3">
                <h3>教师信息</h3>
                <div class="jumbotron">
                    <p style="font-size: 20px;">
                        <strong>单红</strong><br>所属院系：数学与计算机科学<br> 个人简介：

                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
        <div class="col-md-9">
            <div class="col-md-9">

                <h3>课程通知</h3>
                <div class="jumbotron">
                    <ul>
                        <% List<Topic> topics = new TopicService().findTopicWithplatOption(platForumType.Notification);%>
                        <% if (topics==null || topics.size() <1){%>
                        <li>当前没有通知</li>
                        <%}else{
                            for(Topic topic:topics){
                        %>
                        <li>
                           <a href="/topics?topicid=<%=topic.getId()%>"> <%=topic.getTheme()%> &nbsp;<%=Utils.parseDate(topic.getLastUpdateDate())%></a>
                        </li>
                        <%}}%>
                        <li>
                            课件已上传，请同学们自行下载

                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-3">
                <h3>课程信息</h3>
                <div class="jumbotron">

                    <p style="font-size: 20px;">
                        选课学生数量：143<br>
                        课程通知数：2<br>
                        课程作业数：2<br>
                        教学材料数：16<br>
                    </p>
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

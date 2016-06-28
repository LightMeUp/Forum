<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 6/3/16
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user"  class="com.SE3Forum.fzu.Bean.users.UserCount"/>
<% session = request.getSession();
    user =(UserCount) session.getAttribute("user");
%>

<html>
<head>
    <title>板块的导航条</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Flatfy Free Flat and Responsive HTML5 Template ">
    <meta name="author" content=""/>
    <script src="/js/modernizr-2.6.2.min.js"></script>
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
    <link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
    <style type="text/css">
        #user_image {
            border-radius: 30px;
            align-content: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="navbar navbar-inverse">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a> <a href="/index.jsp" class="brand">软件工程论坛</a>
                        <div class="nav-collapse collapse navbar-responsive-collapse">
                            <ul class="nav navbar-nav">
                                <li><img  id ="user_image"src="/images/header_back.jpg" width="60px" height="60px"></li>
                                <%if(user==null){%>
                                <li class="menuItem"><a href="/login.jsp">登陆</a></li>
                                <%}else {%>
                                <li class="menuItem"><a href="/personal/show?id=<%=user.getId()%>"><%=user.getName()%></a></li>
                                <li class="menuItem"><a href="#useit">我的消息</a></li>
                                <li class="menuItem"><a href="/UserType.action">我的课程</a></li>
                                <li class="menuItem"><a href="#credits">我的脚步</a></li>
                                <%}%>

                                <li class="menuItem"><a href="#contact">论坛设置</a></li>
                                <li class="menuItem"><a href="http://www.fzu.edu.cn">福州大学</a></li>
                                <li class="menuItem"><a href="http://jwch.fzu.edu.cn">教务处</a></li>
                                <li class="menuItem"><a href="http://bbs.fzu.edu.cn">新亭芳苑</a></li>
                                <%if (user!=null){%>
                                <li class="menuItem"><a href="logout.action">退出</a></li>
                                <%}%>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

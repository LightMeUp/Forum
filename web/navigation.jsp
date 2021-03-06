<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/31/16
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="user"  class="com.SE3Forum.fzu.Bean.users.UserCount"/>
<% session = request.getSession();
    user =(UserCount) session.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Flatfy Free Flat and Responsive HTML5 Template ">
    <meta name="author" content="">

    <title>Flatfy – Free Flat and Responsive HTML5 Template</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Google Web Font -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>

    <!-- Custom CSS-->
    <link href="/css/general.css" rel="stylesheet">

    <!-- Owl-Carousel -->
    <link href="/css/custom.css" rel="stylesheet">
    <link href="/css/owl.carousel.css" rel="stylesheet">
    <link href="/css/owl.theme.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/animate.css" rel="stylesheet">

    <!-- Magnific Popup core CSS file -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <![endif]-->
    <style type="text/css">
        #user_image {
            border-radius: 30px;
            align-content: center;
        }
    </style>

    <script>
        function checkLogin(){
            var id = '<%=request.getSession().getAttribute("user") %>';
            if(id==null){
                alert("还未登录,请先登录");
                window.location="/login.jsp";
            }
        }
    </script>
</head>
<body>
<nav class="navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.jsp">软件工程论坛</a>
        </div>

        <div class="collapse navbar-collapse navbar-right navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><img  id ="user_image"src="/images/header_back.jpg" width="60px" height="60px"></li>
                <%if(user==null){%>
                <li class="menuItem"><a href="/login.jsp">登陆</a></li>
                <%}else {%>
                <li class="menuItem"><a href="/personal/show?id=<%=user.getId()%>"><%=user.getName()%></a></li>
                <li class="menuItem"><a href="/personal/Messages?id=<%=user.getId()%>" onclick=" return checkLogin()">我的消息</a></li>
                <li class="menuItem"><a href="">我的脚步</a></li>
                <li class="menuItem"><a href="/UserType.action">我的课程</a></li>
                <%}%>

                <li class="menuItem"><a href="#contact">论坛设置</a></li>
                <li class="menuItem"><a href="http://www.fzu.edu.cn">福州大学</a></li>
                <li class="menuItem"><a href="http://jwch.fzu.edu.cn">教务处</a></li>
                <li class="menuItem"><a href="http://bbs.fzu.edu.cn">新亭芳苑</a></li>
                <%if (user!=null){%>
                <li class="menuItem"><a href="/logout.action">退出</a></li>
                <%}%>
            </ul>
        </div>

    </div>
</nav>

</body>
</html>

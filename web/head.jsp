<%@ page import="com.SE3Forum.fzu.Util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2016/5/26
  Time: 下午 04:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>标题</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="apple-mobile-app-capable" content="yes">
    <meta name="apple-mobile-app-status-bar-style" content="black">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="cononico">
    <meta name="application-name" content="Cononico" >
    <script src="/scripts/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script>
        function  isLogin(){

        }
        function showMessage(){

        }
    </script>

</head>
<body>
<header class="head" id="top">
    <nav class="navbar  navbar-default" role="navigation" >
        <div class="navbar-header">
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <img src="header_back.jpg" class="img-responsive"  width="80" height="50" />
                </li>
                <li>
                    <input  class="text-input-dialog" type="text" placeholder="Search" />
                </li>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right" >
                <li class="active"><img src="header_back.jpg" class="img-circle" width="40px"height="40px" />
                </li>
                <li><% if (!Utils.isLoginBySession(session)){%>

                    <a href="/login.jsp">登陆</a></li>
                <%} else {%>
                    <a href="/showInfor?id=<%=221300201%>"><%="蔡宏锋"%></a>
                <%}%>
                <li><a href="/personal/Messages?id=<%=session.getAttribute("count")%>" onclick="return showMessage()">我的消息</a></li>
                   <li> <a href="#">
                        我的收藏
                        <b class="caret"></b>
                    </a></li>
                <li><a href="#">我的课程</a></li>
                <li><a href="#">福大首页</a></li>
                <li><a href="logout.action">退出</a></li>
                </li>
            </ul>
        </div>
    </nav>
</header>

</body>
</html>

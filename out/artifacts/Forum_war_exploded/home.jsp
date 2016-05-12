<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/13/16
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .header{
            width: 100%;
            height: 5%;
        }
        .center{
            background-color: blue;
            width: 100%;
            height: 130%;
        }

        .center_left{
            float: left;
            background-color:red;
            width: 25%;
            height: 100%;
        }
        .center_left_top{
            height: auto;
            width: 100%;
        }
        .center_left_buttom{
            height: auto;
            width: 100%;
        }
        .center_center{
            float: left;
            background-color:yellow;
            width: 65%;
            height: 100%;
        }
        .center_center_top{
            height: auto;
            width: 100%;
        }
        .center_center_center{
            height: auto;
            width: 100%;
        }
        .center_center_buttom{
            height: auto;
            width: 100%;
        }
        .center_right{
            background-color:black;
            width: 10%;
            height: 100%;
        }
        .tail{
            background-color: aqua;
            width: 100%;
            height: 5%;
        }
    </style>
</head>
<body>
        <div class="header">
            <jsp:include page="header.jsp"/>

        </div>

        <div class="center">
            <div class="center_left">
                <div class="center_left_top">
                <jsp:include page="login.jsp"/>
                </div>
                <div class="center_left_buttom">
                    <jsp:include page="showstatus.jsp"/>
                </div>

            </div>
            <div class="center_center">
                <div class="center_center_top">
                    <jsp:include page="notification.jsp"/>
                </div>
                <div class="center_center_center">
                    <jsp:include page="plat.html"/>
                </div>
                <div class="center_center_buttom">
                    <jsp:include page="hotTpic.jsp"/>
                </div>

            </div>
            <div class="center_right">

            </div>


        </div>
        <div class="tail">
            <jsp:include page="tail.jsp"/>
        </div>


</body>
</html>

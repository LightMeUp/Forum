<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/15/16
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% String base =request.getContextPath();%>
    <title>学习天地精品贴表</title>
    <style type="text/css">
        body{
            background-color: lightblue;
        }
        .header{
            height:5%;
            width:auto;
            float: left;
        }
        .Topic_title{
            margin-left: 5%;
            margin-right: 5%;
        }
        .center{
            height: 180%;
            width: 100%;
            float: left;
            margin-top: 30px;
        }
        .center_center{
            height: 100%;
            width: 80%;
            margin-left: 10%;
            margin-right: 10%;
            background-color: white;
            margin-top: 20px;
        }
        .center_center_left{
            width: 70%;
            height: auto;
            float: left;
        }
        .center_center_right{
            height: auto;
            width: 10%;
            float: left;
        }
        .tail{
            width: 100%;
            height: 5%;
        }

    </style>
</head>
<body>
    <div class="header">
        <jsp:include page="${base}/header.jsp" />
    </div>
    <div class="center">
        <div class="Topic_title">
            <fieldset>
        <jsp:include page="TopicHeader.html"/>
            </fieldset>
        </div>
        <div class="center_center">
            <div class="center_center_left" >
                <fieldset>
                <jsp:include page="all.html"/>
                </fieldset>
            </div>
            <div class="center_center_right">
                <fieldset>
                <jsp:include page="${base}/index_left.jsp"/>
                </fieldset>
            </div>

        </div>
        <div class="center_right"></div>
    </div>
    <div class="tail">
        <jsp:include page="${base}/tail.jsp"/>
    </div>

</body>
</html>

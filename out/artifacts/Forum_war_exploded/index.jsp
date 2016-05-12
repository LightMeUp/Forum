<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@ page import="com.SE3Forum.fzu.Service.StudentService" %>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 4/8/16
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user ;
    String id ="";
    String usertype="";
    String securityToken ="";
    boolean tf =false;
    Cookie []cookies = request.getCookies();
    if(cookies!=null && cookies.length >1) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id") && cookie.getValue() != null) {
                id = cookie.getValue();
                System.out.println("id:" + id);
            } else if (cookie.getName().equals("securitytoken") && cookie.getValue() != null) {
                securityToken = cookie.getValue();
                System.out.println("sercurity:" + securityToken);
            }
        }

    if (usertype.equals("studentType")){
        StudentService studentService = new StudentService();
        user = studentService.findService(Student.class,id);
        if(user !=null){
            if (user.getSecurityToken().equals(securityToken))
                tf = true;
            else {
                tf = false;
            }
        }
        else tf =false;
    }
    }
    else {
        tf =false;
    }

%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .header{
            width: 100%;
            height: 5%;
            border-bottom-width: 0.5px;
        }
        .center{
            width: 100%;
            height: 130%;
            margin-top: 10px;
        }

        .center_left{
            float: left;
            background-color:lightcyan;
            width: 25%;
            height: 100%;
        }
        .center_left_top{
            height: auto;
            width: 100%;
        }
        .center_left_center{
            height: auto;
            width: 100%;
            background-color: deepskyblue;
        }
        .center_left_buttom{

        }
        .center_center{
            float: left;
            background-color:lightgoldenrodyellow;
            width: 50%;
            height: 100%;
            margin-left: 10px;
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
            width: 25%;
            height: 100%;
        }
        .tail{
            width: 100%;
            height: 5%;
            margin-top: 10px;
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
            <% if (tf == true){
                %>
            <jsp:include page="login.jsp"/>
            <%  }else {
            %>
                <jsp:include page="login.jsp"/>
            <%
                }
            %>
        </div>
        <div class="center_left_center">
            <jsp:include page="showstatus.jsp"/>
        </div>
        <div class="center_left_buttom">
            <fieldset >
                <legend>快速链接</legend>
                <table>
                    <tr><td><a href="http://jwch.fzu.edu.cn">福州大学教务处入口>></a> </td></tr>
                    <tr><td><a href="http://yiban.fzu.edu.cn">福大易班入口>></a> </td></tr>
                    <tr><td><a href="http://www.lib.fzu.edu.cn">福州大学图书馆入口>></a> </td></tr>
                    <tr><td><a href="http://www.lib.fzu.edu.cn">福州大学图书馆入口>></a> </td></tr>
                    <tr><td><a href="http://www.csdn.net">CSDN.Net 全球最大中文IT社区>></a> </td></tr>
                    <tr><td><a href="http://stackoverflow.com/">StackOverFlow 网站入口>></a> </td></tr>
                    <tr><td><a href="https://github.com/">GitHub网站入口>></a> </td></tr>
                    <tr><td><a href="http://www.cocoachina.com">CocoaChina 让移动开发更简单>></a> </td></tr>
                    <tr><td><a href="http://www.imooc.com">慕课网,你的指间有改变世界的力量>></a> </td></tr>
                    <tr><td><a href="http://cmcs.fzu.edu.cn">福州大学数学与计算机科学/软件学院>></a> </td></tr>

                </table>
            </fieldset>
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

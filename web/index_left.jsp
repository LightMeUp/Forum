<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="com.SE3Forum.fzu.Service.StudentService" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/17/16
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .center_left_top{
            height: auto;
            width: 100%;
        }
        .center_left_center{
            height: auto;
            width: 100%;
            margin-top: 20px;
        }
        .center_left_buttom{
            margin-top: 20px;
            width:100%;

        }
    </style>
</head>
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
<body>
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
        <fieldset>
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
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 4/30/16
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%= basePath%>">
    <title>福州大学软件工程论坛</title>
    <meta charset="utf-8" />
    <meta name="开发项目组" content="软件工程第三组" />
    <style type="text/css">
        #right_login{
            margin-top: 150px;
            margin-left: 50%;
            margin-right: 23%;
        }
        #login{
            background-color: aqua;
            width: 250px;
            height:30px;
        }
        #regist{
            background-color: aqua;
            width:250px;
            height:30px;
        }
    </style>
</head>
<body>
    <div  id="right_login">
        <fieldset>
            <legend>登 陆</legend>
            <form  action="Controller/Login.servlet" method="post">
            <table id="table"  cellspacing="20px" cellpadding="5px">
                <tr >
                    <td >帐   号</td>
                    <td colspan="2"><input type="text" name="count"> </td>
                </tr>
                <tr >
                    <td >密   码</td>
                    <td colspan="2"><input type="password" name="password" ></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="登    陆"  id ="login" align="center"></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="注     册" id="regist" align="center"></td>
                </tr>
                <tr>
                    <td><input type="radio" name="userType" value="teacher" >Teacher</td>
                    <td><input type="radio" name="userType" value="student" />Student</td>
                    <td><input type="radio" name="userType" value="tourist" />Tourist</td>
                </tr>
                <tr><td colspan="3">游客登陆请点击<a href="/index.jsp">此处>></a></td></tr>
                <tr><td colspan="3">保存登陆信息<input type="radio" value="YES" name="loginOption"></td></tr>
            </table>
        </form>
        </fieldset>
    </div>

</body>
</html>

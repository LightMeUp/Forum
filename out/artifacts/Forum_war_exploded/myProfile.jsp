<%@ page import="com.SE3Forum.fzu.Struct.FormBeans.loginFormBean" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/12/16
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    Cookie idcookie = cookies[0];
    Cookie namecookie = cookies[1];
    Cookie usertypcookie = cookies[2];
    Cookie lastlogincookie = cookies[3];
    Cookie imagecookie = cookies[4];

    String name = URLDecoder.decode(namecookie.getValue(),"UTF-8");


    String url = imagecookie.getValue().equals("")? "/images/header_poto.jpg":Utils.getImageUploadFolder()+"/"+imagecookie.getValue();
    %>
<html>
<head>
    <title>登录完成,显示个人信息</title>
</head>
<body>
<table  id="login">
    <tr >
        <td rowspan="3">
            <img src="<%=url%>" width="80" height="80"></td>
        <td>帐号</td>
        <td><%= idcookie.getValue()%></td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><%= name.equals("")?"未设置":namecookie.getValue()%></td>
    </tr>
    <tr>
        <td>类型</td>
        <td><%= usertypcookie.getValue()%></td>
    </tr>
    <tr >
        <td>最近登录</td>
        <td><%= lastlogincookie.getValue()%></td>
    </tr>
</table>

</body>
</html>

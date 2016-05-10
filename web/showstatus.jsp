<%@ page import="com.SE3Forum.fzu.Struct.FormBeans.loginFormBean" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/10/16
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        loginFormBean loginFormBean =(loginFormBean) request.getAttribute("user");

    %>
    <title>登录信息页面</title>
</head>
    <p>登录帐号:<%= loginFormBean.getId()%></p>
    <p>用户姓名:<%= loginFormBean.getUserType()%></p>
    <p>IP:<%= request.getRemoteAddr()%></p>
    <p>Port:<%= request.getRemotePort()%></p>
    <p>Host:<%= request.getRemoteHost()%></p>
    <p>User:<%= request.getRemoteUser()%></p>
    <p>Server: <%= request.getServerName()%></p>
    <p>ServerPort: <%= request.getServerPort()%></p>
    <p>Other: <%= request.getHeader("user-agent")%></p>
    <p>Lanuage: <%= request.getLocale().getDisplayLanguage()%></p>
<body>

</body>
</html>

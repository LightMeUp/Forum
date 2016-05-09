<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 4/8/16
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String address = request.getLocalAddr();
    int port = request.getRemotePort();
    String userAgent = request.getHeader("user-agent");
    String country = request.getLocale().getCountry();
%>
<html>
  <head>
    <title>软件工程论坛</title>
  </head>
  <body>
    <h1>软件工程论坛</h1>
  <h5>IP地址:<%=address %></h5>
  <h5>端口:<%=port %></h5>
  <h5>客户端信息:<%=userAgent %></h5>
    <h5>客户端信息:<%=country%></h5>
  </body>
</html>

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
%>
<html>
  <head>
    <title>软件工程论坛</title>
  </head>

  <body>
    <jsp:include page="login.jsp" />
      <a href="/controller/showinfor?id=221300201">查看学生信息</a>
    <jsp:include page="uploadFile.jsp"/>
  </body>
</html>

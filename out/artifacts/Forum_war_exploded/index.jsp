<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 4/8/16
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session = request.getSession();
  String count = (String) session.getAttribute("cout");
  String password = (String)session.getAttribute("password");
  if (count == null)
  {
     response.sendRedirect(request.getContextPath()+"/login.do");
  }
%>
<html>
  <head>
    <title>软件工程论坛</title>
  </head>
  <body>
  </body>
</html>

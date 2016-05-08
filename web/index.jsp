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
  String count = (String) session.getAttribute("count");
  String securityToken = (String) session.getAttribute("securityToken");
  if (count != null && )
  {
    %>
  <jsp:include page="@myprofile.jsp" />
<%
    else
  }
%>
<html>
  <head>
    <title>软件工程论坛</title>
  </head>
  <body>
  </body>
</html>

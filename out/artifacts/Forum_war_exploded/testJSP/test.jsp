<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/8/16
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试请求学生信息</title>
    <% request.setAttribute("teacherid",221300201);%>
</head>

<body>
    <a href="/Controller/list?listtype=student">查看学生信息</a>

</body>
</html>

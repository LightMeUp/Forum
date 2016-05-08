<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/8/16
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="title">
        <tr class="student">
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>联系方式</td>
            <td>QQ</td>
        </tr>
        <c:forEach items="students" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.qqNumber}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>

<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/10/16
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<%
    Student student = null;
    if (request.getAttribute("teacher") != null){

    }
    else {
       student = (Student) request.getAttribute("student");
        if (student ==null){
            System.out.println("no data");
        }
    }
%>
<body>
    <table>
        <tr>
            <td>帐号</td>
            <td><%=student.getId() %></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><%=student.getName() %></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><%=student.getSex() %></td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td><%=student.getOrigin() %></td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><%=student.getBirthDate() %></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><%=student.getCellPhone() %></td>
        </tr>
        <tr>
             <td>QQ</td>
            <td><%=student.getQqnumber() %></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><%=student.getEmail() %></td>
        </tr>
        <tr>
            <td>最近登录时间</td>
            <td><%=student.getLastLoginDate() %></td>
        </tr>


    </table>

</body>
</html>

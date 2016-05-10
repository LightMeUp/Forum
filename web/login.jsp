<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/10/16
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试登录界面</title>
</head>
<body>
    <form action="/loginAction.do" method="post">
        <table>
            <tr>
                <td>帐号</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="radio" value="student" checked name="usertype">学生</td>
                <td><input type="radio" value="teacher"  name="usertype">教师</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
         </table>
    </form>

</body>
</html>

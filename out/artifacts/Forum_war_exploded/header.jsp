<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/12/16
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        #header{
            float: right;
            font-size:small;
            margin-right: 30px
        }
    </style>
</head>
<body>
<fieldset>
    <table id="header">
        <tr>
            <td>
            </td>
            <td> <a href="countSetting.jsp">帐号设置</a></td>
            <td><a href="myMessage.jsp"> 我的消息</a></td>
            <td><a href="forumSetting"> 论坛设置</a></td>
            <td><a href="helpCenter.jsp">帮助中心</a></td>
            <td><a href="myCollection.jsp"> 我的收藏</a></td>
            <td><a href="http://www.fzu.edu.cn">福大首页</a></td>
            <td>友情连接</td>
            <td ><a href="/Controller/logout"> 退出</a></td>
        </tr>
    </table>
</fieldset>
</body>
</html>

<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="javax.rmi.CORBA.Util" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/25/16
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userCount" class="com.SE3Forum.fzu.Bean.users.UserCount" scope="page"/>
<%
    userCount = (UserCount) request.getAttribute("user");
    System.out.println(Utils.getImageUploadFolder()+"/"+ userCount.getHeadimage());
%>

<html>
<head>
    <title>显示用户个人信息</title>
    <style type="text/css">
        #header_image_countInfor{
            border-radius: 40px;

        }
    </style>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script>
        function jump(){
            location.href="/updateUserCount.jsp";
        }
    </script>
</head>

<body>

    <%
        if(userCount!=null) {%>
    <div id="user_infor_center_showCountInfor">
    <fieldset>


    <table class="table">
        <tr >
            <td>头像:</td>
            <td><img  id =" header_image_countInfor" src="/uploadedImages/header_back.jpg"  width="80px" height="80px" /></td>
        </tr>
        <tr >
            <td>帐号:</td>
            <td><%=userCount.getId()%></td>
        </tr>
        <tr >
            <td>帐号类型:</td>
            <td><%=userCount.getUserType().equals("Student")?"学生":"教师"%></td>
        </tr>
        <tr >
            <td>姓名:</td>
            <td><%=userCount.getName()!=null?userCount.getName():"未设置"%></td>
        </tr >
        <tr >
            <td>性别:</td>
            <td><%=userCount.getSex()%></td>
        </tr>
        <tr >
            <td>籍贯:</td>
            <td><%=userCount.getOrigin()!=null?userCount.getOrigin():"未设置"%></td>
        </tr>
        <tr >
            <td>出生日期:</td>
            <td><%=userCount.getBirthDate()!=null?userCount.getBirthDate():"未设置"%></td>
        </tr>
        <tr>
            <td>手机:</td>
            <td><%=userCount.getCellPhone()!=null?userCount.getCellPhone():"未设置"%></td>
        </tr>
        <tr >
            <td>邮箱:</td>
            <td><%=userCount.getEmail()!=null?userCount.getEmail():"未设置"%></td>
        </tr>
        <tr >
            <td>QQ:</td>
            <td><%=userCount.getEmail()!=null?userCount.getQqnumber():"未设置"%></td>
        </tr>
        <tr>
            <td>最近一次登录:</td>
            <td><%=userCount.getLastLoginDate()%></td>
        </tr>
        <tr >
            <td>
                <button name="update" value="update" onclick="jump()">update</button>
            </td>
        </tr>
    </table>
    </fieldset>
    </div>

<%}%>
</body>
</html>

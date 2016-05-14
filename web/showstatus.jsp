<%@ page import="com.SE3Forum.fzu.Struct.FormBeans.loginFormBean" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Util.IpUtils" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/10/16
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        loginFormBean loginFormBean =(loginFormBean) request.getAttribute("user");
        if (loginFormBean == null){
            loginFormBean =  new loginFormBean();
            loginFormBean.setId(Utils.getRandomUUID().toString());
        }
       String Ipinfor= IpUtils.getIpInfo(request.getRemoteAddr());
            Ipinfor =Ipinfor.equals("未分配或者内网IP ")?"福州大学":Ipinfor;

    %>
    <style type="text/css">
        body{
            font-size: x-small;
            width:100%;
            height:100%;
        }
        #fieldset{
            border: none;
        }

    </style>
    <title>登录信息页面</title>
</head>
    <fieldset id="fieldset">
        <legend>登录信息</legend>
        <p>用户姓名:<%= loginFormBean.getUser()==null?"游客":loginFormBean.getUser().getName()%></p>
        <p>IP地址:<%= request.getRemoteAddr()%></p>
        <p>登录地点:<%= Ipinfor%></p>
        <p>服务器地址: <%= request.getServerName()%></p>
        <p>服务器端口: <%= request.getServerPort()%></p>
        <p>语言: <%= request.getLocale().getDisplayLanguage()%></p>
        <p>登录时间:<%= Utils.getCurrentDate()%></p>
    </fieldset>
<body>

</body>
</html>

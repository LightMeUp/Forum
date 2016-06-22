<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" session="true" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="java.util.Set" %>
<jsp:useBean id="userCount" class="com.SE3Forum.fzu.Bean.users.UserCount" scope="page"/>
<jsp:useBean id="user" class="com.SE3Forum.fzu.Bean.users.User"/>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/25/16
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%
//    userCount = (UserCount) session.getAttribute("user");
//    System.out.println(Utils.getImageUploadFolder()+"/"+ userCount.getHeadimage());


    // test
    userCount = (UserCount) request.getAttribute("userCount");
    user = (User) request.getAttribute("user");
    session= request.getSession();
    String iswatch = (String) request.getAttribute("isWatch");
    UserCount loginUser= (UserCount) session.getAttribute("user");
%>

<html>
<head>
    <meta charset="utf-8">
    <title><%=userCount.getName()%>的个人中心</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!-- stylesheet css -->
    <link rel="stylesheet" href="/post/css/bootstrap.min.css">
    <link rel="stylesheet" href="/post/css/font-awesome.min.css">
    <link rel="stylesheet" href="/post/css/templatemo-blue.css">
    <script>
        function  jump(){
            window.location="/updateUserCount.jsp";
        }
    </script>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
<!-- header section -->
<jsp:include page="navigation.jsp"/>
<header>
    <div class="container">
        <div class="row">
            <a class="col-md-12 col-sm-12">
                <img src="/images/img3.jpg" class="img-responsive img-circle tm-border" alt="templatemo easy profile">
                <hr>
                <% if(Utils.isLoginBySession(session)==false){%>
                <a href="/watch?id=<%=userCount.getId()%>"><button class="btn-success">关注我</button></a>
                <%} else %>
                <%{
                    if (loginUser !=null && userCount.getId() != loginUser.getId()){
                %>
                    <%if (!iswatch.equals("true")){%>
                <a href="/watch?id=<%=userCount.getId()%>"><button class="btn-success">关注我</button></a>
                <%}else {%>
                <a href="/unwatch?id=<%=userCount.getId()%>"><button class="btn-danger">取消关注</button></a>
                <%}}}%>
                <h1 class="white bold shadow">Write the code,change the world!</h1>
            </div>
        </div>
    </div>
</header>

<!-- about and skills section -->
<section class="container">
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <div class="about">
                <strong>个人资料</strong>
                <table class="table" align="center">
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
                        <td><%=userCount.getSex().equals("male") ||userCount.getSex().equals("男")?"男":"女"%></td>
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
                    <tr><td>地址:</td><td><%=userCount.getAddress()!=null?userCount.getAddress():"未设置"%></td></tr>
                    <tr>
                        <td>最近一次登录:</td>
                        <td><%=userCount.getLastLoginDate()%></td>
                    </tr>
                    <%
                        if (loginUser != null && user.getId() == loginUser.getId()){
                    %>
                    <tr >
                        <td>
                            <button name="update" value="update" onclick="jump()">修改信息</button>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
    </div>
</section>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
<!-- education and languages -->
<!-- contact and experience -->
<section class="container">
    <div class="row">
        <div class="col-md-4 col-sm-12">
            <div class="contact">
                <%Set<UserCount> friends = (Set<UserCount>) request.getAttribute("friends");%>
                <h3>关注的好友</h3>
                <%if (friends==null || friends.size()<1){%>
                <p><i class="fa fa-map-marker"></i>未关注任何好友</p>
                <%}else{%>
                <%for(UserCount userCount1:friends){%>
                <p><i class="fa fa-map-marker"></i> <%=userCount1.getName()%></p>
                <%}}%>
            </div>
        </div>
        <div class="col-md-8 col-sm-12">
            <div class="experience">
                <h3 class="white">最新动态</h3>
                <% Set<Topic> topics = (Set<Topic>) request.getAttribute("topics");
                %>

                <div class="experience-content">
                    <%if (topics==null){%>
                    <h4 class="experience-title accent">这个家伙已经懒惰到极点了</h4>
                    <%}else {for (Topic topic:topics){%>
                    <a href="/topics?topicid=<%=topic.getId()%>"><h4 class="experience-title accent"><%=topic.getContent()%></h4></a>
                    <%}}%>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/tail.html"/>

<!-- footer section -->

<!-- javascript js -->
<script src="/post/js/jquery.js"></script>
<script src="/post/js/bootstrap.min.js"></script>
<script src="/post/js/jquery.backstretch.min.js"></script>
<script src="/post/js/custom.js"></script>

</body>
</html>

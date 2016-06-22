<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/31/16
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userCount" class="com.SE3Forum.fzu.Bean.users.UserCount"/>

<html>
<head>
    <meta charset="utf-8">
    <title>Easy Profile Blue - templatemo</title>
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
            document.getElementsByClassName("infor_user").readonly=false;
        }
    </script>

    <title>更新账户数据</title>
    <% userCount = (UserCount)session.getAttribute("user");
        String[] birth;
        if (userCount.getBirthDate()==null){
            birth =Utils.parseDate(Utils.getCurrentDate()).split("-");
        }
        else
            birth = userCount.getBirthDate().toString().split("-");
    %>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <!-- 引用jquery -->
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/jquery-migrate-1.2.1.min.js"></script>

    <!-- 引用ajaxfileupload.js -->
    <script src="/js/ajaxfileupload.js"></script>

    <script type="text/javascript">
        $(function() {
            //点击打开文件选择器
            $("#image").on('click', function () {
                $('#file').click();
            });
        })
    </script>
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="image-file-visible.js">
    </script>

    <script>
        $(document).ready(function(){
//图片显示插件
            $.imageFileVisible({wrapSelector: "#image-wrap",
                fileSelector: "#file",
                width: 80,
                height: 80,
                radius:40
            });
        });
    </script>
    <style type="text/css">
        #file{opacity:0;filter:alpha(opacity=0);}
    </style>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
<!-- header section -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <img src="/images/img3.jpg" class="img-responsive img-circle tm-border" alt="templatemo easy profile">
                <hr>
                <button class="btn-success">关注我</button>
                <h1 class="white bold shadow">Hi, I am Julia,Creative Director</h1>
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
                <form method="post" action="/updateUserCount.action" enctype="multipart/form-data">
                    <table class="table">
                        <tr >
                            <td>头像:</td>
                            <td>
                                <div>
                                    <img  id ="image" src="/uploadedImages/header_back.jpg"  width="80px" height="80px" />
                                    <input name="image" id="file" type="file" /><br/>
                                </div>
                            </td>
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
                            <td><input type="text"  name="name" value="<%=userCount.getName()!=null?userCount.getName():"未设置"%>"
                                       onkeyup="value=value.replace(/[\d]/g,'')"
                                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))"/></td>
                        </tr >
                        <tr >
                            <td>性别:</td>
                            <td>
                                <% if (userCount.getSex().equals("男") ||userCount.getSex().equals("male")){%>
                                <input type="radio" value="male" name="sex" checked="checked"/>男
                                <input type="radio" value="female"  name="sex"/>女
                                <%}else{%>
                                <input type="radio" value="male" name="sex" />男
                                <input type="radio" value="female"  name="sex" checked="checked"/>女
                                <%}%>
                            </td>

                        </tr>
                        <tr >
                            <td>籍贯:</td>
                            <td><input type="text"  name="origin" value="<%=userCount.getOrigin()!=null?userCount.getOrigin():"未设置"%>"/></td>
                        </tr>
                        <tr >
                            <td>出生日期:</td>
                            <td><select  name="year">
                                <% for (int i=1900;i<2017;i++){
                                    if(birth[0].equals(""+i)){%>
                                <option selected><%= i%></option>
                                <%} else {%>
                                <option ><%= i%></option>
                                <%}}%>
                            </select>-
                                <select  name="month" >
                                    <% for (int n=1;n<13;n++){
                                        if (birth[1].equals(""+n)){%>
                                    <option selected><%= n%></option>
                                    <%}else {%>
                                    <option ><%= n%></option>

                                    <%}}%>
                                </select>-
                                <select  name="day" >
                                    <% for (int m=1;m<32;m++){
                                        if (birth[2].equals(""+m)){%>
                                    <option selected><%= m%></option>
                                    <%}else {%>
                                    <option ><%= m%></option>

                                    <%}}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>手机:</td>
                            <td><input type="text" name="cellPhone" value="<%=userCount.getCellPhone()!=null?userCount.getCellPhone():"未设置"%>"
                                       onkeyup="this.value=this.value.replace(/\D/g,'')"
                                       onafterpaste="this.value=this.value.replace(/\D/g,'')"/></td>
                        </tr>
                        <tr >
                            <td>邮箱:</td>
                            <td><input type="text" name="email" value="<%=userCount.getEmail()!=null?userCount.getEmail():"未设置"%>" onchange="CheckMail(this.value)"/></td>
                        </tr>
                        <tr >
                            <td>QQ:</td>
                            <td><input type="text" name="qqnumber" value="<%=userCount.getEmail()!=null?userCount.getQqnumber():"未设置"%>"/></td>
                        </tr>
                        <tr>
                            <td>地址</td>
                            <td><textarea name="address" rows="5" cols="20" ><%=userCount.getAddress()!=null?userCount.getAddress():"未设置"%></textarea></td>
                        </tr>
                        <tr>
                            <td>最近一次登录:</td>
                            <td><%=userCount.getLastLoginDate()%></td>
                        </tr>
                        <tr >
                            <td></td>
                            <td>
                                <input type="submit" value="确认" />
                                <button name="cancel" onclick="jumpBack()">取消</button>
                            </td>
                        </tr>
                    </table>
                </form>

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
                <h2>关注的好友</h2>
                <p><i class="fa fa-map-marker"></i> 123 Rama IX Road, Bangkok</p>
                <p><i class="fa fa-phone"></i> 010-020-0890</p>
                <p><i class="fa fa-envelope"></i> easy@company.com</p>
                <p><i class="fa fa-globe"></i> www.company.com</p>
            </div>
        </div>
        <div class="col-md-8 col-sm-12">
            <div class="experience">
                <h2 class="white">最新动态</h2>
                <div class="experience-content">
                    <h4 class="experience-title accent">Website Development</h4>
                    <h5>New Media Company</h5><span></span>
                    <h5>2035 January - 2036 April</h5>
                    <p class="education-description">Cras porta tincidunt sem, in sollicitudin lorem efficitur ut. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- footer section -->

<!-- javascript js -->
<script src="/post/js/jquery.js"></script>
<script src="/post/js/bootstrap.min.js"></script>
<script src="/post/js/jquery.backstretch.min.js"></script>
<script src="/post/js/custom.js"></script>

</body>
</html>



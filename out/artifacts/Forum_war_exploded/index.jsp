<%@ page import="com.SE3Forum.fzu.Bean.users.User" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.Student" %>
<%@ page import="com.SE3Forum.fzu.Service.StudentService" %>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 4/8/16
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user ;
    String id ="";
    String usertype="";
    String securityToken ="";
    boolean tf =false;
    Cookie []cookies = request.getCookies();
    if(cookies!=null && cookies.length >1) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id") && cookie.getValue() != null) {
                id = cookie.getValue();
                System.out.println("id:" + id);
            } else if (cookie.getName().equals("securitytoken") && cookie.getValue() != null) {
                securityToken = cookie.getValue();
                System.out.println("sercurity:" + securityToken);
            }
        }

    if (usertype.equals("studentType")){
        StudentService studentService = new StudentService();
        user = studentService.findService(Student.class,id);
        if(user !=null){
            if (user.getSecurityToken().equals(securityToken))
                tf = true;
            else {
                tf = false;
            }
        }
        else tf =false;
    }
    }
    else {
        tf =false;
    }

%>
<html>
<head>
    <title>软件工程论坛</title>
    <style type="text/css">
        body{
            background-color: white;
        }
        .header{
            width: 100%;
            height: 5%;
        }
        .center{
            width: 100%;
            height: 130%;
            margin-top: 30px;
        }

        .center_left{
            float: left;
            width: 25%;
            height: 100%;
            margin-left: 5%;
            border: double;
            border-color:darkgrey;
        }
        .center_left_top{
            height: auto;
            width: 100%;
        }
        .center_left_center{
            height: auto;
            width: 100%;
            margin-top: 20px;
        }
        .center_left_buttom{
            margin-top: 20px;

        }
        .center_center{
            float: left;
            width: 50%;
            height: 100%;
            margin-left: 15px;
            border: double;
            border-width: 0.5px;
            border-color: darkgray;
        }
        .center_center_top{
            height: auto;
            width: 100%;
            border:thin;
            border-width: 0.5px;
            border-color: darkgray;
            margin-top: 30px;
        }
        .center_center_center{
            height: auto;
            width: 100%;
            border:thin;
            border-width: 0.5px;
            border-color: darkgray;
            margin-top: 30px;
        }
        .center_center_buttom{
            height: auto;
            width: 100%;
            border:thin;
            border-width: 0.5px;
            border-color: darkgray;
            margin-top: 30px;

        }
        .center_right{
            width: 5%;
            height: 100%;
        }
        .tail{
            width: 100%;
            height: 5%;
            margin-top: 50px;
        }
        #fieldset{
            border: none;
        }

        * { padding:0; margin:0;}       /*设置所有对像的内边距为0*/
        #photo-list {
            /* 6张图片的宽度（包含宽度、padding、border、图片间的留白）
            计算：6*(100+2*2+1*2+9) - 9
            之所以减去9是第6张图片的右边留白 */
            width:1081px;
            /* 图片的宽度（包含高度、padding、border）
               计算：100+2*2+1*2  */
            height:106px;
            margin:30px auto;
            overflow:hidden;     /*溢出部份将被隐藏*/
            border:1px dashed #ccc;
        }
        #photo-list ul { list-style:none;}
        #photo-list li { float:left; padding-right:9px;}
        #photo-list img { border:1px solid #ddd; background:#fff; padding:2px;}
    </style>
    <script>
        var id = function(el) {          return document.getElementById(el);        },
                c = id('photo-list');
        if(c) {
            var ul = id('scroll'),
                    lis = ul.getElementsByTagName('li'),
                    itemCount = lis.length,
                    width = lis[0].offsetWidth, //获得每个img容器的宽度
                    marquee = function() {
                        c.scrollLeft += 2;
                        if(c.scrollLeft % width <= 1){  //当 c.scrollLeft 和 width 相等时，把第一个img追加到最后面
                            ul.appendChild(ul.getElementsByTagName('li')[0]);
                            c.scrollLeft = 0;
                        };
                    },
                    speed = 50; //数值越大越慢
            ul.style.width = width*itemCount + 'px'; //加载完后设置容器长度
            var timer = setInterval(marquee, speed);
            c.onmouseover = function() {
                clearInterval(timer);
            };
            c.onmouseout = function() {
                timer = setInterval(marquee, speed);
            };
        };
    </script>
    
</head>
<body>
<div class="header">
    <jsp:include page="header.jsp"/>

</div>

<div id="photo-list">  <ul id="scroll">
    <li><a href="#"><img src="images/dm.jpg" width="200px" height="100px" alt=""/></a></li>
    <li><a href="#"><img src="images/fj.jpg" width="200px" height="100px" alt=""/></a></li>
    <li><a href="#"><img src="images/pet.jpg" width="200px" height="100px" alt=""/></a></li>
    <li><a href="#"><img src="images/ss.jpg" width="200px" height="100px" alt=""/></a></li>
    <li><a href="#"><img src="images/kid.jpg" width="200px" height="100px" alt=""/></a></li>
    <li><a href="#"><img src="images/rabbit.jpg" width="200px" height="100px" alt=""/></a></li>    </ul> </div>




<div class="center">
    <div class="center_left">
        <div class="center_left_top">
            <% if (tf == true){
                %>
            <jsp:include page="login.jsp"/>
            <%  }else {
            %>
                <jsp:include page="login.jsp"/>
            <%
                }
            %>
        </div>
        <div class="center_left_center">
            <jsp:include page="showstatus.jsp"/>
        </div>
        <div class="center_left_buttom">
                <legend>快速链接</legend>
                <table>
                    <tr><td><a href="http://jwch.fzu.edu.cn">福州大学教务处入口>></a> </td></tr>
                    <tr><td><a href="http://yiban.fzu.edu.cn">福大易班入口>></a> </td></tr>
                    <tr><td><a href="http://www.lib.fzu.edu.cn">福州大学图书馆入口>></a> </td></tr>
                    <tr><td><a href="http://www.lib.fzu.edu.cn">福州大学图书馆入口>></a> </td></tr>
                    <tr><td><a href="http://www.csdn.net">CSDN.Net 全球最大中文IT社区>></a> </td></tr>
                    <tr><td><a href="http://stackoverflow.com/">StackOverFlow 网站入口>></a> </td></tr>
                    <tr><td><a href="https://github.com/">GitHub网站入口>></a> </td></tr>
                    <tr><td><a href="http://www.cocoachina.com">CocoaChina 让移动开发更简单>></a> </td></tr>
                    <tr><td><a href="http://www.imooc.com">慕课网,你的指间有改变世界的力量>></a> </td></tr>
                    <tr><td><a href="http://cmcs.fzu.edu.cn">福州大学数学与计算机科学/软件学院>></a> </td></tr>

                </table>
        </div>

    </div>
    <div class="center_center">
        <div class="center_center_top">
            <jsp:include page="notification.jsp"/>
        </div>
        <div class="center_center_center">
            <jsp:include page="plat.html"/>
        </div>
        <div class="center_center_buttom">
            <jsp:include page="hotTpic.jsp"/>
        </div>

    </div>
    <div class="center_right">

    </div>


</div>
<div class="tail">
    <jsp:include page="tail.jsp"/>
</div>


</body>
</html>

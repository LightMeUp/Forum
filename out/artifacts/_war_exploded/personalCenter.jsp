<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/31/16
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visual Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">

    <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="/personalCenter/css/font-awesome.min.css" rel="stylesheet">
    <link href="/personalCenter/css/bootstrap.min.css" rel="stylesheet">
    <link href="/personalCenter/css/templatemo-style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">
        function sendRequest(){
            document.getElementsById("right_frame").src="/showCountInfor.jsp";
        }

    </script>
    <style type="text/css">
    #right_frame{
        width: 100%;
        height: 100%;
    }
        #personalCenter_right{
            float: left;
            width: 75%;
            height: 90%;
        }
        #personalCenter_left{
            float: left;
        }
    </style>


</head>
<body>
<!-- Left column -->
<jsp:include page="navigation.jsp"/>
<div class="templatemo-flex-row" id="personalCenter_left">
    <div class="templatemo-sidebar">
        <div class="profile-photo-container">
            <img src="/personalCenter/images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">
            <div class="profile-photo-overlay"></div>
        </div>
        <!-- Search box -->
        <nav class="templatemo-left-nav">
            <ul>
                <li><a href="" class="active" onclick=" return sendRequest()"><i class="fa fa-home fa-fw"></i>个人信息</a></li>
                <li><a href="data-visualization.html"><i class="fa fa-bar-chart fa-fw"></i>我的消息</a></li>
                <li><a href="data-visualization.html"><i class="fa fa-database fa-fw"></i>我的帖子</a></li>
                <li><a href="maps.html"><i class="fa fa-map-marker fa-fw"></i>与我相关</a></li>
                <li><a href="/logout.action"><i class="fa fa-eject fa-fw"></i>退出</a></li>
            </ul>
        </nav>
    </div>

    <!-- Main content -->
    <!-- JS -->
    <script src="/personalCenter/js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script src="/js/jquery-migrate-1.2.1.min.js"></script> <!--  jQuery Migrate Plugin -->
    <script src="https://www.google.com/jsapi"></script> <!-- Google Chart -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

</div>
<div id="personalCenter_right">
    <iframe src="/showInfor?id=221300201"  id="right_frame"></iframe>
</div>
</body>
</html>

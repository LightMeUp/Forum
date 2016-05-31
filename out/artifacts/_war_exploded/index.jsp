<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/24/16
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- FlatFy Theme - Andrea Galanti /-->
<!doctype html>
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="no-js ie9" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Flatfy Free Flat and Responsive HTML5 Template ">
    <meta name="author" content="">

    <title>Flatfy – Free Flat and Responsive HTML5 Template</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Google Web Font -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>

    <!-- Custom CSS-->
    <link href="css/general.css" rel="stylesheet">

    <!-- Owl-Carousel -->
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">

    <!-- Magnific Popup core CSS file -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <script src="js/modernizr-2.6.2.min.js"></script>  <!-- Modernizr /-->
    <script src="js/PIE_IE9.js"></script>
    <script src="js/PIE_IE678.js"></script>

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->

</head>

<body id="home">

<!-- Preloader -->
<div id="preloader">
    <div id="status"></div>
</div>

<!-- FullScreen -->
<div class="intro-header">
    <div class="col-xs-12 text-center abcen1">
        <h1 class="h1_home wow fadeIn" data-wow-delay="0.4s">软件工程论坛</h1>
        <h3 class="h3_home wow fadeIn" data-wow-delay="0.6s">用心分享快乐，用双手创造奇迹</h3>
        <h3>----软件工程第三组</h3>
        <ul class="list-inline intro-social-buttons">
            <li><a href="https://twitter.com/galantiandrea" class="btn  btn-lg mybutton_cyano wow fadeIn" data-wow-delay="0.8s"><span class="network-name">Twitter</span></a>
            </li>
            </li>
        </ul>
    </div>
    <!-- /.container -->
    <div class="col-xs-12 text-center abcen wow fadeIn">
        <div class="button_down ">
            <a class="imgcircle wow bounceInUp" data-wow-duration="1.5s"  href="#whatis"> <img class="img_scroll" src="img/icon/circle.png" alt=""> </a>
        </div>
    </div>
</div>

<!-- NavBar-->
<div><jsp:include page="/navigation.jsp"/></div>
<!-- What is -->
<div id="whatis" class="content-section-b" style="border-top: 0">
    <div class="<container">

        <div class="col-md-6 col-md-offset-3 text-center wrap_title">
            <h2>Where you want to go?</h2>
            <p class="lead" style="margin-top:0">chose one platform that you want to join</p>

        </div>

        <div class="row">

            <div class="col-sm-4 wow fadeInDown text-center">
                <img class="rotate" src="img/icon/tweet.svg" alt="Generic placeholder image">
                <h3>学习天地</h3>
                <p class="lead">对世界上的一切学问与知识的掌握也并非难事,只要持之以恒地学习,努力掌握规律,达到熟悉的境地,就能融会贯通,运用自如了. —— 高士其
                </p>

                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

            <div class="col-sm-4 wow fadeInDown text-center">
                <img  class="rotate" src="img/icon/picture.svg" alt="Generic placeholder image">
                <h3>灌水区</h3>
                <p class="lead">在快乐时，朋友会认识我们;在患难时，我们会认识朋友。——柯林斯 </p>
                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

            <div class="col-sm-4 wow fadeInDown text-center">
                <img  class="rotate" src="img/icon/retina.svg" alt="Generic placeholder image">
                <h3>资料库</h3>
                <p class="lead">Epsum factorial non deposit quid pro quo hic escorol. Olypian quarrels et gorilla congolium sic ad nauseum. </p>
                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

        </div><!-- /.row -->

        <div class="row tworow">

            <div class="col-sm-4  wow fadeInDown text-center">
                <img class="rotate" src="img/icon/laptop.svg" alt="Generic placeholder image">
                <h3>其他</h3>
                <p class="lead">人生的磨难是很多的，所以我们不可对于每一件轻微的伤害都过于敏感。在生活磨难面前，精神上的坚强和无动于衷是我们抵抗罪恶和人生意外的最好武器。 —— 洛克
                </p>
                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

            <div class="col-sm-4 wow fadeInDown text-center">
                <img  class="rotate" src="img/icon/map.svg" alt="Generic placeholder image">
                <h3>开发团队</h3>
                <p class="lead">开发团队介绍，点击查看开发人员</p>
                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

            <div class="col-sm-4 wow fadeInDown text-center">
                <img  class="rotate" src="img/icon/browser.svg" alt="Generic placeholder image">
                <h3>问题交流</h3>
                <p class="lead"> 网站BUG，问题反馈区，有好的意见也请及时提出，攻城狮们会努力完善的</p>
                <!-- <p><a class="btn btn-embossed btn-primary view" role="button">View Details</a></p> -->
            </div><!-- /.col-lg-4 -->

        </div><!-- /.row -->
    </div>
</div>

<!-- Use it -->
<div id ="useit" class="content-section-a">

    <div class="container">

        <div class="row">

            <div class="col-sm-6 pull-right wow fadeInRightBig">
                <img class="img-responsive " src="img/ipad.png" alt="">
            </div>

            <div class="col-sm-6 wow fadeInLeftBig"  data-animation-delay="200">
                <h1 class="section-heading">福州大学</h1>
                <div class="sub-title lead3">福州大学是国家“211工程”重点建设高校<br> 创建于1958年，现已发展成为一所以工为主、理工结合，理、工、经、管、文、法、艺等多学科协调发展的重点大学。</div>
                <p class="lead">
                    学校目前拥有福州旗山、怡山、铜盘和厦门集美、鼓浪屿等多个校区，占地5000余亩。
                    办学主体位于福州地区大学新区旗山校区，现有校舍建筑总面积110余万平方米，运动场地 14余万平方米。
                    固定资产总值29余亿元，其中教学科研仪器设备值10余亿元。
                    图书馆藏书310余万册，中外文纸质期刊2216种，电子图书212万册。
                    信息办网络中心是中国教育和科研计算机网福州主节点。<a href="http://www.fzu.edu.cn/html/xxgk/1.html">>>>点击查看详细</a>
                </p>

                <p><a class="btn btn-embossed btn-primary" href=="http://www.fzu.edu.cn/html/xxgk/1.html" role="button">更多介绍</a>
                    <a class="btn btn-embossed btn-info" href="www.fzu.edu.cn" role="button">福州大学</a></p>
            </div>
        </div>
    </div>
    <!-- /.container -->
</div>

<div class="content-section-b">

    <div class="container">
        <div class="row">
            <div class="col-sm-6 wow fadeInLeftBig">
                <div id="owl-demo-1" class="owl-carousel">
                    <a href="img/iphone.png" class="image-link">
                        <div class="item">
                            <img  class="img-responsive img-rounded" src="img/iphone.png" alt="">
                        </div>
                    </a>
                    <a href="img/iphone.png" class="image-link">
                        <div class="item">
                            <img  class="img-responsive img-rounded" src="img/iphone.png" alt="">
                        </div>
                    </a>
                    <a href="img/iphone.png" class="image-link">
                        <div class="item">
                            <img  class="img-responsive img-rounded" src="img/iphone.png" alt="">
                        </div>
                    </a>
                </div>
            </div>

            <div class="col-sm-6 wow fadeInRightBig"  data-animation-delay="200">
                <h3 class="section-heading">Drag Gallery</h3>
                <div class="sub-title lead3">软件工程是一门研究用工程化方法构建和维护有效的、实用的和高质量的软件的学科。<br>它涉及程序设计语言、数据库、软件开发工具、系统平台、标准、设计模式等方面</div>
                <p class="lead">
                    在现代社会中，软件应用于多个方面。
                    典型的软件有电子邮件、嵌入式系统、人机界面、办公套件、操作系统、编译器、数据库、游戏等。
                    同时，各个行业几乎都有计算机软件的应用，如工业、农业、银行、航空、政府部门等。
                    这些应用促进了经济和社会的发展，也提高了工作效率和生活效率。
                </p>

                <p><a class="btn btn-embossed btn-primary" href="http://baike.baidu.com/link?url=FpGVUYzyy1lbMuWPuN59j0-JjOIrU3ZGtqfss36pvbKDnSf9LnZcEewmvqPes_sRKpfB-6TCjoDqyAJDSBN8xnmL57btQU9ef76-HEiC9TO" role="button">查看更多</a>
                    <a class="btn btn-embossed btn-info" href="https://en.wikipedia.org/wiki/Main_Page" role="button">维基百科</a></p>
            </div>
        </div>
    </div>
</div>

<div class="content-section-a">

    <div class="container">

        <div class="row">

            <div class="col-sm-6 pull-right wow fadeInRightBig">
                <img class="img-responsive " src="img/doge.png" alt="">
            </div>

            <div class="col-sm-6 wow fadeInLeftBig"  data-animation-delay="200">
                <h3 class="section-heading">Font Awesome & Glyphicon</h3>
                <p class="lead">A special thanks to Death to the Stock Photo for
                    providing the photographs that you see in this template.
                </p>

                <ul class="descp lead2">
                    <li><i class="glyphicon glyphicon-signal"></i> Reliable and Secure Platform</li>
                    <li><i class="glyphicon glyphicon-refresh"></i> Everything is perfectly orgainized for future</li>
                    <li><i class="glyphicon glyphicon-headphones"></i> Attach large file easily</li>
                </ul>
            </div>
        </div>
    </div>

</div>


<!-- Credits -->
<div id="credits" class="content-section-a">
    <div class="container">
        <div class="row">

            <div class="col-md-6 col-md-offset-3 text-center wrap_title">
                <h2>Credits</h2>
                <p class="lead" style="margin-top:0">A special thanks to Death.</p>
            </div>

            <div class="col-sm-6  block wow bounceIn">
                <div class="row">
                    <div class="col-md-4 box-icon rotate">
                        <i class="fa fa-desktop fa-4x "> </i>
                    </div>
                    <div class="col-md-8 box-ct">
                        <h3> Bootstrap </h3>
                        <p> Lorem ipsum dolor sit ametconsectetur adipiscing elit. Suspendisse orci quam. </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 block wow bounceIn">
                <div class="row">
                    <div class="col-md-4 box-icon rotate">
                        <i class="fa fa-picture-o fa-4x "> </i>
                    </div>
                    <div class="col-md-8 box-ct">
                        <h3> Owl-Carousel </h3>
                        <p> Nullam mo  arcu ac molestie scelerisqu vulputate, molestie ligula gravida, tempus ipsum.</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row tworow">
            <div class="col-sm-6  block wow bounceIn">
                <div class="row">
                    <div class="col-md-4 box-icon rotate">
                        <i class="fa fa-magic fa-4x "> </i>
                    </div>
                    <div class="col-md-8 box-ct">
                        <h3> Codrops </h3>
                        <p> Lorem ipsum dolor sit ametconsectetur adipiscing elit. Suspendisse orci quam. </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 block wow bounceIn">
                <div class="row">
                    <div class="col-md-4 box-icon rotate">
                        <i class="fa fa-heart fa-4x "> </i>
                    </div>
                    <div class="col-md-8 box-ct">
                        <h3> Lorem Ipsum</h3>
                        <p> Nullam mo  arcu ac molestie scelerisqu vulputate, molestie ligula gravida, tempus ipsum.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Banner Download -->
<div id="downloadlink" class="banner">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center wrap_title">
                <h2>Download Free</h2>
                <p class="lead" style="margin-top:0">Pay with a Tweet</p>
                <p><a class="btn btn-embossed btn-primary view" role="button">Free Download</a></p>
            </div>
        </div>
    </div>
</div>

<!-- Contact -->
<div id="contact" class="content-section-a">
    <div class="container">
        <div class="row">

            <div class="col-md-6 col-md-offset-3 text-center wrap_title">
                <h2>Contact Us</h2>
                <p class="lead" style="margin-top:0">A special thanks to Death.</p>
            </div>

            <form role="form" action="" method="post" >
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="InputName">Your Name</label>
                        <div class="input-group">
                            <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="InputEmail">Your Email</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="InputEmail" name="InputEmail" placeholder="Enter Email" required  >
                            <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="InputMessage">Message</label>
                        <div class="input-group">
                            <textarea name="InputMessage" id="InputMessage" class="form-control" rows="5" required></textarea>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-ok form-control-feedback"></i></span>
                        </div>
                    </div>

                    <input type="submit" name="submit" id="submit" value="Submit" class="btn wow tada btn-embossed btn-primary pull-right">
                </div>
            </form>

            <hr class="featurette-divider hidden-lg">
            <div class="col-md-5 col-md-push-1 address">
                <address>
                    <h3>Office Location</h3>
                    <p class="lead"><a href="#">The Pentagon<br>
                        Washington, DC 20301</a><br>
                        Phone: XXX-XXX-XXXX<br>
                        Fax: XXX-XXX-YYYY</p>
                </address>

                <h3>Social</h3>
                <li class="social">
                    <a href="#"><i class="fa fa-facebook-square fa-size"> </i></a>
                    <a href="#"><i class="fa  fa-twitter-square fa-size"> </i> </a>
                    <a href="#"><i class="fa fa-google-plus-square fa-size"> </i></a>
                    <a href="#"><i class="fa fa-flickr fa-size"> </i> </a>
                </li>
            </div>
        </div>
    </div>
</div>



<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h3 class="footer-title">Follow Me!</h3>
                <p>Vuoi ricevere news su altri template?<br/>
                    Visita Andrea Galanti.it e vedrai tutte le news riguardanti nuovi Theme!<br/>
                    Go to: <a  href="#" target="_blank">andreagalanti.it</a>
                </p>

                <!-- LICENSE -->
                <a rel="cc:attributionURL" href="#"
                   property="dc:title">Flatfy Theme </a> by
                <a rel="dc:creator" href="#"
                   property="cc:attributionName">Andrea Galanti</a>
                is licensed to the public under
                <BR>the <a rel="license"
                           href="#">Creative
                Commons Attribution 3.0 License - NOT COMMERCIAL</a>.


            </div> <!-- /col-xs-7 -->

            <div class="col-md-5">
                <div class="footer-banner">
                    <h3 class="footer-title"></h3>
                    <ul>
                        <li>软件工程实践第三项目组</li>
                        <li>MAIL:HF_KIA@LIVE.COM</li>
                        <li>版权所有，如有雷同，纯属你抄我</li>
                        <li>2016-2017</li>
                        <li>地址：福州市福州大学博学苑</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- JavaScript -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/script.js"></script>
<!-- StikyMenu -->
<script src="js/stickUp.min.js"></script>
<script type="text/javascript">
    jQuery(function($) {
        $(document).ready( function() {
            $('.navbar-default').stickUp();

        });
    });

</script>
<!-- Smoothscroll -->
<script type="text/javascript" src="js/jquery.corner.js"></script>
<script src="js/wow.min.js"></script>
<script>
    new WOW().init();
</script>
<script src="js/classie.js"></script>
<script src="js/uiMorphingButton_inflow.js"></script>
<!-- Magnific Popup core JS file -->
<script src="js/jquery.magnific-popup.js"></script>
</body>

</html>



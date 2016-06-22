<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Topic topic = (Topic) request.getAttribute("topic");%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!-- stylesheet css -->
    <link rel="stylesheet" href="/post/css/bootstrap.min.css">
    <link rel="stylesheet" href="/post/css/font-awesome.min.css">
    <link rel="stylesheet" href="/post/css/templatemo-blue.css">
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
    <style type="text/css">
        .post_up{
            float: left;
            border-right: groove;
        }
        .header_image{
            margin-bottom: 10px;
            margin-right: 20px;
            border-radius: 60px;
        }
        .watch_button{
            margin-right: 20px;
        }
        .detail_label{
            margin-right: 20px;
        }
        .level_label{
            margin-right: 20px;
            align-items:center;
        }
        #flip{
            margin-left: 30%;
        }
    </style>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
 <jsp:include page="/navigation.jsp"/>

<!-- header section -->

<header>
    <section class="container">
        <div class="row">
            <div >
                <div class="languages">
                    <div class="post_up">
                        <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                        <button  class="watch_button" >关注</button>
                        <h5><%=topic.getUser().getName()%></h5>
                        <h5 class="detail_label">回复999:关注999</h5>
                        <h5 class="level_label">Lv:999</h5>
                    </div>
                    <div >
                        <h3><%=topic.getTheme()%></h3>
                        <p><%=topic.getContent()%></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</header>

<!-- about and skills section -->
<section class="container">
    <div class="row">
        <div class="col-md-6 col-sm-12">
            <div class="about">
                <div class="post_up">
                    <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                    <button  class="watch_button" >关注</button>
                    <h5 class="detail_label">回复999:关注999</h5>
                    <h5 class="level_label">Lv:999</h5>
                </div>
                <div >
                    <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-sm-12">
            <div class="skills">
                <div class="post_up">
                    <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                    <button  class="watch_button" >关注</button>
                    <h5 class="detail_label">回复999:关注999</h5>
                    <h5 class="level_label">Lv:999</h5>
                </div>
                <div >
                    <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- education and languages -->
<section class="container">
    <div class="row">
        <div class="col-md-6 col-sm-12">
            <div class="languages">
                <div class="post_up">
                    <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                    <button  class="watch_button" >关注</button>
                    <h5 class="detail_label">回复999:关注999</h5>
                    <h5 class="level_label">Lv:999</h5>
                </div>
                <div >
                    <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfdss<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-sm-12">
            <div class="languages">
                <div class="post_up">
                    <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                    <button  class="watch_button" >关注</button>
                    <h5 class="detail_label">回复999:关注999</h5>
                    <h5 class="level_label">Lv:999</h5>
                </div>
                <div >
                    <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfdss<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                        adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                </div>
            </div>
        </div>
    </div>
</section>
 <section class="container">
     <div class="row">
         <div class="col-md-6 col-sm-12">
             <div class="languages">
                 <div class="post_up">
                     <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                     <button  class="watch_button" >关注</button>
                     <h5 class="detail_label">回复999:关注999</h5>
                     <h5 class="level_label">Lv:999</h5>
                 </div>
                 <div >
                     <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfdss<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                 </div>
             </div>
         </div>
         <div class="col-md-6 col-sm-12">
             <div class="languages">
                 <div class="post_up">
                     <img src="/images/img1.jpg" width="120px" height="120px" class="header_image"/><br>
                     <button  class="watch_button" >关注</button>
                     <h5 class="detail_label">回复999:关注999</h5>
                     <h5 class="level_label">Lv:999</h5>
                 </div>
                 <div >
                     <p>  adsfshfkjshdfljkhsdlkhfkjsdlhfdss<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br>
                         adsfshfkjshdfljkhsdlkhfkjsdlhfds<br></p>
                 </div>
             </div>
         </div>
     </div>
 </section>
<!-- contact and experience -->
 <div class="container-fluid" >
     <div class="row-fluid">
         <div class="span12">
             <div class="pagination" id="Flip">
                 <ul>
                     <li>
                         <a href="#">上一页</a>
                     </li>
                     <li>
                         <a href="#">1</a>
                     </li>
                     <li>
                         <a href="#">2</a>
                     </li>
                     <li>
                         <a href="#">3</a>
                     </li>
                     <li>
                         <a href="#">4</a>
                     </li>
                     <li>
                         <a href="#">5</a>
                     </li>
                     <li>
                         <a href="#">6</a>
                     </li>
                     <li>
                         <a href="#">7</a>
                     </li>
                     <li>
                         <a href="#">8</a>
                     </li>
                     <li>
                         <a href="#">9</a>
                     </li>
                     <li>
                         <a href="#">10</a>
                     </li>
                     <li>
                         <a href="#">下一页</a>
                     </li>
                 </ul>
             </div>
         </div>
     </div>
 </div>
 <div class="row">
     <div class="col-md-12 col-sm-12">
         <div class="about">
 <form action="/post.action" method="post">
     <!-- 加载编辑器的容器 -->
     <input name="topicId" value="<%=topic.getId()%>" hidden="hidden" />
     <script id="container" name="content" type="text/plain">
            这里写你的初始化内容
        </script>
     <input type="submit" value="submit" />
 </form>
 <!-- 实例化编辑器 -->
 <script type="text/javascript">
     var editor = UE.getEditor('container');
 </script>
        </div>
     </div>
 </div>
    <jsp:include page="/tail.html"/>

<!-- javascript js -->
<script src="/post/js/jquery.js"></script>
<script src="/post/js/bootstrap.min.js"></script>
<script src="/post/js/jquery.backstretch.min.js"></script>
<script src="/post/js/custom.js"></script>

</body>
</html>

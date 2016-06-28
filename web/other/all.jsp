<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/26/16
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <jsp:useBean id="topic" class="com.SE3Forum.fzu.Bean.Post_Comments.Topic"/>
    <jsp:useBean id="user" class="com.SE3Forum.fzu.Bean.users.UserCount" />
    <title>学习版块主题列表</title>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
    <%
        List<Topic> topics = (List<Topic>) request.getAttribute("topics");
        List<UserCount> users =(List<UserCount>) request.getAttribute("users");
        List<Topic> notifications = (List<Topic>) request.getAttribute("notification");
    %>
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
    <link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/pat_navigation.jsp"/>
<div class="row-fluid">
    <div class="span2">
    </div>
    <div class="span6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">学习天地</h3>
            </div>
            <div class="panel-body">
                <table class="table table-condensed ">
                    <thread>
                        <td>发帖人</td>
                        <td>内容</td>
                        <td>时间</td>
                    </thread>
                    <tbody>

                    <%
                        if (topics==null || topics.size() <1 ){
                    %>

                    <p>此版块还没有人发帖</p>
                    <%

                    }
                    else {
                        for (int i=0;i<topics.size();i++){
                            topic = topics.get(i);
                            user = topic.getUser();
                    %>

                    <tr>
                        <td><%=user.getName()%></td>
                        <td><a href="/topics?topicid=<%=topic.getId()%>"><%= topic.getTheme()%></a></td>
                        <td><%= topic.getCreateDate()%></td>
                    </tr>

                    <%
                        }
                    %>
                    </tbody>
                </table>
                <%  }
                %>
            </div>
        </div>
        <div class="pagination pagination-small pagination-right">
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
                    <a href="#">下一页</a>
                </li>
            </ul>
        </div>
        <div class="panel panel-default">
            <div class="col-md-12 col-sm-12">
                <div class="about">
                    <form action="/createTopic.action" method="post" id="form">
                        <!-- 加载编辑器的容器 -->
                        主题:<input name="theme" type="text" width="200px"/>
                        <input name="type" value="Other" hidden="hidden"/>
                        <script id="container" name="content">
                        </script>
                        <%if(session.getAttribute("user")==null){%>
                        <a href="/login.jsp"><button class="btn-success">登录/注册</button></a>
                        <%} else{%>
                        <input type="submit" class="btn-success" value="发布" />
                        <%}%>
                    </form>
                    <!-- 配置文件 -->
                    <script type="text/javascript" src="/ueditor/ueditor.config.js"></script>
                    <!-- 编辑器源码文件 -->
                    <script type="text/javascript" src="/ueditor/ueditor.all.js"></script>
                    <!-- 实例化编辑器 -->
                    <script type="text/javascript">
                        var editor = UE.getEditor('container');
                    </script>
                </div>
            </div>
        </div>

    </div>
    <div class="span4">
        <div class="row-fluid">
            <div class="span8">
                <div class="list-group">
                    <a class="list-group-item active" href="#">通知</a>
                    <%for (Topic notification:notifications){%>
                    <div class="list-group-item">
                        <a href="/topics?topicid=<%=notification.getId()%>"><%=notification.getTheme()%> &nbsp;&nbsp;<%=notification.getCreateDate()%>  </a>
                    </div>
                    <%}%>

                </div>
                <a href="#form" ><button class="btn btn-large btn-success btn-block" type="button">我要发帖</button></a>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            活跃用户
                        </h3>
                    </div>
                    <div class="panel-heading">
                        <table>
                            <%for (UserCount popularuser:users){%>
                            <tr>
                                <td><a href="/personal/show?id=<%=popularuser.getId()%>"><h6 class="panel-title"><%=popularuser.getId()%>&nbsp;<%=popularuser.getName()%></h6></a></td>
                                <td></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                </div>
            </div>
            <div class="span4">
            </div>
        </div>

    </div>
</div>
<jsp:include page="${base}/tail.html"/>
</body>
</html>

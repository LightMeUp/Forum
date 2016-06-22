<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.Data.uploadFile" %><%--
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
    <jsp:useBean id="file" class="com.SE3Forum.fzu.Bean.Data.uploadFile"/>
    <jsp:useBean id="user" class="com.SE3Forum.fzu.Bean.users.User" />
    <title>学习版块主题列表</title>
    <%
        List<uploadFile> topics = (List<uploadFile>) request.getAttribute("files");
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
                        <h3 class="panel-title">资料库</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-condensed ">
                            <thread>
                                <td>文件上传用户</td>
                                <td>内容</td>
                                <td>上传时间</td>
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
                            file = topics.get(i);
                            user = file.getUser();

                            System.out.println(topics.get(0).getId());
                    %>

                        <tr>
                            <td><%=user.getId()%></td>
                            <td><%=file.getFilepath()%></td>
                            <td><%= file.getUploadDate()%></td>
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
            </div>
            <div class="span4">
                <div class="row-fluid">
                    <div class="span8">
                        <div class="list-group">
                            <a class="list-group-item active" href="#">通知</a>
                            <div class="list-group-item">
                                列表标题
                            </div>
                            <div class="list-group-item">
                                列表标题
                            </div>
                            <div class="list-group-item">
                                列表标题
                            </div>
                            <div class="list-group-item">
                                列表标题
                            </div>
                            <div class="list-group-item">
                            列表标题
                            </div>

                        </div>
                        <button class="btn btn-large btn-success btn-block" type="button">我要发帖</button>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    活跃用户
                                </h3>
                            </div>
                            <div class="panel-heading">
                                    <table>

                                        <tr>
                                            <td><img src="/img/cross.png" width="30" height="30"></td>
                                            <td><h6 class="panel-title">论坛活跃用户1</h6></td>
                                            <td><h6 class="panel-title">等级999</h6></td>
                                        </tr>
                                        <tr>
                                            <td><img src="/img/cross.png" width="30" height="30"></td>
                                            <td><h6 class="panel-title">论坛活跃用户2</h6></td>
                                            <td><h6 class="panel-title">等级999</h6></td>
                                        </tr>
                                        <tr>
                                            <td><img src="/img/cross.png" width="30" height="30"></td>
                                            <td><h6 class="panel-title">论坛活跃用户3</h6></td>
                                            <td><h6 class="panel-title">等级999</h6></td>
                                        </tr>
                                        <tr>
                                            <td><img src="/img/cross.png" width="30" height="30"></td>
                                            <td><h6 class="panel-title">论坛活跃用户4</h6></td>
                                            <td><h6 class="panel-title">等级999</h6></td>
                                        </tr>
                                    </table>
                            </div>
                        </div>
                    </div>
                    <div class="span4">
                    </div>
                </div>

            </div>
        </div>
        </div>
        </div>
        <jsp:include page="${base}/tail.html"/>
</body>
</html>

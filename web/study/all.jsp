<%@ page import="com.SE3Forum.fzu.Bean.Post_Comments.Topic" %>
<%@ page import="java.util.List" %><%--
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
    <%
        List<Topic> topics = (List<Topic>) request.getAttribute("topics");
    %>

</head>
<body>
        <jsp:include page="/head.jsp"/>
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

                    System.out.println(topics.get(0).getId());
                %>
        <fieldset>
        <table>
            <tr>
                <td>userName<%=user.getName()%></td>
                <td>Theme<%= topic.getTheme()%></td>
                <td>CreateDate <%= topic.getCreateDate()%></td>
            </tr>
        </table>
        </fieldset>

        <%
            }
            }
        %>
        <jsp:include page="${base}/tail.html"/>
</body>
</html>

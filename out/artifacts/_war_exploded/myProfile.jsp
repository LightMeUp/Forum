<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/24/16
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%
        Cookie[] cookies = request.getCookies();
        String count="";
        String name="";
        String Token="";
        String image="";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("count"))
                count =cookie.getValue();
            else if(cookie.getName().equals("name")) {
                name = URLDecoder.decode(cookie.getValue(),"UTF-8");
            }
            else if (cookie.getName().equals("sercurityToken"))
                Token = cookie.getValue();
            else if (cookie.getName().equals("image"))
                image = cookie.getValue();
        }
    %>
    <title>Title</title>
    <p>
        userprofile
    </p>
    <table>
        <tr>
            <td>count</td>
            <td><%=count%></td>
        </tr>
        <tr><td>&n</td></tr>
        <tr>
            <td>name</td>
            <td><%=name%></td>
        </tr>
        <tr>
            <td>securityToken</td>
            <td><%=Token%></td>
        </tr>
        <tr>
            <td>image</td>
            <td><%=image%></td>
        </tr>
    </table>
        <a href="logout">logout</a>
</head>
<body>

</body>
</html>

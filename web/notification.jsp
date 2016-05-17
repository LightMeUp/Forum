<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/12/16
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
     /*
     * 从消息表中获取最新的消息通知 取前10条*/
%>
<html>
<head>
    <title>通知</title>
    <style type="text/css">
        body{
            float: left;
            height:auto;
            width:100%;
        }
        #legend{
            font-size: x-large;
        }
        .date{
            float: right;
        }
        #notibody{
            border-color: lightgray;
            border-width: thin;
        }

    </style>
</head>
<body id="notibody">
    <fieldset>
        <legend id="legend"><a href="allNotifies.jsp">消息通知</a></legend>
        <table>
            <tr>
                <td><a href="http://www.fzu.edu.cn/">福州大学首页</a> </td>
            </tr>
            <tr>
                <td><a href="http://jwch.fzu.edu.cn/html/jwtz/bm02/9790.html#ritht" >关于做好本科生转专业通知</a></td>
                <td></td>
                <td class="date" colspan="2">2016-5-1</td>
            </tr>
            <tr>
                <td><a href="http://jwch.fzu.edu.cn/html/jwtz/bm06/9775.html">关于2016年教师本科教学综合测评工作的通知</a> </td>
                <td></td>
                <td class="date" colspan="2">2016-5-1</td>
            </tr>
            <tr>
                <td><a href="http://jwch.fzu.edu.cn/html/jwtz/bm06/9775.html">关于2016年教师本科教学综合测评工作的通知</a></td>
                <td></td>
                <td class="date" colspan="2">2016-5-1</td>
            </tr>
            <tr>
            <td><a href="http://jwch.fzu.edu.cn/html/jwtz/bm06/9775.html">关于2016年教师本科教学综合测评工作的通知</a></td>
                <td></td>
            <td class="date"  colspan="2">2016-5-1</td>
        </tr>
        </table>
    </fieldset>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/17/16
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>


/*其它类别显示所有的 帖子信息*/
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>所有发帖</title>
    <style type="text/css">
        .content_table{
            width: 100%;
        }
        .image_row{
            width: 10%;
        }
        .all_button{
            width: 45px;
            height: 20px;
            border: thin;
            border-color: white;
        }
    </style>
</head>
<body>
<% for(int i=0;i<5;i++) {%>
<fieldset>
    <table class="content_table">
        <tr>
            <td rowspan="3" class="image_row"><img src="/images/header_poto.jpg" width="80px" height="80px"></td>
        </tr>
        <tr>
            <td rowspan="3">
                <table>
                    <tr><td>标题</td></tr>
                    <tr><td>内容</td></tr>
                    <tr>
                        <td><img src="/images/pet.jpg" width="60px"height="60px" /></td>
                        <td><img src="/images/pet.jpg" width="60px"height="60px" /></td>
                        <td><img src="/images/pet.jpg" width="60px"height="60px" /></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr><td>作者</td></tr>
        <tr></tr>
    </table>
</fieldset>
<%}%>
<fieldset>
    <table>
        <tr>
            <td>
                <button class="all_button">首页</button>
            </td>
            <td>
                <button class="all_button">上一页</button>
            </td>
            <%for(int i=0;i<10;i++){%>
            <td><button class="all_button"><%=i%></button></td>
            <%}%>
            <td>
                <button class="all_button">下一页</button>
            </td>
            <td><button class="all_button">尾页</button></td>
        </tr>
    </table>
</fieldset>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/17/16
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>板块</title>
    <style type="text/css">
        body{
            float: inherit;
            width:100%;
        }
        .plat{
            width:80px;
            height: 80px;
            border-radius: 40px;
            margin-left: 20px;
            font-family: "Baoli SC";
            font-size: larger;
            border: none;
            border-width:0;
            margin-left: 20px;
        }
        #legend{
            font-size: x-large;
        }
        #study{
            background-color: greenyellow;
        }
        #freeZone{
            background-color: #5c9dff;
        }
        #download{
            background-color: brown;
        }
        #subject{
            background-color: coral;
        }
        #other{
            background-color: red;
        }
    </style>

</head>
<body>
<fieldset id="fieldset">
    <legend id="legend">板块天地</legend>
    <tr>
        <td></td>
        <td><button id ="study" class="plat" name="study" type="button" value="学习天地" onclick="alert(hello)"  /></td>
        <td><input id ="freeZone" class="plat" name="irrigation" type="button" value="灌水区" /></td>
        <td><input id="download" class="plat" name="downloadFile" type="button" value="资料下载" /></td>
        <td><input id="subject" class="plat" name="chat" type="button" value="主题讨论"/></td>
        <td><input id="other" class="plat" name="other" type="button" value="其它"/></td>
    </tr>
</fieldset>

</body>
</html>
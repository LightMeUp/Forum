<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/9/16
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <fieldset>
        <legend>文件上传</legend>
    <form action="/uploadAction.do?action=upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="上传">
    </form>
    </fieldset>

</body>
</html>

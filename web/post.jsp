<%@ page import="com.SE3Forum.fzu.Util.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/25/16
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post test</title>
        <h3>测试发帖功能,标题和内容未必选项目,文件和图片可以不选择</h3>
    <form action="uploadFiles.action", method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>主题标题</td>
                <td><input type="text" maxlength="15" name="theme"> </td>
            </tr>
            <tr>
                <td>主题内容</td>
                <td><textarea maxlength="140" name="content" ></textarea></td>
            </tr>
            <tr><td><input type="file" name="file" /> </td></tr>
            <tr><td><input type="submit" name="submit" value="submit"></td></tr>
        </table>


    </form>
    <!-- upload Image-->
    <p>上传图片 网络上代码</p>
    <form action="/action/uploadFiles.action" method="post" enctype="multipart/form-data">
        <tablle>
            <tr><td><img src="<%= Utils.getImageUploadFolder()+"/no_photo.jpg"%>"></td></tr>
            <tr><td><input type="file" width="80px" height="80px"></td></tr>
            <tr><td><input type="submit" value="submit"></td></tr>
        </tablle>


    </form>

</head>
<body>

</body>
</html>

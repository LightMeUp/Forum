<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/18/16
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .form-control{
            width: 80%;
            
        }
        .form-control2{
            width: 80%;
            height: 60%;
        }
        .btn-custom{
            width: 100%;
            background-color: blue;
        }
    </style>
</head>
<body>
<form role="form" action="" method="post">
    <table  width="100%">
        <tr>
            <td colspan="5"> <h3>快速发表新主题</h3></td>
        </tr>
        <tr>
            <td colspan="5">
                <label>主题</label>
            </td>
        </tr>
        <tr>
            <td colspan="5">
                <input type="text" class="form-control" id="title">
            </td>
            <tr>
                <td width="40px"><label>内容</label></td>
                <td width="40px"><button>图片</button></td>
                <td width="40px"><button>视频</button></td>
                <td width="40px"><button>文件</button></td>
                <td>&nbsp </td>
            </tr>
            <tr>
               <td colspan="5"><textarea class="form-control2" rows="10" ></textarea></td>
            </tr>
        <tr>
            <td colspan="2">
            <button type="submit" class="btn btn-custom">发布</button>
            </td>
        </tr>
    </table>
</form>



</body>
</html>

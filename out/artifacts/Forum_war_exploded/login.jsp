 <%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/10/16
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试登录界面</title>
    <script>
    </script>
    <style type="text/css">
        #login{
            font-size: small;
            margin-right: 5px;
            margin-top: 5px;
            width:100%;
            padding-top: 10px;
        }
        #submit{
            width:250px;
            border-radius: 10px;
            border-color: red;
            align-content: center;
        }
        .image{
            max-width: 80px;
            max-height:80px;
            width: 80px

        }
        #form{
            margin-right: 5px;
        }
        #submit{
           align-items: center;
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <form action="/loginAction.do" method="post" id="form">
        <table id="login" >
            <tr >
                <td rowspan="2"><img src="/images/header_poto.jpg" class="image"></td>
                <td>帐号</td>
                <td><input type="text" name="id" style="width: auto" ></td>

            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" style="width: auto"></td>
            </tr>
            <tr >
                <td colspan="3"><input type="submit" value="登    录" id="submit"  ></td>
            </tr>
         </table>
    </form>

</body>
</html>

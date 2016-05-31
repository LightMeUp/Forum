<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/31/16
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userCount" class="com.SE3Forum.fzu.Bean.users.UserCount"/>
<html>
<head>

    <title>更新账户数据</title>
    <% userCount = (UserCount)session.getAttribute("user");%>
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <!-- 引用jquery -->
    <script src="/personalCenter/jquery-1.11.2.min.js"></script>
    <script src="/personalCenter/jquery-migrate-1.2.1.min.js"></script>

    <!-- 引用ajaxfileupload.js -->
    <script src="/js/ajaxfileupload.js"></script>

    <script type="text/javascript">
        $(function(){
            //点击打开文件选择器
            $("#upload").on('click', function() {
                $('#fileToUpload').click();
            });

            //选择文件之后执行上传
            $('#fileToUpload').on('change', function() {
                $.ajaxFileUpload({
                    url:'uploadImage.action',
                    secureuri:false,
                    fileElementId:'fileToUpload',//file标签的id
                    dataType: 'json',//返回数据的类型
                    data:{name:'logan'},//一同上传的数据
                    success: function (data, status) {
                        //把图片替换
                        alert("success");
                        var obj = jQuery.parseJSON(data);
                        $("#upload").attr("src", "uploadedImages/"+obj.fileName);

                        if(typeof(data.error) != 'undefined') {
                            if(data.error != '') {
                                alert(data.error);
                            } else {
                                alert(data.msg);
                            }
                        }
                    },
                    error: function (data, status, e) {
                        alert(e);
                    }
                });
            });

        });
    </script>
</head>
<body>
<fieldset>


    <table class="table">
        <tr >
            <td>头像:</td>
            <td>
                <img  id ="upload" src="/uploadedImages/header_back.jpg"  width="80px" height="80px" />
                <input name="image" id="fileToUpload" style="display: none" type="file" name="upfile"><br/>
            </td>
        </tr>
        <tr >
            <td>帐号:</td>
            <td><%=userCount.getId()%></td>
        </tr>
        <tr >
            <td>帐号类型:</td>
            <td><%=userCount.getUserType().equals("Student")?"学生":"教师"%></td>
        </tr>
        <tr >
            <td>姓名:</td>
            <td><input type="text"  name="username" value="<%=userCount.getName()!=null?userCount.getName():"未设置"%>" /></td>
        </tr >
        <tr >
            <td>性别:</td>
            <td><input type="text"  name="sex" value="<%=userCount.getSex()%>"/></td>
        </tr>
        <tr >
            <td>籍贯:</td>
            <td><input type="text"  name="origin" value="<%=userCount.getOrigin()!=null?userCount.getOrigin():"未设置"%>"/></td>
        </tr>
        <tr >
            <td>出生日期:</td>
            <td><input type="text" name="birthdate" value="<%=userCount.getBirthDate()!=null?userCount.getBirthDate():"未设置"%>"/></td>
        </tr>
        <tr>
            <td>手机:</td>
            <td><input type="text" name="mobile" value="<%=userCount.getCellPhone()!=null?userCount.getCellPhone():"未设置"%>"/></td>
        </tr>
        <tr >
            <td>邮箱:</td>
            <td><input type="text" name="email" value="<%=userCount.getEmail()!=null?userCount.getEmail():"未设置"%>"/></td>
        </tr>
        <tr >
            <td>QQ:</td>
            <td><input type="text" name="qqnumber" value="<%=userCount.getEmail()!=null?userCount.getQqnumber():"未设置"%>"/></td>
        </tr>
        <tr>
            <td>最近一次登录:</td>
            <td><%=userCount.getLastLoginDate()%></td>
        </tr>
        <tr >
            <td>
                <button name="confirm" value="update" onclick="jump()">确认</button>
            </td>
            <td><button name="cancel" value="cancel" onclick="jump()">取消</button> </td>
        </tr>
    </table>
</fieldset>
</body>
</html>

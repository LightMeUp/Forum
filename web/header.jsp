<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/12/16
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        #header{
            position: absolute;
            top: 2%;
            left: 65%;
            font-size:small;


        }
        #baiduSearch{
            float: left;
            margin-left: 30px;
        }
    </style>

    <script src="http://s1.bdstatic.com/r/www/cache/global/js/BaiduHttps_20150714_zhanzhang.js"></script>
    <script>
        function checkHttps () {
            BaiduHttps.useHttps();
        };
        function g(formname) {
            var data = BaiduHttps.useHttps();
            var url = '';
            url = data.s == 0 ? "http://www.baidu.com/baidu" : 'https://www.baidu.com/baidu' + '?ssl_s=1&ssl_c' + data.ssl_code;
            if (formname.s[1].checked) {
                formname.ct.value = "2097152";
            }
            else {
                formname.ct.value = "0";
            }
            formname.action = url;
            return true;
        };
    </script>
</head>
<body>
    <form name="f1" onsubmit="return g(this)" target="_blank" id="baiduSearch">
        <table bgcolor="#FFFFFF" style="font-size:9pt;">
            <tr height="40">
                <td align="top" width="4%">
                    <a href="https://www.baidu.com/"  target="_blank">
                        <img src="https://www.baidu.com/img/baidu_jgylogo3.gif" border="0" alt="baidu">
                    </a>
                </td>
                <td>
                    <input type="text" name="word" onfocus="checkHttps" size="30" maxlength="100">
                    <input type="submit" value="百度搜索"><br>
                    <input name="tn" type="hidden" value="SE_zzsearchcode_shhzc78w">
                    <input name="cl" type="hidden" value="3">
                    <input name="ct" type="hidden">
                    <input name="si" type="hidden" value="www.baidu.com">
                </td>
            </tr>
        </table>
    </form>
    <table id="header">
        <tr>
            <td>
            </td>
            <td ><a href="${base}/personal/personal.jsp" target="center_iframe" >帐号设置</a></td>
            <td><a href="myMessage.jsp"> 我的消息</a></td>
            <td><a href="forumSetting"> 论坛设置</a></td>
            <td><a href="helpCenter.jsp">帮助中心</a></td>
            <td><a href="myCollection.jsp"> 我的收藏</a></td>
            <td><a href="http://www.fzu.edu.cn">福大首页</a></td>
            <td>友情连接</td>
            <td ><a href="/Controller/logout"> 退出</a></td>
        </tr>
    </table>
</body>
</html>

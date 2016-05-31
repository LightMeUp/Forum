<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 5/30/16
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <!-- 引用jquery -->
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

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
                        var obj = jQuery.parseJSON(data);
                        $("#upload").attr("src", "../image/"+obj.fileName);

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

<!-- 点击图片，打开文件选择器，确定，上传。(这是网络上的一个图片) -->
<img id="upload" alt="" style="width: 200px; height: 200px"
     src="/header_back.jpg">

<!-- 隐藏file标签 -->
<input name="image" id="fileToUpload" style="display: none" type="file" name="upfile"><br/>

</body>
</html>





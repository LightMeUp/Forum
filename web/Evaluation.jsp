<%@ page import="com.SE3Forum.fzu.Util.Utils" %>
<%@ page import="com.SE3Forum.fzu.Bean.SchoolAssignment.Evaluation" %>
<%@ page import="com.SE3Forum.fzu.Bean.users.UserCount" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 6/28/16
  Time: 2:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%Evaluation evaluation = (Evaluation) request.getAttribute("evaluation");
System.out.println("evaid " +evaluation.getId());
    UserCount userCount=(UserCount)session.getAttribute("user");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 3, from LayoutIt!</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        .content{
            margin-top: 40px;
        }

        .siderbar{
            font-size: 20px;
            border: 1px solid #eeeeee;
            text-align: center;
        }

    </style>
</head>
<body>
<jsp:include page="/navigation.jsp"/>
<div class="content">
    <div class="col-md-3">
        <ul class="nav nav-tabs nav-stacked siderbar">
            <li>
                <a href="/GSQZYCreate.jsp">发布作业</a>
            </li>
            <li>
                <a href="/sendNotificaion.jsp">发布通知</a>
            </li>
            <li>
                <a href="/HWCheck">查看作业</a>
            </li>
            <li>
                <a href="/dataDownload.jsp">资料下载</a>
            </li>
            <li>
                <a href="/showStudents?teacherId=<%=userCount.getId()%>">我的学生</a>
            </li>

        </ul>
    </div>
    <div class="col-md-8">
    <div class="form-group">
    <h4><%=evaluation.getStudent().getName()%>的第<%=evaluation.getSchoolAssignment().getId()%>次作业</h4>
    <table class="table-bordered table">
        <tr>
            <td>作业编号</td><td><%=evaluation.getSchoolAssignment().getId()%></td>
            <td>发布时间</td><td><%=Utils.parseDate(evaluation.getSchoolAssignment().getPublishDate())%></td>
        </tr>
        <tr><td>截止时间</td><td><%=Utils.parseDate(evaluation.getSchoolAssignment().getDeadLine())%></td>
            <td>发布人</td><td><%=evaluation.getSchoolAssignment().getTeacher().getId()%></td>
        </tr>
        <tr><td colspan="4"><%=evaluation.getSchoolAssignment().getContent()%></td></tr>
    </table>
    <form action="updatevaluation.action" method="post">
    <table class="table table-bordered" >
        <tr>
            <td>编号</td>
            <td ><%=evaluation.getId()%></td>
            <input name="evaluationId" value="<%=evaluation.getId()%>" hidden="hidden"/>
            <td>提交日期</td>
            <td ><%=evaluation.getSubmitDate()%></td>
            <td>成绩</td>
            <td ><input name="score" /></td>
        </tr>
        <tr>
            <td>内容</td>
            <td colspan="5"><%=evaluation.getContent()%></td>
        </tr>
        </tbody>
    </table>
        <div>
        <script id="container" name="evaluation" type="text/plain">

        </script>
        <script type="text/javascript">
            var editor = UE.getEditor('container');
        </script>
            <button type="submit" class="btn-success">评分</button>
        </div>

    </form>

</div>
    </div>
</div>
<div>
</div>
</body>
</html>

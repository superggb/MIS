<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/10
  Time: 15:56
  To change this template use File | Settings | File Templates.
  DONE
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理人员</title>
    <link href="/resource/form/css/style.css" rel='stylesheet' type='text/css' media="all" />
    <!--
        作者：paopao
        时间：2018-09-06
        描述：引入列表相关文件
    -->
    <link rel="stylesheet" type="text/css" href="/resource/list/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resource/list/css/jquery.paginate.css" />
    <link rel="stylesheet" href="/resource/list/css/jquery.yhhDataTable.css" />

    <script type="text/javascript" src="/resource/list/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resource/list/js/jquery.paginate.js" ></script>
    <script type="text/javascript" src="/resource/list/js/jquery.yhhDataTable.js" ></script>
    <script type="text/javascript" src="/resource/list/js/index.js" ></script>
</head>
<body style="background-image: url(/resource/background/manager.jpg);">
<h1 class="header-w3ls">权限分配</h1>
<div class="content-w3ls">
    <div class="form-w3ls">
        <div class="grid-agileits1">
            <table id="testtable1" >
                <thead>
                <tr>
                    <th>部门</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="dp" items="${deps}">
                <tr>
                    <td>${dp.name}</td>
                    <td>${dp.did}</td>
                    <td>${dp.password}</td>
                    <td><a href="/changedpassword/${dp.did}">修改</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/resource/alert.js"></script>
<script type="text/javascript">
    alertMsg.showMsg("${msg}");
</script>
</html>

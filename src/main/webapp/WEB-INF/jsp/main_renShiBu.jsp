<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/10
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>人事部</title>
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
<body style="background-image: url(/resource/background/renshi.jpg);">
<h1 class="header-w3ls">员工调动信息</h1>
<div class="w3ls-btn">
    <div class="wthreesubmitaits">
        <a href="/addemp1"><button style="margin-right: 1%;">新增人员信息</button></a>
        <a href="/renshibu"><button style="margin-right: 1%;">新增调动信息</button></a>
        <a href="/login"><button style="background: gray;">退出登录</button></a>
    </div>
</div>
<div class="content-w3ls">
    <div class="form-w3ls">
        <div class="grid-agileits1">
            <table id="testtable1" >
                <thead>
                <tr>
                    <th>工号</th>
                    <th>姓名</th>
                    <th>调动类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="info" items="${Infos}">
                <tr>
                    <td>${info.eid}</td>
                    <td>${info.name}</td>
                    <td>${info.transferInfo}</td>
                    <td><a href="/edittransfer/${info.tid}/${info.eid}">修改</a>&nbsp;&nbsp;<a href="/deletetransfer/${info.tid}">删除</a></td>
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

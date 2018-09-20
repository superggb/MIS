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
    <title>财务部</title>
    <link href="/resource/form/css/style.css" rel='stylesheet' type='text/css' media="all" />
    <!--
        作者：paopao
        时间：2018-09-06
        描述：引入列表相关文件
    -->
    <link rel="stylesheet" type="text/css" href="/resourcelist/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resource/list/css/jquery.paginate.css" />
    <link rel="stylesheet" href="/resource/list/css/jquery.yhhDataTable.css" />

    <script type="text/javascript" src="/resource/list/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resource/list/js/jquery.paginate.js" ></script>
    <script type="text/javascript" src="/resource/list/js/jquery.yhhDataTable.js" ></script>
    <script type="text/javascript" src="/resource/list/js/index.js" ></script>
</head>
<body style="background-image: url(/resource/background/caiwu.jpg);">
<h1 class="header-w3ls">员工工资信息</h1>
<div class="w3ls-btn">
    <div class="wthreesubmitaits">
        <a href="xingZhengBu.html"><button>新增缺勤信息</button></a>
        <a href="xingZhengBu.html"><button style="background: gray;">退出登录</button></a>
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
                    <th>基本工资</th>
                    <th>奖金</th>
                    <th>扣款</th>
                    <th>税收</th>
                    <th>实际工资</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sa" items="${salaryList}">
                <tr>
                    <td>${sa.eid}</td>
                    <td>${sa.name}</td>
                    <td>${sa.salary}</td>
                    <td>${sa.bonus}</td>
                    <td>${sa.fine}</td>
                    <td>${sa.tax}</td>
                    <td>${sa.realsalary}</td>
                    <td><a href="caiWuBu2.html">修改</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

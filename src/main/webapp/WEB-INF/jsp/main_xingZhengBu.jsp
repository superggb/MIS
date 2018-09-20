<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/10
  Time: 15:57
  To change this template use File | Settings | File Templates.
  DONE
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>行政部</title>
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
<body style="background-image: url(/resource/background/xingzheng.jpg);">
<h1 class="header-w3ls">员工缺勤信息</h1>
<div class="w3ls-btn">
    <div class="wthreesubmitaits">
        <a href="/refaddabs"><button>新增缺勤信息</button></a>
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
                    <th>起始日期</th>
                    <th>结束日期</th>
                    <th>原因</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ab" items="${abs}">
                <tr>
                    <td>${ab.eid}</td>
                    <td>${ab.name}</td>
                    <td>${ab.starttime}</td>
                    <td>${ab.endtime}</td>
                    <td>${ab.description}</td>
                    <td><a href="/editabs/${ab.aid}">修改</a>&nbsp;&nbsp;<a href="/delabs/${ab.aid}">删除</a></td>
                </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

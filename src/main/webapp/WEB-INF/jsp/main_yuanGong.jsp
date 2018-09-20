<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/10
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工工资</title>
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
<body>
<script type="text/javascript">
    if(1==${result})
        alert("修改密码成功！")
</script>
<h1 class="header-w3ls">工资一览</h1>
<div class="w3ls-btn">
    <div class="wthreesubmitaits">
<<<<<<< HEAD
        <a href="/changepassword/${eid}"><button>修改密码</button></a>
        <a href="xingZhengBu.html"><button style="background: gray;">退出登录</button></a>
=======
        <a href="/changeepassword/${eid}"><button>修改密码</button></a>
>>>>>>> bc768bde9f7af6a31ccc77b4102a496917fcd999
    </div>
</div>
<div class="content-w3ls">
    <div class="form-w3ls">
        <div class="grid-agileits1">
            <table id="testtable1" >
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>时间</th>
                    <th>基本工资</th>
                    <th>奖金</th>
                    <th>扣款</th>
                    <th>税收</th>
                    <th>实际工资</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="sa" items="${sas}">
                <tr>
                    <td>${sa.name}</td>
                    <td>${sa.date}</td>
                    <td>${sa.salary}</td>
                    <td>${sa.bonus}</td>
                    <td>${sa.fine}</td>
                    <td>${sa.tax}</td>
                    <td>${sa.realsalary}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

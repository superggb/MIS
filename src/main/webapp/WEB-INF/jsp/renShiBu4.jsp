<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/11
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <title>人事部</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Design Order Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- font files -->
    <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- /font files -->
    <link href="/resource/form/css/style.css" rel='stylesheet' type='text/css' media="all" />
</head>
<body style="background-image: url(/resource/background/renshi.jpg);">
<h1 class="header-w3ls">新增员工信息</h1>
<div class="content-w3ls">
    <div class="form-w3ls">
        <form action="/addemp" method="post">
            <div class="content-wthree1">

                <div class="grid-agileits1">
                    <div class="form-control">
                        <label class="header">姓名 :</label>
                        <input type="text" id="name" name="ename" title="Please enter your Phone No" required="">
                    </div>
                    <div class="form-control">
                        <label class="header">密码 :</label>
                        <input type="text" id="name" name="password" title="Please enter your Phone No" required="">
                    </div>
                    <div class="form-control">
                        <label class="header">基本工资:</label>
                        <input type="text" id="name" name="salary" title="Please enter your Phone No" required="">
                    </div>
                    <div class="form-control">
                        <label class="header">部门 :</label>
                        <select name="dpnum">
                            <option value="0" selected="" disabled="">无</option>
                            <option value="1">教务处</option>
                            <option value="2">人事部</option>
                            <option value="3">行政部</option>
                            <option value="4">财务部</option>
                            <option value="5">学生处</option>
                            <option value="6">保卫处</option>
                            <option value="7">图书馆</option>
                            <option value="8">后勤管理处 </option>
                            <option value="9">就业指导中心 </option>
                            <option value="10">招生办公室 </option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="w3ls-btn">
                <div class="wthreesubmitaits">
                    <input type="submit" name="submit" value="确认">
                </div>
            </div>
        </form>
    </div>
</div>
<p class="copyright">© 2018 Design by paopao</p>
</body>
</html>

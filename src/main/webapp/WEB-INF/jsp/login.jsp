<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/10
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>工资管理系统登录</title>
    <meta name="keywords" content="Winter Login Form Responsive widget, Flat Web Templates, Android Compatible web template,
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resource/login/css/font-awesome.css">
    <link rel="stylesheet" href="/resource/login/css/style.css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700" rel="stylesheet">
</head>
<body style="background-image:url(/resource/background/login.JPG) ;">
<div class="agile-login">
    <h1><strong>工资管理系统</strong></h1>
    <div class="wrapper">
        <h2>登录</h2>
        <div class="w3ls-form">
            <form action="/main" method="post">
                <label>账号</label>
                <input type="text" name="username" placeholder="Username" required/>
                <label>密码</label>
                <input type="text" name="password" placeholder="Password" required />
                <div style="margin-bottom: 10%;margin-top: 10%;">
                    <label style="position:sticky;display: inline;"><input type="radio" name="way" value="0" checked="checked"><font color="white" size="2">员工登录</font></label>
                    <label style="margin-left: 15%;position: sticky;display: inline;"><input type="radio" name="way" value="1" ><font color="white" size="2">管理人员登录</font></label>
                </div >
                <input type="submit" value="登录" />
            </form>
        </div>

        <div class="agile-icons">
            <a href="#"><span class="fa fa-twitter" aria-hidden="true"></span></a>
            <a href="#"><span class="fa fa-facebook"></span></a>
            <a href="#"><span class="fa fa-pinterest-p"></span></a>
        </div>
    </div>
    <br>
    <div class="copyright">
        <p>© 2018 Design by paopao</p>
    </div>
</div>

</body>
</html>
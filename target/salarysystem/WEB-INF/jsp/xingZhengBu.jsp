<%--
  Created by IntelliJ IDEA.
  User: GGB
  Date: 2018/9/11
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <title>行政部</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Design Order Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- font files -->
    <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- /font files -->
    <link href="/resource/form/css/style.css" rel='stylesheet' type='text/css' media="all" />
</head>
<body>
<h1 class="header-w3ls">记录员工缺勤信息</h1>
<div class="content-w3ls">
    <div class="form-w3ls">
        <form action="/addabs" method="post">
            <div class="content-wthree1">

                <div class="grid-agileits1">
                    <div class="form-control">
                        <label class="header">员工工号 <span>*</span></label>
                        <input type="text" id="name" name="eid" required="">
                    </div>
                    <div class="form-control">
                        <label class="header">缺勤开始日期 :</label>
                        <input type="date" id="name" name="startDate"  required="">
                    </div>
                    <div class="form-control">
                        <label class="header">缺勤天数 :</label>
                        <input type="text" id="name" name="days"  required="">
                    </div>
                    <div class="form-control">
                        <div class="main-row">
                            <label class="header">缺勤类型 <span>*</span></label>
                            <select name="atype">
                                <option value="1" selected="">请假</option>
                                <option value="2">迟到</option>
                                <option value="3">旷工</option>
                            </select>

                        </div>
                    </div>
                    <div class="form-control">
                        <label class="header">缺勤说明 :</label>
                        <textarea id="message" name="reason"></textarea>
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


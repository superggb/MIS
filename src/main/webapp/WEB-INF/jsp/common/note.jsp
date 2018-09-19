<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/19/019
  Time: 12:47

  用于页面应答
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String command = request.getParameter("command");
    if (command.equals('0')) {
        out.println("<script>");
        out.println("alert('操作失败');");
        out.println("</script>");
    }else if(command.equals('1')){
        out.println("<script>");
        out.println("alert('操作成功');");
        out.println("</script>");
    }
%>

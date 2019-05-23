<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23 0023
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域测试页面</title>
</head>
<body>
<%--request对象
<h2>${requestScope.username},您好!</h2>
--%>

<%--session对象--%>
<%--<h2>${sessionScope.username},您好!</h2>--%>

<%--application对象--%>
<h2>${applicationScope.username},您好!</h2>
</body>
</html>

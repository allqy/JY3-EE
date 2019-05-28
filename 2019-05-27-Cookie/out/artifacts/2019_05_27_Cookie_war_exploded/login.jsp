<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/27 0027
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>免登录测试页面</title>
</head>
<body>
    <form action="login.do" method="post">
        用户名:<input type="text" name="uname"><br>
        密码:<input type="password" name="upwd"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17 0017
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="login" method="get">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" placeholder="请输入用户名" name="username"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码：</td>
                <td><input type="password" placeholder="请输入密码" name="userpwd"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

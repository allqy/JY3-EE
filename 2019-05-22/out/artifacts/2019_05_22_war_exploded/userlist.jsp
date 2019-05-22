<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="../css/userlist.css">
</head>
<body>
    <form action= "" method="">
        <h3>用户信息表</h3>
        <table border="1px">
            <tr>
                <th>用户名</th>
                <th>密 码</th>
                <th colspan="2">操 作</th>
            </tr>
            <c:forEach items="${userlist}" var="user">
                <tr>
                    <td>${user.uname}</td>
                    <td>${user.upwd}</td>
                    <td><a href="updateUser.jsp?uname=${user.uname}">修改</a></td>
                    <td><a href="delUser.do?uname=${user.uname}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>

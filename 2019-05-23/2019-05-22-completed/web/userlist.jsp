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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
    <form >
        <h3>用户信息表</h3>
        <table class="table table-hover">
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>密 码</th>
                <th>操 作</th>
            </tr>
            <c:forEach items="${userlist}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.uname}</td>
                    <td>${user.upwd}</td>
                    <td>
                        <a href="updateUser.jsp?uid=${user.id}&username=${user.uname}">修改</a>
                        <a href="delUser.do?uid=${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>欢迎界面</title>
  </head>
  <body>
  <c:forEach items="${userlist}" var="user">
    <h2>Hello,${user.uname}</h2>
  </c:forEach>
  </body>
</html>

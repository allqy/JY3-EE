<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.entity.User" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17 0017
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎界面</title>
    <style>
        h1 a{
            color: red;
        }
    </style>
  </head>
  <body>
  <%
    List<User> userlist=(List<User>)request.getAttribute("userlist");
      for(User user:userlist){
        out.print("<h1>欢迎<a>"+user.getuName()+"</a>同志!!!</h1>");
    }
  %>
  </body>
</html>

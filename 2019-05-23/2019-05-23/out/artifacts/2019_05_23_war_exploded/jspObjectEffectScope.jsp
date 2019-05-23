<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23 0023
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP四个作用域对象</title>
</head>
<body>
    <%
        //作用域范围从小到大依次为:pageContext,request,session,application

        //1.pageContext(仅作用于本页面,但是可以可以设置其他对象的值)
        pageContext.setAttribute("username","张三");

        //2.request
        //方法(一)
        //request.setAttribute("username","李四");
        //request.getRequestDispatcher("test.jsp").forward(request,response);
        //方法(二)
        //pageContext.setAttribute("username","李四",pageContext.REQUEST_SCOPE);
        //request.getRequestDispatcher("test.jsp").forward(request,response);

        //3.session对象(作用于一个浏览器，在浏览器运行期间有效，当关闭浏览器并且重新打开时失效，
        // 但是原来的session对象在服务器上依然存在,只是新的浏览器找不到了)

        //方法(一)
        //session.setAttribute("username","王五");
        //方法(二)
        //pageContext.setAttribute("username","王五",pageContext.SESSION_SCOPE);

        //4.application对象(作用于整个项目中，当一个服务器只存放一个项目时，相当于是作用于这个服务器上)
        //方法(一)
        //application.setAttribute("username","小丽");
        //方法(二)
        pageContext.setAttribute("username","小丽",pageContext.APPLICATION_SCOPE);
    %>
</body>
</html>

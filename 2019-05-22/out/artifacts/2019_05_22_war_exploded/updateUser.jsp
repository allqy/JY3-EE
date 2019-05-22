<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22 0022
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户编辑</title>
</head>
<body>
    <form action="" method="">
        <h2>用户信息编辑</h2>
        用 户 名:
        <input type="text" value="<%=request.getParameter("uname")%>" readonly="readonly" name="uname" id="uname"><br>
        <input type="text" hidden="hidden" value="1" id="midUname" name="midUname">
        输入密码:
        <input type="password" name="upwd" id="upwd"><br>
        确认密码:
        <input type="password" name="confirmUpwd" id="confirmUpwd"><br>
        <input type="submit" value="确认修改" id="update">
    </form>
    <script>
        var updateBtn=document.getElementById("update")
        updateBtn.onclick=function () {
            var uName1=document.getElementById("uname").value;
            document.getElementById("midUname").value=uName1;
            alert(uName1);
        }
    </script>
</body>
</html>

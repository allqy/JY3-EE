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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/updateUser.js"></script>
</head>
<body>
    <h3 style="margin: 30px 260px">用户信息编辑</h3>
    <form class="form-horizontal" action="updateUser.do" method="post">
        <div class="form-group">
            <input type="hidden" value="<%=request.getParameter("uid")%>" name="uid">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width: 200px" id="inputEmail3" value="<%=request.getParameter("username")%>" name="uname">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密&nbsp;&nbsp;码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width: 200px" id="inputPassword3" name="upwd" >
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" style="width: 200px" id="inputPassword4" name="confirmUpwd" >
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id="updateBtn">确认修改</button>
            </div>
        </div>
    </form>
</body>
</html>

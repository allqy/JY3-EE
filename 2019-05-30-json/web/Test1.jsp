<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>例题一</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        window.onload=function () {
            $("#btn").click(function () {
                $("#comments").load(
                    "test1.do",
                    function (respond,status,xhr) {
                        $("#comments").html(respond)
                    }
                )
            })
        }
    </script>
</head>
<body>
    <button id="btn">Ajax获取</button>
    <h3>已有评论:</h3>
    <div id="comments">

    </div>
</body>
</html>

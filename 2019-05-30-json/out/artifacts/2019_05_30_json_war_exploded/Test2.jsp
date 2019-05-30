<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>例题二</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        window.onload=function () {
            $("#btn").click(function () {
                //console.log($("#name").val())
                $.post(
                    "test2.do",{name:$("#name").val()},function (data) {

                    }
                )
            })
        }
    </script>
</head>
<body>
    用户:<input type="text" id="name"><button id="btn">Ajax获取</button><br>
    <h3></h3>
    <div id="comment">

    </div>
</body>
</html>

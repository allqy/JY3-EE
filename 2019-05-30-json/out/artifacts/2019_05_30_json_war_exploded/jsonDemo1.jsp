<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json练习一</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        window.onload=function () {
            $.ajax(
                {
                    url:"json.do",
                    type:"post",
                    success:function (data) {
                        //console.log(data)
                        var arr=eval(data);
                        //console.log(arr)
                        console.log(arr[0].uName)
                    }
                }
            )
        }
    </script>
</head>
<body>

</body>
</html>

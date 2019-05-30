<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30 0030
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json练习二</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        window.onload=function () {
            $.ajax(
                {
                    url:"json2.do",
                    type:"post",
                    dataType:"json",
                    complete:function () {
                        console.log("请求完成!")
                    },
                    success:function (data) {
                        //console.log("请求成功!")
                        //console.log(data[0].uName)
                        //相当于java中的foreach循环
                        $.each(data,function (i,val) {
                            $("tbody").append($("<tr><td>"+val.uName+"</td><td>"+val.uPwd+"</td></tr>"))
                        })
                    },
                    error:function () {
                        console.log("请求失败!")
                    }
                }
            )
        }
    </script>
</head>
<body>
    <table border="1px">
        <thead>
            <th>用户名</th>
            <th>密码</th>
        </thead>
        <tbody>

        </tbody>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24 0024
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有商品</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="showAllPro.do" method="post">
        <table class="table table-hover" border="1px">
            <tr>
                <th>产品编号</th>
                <th>产品名称</th>
                <th>售价</th>
                <th>图片</th>
                <th>产品描述</th>
                <th>产品库存</th>
                <th>上架日期</th>
                <th>类别编号</th>
                <th>生产厂家</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${prolist}" var="product">
                <tr>
                    <td>${product.pro_id}</td>
                    <td>${product.pro_name}</td>
                    <td>${product.pro_price}</td>
                    <td>${product.pro_image}</td>
                    <td>${product.pro_des}</td>
                    <td>${product.pro_stock}</td>
                    <td>${product.pro_date}</td>
                    <td>${product.cate_id}</td>
                    <td>${product.pro_fac}</td>
                    <td>
                        <a href="updateProduct.jsp"><button>修改</button></a>
                        <a href="delProduct.jsp"><button>删除</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>

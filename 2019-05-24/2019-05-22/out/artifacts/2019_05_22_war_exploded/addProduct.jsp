<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24 0024
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="addPro.do">
    <div class="form-group">
        <label for="pro_name">商品名称</label>
        <input type="text" class="form-control" id="pro_name" placeholder="请输入商品名称" name="pro_name">
    </div>
    <div class="form-group">
        <label for="pro_price">商品价格</label>
        <input type="number" class="form-control" id="pro_price" placeholder="请输入商品价格" min="1.00" max="9999999.99" name="pro_price">
    </div>
    <div class="form-group">
        <label for="pro_img">商品图片</label>
        <input type="file" id="pro_img" name="pro_img">
        <p class="help-block">添加一张商品图片</p>
    </div>
    <div class="form-group">
        <label for="pro_des">商品描述</label><br>
        <textarea id="pro_des" placeholder="请输入商品描述信息" style="width: 100%" name="pro_des"></textarea>
    </div>
    <div class="form-group">
        <label for="pro_stock">商品库存</label>
        <input type="number" class="form-control" id="pro_stock" placeholder="请输入商品库存量" min="0" max="999999" name="pro_stock">
    </div>
    <div class="form-group">
        <label for="pro_date">商品上架日期</label>
        <input type="date" class="form-control" id="pro_date" placeholder="请输入商品商品上架日期" name="pro_date">
    </div>
    <div class="form-group">
        <label for="cate_id">商品类别ID</label>
        <input type="number" class="form-control" id="cate_id" placeholder="请输入商品类别ID" min="0" max="999" name="cate_id">
    </div>
    <div class="form-group">
        <label for="pro_fac">生产厂家</label>
        <input type="text" class="form-control" id="pro_fac" placeholder="请输入生产厂家名称" name="pro_fac">
    </div>
    <button type="submit" class="btn btn-default">添加</button>
</form>
</body>
</html>

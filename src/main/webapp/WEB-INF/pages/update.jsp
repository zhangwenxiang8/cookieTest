<%--
  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/13
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>      <%--el表达式 可以接收updateservlet页面的req.setAttribute k值  替代了resp.get...--%>
<form action="doUpdate">
    <input hidden="hidden" name="id" value="${p.productId}">  <%--隐藏id框,默认存在--%>
    商品名称:<input type="text" name="name" value="${p.productName}"><br>
    商品价格:<input type="text" name="price" value="${p.price}"><br>
    商品图片: <input type="text" name="url" value="${p.url}"><br>
    商品描述:<input type="text" name="des" value="${p.productDes}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>

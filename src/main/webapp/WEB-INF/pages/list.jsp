<%@ page import="work.pojo.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--el表达式的核心包--%>
<%--

  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/12
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

    欢迎${user.username}<br><a href="exit">退出</a>
    <table>
        <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品图片</th>
            <th>商品描述</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
    <%--${list}--%>
<table>
    <tbody>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.productId}</td>
            <td>${p.productName}</td>
            <td>${p.productDes}</td>
            <td><img src="${p.url}" alt="fh"></td>
            <td>${p.price}</td>
            <td><a href="delete?product_id=${p.productId}">删除</a>&nbsp;|&nbsp;<a href="update?product_id=${p.productName}">修改</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>





<%--<script type="text/javascript" src="../../jquery/jquery-3.3.1.min.js"> </script>--%>
<%--<script type="text/javascript">--%>

    <%--$(function () {--%>
        <%--$.ajax({--%>
            <%--url:"list",--%>
            <%--type:"get",--%>
            <%--dataType:"json",   //指定返回值类型--%>
            <%--success:function (data) {--%>
               <%--$(data).each(function (index,element) {--%>
                   <%--var $tr=$("<tr></tr>");--%>

                                        <%--//拼接的格式,获取url和price内的值--%>
                   <%--$tr.append($("<td>"+$(element)[0].url+"</td>")).append($("<td>"+$(element)[0].price+"</td>"));--%>
                    <%--$("#tbody").append($tr)--%>
               <%--})--%>
            <%--}--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>

</body>
</html>

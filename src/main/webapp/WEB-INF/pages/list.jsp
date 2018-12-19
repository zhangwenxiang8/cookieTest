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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

    欢迎${user.username}<br><a href="exit">退出</a>
    ${list}
<table>
    <tbody id="tbody">

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

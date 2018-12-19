<%--
  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/13
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="fm" action="dologin" method="post">
    用户名:<input type="text" name="username" id="uname">
    <hr>
    密码: <input type="password" name="pwd"  id="pwd">
    <hr>
    <input type="submit" value="登陆" id="btn">
    <%--点击按钮,通过a链接 跳转到  register.jsp注册页面--%>
</form>
<%--<script type="text/javascript" src="jquery/jquery-3.3.1.min.js"> </script>--%>
<%--<script type="text/javascript">--%>
    <%--$(function () {--%>
        <%--$("#btn").click(function () {--%>
           <%--var fm =$("#fm").serialize();--%>
            <%--$.ajax({--%>
                <%--url:"dologin",--%>
                <%--type:"post",--%>
                <%--data:fm,--%>
                <%--success:function (data) {--%>
                    <%--if (data=="1"){--%>
                        <%--alert("登陆成功")--%>
                        <%--window.location.href="http://localhost:8080/web12.10/list";--%>
                    <%--}--%>
                <%--}--%>
            <%--})--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>

</body>
</html>

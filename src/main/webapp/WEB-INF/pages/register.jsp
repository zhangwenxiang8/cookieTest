<%--
  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/12
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/path.jsp"%>   <%--引入文件 注意加"/"--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="doRegister">    <%--握手链接名: register--%>
    用户名:<input type="text" name="username" id="uname" class="a"><span id="message" ></span><br>
    <br>
    密码: <input type="password" name="pwd" id="pwd"  placeholder="6~18 数字和字母">
    <br>
    确认密码: <input type="password" name="pwds"  id="pwds" class="a" placeholder="6~18 数字和字母"><span id="pmes" ></span>
    <br>
    手机: <<input type="text" name="tele" id="tele"  placeholder="手机号码" class="a">
    <br>
    <input type="button" value="注册" disabled="disabled" id="btn">  <%--disabled 按钮不生效 点击效果--%>
</form>
<script type="text/javascript" src="${path}jquery/jquery-3.3.1.min.js"> </script>
<script>


        $(function (){

            /*使用ajax*/
            var un;
            var ps;
            var p;
            var tele;
            $(".a").blur(function () {
                un= $("#uname").val();
                p= $("#pwd").val();                                          //input标签,所以这里可以获取val值
                   ps= $("#pwds").val();                         //span标签,所以这里只能获取text值
                tele=$("#tele").val();
                $.ajax({
                    url:"doRegister",
                    type:"get",
                    data:{"names":un,"p":p,"ps":ps,"tele":tele},
                    success:function (data) {         //回调函数,当事件触发时,会返回一个值
                      if (data=="4"){
                           $("#message").text("可以注册"); //密码正确时  "1" ,可以注册
                        }
                           if (data=="43"){
                               $("#message").text("可以注册");
                               $("#pmes").text("✓")
                               $("#btn").attr("disabled",false);
                           }
                           if (data=="1"){
                          $("#message").text("用户已存在")
                           }
                           if (data=="42"){
                               $("#pmes").text("两次密码不一致")
                           }

                    }
                });
            });

                $("#btn").click(function () {
                   $.ajax({
                       url:"doIt",
                       type:"post",
                       data:{"names":un,"p":p,"ps":ps,"tele":tele},
                       success:function (data) {
                            if (data>0){
                                alert("注册成功");
                                window.location.href="http://localhost:8080/web12.10/login";

                            }
                       }
                   })
                })

        })
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/19
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>                           <%--enctype="multipart/form-data"  上传文件允许二进制编码传值--%>
<form action="img" method="post"  enctype="multipart/form-data">
    <input type="file" name="file" onchange="imgChange(this)"><img id="img" style="width: 40px;height: 40px;"><br>
    <input type="submit">
</form>
<script type="text/javascript">
    function  imgChange(obj) {  //change事件的值传进来的时候
        /*获取obj对象的数组[方法]类型文件的Name值, 返回从name值"."后面的字符串   做判断*/
        if ((obj.files[0].name).substr((obj.files[0].name).indexOf(".") + 1) == "png") {
            /*substr返回一个从指定位置开始的指定长度的子字符串。*/

            var reader = new FileReader();    //new个文件读取器
            reader.onload = function (e) {  //加载的时候读取文件
                var img = document.getElementById("img");
                /*获取Img标签 获取 对象的目标的结果*/
                img.src = e.target.result;
            };
            reader.readAsDataURL(obj.files[0])
            /*将里面的文件读取出URL的方法,img就有url了 */
        } else {
            alert("格式不对")
            img.src = "";   /*图片的格式 以空来覆盖上一个选择的图片*/
        }
    }
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 章文翔
  Date: 2018/12/20
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  System.out.println(request.getScheme());  //获取协议  Http
        System.out.println(request.getServerName());   //获取服务器名称  localhost
        System.out.println(request.getServerPort());    //获取端口号 8080
        System.out.println(request.getContextPath());   //获取项目名
        String path="";
        //Run-EditConfigurations里改端口号

    if (request.getServerPort()==80){
        path=(request.getScheme()+"://"+request.getServerName()+request.getContextPath();
    }else{
        path=(request.getScheme()+"://"+request.getServerName()+":"+request.getContextPath();
    }
    pageContext.setAttribute("path",path);   //kv值给jsp页面获取 作为绝对路径
%>


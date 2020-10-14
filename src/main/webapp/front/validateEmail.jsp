<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/15
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
<div class="container" style="margin-top:20px">
    <div class="row">
        <div class="col-md-5">
            <img src="images/DDlogoNEW.gif" alt="" class="pull-right">
        </div>
    </div>

    <hr style="border:solid 2px red">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <ul class="nav nav-pills " style="padding-top:10px">
                <li  style="margin: 10px;background:rgb(246,246,246)"><h5 style="margin:15px;">1.填写信息</h5></li>
                <li  style="margin: 10px;background:rgb(255,102,102)"><h5 style="margin:15px;color:rgb(255,231,250)" class="text-muted">2.验证邮箱</h5></li>
                <li  style="margin:10px;background:rgb(246,246,246)"><h5 style="margin:15px" class="text-muted">3.注册成功</h5></li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <p style="font-family: 宋体;font-weight: 700">
                感谢您注册当当网，现在请按一下步骤完成您的注册！<span style="color:red">${sessionScope.msg}</span>
            </p>
            <c:remove var="msg" scope="session"/>
            <hr>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p style="font-family: 宋体;font-weight: 700">第一步：查看您的电子邮箱</p>
            <p class="text-muted">我们给您发送了邮箱验证，邮箱的地址：<span style="color:red">${param.email}</span> 请登录您的邮箱收信。</p>
        </div>
    </div>

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <p style="font-family: 宋体;font-weight: 700">第二步：输入验证码</p>
            <form class="form-inline" action="${pageContext.request.contextPath}/register/Register_activation">
                <div class="form-group">
                    <label for="activeCode" class="text-muted small">输入您收到的邮箱中的验证码：</label>
                    <input type="hidden" name="email" value="${email}">
                    <input type="text" name="code" class="form-control" id="activeCode" placeholder="activeCode">
                </div>
                <button type="submit" class="btn btn-default">验证</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>

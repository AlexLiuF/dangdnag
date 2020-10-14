<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/13
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
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
                <li  style="margin: 10px;background:rgb(255,102,102)"><h5 style="margin:15px;color:rgb(255,231,250)">1.填写信息</h5></li>
                <li  style="margin: 10px;background:rgb(246,246,246)"><h5 style="margin:15px" class="text-muted">2.验证邮箱</h5></li>
                <li  style="margin:10px;background:rgb(246,246,246)"><h5 style="margin:15px" class="text-muted">3.注册成功</h5></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <h4 style="color:red;font-family: 宋体;text-align: center">以下均为必填项</h4>
            <h4 style="color:red">${sessionScope.msg}</h4>
            <c:remove var="msg" scope="session"/>
            <form action="${pageContext.request.contextPath}/register/Register_register" class="form-horizontal">
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">请填写您的Email地址:</label>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="email" class="form-control" id="email" placeholder="Email" name="email">
                            </div>
                            <div class="col-md-7">
                                <span>请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-3 control-label">设置您在当当网的昵称:</label>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="text" class="form-control" id="nickname" placeholder="nickname" name="nickname">
                            </div>
                            <div class="col-md-7">
                                <span>您的昵称可以由小写英文字母、中文、数字组成，长度4－20个字符。</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd1" class="col-sm-3 control-label">设置密码:</label>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="password" class="form-control" id="pwd1" placeholder="Password1" name="pwd1">
                            </div>
                            <div class="col-md-7">
                                <span>您的密码可以由大小写英文字母、数字组成，长度6－20位。</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd2" class="col-sm-3 control-label">再次输入您设置的密码:</label>
                    <div class="col-sm-9">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="password" class="form-control" id="pwd2" placeholder="Password2" name="pwd2">
                            </div>
                            <div class="col-md-7">
                                <span>两次密码必须一致。</span>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <label for="validateCode" class="col-sm-3 control-label">验证码:</label>
                    <div class="col-sm-9 ">
                        <div class="row">
                            <div class="col-md-5 form-inline">
                                <img src='${pageContext.request.contextPath}/vericode/Code_showCode' alt='' id='sr' onclick='chance()' height='50px' >
                                <input type="text" class="form-control" id="validateCode" name="code" placeholder="validateCode" style="width:170px">
                            </div>
                            <div class="col-md-7">
                                <span>请输入图片中的四个字母。<a href="">看不清楚？换个图片</a></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary">注册</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
		function chance() {
			var img=document.getElementById("sr");
			img.src="${pageContext.request.contextPath}/vericode/Code_showCode?a="+ Math.random();
		}
</script>
</body>
</html>

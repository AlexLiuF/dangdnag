<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body >
<div class="navbar navbar-default">
    <div class="container">
        <a href="http://www.baizhiedu.com" class="navbar-brand">百知教育</a>
    </div>
</div>
<div class="container" style="background: url('${pageContext.request.contextPath}/images/xiaojiejie.jpg') no-repeat center;">

    <div class="row" style="margin-top:50px" >
        <div class="col-sm-4 col-sm-offset-4">
            <div class="panel panel-default " style="opacity:0.65;">
                <div class="panel-heading">
                    <h5 class="panel-title">登录</h5>
                    <span>${sessionScope.msg }</span>
                    <c:remove var="msg" scope="session"/>
                </div>
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/loginback/Loginback_login" method="post">
                        <div class="form-group">
                            <label for="username" class="control-label">用户名</label>
                            <input type="text" name="username" id="username" class="form-control" placeholder="用户名"/>
                        </div>
                        <div class="form-group">
                            <label for="pwd" class="control-label">密码</label>
                            <input type="password" class="form-control" name="password" id="pwd" placeholder="密码">
                        </div>
                        <div class="form-group">
                            <label for="validateCode" class="control-label">验证码</label>
                            <div class="form-inline">
                                <input type="text" class="form-control" name="validateCode" id="validateCode" placeholder="验证码">
                                <img src="${pageContext.request.contextPath}/vericode/Code_showCode" width="80px" height="40px" class="form-inline" onclick="this.src='/dangdang/validateCode.png?r='+Math.random();">
                            </div>

                        </div>
                        <button type="submit" class="btn btn-primary">登录</button>
                    </form>
                </div>
                <div class="panel-footer"></div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    if(top != window){
        top.location.href = window.location.href;
    }
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/13
  Time: 20:56
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
        <div class="col-md-offset-1 col-md-5">
            <h4>当当网，全球最大的中文网上书店</h4>
            <hr>
            <ul>
                <li><span>更多选择</span>
                    <p class="text-muted">60万种图书音像，共计百万种商品。</p>
                </li>
                <li><span>更低价格</span>
                    <p class="text-muted">电视购物的3-5折，传统书店的5-7折，其他网站的7-9折。</p>
                </li>
                <li><span>更方便、更安全</span>
                    <p class="text-muted">全国超过300个城市送货上门、货到付款。零风险购物，便捷到家。</p>
                </li>
            </ul>
        </div>
        <div class="col-md-4 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">登录当当网 </h3>
               		
                </div>
                <div class="panel-body" style="background:#F5F5F5">
                	<span class="h6" style="color:red">  ${sessionScope.msg }</span>
                	<c:remove var="msg" scope="session"/> 
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/register/Register_login">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">登录</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">
                    <h5 style="font-weight: 500">您还不是当当网用户？</h5>
                    <h6 style="text-align:right;color:blue">
                        <a href="register.jsp">创建一个新用户</a>
                    </h6>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

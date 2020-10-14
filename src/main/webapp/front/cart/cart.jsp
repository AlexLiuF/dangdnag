<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/14
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
<%@ include file="/front/commons/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/images/cart/dd_logo.jpg" alt="" class="pull-right">
        </div>
        <div class="col-md-7">

            <ul class="nav nav-pills " style="padding-top:10px">
                <li  style="margin: 10px;background:rgb(255,102,102)"><h4 style="margin:15px;color:rgb(255,231,250)">1.购物车</h4></li>
                <li  style="margin: 10px;background:rgb(246,246,246)"><h4 style="margin:15px" class="text-muted">2.填写订单</h4></li>
                <li  style="margin:10px;background:rgb(246,246,246)"><h4 style="margin:15px" class="text-muted">3.支付订单</h4></li>
            </ul>
        </div>
    </div>
    <hr style="border:solid 2px red;">
    
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="row">
                <div class="col-sm-12" style="padding-left:150px">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-4">商品信息</div>
                            <div class="col-md-2">单价（元）</div>
                            <div class="col-md-2 text-center">数量</div>
                            <div class="col-md-2">金额（元）</div>
                            <div class="col-md-2">操作</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-body">
            <ul class="media-list">
                <c:forEach var="e" items="${sessionScope.cart.items}">
                    <div class="media">
                        <div class="media-left media-middle">
                            <img src="${pageContext.request.contextPath}/images/book/${e.value.book.cover}" alt="" class="media-object" style="width:130px">
                        </div>
                        <div class="media-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-4">
                                        <span class="text-muted small">${e.value.book.name}</span>
                                    </div>
                                    <div class="col-md-2">
                                        <span class="text-muted small">￥${e.value.book.dprice}</span>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="input-group">
                                            <div class="input-group-btn" onclick="location.href='${pageContext.request.contextPath}/cart/Cart_decrease?bookId=${e.key}'">
                                                <button class="btn btn-default minus" ><span class="glyphicon glyphicon-minus"/></button>
                                            </div>
                                            <input type="hidden" name="id" value="${e.key}">
                                            <input type="text"  class="form-control text-center" name="count" id="" value="${e.value.count}" >
                                            <div class="input-group-btn" onclick="location.href='${pageContext.request.contextPath}/cart/Cart_add?bookId=${e.key}'">
                                                <button class="btn btn-default plus" ><span class="glyphicon glyphicon-plus"/></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <span class="text-muted small text-center">￥${e.value.book.dprice * e.value.count}</span>
                                    </div>
                                    <div class="col-md-2">
                                        <a href="${pageContext.request.contextPath}/cart/Cart_delete?bookId=${e.key}" class="text-muted small">删除</a>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <hr>
                    </div>
                </c:forEach>
            </ul>
        <div class="row">
	    	<div class="col-md-offset-11 col-md-1">
	    		<a href="${pageContext.request.contextPath }/cart/Cart_gotoMain" >回到首页</a>
	    	</div>
	    </div>
        </div>
        <div class="panel-footer">
            <div class="row">
                <div class="col-md-2 text-center">
                    <strong class="h4 center-block">店铺合计</strong>
                </div>
                <div class="col-md-3 col-md-offset-7">
                    <div class="row">
                        <div class="col-md-6">
                            <p><span class="small text-muted">总计：</span><span style="color:red">￥${sessionScope.cart.totalPrice}</span></p>
                            <p class="small text-muted">已节省：<span>￥${sessionScope.cart.savePrice}</span></p>
                        </div>
                        <div class="col-md-6">
                            <a href="${pageContext.request.contextPath}/order/Order_selectAll?userId=${sessionScope.user.id}" class="btn btn-danger">结算</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>

</body>
</html>

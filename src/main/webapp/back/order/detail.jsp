<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/18
  Time: 21:45
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
<div class="panel panel-default">
    <div class="panel-heading">
        <h4>订单详情信息</h4>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>订单号：${order.id}</th>
                <th colspan="2">订单金额 ￥：${order.total}</th>
                <th colspan="2">订单状态：${order.status == 0? "未支付":"已支付"}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.book.name}</td>
                    <td><img src="${pageContext.request.contextPath}/images/book/${item.book.cover}" alt="" style="height: 20px"></td>
                    <td>单价:￥${item.book.price}</td>
                    <td>当当价:￥${item.book.dprice}</td>
                    <td>${item.count}本</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="panel-footer"></div>
</div>
</body>
</html>

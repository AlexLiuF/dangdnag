<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/18
  Time: 21:44
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
        <h4>订单管理</h4>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>订单编号</th>
                <th>金额</th>
                <th>订单状态</th>
                <th>收件人</th>
                <th>收货地址</th>
                <th>创建日期</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="o" items="${list}">
                <tr>
                    <td>${o.id}</td>
                    <td>${o.total}</td>
                    <td>${o.status == 0 ? "未付款":"已付款"}</td>
                    <td>${o.name}</td>
                    <td>${o.city}</td>
                    <td><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd"/> </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/orderback/Orderback_showItem?orderId=${o.id}" class="btn btn-info" >订单详细信息</a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
        <ul class="pagination">
        	<c:if test="${!page.hasPreviousPage}">
                <li class="disabled"><a href="javascript:void(0)"><span>&laquo;</span></a></li>
            </c:if>
            <c:if test="${page.hasPreviousPage}">
                <li><a href="${pageContext.request.contextPath}/orderback/Orderback_showAll?pageNum=${page.prePage}&pageSize=${page.pageSize}"><span>&laquo;</span></a></li>
            </c:if>
            <c:forEach var="i" items="${page.navigatepageNums }">
                <li><a href="${pageContext.request.contextPath}/orderback/Orderback_showAll?pageNum=${i}&pageSize=${page.pageSize}">${i}</a></li>
            </c:forEach>
            <c:if test="${!page.hasNextPage}">
                <li class="disabled"><a href="javascript:void(0)"><span>&raquo;</span></a></li>
            </c:if>
            <c:if test="${page.hasNextPage}">
                <li><a href="${pageContext.request.contextPath}/orderback/Orderback_showAll?pageNum=${page.nextPage}&pageSize=${page.pageSize}"><span>&raquo;</span></a></li>
            </c:if>
            
        </ul>
    </div>
    <div class="panel-footer"></div>
</div>
<script>
    console.log(document.body.scrollHeight);
    $(function(){
        $(".collapse").on('shown.bs.collapse',function(){
            console.log("shown");
            console.log(document.body.scrollHeight);
            $(parent.document).find("#content").prop("height",document.body.scrollHeight);
        })

        $(".collapse").on("hidden.bs.collapse",function(){
            console.log("hidden");
            console.log(document.body.scrollHeight);
            $(parent.document).find("#content").prop("height",document.body.scrollHeight);
        })
    })
</script>
</body>
</html>

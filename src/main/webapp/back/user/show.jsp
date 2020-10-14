<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/12
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width" initial-scale="1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4>用户管理</h4>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>昵称</th>
                <th>邮箱</th>
                <th>状态</th>
                <th>激活码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${list}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.nickname}</td>
                    <td>${u.email}</td>
                    <c:if test="${u.status==1}">
                   		<td>激活状态</td>
                   	</c:if>
                   	<c:if test="${u.status==0}">
                   		<td>冻结状态</td>
                   	</c:if> 
                    
                    <td>${u.code}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/user/User_updateStatus?id=${u.id}&status=${u.status == 1 ?0:1}" class="btn btn-warning">修改状态</a>
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
                <li><a href="${pageContext.request.contextPath}/user/User_selectAll?pageNum=${page.prePage}&pageSize=${page.pageSize}"><span>&laquo;</span></a></li>
            </c:if>
            <c:forEach var="i" items="${page.navigatepageNums }">
                <li><a href="${pageContext.request.contextPath}/user/User_selectAll?pageNum=${i}&pageSize=${page.pageSize}">${i}</a></li>
            </c:forEach>
            <c:if test="${!page.hasNextPage}">
                <li class="disabled"><a href="javascript:void(0)"><span>&raquo;</span></a></li>
            </c:if>
            <c:if test="${page.hasNextPage}">
                <li><a href="${pageContext.request.contextPath}/user/User_selectAll?pageNum=${page.nextPage}&pageSize=${page.pageSize}"><span>&raquo;</span></a></li>
            </c:if>
            
            
        </ul>
    </div>
    <div class="panel-footer"></div>
</div>
<script>

</script>
</body>
</html>

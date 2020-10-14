<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <h4>添加二级类别</h4>
    </div>
    <div class="panel-body">
        <form action="${pageContext.request.contextPath}/back/category/add" class="form-horizontal">
            <div class="form-group">
                <label for="parentId" class="control-label col-xs-12 col-sm-2">所属一级类别：</label>
                <div class="col-xs-12 col-sm-4">
                    <select id="parentId" name="parent.id" class="form-control">
                        <c:forEach var="p" items="${categories}">
                            <option value="${p.id}">${p.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="categoryName" class="control-label col-xs-12 col-sm-2">二级类别：</label>
                <div class="col-xs-12 col-sm-4">
                    <input type="text" id="categoryName" name="name" class="form-control">
                    <input type="hidden" name="levels" value="2"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-success pull-right">提交</button>
                </div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-warning" onclick="history.go(-1)">返回</button>
                </div>
            </div>
        </form>
    </div>
    <div class="panel-footer"></div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 15:27
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
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4>添加一级类别</h4>
    </div>
    <div class="panel-body">
        <form action="${pageContext.request.contextPath}/back/category/add" class="form-horizontal" >
            <div class="form-group">
                <label for="categoryName" class="control-label col-xs-12 col-sm-2">类别名：</label>
                <div class="col-xs-12 col-sm-4">
                    <input id="categoryName" class="form-control " name="name" placeholder="类别名">
                    <input type="hidden" name="levels" value="1"/>
                </div>

            </div>
            <div class="form-group">
                <div class="col-sm-2">
                    <button type="submit" class="btn btn-success pull-right">提交</button>
                </div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-warning " onclick="history.go(-1)">返回</button>
                </div>

            </div>

        </form>
    </div>
    <div class="panel-footer"></div>
</div>
</body>
</html>

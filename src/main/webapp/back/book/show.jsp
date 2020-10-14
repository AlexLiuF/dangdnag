<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <h4 >图书管理</h4>

        <a href="${pageContext.request.contextPath}/books/Book_selectByLeversTwo?levels=2" class="btn btn-info">添加图书</a>
        <form action="${pageContext.request.contextPath}/books/Book_selectAll" class="form-inline pull-right">
            <div class="form-group">
                <select name="query" id="" class="form-control">
                    <option value="name">书名</option>
                    <option value="author">作者</option>
                    <option value="press">出版社</option>
                </select>
            </div>
            <div class="form-group">
                <input type="text" name="value" placeholder="请输入查询条件" id="" class="form-control">
            </div>
            <button type="submit" class="btn btn-info">搜索</button>
        </form>
        <div class="clearfix"></div>
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>名称</th>
                <th>作者</th>
                <th>价格</th>
                <th>当当价</th>
                <th>出版社</th>
                <th>出版时间</th>
                <th>封面图</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${list}" varStatus="vs">
                <tr>
                    <td>${b.name}</td>
                    <td>${b.author}</td>
                    <td>${b.price}</td>
                    <td>${b.dprice}</td>
                    <td>${b.press}</td>
                    <td>
                        <fmt:formatDate value="${b.createDate}" pattern="yyyy-MM-dd"/> 
                    </td>
                    <td><img src="${b.cover}" style="height:30px"></td>
                    <td>${b.sale}</td>
                    <td>${b.stock}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/books/Book_updateShow?id=${b.id}" class="btn btn-warning">修改</a>
                        <a href="#" class="btn btn-danger" data-target="#book${vs.count}" data-toggle="modal">删除</a>
                    </td>
                    <div id="book${vs.count}" class="modal fade">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5 class="text-danger">确认删除吗?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                                    <button type="button" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath}/books/Book_delete?id=${b.id}&query=${query}&value=${value}&pageNum=${page.pageNum}&pageSize=${page.pageSize}';">确认</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>

            </c:forEach>
            </tbody>
        </table>
       
      <ul class="pagination">
            <c:if test="${!page.hasPreviousPage}">
                <li class="disabled"><a href="javascript:void(0)"><span>&laquo;</span></a></li>
            </c:if>
            <c:if test="${page.hasPreviousPage}">
                <li><a href="${pageContext.request.contextPath}/books/Book_selectAll?query=${query}&value=${value}&pageNum=${page.prePage}&pageSize=${page.pageSize}"><span>&laquo;</span></a></li>
            </c:if>
            <c:forEach var="i" items="${page.navigatepageNums }">
                <li><a href="${pageContext.request.contextPath}/books/Book_selectAll?query=${query}&value=${value}&pageNum=${i}&pageSize=${page.pageSize}">${i}</a></li>
            </c:forEach>
            <c:if test="${!page.hasNextPage}">
                <li class="disabled"><a href="javascript:void(0)"><span>&raquo;</span></a></li>
            </c:if>
            <c:if test="${page.hasNextPage}">
                <li><a href="${pageContext.request.contextPath}/books/Book_selectAll?query=${query}&value=${value}&pageNum=${page.nextPage}&pageSize=${page.pageSize}"><span>&raquo;</span></a></li>
            </c:if>
        </ul>
    </div>
    <div class="panel-footer"></div>
    
    <script type="text/javascript">
    	if("${sessionScope.msg}"){
    		alert("${sessionScope.msg}");
    	}
    </script>
    <% session.removeAttribute("msg"); %>
</div>
</body>
</html>

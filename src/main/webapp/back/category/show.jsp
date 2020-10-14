<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 11:47
  To change this template use File | Settings | File Templates.
  
--%>
<%@page import="com.github.pagehelper.Page"%>
<%@page import="com.github.pagehelper.PageInfo"%>
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
        <div class="row">
            <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
                <h4 >类别管理</h4>
            </div>
            <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-sm-offset-8">
                <a href="#add" class="btn btn-default" data-toggle="modal" >添加 <span class="glyphicon glyphicon-plus"></span></a>
                <div id="add" class="modal fade">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" data-dismiss="modal"><span>&times;</span></button>
                                </div>
                                <div class="modal-body">
             
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/category/Category_insertOneGarde">
					       
					                    <c:if test="${!empty parentId}">
					                	 
					                    <div class="form-group">
					                        <label for="" class="col-sm-4 control-label">父类别：</label>
					                        <div class="col-sm-8">
					                            <input type="hidden" class="form-control" name="c.parentId" value="${parent.id }">
					                        	<strong>${parent.name }</strong>
					                        </div>
					                    </div>
					                    </c:if>
					                    <div class="form-group">
					                        <label for="" class="col-sm-4 control-label">类别名：</label>
					                        <div class="col-sm-8">
					                            <input type="text" class="form-control" name="c.name"  placeholder="类别名">
					                        </div>
					                    </div>
					                    
					                    <div class="form-group">
					                        <div class="col-sm-offset-4 col-sm-2">
					                            <button type="submit" class="btn btn-primary">添加</button>
					
					                        </div>
					                        <div class="col-sm-offset-1 col-sm-2">
					                            <button class="btn btn-default" data-dismiss="modal">取消</button>
					                        </div>
					                    </div>
					                </form>
                                </div>
                                <div class="modal-footer">                               </div>
                            </div>
                        </div>
                    </div>
                <%-- <div class="dropdown">
                    <a href="" class="btn btn-default" data-toggle="dropdown" >添加 <span class="glyphicon glyphicon-plus"></span></a>
                    <ul class="dropdown-menu" >
                        <li><a href="${pageContext.request.contextPath}/back/category/add-first.jsp" >添加一级类别</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/back/category/showLevel1Category" >添加二级类别</a></li>
                    </ul>
                </div> --%>
            </div>

        </div>
        
    </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>编号</th>
                <th>类别名</th>
                <th>级别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
         
            <c:forEach var="c" items="${list}" varStatus="vs">
              	<c:if test="${c.levels == 1 }">
                <tr ondblclick="location.href='${pageContext.request.contextPath}/category/Category_selectByParentId?parentId=${c.id}'">
                </c:if>
                <c:if test="${c.levels == 2}">
                <tr>
                </c:if>
                
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.levels}</td>
              
                    <td>
                        <a href="" class="btn btn-default" data-toggle="modal" data-target="#delete${vs.count}"><span class="text-danger">删除 </span><span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                    <div id="delete${vs.count}" class="modal fade">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" data-dismiss="modal"><span>&times;</span></button>
                                </div>
                                <div class="modal-body">
                                    <h5>确认删除吗?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/category/Category_delete?c.id=${c.id}&c.parentId=${parentId}&pageNum=${page.pageNum}&pagesize=${page.pageSize}'">确认</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </tr>

            </c:forEach>
            </tbody>
        </table>
               <ul class="pagination">
                <c:if test="${page.pageNum == 1}">
                    <li class="disabled">
                    <a href="javascript:void(0)" aria-label="Previous" >
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                    </li>
                </c:if>
                <c:if test="${page.pageNum > 1}">
                    <li>
                    <a href="${pageContext.request.contextPath}/category/Category_showAll?parentId=${parentId}&pageNum=${page.pageNum-1}&pageSize=${page.pageSize}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                </c:if>
            <c:forEach var="i" begin="${page.navigateFirstPage }" end="${page.navigateLastPage}">
                <li ${page.pageNum == i? "class='active'":""}><a href="${pageContext.request.contextPath}/category/Category_showAll?parentId=${parentId}&pageNum=${i}&pageSize=${page.pageSize}">${i}</a></li>
            </c:forEach>
            
            <!--
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            -->
                <c:if test="${page.pageNum == page.pages}">
            <li class="disabled">
                    <a href="javascript:void(0)" aria-label="Previous" class="disabled">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
            </li>
                </c:if>
                <c:if test="${page.pageNum < page.pages}">
            <li>
                    <a href="${pageContext.request.contextPath}/category/Category_showAll?parentId=${parentId}&pageNum=${page.pageNum+1}&pageSize=${page.pageSize}" aria-label="Previous">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
        </li>
            </c:if>
        </ul>
    </div>
    <div class="panel-footer" >
    </div>
</div>
<script type="text/javascript">


<%--alert(${sessionScope.msg})--%>
if("${sessionScope.msg}"){
    alert("${sessionScope.msg}");
}


</script>
<% session.removeAttribute("msg"); %>
</body>
</html>

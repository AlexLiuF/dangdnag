<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/14
  Time: 22:28
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
<%@ include file="/front/commons/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <img class="pull-right" src="${pageContext.request.contextPath}/images/book/${book.cover}" alt="">
        </div>
        <div class="col-md-8">
            <h3>${book.name}</h3>
            <hr>
            <p>作者：${book.author}</p>
            <p>出版社：${book.press}</p>

            <div class="row">
                <div class="col-md-5">出版时间：<fmt:formatDate value="${book.press_date}" pattern="yyyy-MM-dd"/> </div>
                <div class="col-md-7">字数：${book.wordNum}</div>
            </div>
            <div class="row">
                <div class="col-md-5">版次：${book.edition}</div>
                <div class="col-md-7">页数：${book.pageNum}</div>
            </div>
            <div class="row">
                <div class="col-md-5">印刷时间：<fmt:formatDate value="${book.printDate}" pattern="yyyy-MM-dd"/> </div>
                <div class="col-md-7">开本：${book.sizeB}</div>
            </div>
            <div class="row">
                <div class="col-md-5">印次：${book.impression}</div>
                <div class="col-md-7">纸张：${book.paper}</div>
            </div>
            <div class="row">
                <div class="col-md-5">ISBN：${book.isbn}</div>
                <div class="col-md-7">包装：${book.pack}</div>
            </div>
            <p>
                定价：<del>￥${book.price}</del>     <span style="color:red">当当价：￥${book.dprice}</span>     节省：￥${book.price - book.dprice}
            </p>
            <p><a href="${pageContext.request.contextPath}/cart/Cart_goCart?bookId=${book.id}" class="btn btn-danger">加入购物车</a></p>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-12">
                <strong>编辑推荐</strong>
                <p class="well">${book.editorRecommend}</p>
                <hr>
                <strong>内容简介</strong>
                <p class="well">${book.contentAbstract}</p>
                <hr>
                <strong>作者简介</strong>
                <p class="well">${book.authorAbstract}</p>
                <hr>
                <strong>目录</strong>
                <p class="well">${book.director}</p>
                <hr>
                <strong>媒体评论</strong>
                <p class="well"> ${book.mediaCommentary}</p>
                <hr>
            </div>
        </div>


    </div>
    <h4></h4>
    <p></p>



</div>
</body>
</html>

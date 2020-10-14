<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/12
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <style type="text/css">


        #file_upload1 {
            display: none;
        }
        #file_upload1_label {
            display: inline-block;
            border: 1px solid #aaa;
            width: 120px;
            height: 145px;
            margin-left: 20px;
            text-align: center;
            line-height: 145px;
            cursor: pointer;
        }
    </style>


</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="text-left">修改图书信息</h4>
    </div>
    <div class="panel-body" >
        <form action="${pageContext.request.contextPath}/books/Book_update" method="post" enctype="multipart/form-data" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2">名称：</label>
                <div class="col-sm-4">
                    <input type="hidden" name="b.id" value="${b.id}"/>
                    <input type="text" name="b.name" class="form-control" value="${b.name}"></div>

                <label class="control-label col-sm-2">页数：</label>
                <div class="col-sm-4"><input type="number" name="b.pageNum" class="form-control" value="${b.pageNum}" ></div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">所属分类：</label>
                <div class="col-sm-4">
                    <select name="b.category.id" class="form-control inner2">
                        <c:forEach var="c" items="${list1}">
                            <option value="${c.id}" ${b.categoryId == c.id ? "selected":""}>${c.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <label class="control-label col-sm-2">字数：</label>
                <div class="col-sm-4"><input type="number" name="b.wordNum" class="form-control" value="${b.wordNum}" ></div>
            </div>
            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">原价：</label>
                        <div class="col-sm-8"><input type="number" name="b.price" class="form-control" value="${b.price}"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">当当价：</label>
                        <div class="col-sm-8"><input type=number name="b.dprice" class="form-control" value="${b.dprice}"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">库存：</label>
                        <div class="col-sm-8"><input type="number" name="b.stock" class="form-control" value="${b.stock}"></div>
                    </div>

                </div>

                <label class="control-label col-sm-2">封面：</label>
                <div class="col-sm-4">
                    <label id="file_upload1_label" for="file_upload1">
                        <img id="uploadimg" src="${pageContext.request.contextPath}/images/book/${b.cover}" alt="" width="120" height="145" />
                    </label>
                    <input type="file" name="pic" class="" id="file_upload1" onchange="upload_review()">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">作者：</label>
                        <div class="col-sm-8"><input type="text" name="b.author" class="form-control" value="${b.author}"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">出版社：</label></td>
                        <div class="col-sm-8"><input type="text" name="b.press" class="form-control" value="${b.press}"></div>
                    </div>
                </div>

                <label class="control-label col-sm-2">编辑推荐：</label>
                <div class="col-sm-4"><textarea class="form-control" name="b.editorRecommend">${b.editorRecommend}</textarea></div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">出版时间：</label>
                        <div class="col-sm-8"><input type="date" name="b.press_date" class="form-control" value="<fmt:formatDate value='${b.press_date}' pattern='yyyy-MM-dd'/>" "></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">版次：</label>
                        <div class="col-sm-8"><input type="text" name="b.edition" class="form-control" value="${b.edition}"></div>
                    </div>
                </div>

                <label class="control-label col-sm-2">内容简介：</label>
                <div class="col-sm-4"><textarea class="form-control" name="b.contentAbstract" >${b.contentAbstract}</textarea></div>
            </div>


            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">印刷时间：</label>
                        <div class="col-sm-8"><input type="date" name="b.printDate" class="form-control" value="<fmt:formatDate value='${b.printDate}' pattern='yyyy-MM-dd' />"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">印次：</label>
                        <div class="col-sm-8"><input type="text" name="b.impression" class="form-control" value="${b.impression}"></div>
                    </div>
                </div>

                <label class="control-label col-sm-2">作者简介：</label>
                <div class="col-sm-4"><textarea class="form-control" name="b.authorAbstract">${b.authorAbstract}</textarea></div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">ISBN：</label>
                        <div class="col-sm-8"><input type="text" name="b.isbn" class="form-control " value="${b.isbn}"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">开本：</label>
                        <div class="col-sm-8"><input type="text" name="b.sizeB" class="form-control" value="${b.sizeB}"></div>
                    </div>
                </div>

                <label class="control-label col-sm-2">基本目录：</label>
                <div class="col-sm-4"><textarea class="form-control" name="b.director" >${b.director}</textarea></div>
            </div>
            <div class="form-group">

            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="control-label col-sm-4">纸张：</label>
                        <div class="col-sm-8"><input type="text" name="b.paper" class="form-control" value="${b.paper}"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4">包装：</label>
                        <div class="col-sm-8"><input type="text" name="b.pack" class="form-control" value="${b.pack}"></div>
                    </div>
                </div>

                <label class="control-label col-sm-2">媒体评论：</label>
                <div class="col-sm-4"><textarea class="form-control" name="b.mediaCommentary">${b.mediaCommentary}</textarea></div>
            </div>

            <div class="form-group">
                <div class="col-sm-6">
                    <input type="submit" class="btn btn-success pull-right" value="提交" />
                </div>
                <div class="col-sm-6">
                    <input type="button" class="btn btn-warning" value="返回上级" onclick="history.go(-1);" />
                </div>
            </div>


        </form>
    </div>
    <div class="panel-footer"></div>
</div>

<script>
    function upload_review() {
        var img = document.getElementById("uploadimg");
        var input = document.getElementById("file_upload1");
        var tip = document.getElementById("uploadtip");

        var file = input.files.item(0);
        var freader = new FileReader();
        freader.readAsDataURL(file);
        freader.onload = function(e) {
            img.src = e.target.result;
            tip.style.display = "none";
        };
    }
</script>
</body>
</html>

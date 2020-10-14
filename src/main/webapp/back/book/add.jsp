<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/12
  Time: 11:21
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
        td {
            padding-top: 8px;
        }

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

<body
        style="text-align: center">
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="text-left">添加图书</h4>
    </div>
    <div class="panel-body">
        <form action="${pageContext.request.contextPath}/books/Book_insert" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td><label for="" class="control-label">名称：</label></td>
                    <td><input type="text" name="b.name" class="form-control"></td>
                    <td rowspan="14" style="width: 300px">
                    <td><label for="" class="control-label">页数：</label></td>
                    <td><input type="number" name="b.pageNum" class="form-control"></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">所属分类：</label></td>
                    <td>
                        <select name="b.categoryId" class="el-select__inner inner2 form-control">
                            <c:forEach var="c" items="${list1}">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>

                        </select>
                    </td>
                    <td><label for="" class="control-label">字数：</label></td>
                    <td><input type="number" name="b.wordNum" class="form-control"></td>
                </tr>

                <tr>
                    <td><label for="" class="control-label">原价：</label></td>
                    <td><input type="number" name="b.price" class="form-control"></td>
                    <td><label for="" class="control-label">封面：</label></td>
                    <td rowspan="3">
                        <label id="file_upload1_label" for="file_upload1">
                            <span id="uploadtip">添加图书封面</span>
                            <img id="uploadimg" src="" alt="" width="118px" height="143px" />
                        </label>
                        <input type="file" name="pic" class="" id="file_upload1"	onchange="upload_review()">
                    </td>
                </tr>

                <tr>
                    <td><label for="" class="control-label">当当价：</label></td>
                    <td><input type=number name="b.dprice" class="  form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">库存：</label></td>
                    <td><input type="number" name="b.stock" class="  form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">作者：</label></td>
                    <td><input type="text" name="b.author" class="  form-control"></td>
                    <td><label for="" class="control-label">编辑推荐：</label></td>
                    <td rowspan="2"><textarea class="form-control" name="b.editorRecommend"></textarea></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">出版社：</label></td>
                    <td><input type="text" name="b.press" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">出版时间：</label></td>
                    <td><input type="date" name="b.press_date" class="form-control"></td>
                    <td><label for="" class="control-label">内容简介：</label></td>
                    <td rowspan="2"><textarea class="form-control" name="b.contentAbstract"></textarea></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">版次：</label></td>
                    <td><input type="text" name="b.edition" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">印刷时间：</label></td>
                    <td><input type="date" name="b.printDate" class="form-control"></td>
                    <td><label for="" class="control-label">作者简介：</label></td>
                    <td rowspan="2"><textarea class="form-control" name="b.authorAbstract"></textarea></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">印次：</label></td>
                    <td><input type="text" name="b.impression" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">ISBN：</label></td>
                    <td><input type="text" name="b.isbn" class="form-control"></td>
                    <td><label for="" class="control-label">基本目录：</label></td>
                    <td rowspan="2"><textarea class="form-control" name="b.director"></textarea></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">开本：</label></td>
                    <td><input type="text" name="b.sizeB" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">纸张：</label></td>
                    <td><input type="text" name="b.paper" class="form-control"></td>
                    <td><label for="" class="control-label">媒体评论：</label></td>
                    <td rowspan="2"><textarea class="form-control" name="b.mediaCommentary"></textarea></td>
                </tr>
                <tr>
                    <td><label for="" class="control-label">包装：</label></td>
                    <td><input type="text" name="b.pack" class="form-control"></td>
                    <td></td>
                </tr>
            </table>
            <input type="submit" class="btn btn-success" value="提交" />&emsp;
            <input type="button" class="btn btn-warning" value="返回上级" onclick="history.go(-1);" />
        </form>
    </div>
    <div class="panel-footer"></div>
</div>
<c:if test="${!empty sessionScope.msg}">
		alert("${sessionScope.msg}")
	</c:if>
	<c:remove var="msg" scope="session"/>
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

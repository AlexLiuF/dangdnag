<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/11
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" style="margin:0;padding:0">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <style type="text/css">
        ::-webkit-scrollbar {
            display: none;
        }
    </style>
</head>
<body style="margin:0;padding:0">
<!-- 设置页眉-->
<div class="header">
    <div class="navbar navbar-default">
        <div class="container">
            <!-- 设置公司标识-->
            <div class="navbar-header">
                <button class="navbar-toggle" data-toggle="collapse" data-target="#admin">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="http://www.baizhiedu.com" class="navbar-brand">
                    <img src="${pageContext.request.contextPath}/images/logo1.png" alt="" style="height:30px;margin-top:-7px;display:inline-block">
                    <span class="hidden-xs hidden-sm">当当网后台管理系统</span>
                </a>
            </div>
            <div class="collapse navbar-collapse navbar-right" id="admin">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-wrench padding-right-small" style="position:relative;top: 3px;"/>&nbsp;Admin<i class="caret"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href=""><span class="glyphicon glyphicon-cog" /><span> 我的信息</span></a></li>
                            <li class="divider"></li>
                            <li><a href=""><span class="glyphicon glyphicon-off"/><span> 安全退出</span></a></li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- 主体区域-->
<div class="container">
    <div class="row">
        <!-- 左侧边栏 -->
        <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" >
            <div id="menu">
                <h4 class="text-center">系统主菜单</h4>
                <div class="list-group text-center" >
                    <a href="${pageContext.request.contextPath}/category/Category_showAll" target="content" class="list-group-item"><span class="glyphicon glyphicon-list"/>&nbsp;类别管理</a>
                    <a href="${pageContext.request.contextPath}/books/Book_selectAll" target="content" class="list-group-item"><span class="glyphicon glyphicon-book"/>&nbsp;图书管理</a>
                    <a href="${pageContext.request.contextPath}/orderback/Orderback_showAll" target="content" class="list-group-item"><span class="glyphicon glyphicon-credit-card"/>&nbsp;订单管理</a>
                    <a href="${pageContext.request.contextPath}/user/User_selectAll" target="content" class="list-group-item"><span class="glyphicon glyphicon-user"/>&nbsp;用户管理</a>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-10 col-md-10 col-lg-10" >

            <iframe name="content" id="content" src="content.html" class="embed-responsive-item"  style="width:100%;padding:0;margin:0" onload="this.height=content.document.body.scrollHeight;console.log(this.height);console.log(content.document.body.scrollWidth)" scrolling="no" frameborder="0">

            </iframe>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        var menu = $(".list-group>.list-group-item");
        menu.click(function(){
            menu.removeClass("active")
            $(this).addClass("active");
        });

        $("#menu").affix({
            offset:{
                top:function(){
                    return this.top = 1;
                }
            }
        })
        var wd = $("#menu").width();
        $(window).scroll(function() {
            $("#menu").css("width", wd);
        });
    })
</script>


</body>
</html>

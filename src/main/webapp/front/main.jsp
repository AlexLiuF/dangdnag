<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/13
  Time: 22:20
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
    <style type="text/css">
        .navbar-nav li.divider:after {
            content: '';
            position: absolute;
            width: 1px;
            height: 14px;
            background-color: #a4a4a4;
            top: 18px;
            right: 0;
        }
        .carousel-indicators li{
            background-color:rgba(167,167,167,0.5);
        }
    </style>
</head>
<body>
<%@ include file="/front/commons/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <img src="images/DDlogoNEW.gif" alt="">
        </div>
        <div class="col-md-6">
            <form action="${pageContext.request.contextPath}/front/Front_selectByValue">
                <div class="input-group navbar-btn">
                    <input type="text" name="value" placeholder="搜索关键字" id="" class="form-control">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span></button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3">
            <ul class="nav nav-pills">
                <li class="bg-success"><a href="${pageContext.request.contextPath}/cart/Cart_gotoCart"><span class="text-muted">购物车</span><span class="badge">0</span></a></li>
                <li class="bg-info"><a href=""><span class="text-muted">我的订单</span></a></li>
            </ul>
        </div>
    </div>

    <br>
    <br>
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h5 class="panel-title">分类浏览</h5>
                </div>
                <div class="panel-body">
                    <div class="panel-group" id="category">
                 
                        <c:forEach begin="0" end="6" var="p" items="${list}" varStatus="vs">
                            <a href="#${vs.count}" data-toggle="collapse" data-parent="#category"><strong class="text-danger">[${p.name}]</strong></a>

                            <div class="panel">
                                <div class="panel-collapse collapse" id="${vs.count}">
                                    <div class="panel-body bg-success">
                                        <h5><a href="${pageContext.request.contextPath}/front/Front_selectSortShow?fid=${p.id}">${p.name}</a></h5>
                                        <c:forEach var="c" items="${p.lis}">
                                            <a href="${pageContext.request.contextPath}/front/Front_selectSortShow?fid=${p.id}&sid=${c.id}&sname=${c.name}"><span class="text-info">${c.name}</span></a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div id="top" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#top" data-slide-to="0"></li>
                    <li data-target="#top" data-slide-to="1"></li>
                    <li data-target="#top" data-slide-to="2"></li>
                    <li data-target="#top" data-slide-to="3"></li>
                    <li data-target="#top" data-slide-to="4"></li>
                    <li data-target="#top" data-slide-to="5"></li>
                </ol>

                <div class="carousel-inner" role="list-box">
                    <div class="item active">
                        <img src="images/top/hzjsj2020618750315.jpg" alt="">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="images/top/200424_wj_sxzmzt_750x315.jpg" alt="">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="images/top/200513_rjn2_dptj_750x315.jpg" alt="">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="images/top/rrkddlzjs750315.jpg" alt="">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="images/top/xcjg750_315.jpg" alt="">
                        <div></div>
                    </div>
                    <div class="item">
                        <img src="images/top/yunjisuan0422750315.jpg" alt="">
                        <div></div>
                    </div>
                </div>

                <a href="#top" class="left carousel-control" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a href="#top" class="right carousel-control" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
        <div class="col-md-3">
            <h4>信息公告</h4>
            <ul>
                <li>精品童装限时0元领</li>
                <li>30万图书 5折封顶</li>
                <li>当当阅读器 海量电子书免费读</li>
                <li>多种商品，礼品卡支付更优惠</li>
                <li>当当周年庆 实付200再减30</li>
            </ul>
        </div>
    </div>

    <br>
    <br>
    <div class="row">
        <div class="col-sm-12">

            <ul class="nav nav-tabs" style="display:inline-block">
                <li class="active"><a href="#recommend" data-toggle="tab"><strong>编辑推荐</strong></a></li>
                <li><a href="#hot-sale" data-toggle="tab"><strong>热销图书</strong></a></li>
                <li><a href="#new-stores" data-toggle="tab"><strong>最新上架图书</strong></a></li>
                <li><a href="#new-hot-sale" data-toggle="tab"><strong>新书热卖榜</strong></a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="tab-content">
            <div class="tab-pane active" id="recommend">
                <!--推荐-->
                <c:forEach var="b" items="${list1}">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}"><img src="${b.cover}" style="height: 200px;width:200px" alt="图片"></a>
                            <div class="caption">
                                <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}">
                                    <strong>${b.name}</strong>
                                </a>
                                <p><span style="color:red">￥${b.price}</span><span>&nbsp;</span><del class="text-muted small">￥${b.dprice}</del></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <div class="tab-pane" id="hot-sale">
                <!-- 热销 -->
                <c:forEach var="b" items="${list2}">

                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}"><img src="${b.cover}"  style="height: 200px;width:200px" alt="图片"></a>
                            <div class="caption">  
                                <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}">
                                    <strong>${b.name}</strong>
                                </a>
                                <p><span style="color:red">￥${b.price}</span><span>&nbsp;</span><del class="text-muted small">￥${b.dprice}</del></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <div class="tab-pane" id="new-stores">
                <!-- 新书上架 -->
                <c:forEach var="b" items="${list3}">

                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}"><img src="${b.cover}" alt="图片" style="height: 200px;width:200px"></a>
                            <div class="caption">
                                <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}">
                                    <strong>${b.name}</strong>
                                </a>
                                <p><span style="color:red">￥${b.price}</span><span>&nbsp;</span><del class="text-muted small">￥${b.dprice}</del></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="tab-pane" id="new-hot-sale">
                <!-- 新书热卖 -->
                <c:forEach var="b" items="${list4}">

                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}"><img src="${b.cover}" style="height: 200px;width:200px" alt="图片"></a>
                            <div class="caption">
                                <a href="${pageContext.request.contextPath}/front/Front_selectById?id=${b.id}">
                                    <strong>${b.name}</strong>
                                </a>
                                <p><span style="color:red">￥${b.price}</span><span>&nbsp;</span><del class="text-muted small">￥${b.dprice}</del></p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>


</div>

<script>
    //自定义切换时间 默认为5s
    $('.carousel').carousel({
        interval: 4000
    });
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xsy
  Date: 2020/7/16
  Time: 21:50
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
<%@ include file="/front/commons/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="${pageContext.request.contextPath}/images/cart/dd_logo.jpg" alt="" class="pull-right">
        </div>
        <div class="col-md-7">

            <ul class="nav nav-pills " style="padding-top:10px">
                <li  style="margin: 10px;background:rgb(246,246,246)"><h4 style="margin:15px;">1.购物车</h4></li>
                <li  style="margin: 10px;background:rgb(255,102,102)"><h4 style="margin:15px;color:rgb(255,231,250)" class="text-muted">2.填写订单</h4></li>
                <li  style="margin:10px;background:rgb(246,246,246)"><h4 style="margin:15px" class="text-muted">3.支付订单</h4></li>
            </ul>
        </div>
    </div>
    <hr style="border:solid 2px red;">

    <div class="container">
        <div class="row">
            <h4>收货人信息</h4>
            <c:forEach var="a" items="${list}">
                <div class="col-sm-3" style="padding:0 5px">
                    <div class="address" id="${a.id}" style="padding:10px 20px;border:solid 2px #E6E4E2;height:135px;background: #FBFBFB;">
                        <div style="padding-bottom:5px">
                            <div class="pull-left"><strong class="name">${a.name}</strong></div>
                            <div class="pull-right"><strong class="mobile">${a.mobile}</strong></div>
                        </div>
                        <hr >
                        <p>中国 <span class="province">${a.province}</span> <span class="city">${a.city}</span>
                            <span class="district">${a.district}</span> <span class="town">${a.town}</span>
                            <span class="address">${a.address}</span></p>
                        <div style="padding-bottom: 10px;display: none" class="operation">
                            <a href="javascript:void(0)" onclick="openUpdateAddressModal('${a.id}')" style="padding-right: 20px;">编辑</a>
                            <a href="${pageContext.request.contextPath}/order/Order_delete?userId=${a.id}">删除</a>
                        </div>
                    </div>
                </div>
            </c:forEach>


        </div>
        <div class="row">
            <div class="col-sm-12" style="margin:20px 0">
                <button class="btn" data-toggle="modal" data-target="#addAddress">新增收货地址 <span class="glyphicon glyphicon-plus"></span></button>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-11" style="padding-left:0px">
                <h4 class="pull-left" >送货清单</h4> <a href="${pageContext.request.contextPath }/front/cart/cart.jsp" class="pull-right">返回购物车</a>
            </div>

        </div>

        <div class="row">
            <div class="col-sm-11">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-sm-12" style="padding-left:150px">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-md-3 text-center">商品信息</div>
                                        <div class="col-md-3 text-center">单价（元）</div>
                                        <div class="col-md-3 text-center">数量</div>
                                        <div class="col-md-3 text-center">金额（元）</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <ul class="media-list">
                            <c:forEach var="e" items="${sessionScope.cart.items}">
                                <div class="media">
                                    <div class="media-left media-middle">
                                        <img src="${pageContext.request.contextPath}/${e.value.book.cover}" alt="" class="media-object" style="width:130px">
                                    </div>
                                    <div class="media-body">
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-md-3 text-center">
                                                    <span class="text-muted small">${e.value.book.name}</span>
                                                </div>
                                                <div class="col-md-3 text-center">
                                                    <span class="text-muted small">￥${e.value.book.dprice}</span>
                                                </div>
                                                <div class="col-md-3 text-center">
                                                    <span class="text-muted small">${e.value.count}</span>
                                                </div>
                                                <div class="col-md-3 text-center">
                                                    <span class="text-muted small">￥${e.value.count * e.value.book.dprice}</span>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                    <hr>
                                </div>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="panel-footer">
                        <form id="orderForm" action="${pageContext.request.contextPath}/order1/Order1_addOrder">
                            <input type="hidden" name="o.name" class="address">
                            <input type="hidden" name="o.total" value="${sessionScope.cart.totalPrice}">
                            <input type="hidden" name="o.status" value="0">
                            <input type="hidden" name="o.mobile" value="" class="address">
                            <input type="hidden" name="o.province" value="" class="address">
                            <input type="hidden" name="o.city" value="" class="address">
                            <input type="hidden" name="o.district" value="" class="address">
                            <input type="hidden" name="o.town" value="" class="address">
                            <input type="hidden" name="o.address" value="" class="address">

                        <div class="row">
                            <div class="col-md-5 show">
                                <div class="row">
                                    <div class="col-md-2" style="padding-right:0">寄送至:</div>
                                    <div class="col-md-9 text-muted small" style="padding-left:0">
                                        <span>中国</span> <span class="province"></span>
                                            <span class="city"></span>
                                            <span class="district"></span>
                                            <span class="town"></span>
                                            <span class="address"> </span>
                                        <p><span class="name"></span><span class="mobile"></span></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-md-offset-3">
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small text-muted">共 <span style="color:red">${sessionScope.cart.items.length}</span> 种商品</p>
                                        <p class="small text-muted">实付金额：￥<span style="color:red">${sessionScope.cart.totalPrice}.0</span></p>
                                    </div>
                                    <div class="col-md-6">
                                        <button type="button"  class="btn btn-danger" onclick="handleSubmit()">去支付</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>

<!-- 添加地址表单 -->
<div id="addAddress" class="modal fade" tabindex="-1">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加地址</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/order/Order_insert">
                    <div class="form-group">
                        <label for="" class="col-sm-2 control-label">收件人：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="a.name" placeholder="收件人姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="" class="col-sm-2 control-label">电话：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="a.mobile" id="mobile" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">地址：</label>
                        <div class="col-sm-10">
                            <div class="row">
                                <label class="col-sm-2 control-label">省：</label>
                                <div class="col-sm-4">
                                    <input name="a.province" class="form-control">
                                </div>
                                <label class="col-sm-3 control-label">市：</label>
                                <div class="col-sm-3" style="padding-left:0">
                                    <input name="a.city" class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 control-label" style="padding:0 0">区（县）：</label>
                                <div class="col-sm-4">
                                    <input name="a.district" class="form-control">
                                </div>
                                <label class="col-sm-3 control-label" style="padding:0 0">街道（乡镇）：</label>
                                <div class="col-sm-3" style="padding-left:0">
                                    <input name="a.town" class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 control-label">详细地址：</label>
                                <div class="col-sm-10">
                                    <textarea name="a.address" class="form-control" id="" rows="3"></textarea>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                            <button type="submit" class="btn btn-primary">添加</button>

                        </div>
                        <div class="col-sm-offset-1 col-sm-2">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 更新模态框 -->
<div id="updateAddress" class="modal fade" tabindex="-1">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">更新地址</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/order/Order_update">
                    <div class="form-group">
                        <label for="" class="col-sm-2 control-label">收件人：</label>
                        <div class="col-sm-10">
                            <input type="hidden" name="a.id" value="">
                            <input type="text" class="form-control" name="a.name" placeholder="收件人姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">电话：</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="a.mobile" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">地址：</label>
                        <div class="col-sm-10">
                            <div class="row">
                                <label class="col-sm-2 control-label">省：</label>
                                <div class="col-sm-4">
                                    <input name="a.province" class="form-control">
                                </div>
                                <label class="col-sm-3 control-label">市：</label>
                                <div class="col-sm-3" style="padding-left:0">
                                    <input name="a.city" class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 control-label" style="padding:0 0">区（县）：</label>
                                <div class="col-sm-4">
                                    <input name="a.district" class="form-control">
                                </div>
                                <label class="col-sm-3 control-label" style="padding:0 0">街道（乡镇）：</label>
                                <div class="col-sm-3" style="padding-left:0">
                                    <input name="a.town" class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-2 control-label">详细地址：</label>
                                <div class="col-sm-10">
                                    <textarea name="a.address" class="form-control" id="" rows="3"></textarea>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                            <button type="submit" class="btn btn-primary">更新</button>

                        </div>
                        <div class="col-sm-offset-1 col-sm-2">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">

    $(function(){// 为地址添加鼠标移入移出事件
        $(".address").mouseover(function(){
            $(this).find(".operation").css("display", "block");
        }).mouseout(function(){
            $(this).find(".operation").css("display", "none");
        }).click(function(){
            $(".address").css("border","solid 2px #E6E4E2");
            $(this).css("border", "solid 2px red");

            var addr = $(this);
            console.log(addr);
            var name = addr.find(".name").html();
            var mobile = addr.find(".mobile").html();
            var province = addr.find(".province").html();
            var city = addr.find(".city").html();
            var district = addr.find(".district").html();
            var town = addr.find(".town").html();
            var address = addr.find(".address").html();
            console.log(name,mobile,province,district,town,address);

            var footer = $(".panel-footer");
            footer.find("span.name").html(name);
            footer.find("input[name='o.name']").val(name);
            footer.find("span.mobile").html(mobile);
            footer.find("input[name='o.mobile']").val(mobile);
            footer.find("span.province").html(province);
            footer.find("input[name='o.province']").val(province);

            footer.find("span.city").html(city);
            footer.find("input[name='o.city']").val(city);
            footer.find("span.district").html(district);
            footer.find("input[name='o.district']").val(district);
            footer.find("span.town").html(town);
            footer.find("input[name='o.town']").val(town);
            footer.find("span.address").html(address);
            footer.find("input[name='o.address']").val(address);
        })

    })

    //打开更新模态框openUpdateAddressModal
    function openUpdateAddressModal(id){
        var addr = $("#"+id);
        console.log(addr);
        var name = addr.find(".name").html();
        var mobile = addr.find(".mobile").html();
        var province = addr.find(".province").html();
        var city = addr.find(".city").html();
        var district = addr.find(".district").html();
        var town = addr.find(".town").html();
        var address = addr.find(".address").html();
        console.log(name,mobile,province,district,town,address);

        $("#updateAddress [name='a.id']").val(id);
        $("#updateAddress [name='a.name']").val(name);
        $("#updateAddress [name='a.province']").val(province);
        $("#updateAddress [name='a.city']").val(city);
        $("#updateAddress [name='a.mobile']").val(mobile);
        $("#updateAddress [name='a.district']").val(district);
        $("#updateAddress [name='a.town']").val(town);
        $("#updateAddress [name='a.address']").val(address);

        $("#updateAddress").modal("show");
    }

    function handleSubmit(){
        var inputs = $(".panel-footer").find("input.address");
      
        for(var i = 0; i <inputs.length; i++){
        	if(!inputs[i].value){
        		alert("请先选择收获地址");
        		return;
        	}
        }
        
        $("#orderForm").submit();
    }
</script>
</body>
</html>

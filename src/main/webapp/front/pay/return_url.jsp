<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电脑网站支付return_url</title>
</head>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.baizhi.action.*"%>
<%@ page import="com.alipay.api.*"%>
<%@ page import="com.alipay.api.internal.util.*"%>
<%
/* *
 * 功能：支付宝服务器同步通知页面
 * 日期：2017-03-30
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


 *************************页面功能说明*************************
 * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
 */
 
	//获取支付宝GET过来反馈信息
	Map<String,String> params = new HashMap<String,String>();
	Map<String,String[]> requestParams = request.getParameterMap();
	for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用
		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		params.put(name, valueStr);
	}
	System.out.println("接收到的支付宝的反馈参数：");
	for(Map.Entry<String,String> e:params.entrySet()){
		System.out.println(e.getKey()+"="+e.getValue());
	}
	//——请在这里编写您的程序（以下代码仅作参考）——
	
	/*
	实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
	boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

	//——请在这里编写您的程序（以下代码仅作参考）——
	if(signVerified) {
		//商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	
		//支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	
		//付款金额
		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
		response.sendRedirect("/dangdang/order1/Order1_update?orderId="+out_trade_no);
		
		
	}else {
		out.println("验签失败");
	}
	//——请在这里编写您的程序（以上代码仅作参考）——
%>
<body>
</body>
</html>
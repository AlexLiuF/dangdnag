package com.baizhi.action;

import java.io.FileWriter;
import java.io.IOException;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102500756865";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDkYvxSMYZjYMJxWyFnBbz8kgLc4tzpX0KzcZDjZFUX/kE1T5x0xfLZh2m43SVpgh4s88AWL0MRltwTf9jGtYpd3lMR30ivswNXbTdgMOX+WQIgLEypveK8zm4GTEneauYsbBn2gSYIYji+Ex5Mnu1xjb2+NqIsegbY+sDVfVwgCV7+NOc9RrZv2t/xbjQxO3aL96EX5zkObM334DCF1e1EOAkl0LFespQIqafbx7V3L3p0s+AXOKLLNx0eJbFLSlfZd7+6JvbKFY8e58Od1zr335oyD+202TRQgIBqBRI99zl0cBseKOIjbIXH8giJ4QyLQpcktvXy2pzCRe8uGcz5AgMBAAECggEADVGwgWKeAcGs1UuJQSbWhKxHOnaIh5ukmi5vUrOROtr7Fo7UAwNgTEtXYQ6UlfiepeR5OVH8SVRQ9VopXD1OGndSxOIOrSB1e23FIvj3EMREGXg76FJInNY1GGzuiegWEFUllnilrSt9P6iBxdom4s5vWF57Sri7GYBWKp0q+Ds3dtGMW2xMz9SU40dr8+4fan4Eu6MSzdzBYdUa4xkANlQHxnCKJg+cQQF8P5TarDoWwU8p6XsoCla93c3PyII8OFwJkQWMRAQTPCewL3sBrbDmxiHks+3bhQCxXbGsboJgx43tvvk0/DgFaNo2kAGZ6orAmprtkMbfwFgsFCo82QKBgQD314T6A3H4jpXylA45qYNDUPVloilno1yrshXwji0rkMwZXnSFBApNqWUGBP0AIXf+SMfgtdqeFkP6F42WwCat9vRhPMeIjdtLJOs9QGb880R/Le0gXQCLCOSSvfFi4akrYsUcBO2RLZBcinT7BU4TzDJJyPuTIVQZJ3MnDyWUPwKBgQDr54YNT8G0F5Bu6iXBxiPy401Nbw5u5N0C4uTcJxbI+s6GdCYlv/K8fBZU37GBr/Sjuv95YDlYVR10cAsR8tL4WKZWg9y7bRnDW7dgxw3WSQVwjFRyIJ3joRS8nc6vwA1D7QyRMJxw4bLKvS3Jc2qFQxrO8SFRsPGDhe43JvhwxwKBgQCubmvzvmr/YfMc+KEOakStIxSjhD8Z5vr5CGyyko4uBEnxbO4bFB3gTOGCHA6ogeW+/SBYAgWsj8UmBl+rgu92LsIOkcVpUVXPDFvYDzSswNYroHos9efE8uxUbwSt8F6s32YU8070h5n716K/bRtniaa3EZImGiXjUkWUbu+m5wKBgQCJvLe3Y/8MYMnTCOGcv0zUD0VeVd6OfxBQFBxeMnCKTm5xcLWpSua2iJkdWzKwLwVe59ssijNRUPkOuDCufSITIOeWEg26XVwyhYWPewmoOSB082qG7GZjtvR9oIJCeZcFNw4kY8aj3hPfbg+i1MG4J1Mqyv2STgblrThGeXmLlwKBgFaBhPTs35AJNnsAp30e+4p5EM3M9N5Q0gxg2juOWHSh84oN2QN4bhRpGcBf1K40bMRjObX/rV3DgOOXtvV2d2bMaqAQgSv6YfOFARcxm1NhUm5b133sne2KJrv/bksX5KTxBd7+KiOGLRho9VFk8WRAqUPTovOn/7hbkpe16kwm";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgH4tmuW8nwNnoW0u+oBG9LvhOZqorFlwViaHBF5VJNUSc7xo0cLdneqZQkQdft0dS6U13N/wjZ1AxptfjyEbMPiq1CKcqAiu+1fEFeniwzmfUbzN7/Xvv111PynABKSs2GVgbRGerC5O09gNG4gH6Saa4SsQCcH8H09nRmBHdEJ2/mv5RB2pIF/Lw282CJxMeJ3BDztZd6CytoIiEvgSnLy78NHGzujQA0iD3WTpAozQ550oUcqclB0Q10Px1F/4ad/gYuM4RZhwyjUtm8dWpO5KPDDWMBknDOtam3APWytgQp0+tKOMokqMZGdsS8YYVtW+/YylJerO06/iShOnQQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8989/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8989/dangdang/front/pay/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	// 请求网关地址  真实环境网关：https://openapi.alipay.com/gateway.do
	//	         沙箱环境网关：https://openapi.alipaydev.com/gateway.do
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	 //获得初始化的AlipayClient
    public static AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	// 日志记录目录
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


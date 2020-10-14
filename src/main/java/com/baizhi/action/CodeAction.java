package com.baizhi.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

public class CodeAction {
	private ByteArrayInputStream imageStream;
	public String showCode() throws Exception {
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(80, 30, 4, 6);
		imageStream = new ByteArrayInputStream(captcha.getImageBytes());
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("captcha", captcha);
		//将验证码写入浏览器
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream outputStream = response.getOutputStream();
		captcha.write(outputStream);
		return null;
	}
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	
}

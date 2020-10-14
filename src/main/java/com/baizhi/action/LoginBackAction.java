package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.impl.AdminServiceImpl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

public class LoginBackAction {
	private String username;
	private String password;
	private String validateCode;
	public String login() {
		//获取session中的验证码对象并且判断验证码是否正确
		HttpSession session = ServletActionContext.getRequest().getSession();
		CircleCaptcha captcha = (CircleCaptcha)session.getAttribute("captcha");
		boolean verify =  captcha.verify(validateCode);
		if(verify) {
			AdminServiceImpl asi = new AdminServiceImpl();
			Admin psw = asi.selectByUserName(username);
			if(password.equals(psw)) {
				return "Ok";
			}
			return "buOk";
		}
		return "buOk";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}

package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.SendEmailUtil;

import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;

public class RegisterAction {
	private String email;
	private String nickname;
	private String vericode;
	private String pwd1;
	private String pwd2;
	private String code;
	private String password;
	//注册
	public String register() {
		//获取session中的验证码对象并且比对输入的验证码是否正确
		HttpSession session = ServletActionContext.getRequest().getSession();
		CircleCaptcha captcha = (CircleCaptcha)session.getAttribute("captcha");
		boolean verify = captcha.verify(code);
		if(pwd1.equals(pwd2) && verify) {//两次密码相同且验证码没错
			//随机生成密钥
			String randomString = RandomUtil.randomString(6);
			String salt = randomString;
			HMac hMac = new HMac(HmacAlgorithm.HmacMD5,randomString.getBytes());
			String password = hMac.digestHex(pwd1);
			User user = new User();
			user.setPassword(password);
			user.setEmail(email);
			user.setSalt(salt);
			user.setNickname(nickname);
			user.setStatus(0);
			String code = RandomUtil.randomString(6);
			user.setCode(code);
			session.setAttribute("email", email);
			System.out.println(user);
			UserServiceImpl usi = new UserServiceImpl();
			usi.insert(user);
			SendEmailUtil.sendCode(email, code);
			return "Ok";
		}//密码不同或者验证码错误
		return "buOk";
	}
	//激活
	public String activation() {
		System.out.println("-------------------1");
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.selectByEmail(email);
		System.out.println("-------------------2");
		String code1 = user.getCode();
		System.out.println("-------------------3"+code1);
		System.out.println("-------------------4"+code);
		if(code.equals(code1)) {//激活码相同，修改status激活账号
			//根据email查到id
			System.out.println("---------------");
			Integer id = user.getId();
			//根据id修改状态
			usi.updateStatus(id, 1);
			return "OOk";
		}
		return "Ok";
	}
	//登录界面
	public String login() {
		//根据email搜索
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.selectByEmail(email);
		if(password != null && password !="") {//密码不为空
			String salt = user.getSalt();
			HMac hMac = new HMac(HmacAlgorithm.HmacMD5,salt.getBytes());
			String passw = hMac.digestHex(password);
			if(passw.equals(user.getPassword())) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("user", user);
				return "loginOk";
			}
			return "OOk";
		}
		return "OOk";
	}

	public void setVericode(String vericode) {
		this.vericode = vericode;
	}

	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

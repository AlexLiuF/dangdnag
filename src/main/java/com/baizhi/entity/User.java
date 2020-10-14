package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer id;
	private String email;
	private String password;
	private String salt;
	private String nickname;
	private Integer status;
	private String code;
	private Date create_date;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String email, String password, String salt, String nickname, Integer status, String code,
			Date create_date) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.create_date = create_date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", salt=" + salt + ", nickname="
				+ nickname + ", status=" + status + ", code=" + code + ", create_date=" + create_date + "]";
	}
	
	
	
}

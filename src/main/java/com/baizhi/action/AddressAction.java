package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.Cart;
import com.baizhi.entity.User;
import com.baizhi.service.impl.AddressServiceImpl;

public class AddressAction {
	private List<Address> list;
	private Integer userId;
	private Address a;
	//展示所有地址
	public String selectAll() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		userId = user.getId();
		System.out.println(userId);
		AddressServiceImpl ads = new AddressServiceImpl();
		list = ads.selectByUserId(userId);
		Cart cart = (Cart)session.getAttribute("cart");
		System.out.println(cart);
		return "Ok";
	}
	//添加地址
	public String insert() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		userId = user.getId();
		a.setUserId(userId);
		AddressServiceImpl asi = new AddressServiceImpl();
		asi.insert(a);
		return "OOk";
	}
	//删除地址
	public String delete() {
		AddressServiceImpl asi = new AddressServiceImpl();
		asi.delete(userId);
		return "OOk";
	}
	//修改地址
	public String update() {
		System.out.println("++++++++++++++++++++"+a);
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		a.setUserId(user.getId());
		AddressServiceImpl asi = new AddressServiceImpl();
		asi.update(a);
		return "OOk";
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Address getA() {
		return a;
	}
	public void setA(Address a) {
		this.a = a;
	}
	
}

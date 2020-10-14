package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.User;
import com.baizhi.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;

public class UserAction {
	private List<User> list;
	private Integer pageNum=1;
	private Integer pageSize=5;
	private PageInfo<User> page;
	private Integer id;
	private Integer status;
	private User u;
	//后台
	//查所有
	public String selectAll() {
		UserServiceImpl usi = new UserServiceImpl();
		list = usi.selectAll(pageNum,pageSize);
		page = new PageInfo<>(list);
		return "Ok";
	}
	//修改状态
	public String updateStatus() {
		UserServiceImpl usi = new UserServiceImpl();
		usi.updateStatus(id, status);
		return  "sOk";
	}

	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public PageInfo<User> getPage() {
		return page;
	}
	public void setPage(PageInfo<User> page) {
		this.page = page;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

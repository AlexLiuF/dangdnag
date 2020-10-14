package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class CategoryAction {
	private List<Category> list;
	private Integer pageNum=1;
	private Integer pageSize=5;
	private PageInfo<Category> page;
	private Category  c;
	private Integer parentId;
	private Category parent;

	//展示
	public String showAll() {
		CategoryServiceImpl cs = new CategoryServiceImpl();
		if(parentId==null) {	
			list=cs.selectByLevels(pageNum, pageSize, 1);
			page=new PageInfo<>(list);
			return "Ok";
		}else {
			PageHelper.startPage(pageNum, pageSize);
			list=cs.selectByParentId(parentId);
			page=new PageInfo<>(list);
			parent = cs.selectById(parentId);
			return "Ok";
		}
		
	}
	//根据父亲的id查
	public String selectByParentId() {
		CategoryServiceImpl cs = new CategoryServiceImpl();
		PageHelper.startPage(pageNum, pageSize);
		list=cs.selectByParentId(parentId);
		page=new PageInfo<>(list);
		parent = cs.selectById(parentId);
		return "Ok";
	}
	//删除
	public String delete() {
		CategoryServiceImpl cgsi = new CategoryServiceImpl();
		List<Category> msg = cgsi.selectByParentId(c.getId());
		
			try {
				cgsi.delete(c.getId());
			} catch (Exception e) {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("msg", e);
				return "sOk";
			}
			return "sOk";
	}
	//添加一级
	public String insertOneGarde() {
		CategoryServiceImpl cs = new CategoryServiceImpl();
		if(c.getParentId()==null) {
			cs.insertOneGarde(c.getName());
			System.err.println("+++++++++++");
			return "sOk";
		}else {
			parentId=c.getParentId();
			System.out.println(c.getName()+"--------"+ c.getParentId());
			cs.inertTwoGarde(c.getName(), parentId);
			return "ssOk";
		}
		
	}

	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
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
	public PageInfo<Category> getPage() {
		return page;
	}
	public void setPage(PageInfo<Category> page) {
		this.page = page;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}

	
	
}

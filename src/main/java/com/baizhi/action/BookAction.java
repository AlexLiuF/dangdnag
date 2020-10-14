package com.baizhi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.github.pagehelper.PageInfo;

public class BookAction {
	private List<Book> list;
	private List<Category> list1;
	private Integer pageNum=1;
	private Integer pageSize=5;
	private PageInfo<Book> page;
	private Integer levels;
	private File pic;
	private String picFileName;
	private Book b;
	private Integer id;
	private String query;
	private String value;
	//查所有
	public String selectAll() {
		BookServiceImpl bsi = new BookServiceImpl();
		if(query!=null && query.length()>0 && value!=null && value.length()>0) {
			list = bsi.selectByQuery(query, value, pageNum, pageSize);
			page = new PageInfo<>(list);
			return "Ok";
		}
		list = bsi.selectAll(pageNum, pageSize);
		page = new PageInfo<>(list);
		return "Ok";
	}
	//查找所有二级的分类并且转发给(添加页面)的jsp
	public String selectByLeversTwo() {
		CategoryServiceImpl csi = new CategoryServiceImpl();
		list1 = csi.selectAllByLevels(levels);
		return "tianjiaOk";
	}
	//添加图书
	public String insert() throws Exception {
		
		//上传图片
		InputStream in = new FileInputStream(pic);
		ServletContext servletContext = ServletActionContext.getRequest().getServletContext();
		String realPath=servletContext.getRealPath("/images/book/");
		OutputStream out = new FileOutputStream(realPath+picFileName);
		while(true) {
			int value = in.read();
			if(value==-1) {break;}
			out.write(value);
		}
		in.close();
		out.close();
		//保存图书信息到数据库
		b.setCover("\\dangdang\\images\\book\\"+picFileName);
		BookServiceImpl bsi = new BookServiceImpl();
		bsi.insert(b);
		return "sOk";
	}
	//删除
	public String delete() {
		BookServiceImpl bsi = new BookServiceImpl();
		try {
			bsi.delete(id);
		} catch (Exception e) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("msg", e);
			return "sOk";
		}
		return "sOk";
	}
	//修改图书信息页面
	public String updateShow() {
		BookServiceImpl bsi = new BookServiceImpl();
		b=bsi.selectById(id);
		CategoryServiceImpl csi = new CategoryServiceImpl();
		list1 = csi.selectAllByLevels(2);
		for (Category c : list1) {
			System.out.println(c);
		}
		return "ssOk";
	}
	//修改图书信息
	public String update() {
		BookServiceImpl bsi = new BookServiceImpl();
		bsi.update(b);
		return "sOk";
	}
	//条件查询
	public String selectByQuery() {
		BookServiceImpl bsi = new BookServiceImpl();
		list = bsi.selectByQuery(query, value, pageNum, pageSize);
		return "Ok";
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
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
	public PageInfo<Book> getPage() {
		return page;
	}
	public void setPage(PageInfo<Book> page) {
		this.page = page;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public List<Category> getList1() {
		return list1;
	}
	public void setList1(List<Category> list1) {
		this.list1 = list1;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

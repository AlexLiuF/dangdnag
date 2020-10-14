package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryFrontServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.github.pagehelper.PageInfo;

public class MainAction {
	private Integer pageNum = 1;
	private Integer pageSize = 5;
	private PageInfo<Category> page;
	private List<Category> list;
	private List<Book> list1;
	private List<Book> list2;
	private List<Book> list3;
	private List<Book> list4;
	private List<Book> list5;
	private String value;
	private Integer id;
	private Book book;
	private Integer fid;
	private Integer sid;
	public String selectAll() {
		CategoryFrontServiceImpl cfs = new CategoryFrontServiceImpl();
		//分类浏览
		list = cfs.selectAll();
		page = new PageInfo(list);
		//编辑推荐
		BookServiceImpl bsi = new BookServiceImpl();
		list1=bsi.selectRecommend();
		//热销图书
		list2 = bsi.selectHotSale();
		//最新上架
		list3 = bsi.selectNewUp();
		//新书热卖
		list4 = bsi.selectHotNewSale();
		return "Ok";
	}
	//前台模糊查询
	public String selectByValue() {
		BookServiceImpl bsi = new BookServiceImpl(); 
		System.out.println(value);
		list5 = bsi.selectByValue(value, pageNum, pageSize);
		for (Book b : list5) {
			System.out.println(b);
		}
		page = new PageInfo(list5);
		return "Oks";
	}
	//点击图片和文字显示详细信息
	public String selectById() {
		BookServiceImpl bsi = new BookServiceImpl();
		book = bsi.selectById(id);
		return "Okss";
	}
	//分类浏览点击展示
	public String selectSortShow() {
		//查询浏览栏所有分类
		//fid是儿子id的父亲id
		CategoryFrontServiceImpl cfsi = new CategoryFrontServiceImpl();
		//种类栏
		list = cfsi.selectByParentId(fid);
		for(Category c:list) {
			System.out.println(c);
		}
		System.out.println("sid"+sid+"/t"+"fid"+fid);
		//分辨请求是来自一级类别还是二级类别
		BookServiceImpl bsi = new BookServiceImpl();
		if(sid!=null) {
		//查询二级
			list1= bsi.selectByCategoryTwo(sid, pageNum, pageSize);		
			page = new PageInfo(list1);
			for (Book b : list1) {
				System.out.println(b);
			}
			return "Oksss";
		}
		//查询一级
		list1=bsi.selectByCategory(fid, pageNum, pageSize);
		page = new PageInfo(list1);
		for (Book b : list1) {
			System.out.println(b);
		}
		return "Oksss";
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
	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	public List<Book> getList1() {
		return list1;
	}
	public void setList1(List<Book> list1) {
		this.list1 = list1;
	}
	public List<Book> getList2() {
		return list2;
	}
	public void setList2(List<Book> list2) {
		this.list2 = list2;
	}
	public List<Book> getList3() {
		return list3;
	}
	public void setList3(List<Book> list3) {
		this.list3 = list3;
	}
	public List<Book> getList4() {
		return list4;
	}
	public void setList4(List<Book> list4) {
		this.list4 = list4;
	}
	public List<Book> getList5() {
		return list5;
	}
	public void setList5(List<Book> list5) {
		this.list5 = list5;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	
	
}

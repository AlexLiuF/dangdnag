package com.baizhi.entity;

public class CartItem {
	private Book book;//用于保存图书图片  图书名 图书数量
	private Integer count;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Book book, Integer count) {
		super();
		this.book = book;
		this.count = count;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}
	
}

package com.baizhi.entity;

import java.util.Date;


public class Item {
	private Integer id;
	private Integer bookId;
	private Integer count;
	private Date createDate;
	private Integer orderId;
	private Book book;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Integer id, Integer bookId, Integer count, Date createDate, Integer orderId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createDate = createDate;
		this.orderId = orderId;
	}
	
	public Item(Integer id, Integer bookId, Integer count, Date createDate, Integer orderId, Book book) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createDate = createDate;
		this.orderId = orderId;
		this.book = book;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", bookId=" + bookId + ", count=" + count + ", createDate=" + createDate
				+ ", orderId=" + orderId + ", book=" + book + "]";
	}
	
	
	
	
}

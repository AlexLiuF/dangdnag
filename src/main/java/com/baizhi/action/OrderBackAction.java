package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.impl.ItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.github.pagehelper.PageInfo;

public class OrderBackAction {
	private Integer pageNum = 1;
	private Integer pageSize = 5;
	private List<Order> list;
	private List<Item> items;
	private PageInfo<Order> page;
	private Integer orderId;
	private Order order;
	//展示订单管理
	public String  showAll() {
		OrderServiceImpl osi = new OrderServiceImpl();
		list = osi.selectAll(pageNum, pageSize);
		page = new PageInfo<Order>(list,5);
		return "Ok";
	}
	//展示订单详情
	public String showItem() {
		ItemServiceImpl its = new ItemServiceImpl();
		items = its.selectByOrderId(orderId);
		for (Item item : items) {
			System.out.println(item);
		}
		OrderServiceImpl osi = new OrderServiceImpl();
		order = osi.selectById(orderId);
		System.err.println(order);
		return "OOk";
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
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public PageInfo<Order> getPage() {
		return page;
	}
	public void setPage(PageInfo<Order> page) {
		this.page = page;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}

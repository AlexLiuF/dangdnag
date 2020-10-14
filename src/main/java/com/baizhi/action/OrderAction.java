package com.baizhi.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.service.impl.ItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;

public class OrderAction {
	private Order o;
	private Integer orderId;
	private Double totalPrice;
	private Double yuanPrice;
	private Double total;
	private Order order;
	public String addOrder() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		Order order = new Order();
		o.setUserId(71);
		System.out.println(o);
		OrderServiceImpl osi = new OrderServiceImpl();
		osi.insert(o);
		orderId=o.getId();
		System.out.println("+++"+orderId);
		
		System.out.println("-------------------------------------");
		Item item = new Item();
		ItemServiceImpl isi = new ItemServiceImpl();
		Map<Integer, CartItem> items = cart.getItems();
		for (CartItem c : items.values()) {
			Integer bookId = c.getBook().getId();
			Integer count = c.getCount();
			item.setBookId(bookId);
			item.setCount(count);
			item.setOrderId(orderId);
			isi.insert(item);
		}
		return "Ok";
	}
	//添加订单详情
	public String addMoreOrder() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		OrderServiceImpl osi = new OrderServiceImpl();
		Order order = osi.selectById(orderId);
		//订单号orderId
		//付款金额
		total = order.getTotal();
		return "OOk";
	}
	//修改订单状态
	public String update() {
		OrderServiceImpl osi = new OrderServiceImpl();
		osi.update(orderId);
		order=osi.selectById(orderId);
		return "OOOk";
	}
	public Order getO() {
		return o;
	}
	public void setO(Order o) {
		this.o = o;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getYuanPrice() {
		return yuanPrice;
	}
	public void setYuanPrice(Double yuanPrice) {
		this.yuanPrice = yuanPrice;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}

package com.baizhi.action;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.service.impl.BookServiceImpl;

public class CartAction {
	private Integer bookId;
	//跳转到购物车
	public String goCart() {
		//从session中获取购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart == null) {//如果是第一次添加购物车，购物车之前没有保存到作用域
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		System.out.println("---------------");
		//向购物车中添加图书
		Map<Integer,CartItem> items = cart.getItems();//获取条目对象
		
		if(items.containsKey(bookId)) {//不是第一添加图书
			//修改cartItem的count属性,count++
			CartItem  cartItem = items.get(bookId);
			cartItem.setCount(cartItem.getCount()+1);
		}else {//是第一次添加图书
			CartItem cartItem = new CartItem();
			cartItem.setCount(1);
			BookServiceImpl bsi = new BookServiceImpl();
			Book book = bsi.selectById(bookId);
			cartItem.setBook(book);
			//向集合中添加cartItem对象
			items.put(bookId,cartItem);
			System.out.println("---------------");
		}
		//修改总价+节省价格
		//总价:购物车中所有图书的当当价*数量
		//节省价格:购物车中所有图书(原价-当当价)*数量
		double totalPrice = 0.0;
		double savePrice = 0.0;
		Collection<CartItem> cartItems = items.values();
		for(CartItem c:cartItems) {
			totalPrice += c.getBook().getDprice() * c.getCount();
			savePrice += (c.getBook().getPrice()-c.getBook().getDprice())*c.getCount();
		}
		cart.setTotalPrice(totalPrice);
		cart.setSavePrice(savePrice);		
		return "Ok";
	}
	//增加数量
	public String add() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Map<Integer, CartItem> items = cart.getItems();
		CartItem item = items.get(bookId);
		item.setCount(item.getCount()+1);

		//更新总价和节省价格
		cart.setTotalPrice(cart.getTotalPrice()+item.getBook().getDprice());
		cart.setSavePrice(cart.getSavePrice()+(item.getBook().getPrice()-item.getBook().getDprice()));
		return "Ok";
	}
	//减少数量
	public String decrease() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Map<Integer, CartItem> items = cart.getItems();
		CartItem item = items.get(bookId);
		item.setCount(item.getCount()-1);
		if(item.getCount()==0) {
			items.remove(bookId);
		}
		//更新价格
		cart.setTotalPrice(cart.getTotalPrice()-item.getBook().getDprice());
		cart.setSavePrice(cart.getSavePrice()-(item.getBook().getPrice()-item.getBook().getDprice()));
		return "Ok";
	}
	//删除订单
	public String delete() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		Map<Integer, CartItem> items = cart.getItems();
		items.remove(bookId);
		return "Ok";
	}
	//跳转到首页
	public String gotoMain() {
		return "OOk";
	}
	//跳转到购物车
	public String gotoCart() {
		return "Ok";
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	
}

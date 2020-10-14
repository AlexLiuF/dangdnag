package com.baizhi.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Double totalPrice;
	private Double savePrice;
	private Map<Integer,CartItem> items = new HashMap<>();
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Double totalPrice, Double savePrice, Map<Integer, CartItem> items) {
		super();
		this.totalPrice = totalPrice;
		this.savePrice = savePrice;
		this.items = items;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [totalPrice=" + totalPrice + ", savePrice=" + savePrice + ", items=" + items + "]";
	}
	
	
}

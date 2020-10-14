package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemService {
	void insert(Item item);
	//根据orderId查
	List<Item> selectByOrderId(Integer orderId);
}

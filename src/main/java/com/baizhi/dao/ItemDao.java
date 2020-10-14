package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemDao {
	void  insert(Item item);
	//根据订单id查
	List<Item> selectByOrderId(Integer orderId);
}

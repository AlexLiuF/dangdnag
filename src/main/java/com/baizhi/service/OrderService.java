package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Order;

public interface OrderService {
	void insert(Order order);
	//查
	Order selectById(Integer id);
	//修改状态
	void update(Integer id);
	//查所有
	List<Order> selectAll(Integer pageNum,Integer pageSize);
}

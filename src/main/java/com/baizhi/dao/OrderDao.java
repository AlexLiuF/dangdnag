package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Order;

public interface OrderDao {
	void insert(Order order);
	//cha
	Order selectById(Integer id);
	//修改订单状态
	void update(Integer id);
	//查所有
	List<Order> selectAll(@Param("pageNum")Integer pageNum,@Param("pageSize") Integer pageSize);
}

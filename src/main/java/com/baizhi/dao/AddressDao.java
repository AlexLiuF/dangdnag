package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	//增
	void insert(Address address);
	//删
	void delete(Integer id);
	//改
	void update(Address address);
	//查
	List<Address> selectAll();
	//根据用户id查询地址
	List<Address> selectByUserId(Integer userId);
}

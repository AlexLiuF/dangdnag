package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	//增
	void insert(Address address);
	//删
	void delete(Integer id);
	//改
	void update(Address address);
	//查
	List<Address> selectAll();
	//根据userId查
	List<Address> selectByUserId(Integer userId);
}

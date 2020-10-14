package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserService {
	//查所有
	List<User> selectAll(Integer pageNum,Integer pageSize);
	//修改状态
	void updateStatus(Integer id,Integer status);
	//添加
	void insert(User user);
	//根据email查
	User selectByEmail(String email);
}

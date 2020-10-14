package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao {
	//添加
	void insert(User user);
	//根据email查
	User selectByEmail(String email);
	//修改状态
	void update(@Param("id") Integer id,@Param("status") Integer status);
	//查所有
	List<User> selectAll(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
}

package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao {
	//根据username查 
	Admin selectByUserName(@Param("username") String username);
}

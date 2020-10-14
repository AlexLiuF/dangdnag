package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
	//根据username查
	Admin selectByUserName(String username);
}

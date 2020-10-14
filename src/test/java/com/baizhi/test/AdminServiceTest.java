package com.baizhi.test;

import org.junit.Test;

import com.baizhi.entity.Admin;
import com.baizhi.service.impl.AdminServiceImpl;

public class AdminServiceTest {
	@Test
	public void selectByUserNameTest() {
		AdminServiceImpl ads = new AdminServiceImpl();
		Admin admin = ads.selectByUserName("admin");
		System.out.println(admin);
	}
}

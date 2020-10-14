package com.baizhi.test;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.entity.User;
import com.baizhi.service.impl.UserServiceImpl;

public class UserServiceTest {
	@Test
	public void userServiceSelectAllTest() {
		UserServiceImpl usi = new UserServiceImpl();
		List<User> list = usi.selectAll(1,5);
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void  userServiceUpdateStatusTest() {
		UserServiceImpl usi = new UserServiceImpl();
		usi.updateStatus(67, 0);
		
	}
	@Test 
	public void userServiceInsert() throws ParseException {
		UserServiceImpl usi = new UserServiceImpl();
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
        Date p1 = si.parse("2009-1-10");
		User user = new User(1, "123456@qq.com", "111", "111", "爱在西元前", 0, "ssqwq",p1);
		usi.insert(user);
	}
	//根据email查
	@Test
	public void selectByEmail() {
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.selectByEmail("123@qq.com");
		System.out.println(user);
	}
}

package com.baizhi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Order;
import com.baizhi.service.impl.OrderServiceImpl;

public class OrederServiceImplTest {
	@Test
	public void insertTest() throws ParseException {
		OrderServiceImpl osi = new OrderServiceImpl();
		SimpleDateFormat da = new SimpleDateFormat("yyyy-mm-dd");
		Date p1 = da.parse("2010-1-10");
		Order order = new Order(1, 11.1, 1, "211","121", "212", "212", "2112", "2112", "wqwq",p1, 71);
		osi.insert(order);
	}
	@Test
	public void selectByIdTest() {
		OrderServiceImpl ossi = new OrderServiceImpl();
		Order order = ossi.selectById(2);
		System.out.println(order);
	}
	
	@Test
	public void update() {
		OrderServiceImpl osi = new OrderServiceImpl();
		osi.update(2);	
	}
	@Test
	public void selectAll() {
		OrderServiceImpl osi = new OrderServiceImpl();
		List<Order> list = osi.selectAll(1, 5);
		for (Order order : list) {
			System.out.println(order);
		}
	}
}

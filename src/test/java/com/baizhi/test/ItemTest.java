package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Item;
import com.baizhi.service.impl.ItemServiceImpl;

public class ItemTest {
	@Test
	public void insertTest() {
		ItemServiceImpl isl = new ItemServiceImpl();
		Item  item = new Item(null, 81, 111, null, 1);
		isl.insert(item);
	}
	//根据订单id查
	@Test
	public void selectByOrderId() {
		ItemServiceImpl isi = new ItemServiceImpl();
		List<Item> list = isi.selectByOrderId(2);
		for (Item item : list) {
			System.out.println(item);
		}
	}
}

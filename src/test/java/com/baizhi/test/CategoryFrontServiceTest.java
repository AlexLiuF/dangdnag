package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Category;
import com.baizhi.service.impl.CategoryFrontServiceImpl;

public class CategoryFrontServiceTest {
	@Test
	public void selectAll() {
		CategoryFrontServiceImpl cfsi = new CategoryFrontServiceImpl();
		List<Category> list = cfsi.selectAll();
		for (Category c : list) {
			System.out.println(c);
		}
	}
	//根据parentId查询
	@Test
	public void selectByParentId() {
		CategoryFrontServiceImpl fis = new CategoryFrontServiceImpl();
		List<Category> list = fis.selectByParentId(5);
		for (Category category : list) {
			System.out.println(category);
		}
	}
}

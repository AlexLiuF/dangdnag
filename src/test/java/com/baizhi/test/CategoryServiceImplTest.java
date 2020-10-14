package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Category;
import com.baizhi.service.impl.CategoryServiceImpl;

public class CategoryServiceImplTest {
	@Test
	public void CategoryServiceImplSelectByParentId(){
		CategoryServiceImpl cgsi = new CategoryServiceImpl();
		List<Category> list = cgsi.selectByParentId(5);
		for(Category ca:list) {
			System.out.println(ca);
		}
	}
	@Test
	public void CategoryServiceImplSelectById() {
		CategoryServiceImpl cgsi = new CategoryServiceImpl();
		Category selectById = cgsi.selectById(5);
		System.out.println(selectById);
	}
	@Test
	public void CategoryServiceImplInsertTwoGrade() {
		CategoryServiceImpl cs = new CategoryServiceImpl();
		cs.inertTwoGarde("狗狗动", 21);
	}
	@Test
	public void CategoryServiceImplSelectAll() {
		CategoryServiceImpl csi = new CategoryServiceImpl();
		List<Category> list = csi.selectAllByLevels(2);
		for (Category category : list) {
			System.out.println(category);
		}
	}
}

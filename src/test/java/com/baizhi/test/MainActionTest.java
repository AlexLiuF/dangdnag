package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Book;
import com.baizhi.service.impl.BookServiceImpl;

public class MainActionTest {
	@Test
	public void selectOnrShow() {//error
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> lit = bsi.selectByCategoryTwo(5, 1, 5);
		for (Book book : lit) {
			System.out.println(book);
		}
	}
	@Test
	public void selectTwoShow() {
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectByCategory(62,1, 5);
		for (Book book : list) {
			System.out.println(book);
		}
	}
}

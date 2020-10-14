package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Book;
import com.baizhi.service.impl.BookServiceImpl;

public class BookServiceTest {
	@Test
	public void selectAll() {
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectAll(2, 5);
		for(Book b:list) {
			System.out.println(b);
		}
	}
	@Test
	public void selectById() {
		BookServiceImpl bsi = new BookServiceImpl();
		Book book = bsi.selectById(81);
		System.out.println(book);
	}
	@Test
	public void selectByQuery() {
		//书名 作者 出版社 name author press
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectByQuery("press", "1", 1, 5);
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void selectRecommendTest() {
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectRecommend();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	//根据一级查询
	@Test
	public void selectOne() {
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectByCategory(5, 1, 5);
		for (Book book : list) {
			System.out.println(book);
		}
	}
	//根据二级查询
	@Test
	public void selectTwo() {
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.selectByCategoryTwo(62, 1, 5);
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
}

package com.baizhi.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.User;
import com.baizhi.util.MyBatisUtil;

public class BookInsertTest {
	@Test
	public void bookDaoInsert() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
			Date p1 = si.parse("2009-1-10");
			Book book = new Book(1, "大话西游", "liufeng", "封面","人民出版社", p1, 1123, p1, 1111, "isbn", 4444, 4444, "16开", "黄金", "硬皮", 11.1, 23.4, p1, "hao", "hao", "hao", "hao", "wq", 11111,22222,p1,36);
			dao.insert(book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	@Test
	public void BookDaoDeleteTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			dao.delete(4);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	@Test
	public void BookDaoUpdateTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			SimpleDateFormat si = new SimpleDateFormat("yyyy-mm-dd");
			Date p1 = si.parse("2009-1-10");
			Book book = new Book(1, "大话西游", "liufeng", "封面","人民出版社", p1, 1123, p1, 1111, "isbn", 4444, 4444, "16开", "黄金", "硬皮", 11.1, 23.4, p1, "hao", "hao", "hao", "hao", "wq", 11111,22222,p1,6);
			dao.update(book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}	
	}
	@Test
	public void BookDaoSelectAllTest() {
		SqlSession sqlSession = null;
		List<Book> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			list = dao.selectAll(2,5);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		for(Book b :list) {
			System.out.println(b);
		}
	}
	
}

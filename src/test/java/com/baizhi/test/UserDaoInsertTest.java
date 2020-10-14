package com.baizhi.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.User;
import com.baizhi.util.MyBatisUtil;

public class UserDaoInsertTest {
	@Test
	public void insertTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
			Date p1 = si.parse("2009-1-10");

			User user = new User(1, "1232@qq.com", "qqqq", "salt", "会飞的小燕子", 1, "ASSDasAs",p1);
			dao.insert(user);
			sqlSession.commit();
	
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	@Test
	public void selectByEmailTest() {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			user = dao.selectByEmail("444@qq.com");
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		System.out.println(user);
	}
	@Test
	public void updateTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.update(43,1);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
}

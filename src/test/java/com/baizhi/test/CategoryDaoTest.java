package com.baizhi.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.util.MyBatisUtil;

public class CategoryDaoTest {
	@Test
	public void categoryDaoInsertTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			Category category = new Category(1,"诗歌",1,null);
			dao.insert(category);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}	
	}
	@Test
	public void categoryDaoDeleteTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			dao.delete(7);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	@Test
	public void categoryDaoSelectByLeversTest() {
		SqlSession sqlSession = null;
		List<Category> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			list = dao.selectByLevels(1,5,1);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		for(Category s:list) {
			System.out.println(s);
		}
	}
}

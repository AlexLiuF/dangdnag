package com.baizhi.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MyBatisUtil;

public class AdminDaoSelectByUserNameTest {
	@Test
	public void testAdminDao() {
		Admin admin = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AdminDao dao = sqlSession.getMapper(AdminDao.class);
			admin = dao.selectByUserName("admin");
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		System.out.println(admin);
	}
}

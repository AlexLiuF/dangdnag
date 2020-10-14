package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.MyBatisUtil;

public class AdminServiceImpl implements AdminService {
	//根据usenrname查询
	@Override
	public Admin selectByUserName(String username) {
		SqlSession sqlSession = null;
		Admin admin = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AdminDao dao = sqlSession.getMapper(AdminDao.class);
			admin = dao.selectByUserName(username);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return admin;
	}

}

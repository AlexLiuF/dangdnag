package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MyBatisUtil;

public class UserServiceImpl implements UserService {
	//查询所有
	@Override
	public List<User> selectAll(Integer pageNum,Integer pageSize) {
		SqlSession sqlSession = null;
		List<User> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			list = dao.selectAll(pageNum,pageSize);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
	//修改状态
	public void updateStatus(Integer id,Integer status) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.update(id, status);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//插入
	public void insert(User user) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.insert(user);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//根据email查
	public User selectByEmail(String email) {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao dao = sqlSession.getMapper(UserDao.class);
			user = dao.selectByEmail(email);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return user;
	}
}

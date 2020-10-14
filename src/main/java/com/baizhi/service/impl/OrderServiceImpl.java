package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.util.MyBatisUtil;

public class OrderServiceImpl implements OrderService {
	@Override
	public void insert(Order order) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			OrderDao dao = sqlSession.getMapper(OrderDao.class);
			dao.insert(order);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	public Order selectById(Integer id) {
		SqlSession sqlSession = null;
		Order order = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			OrderDao dao = sqlSession.getMapper(OrderDao.class);
			order = dao.selectById(id);
			sqlSession.commit();	
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return order;
	}
	//修改状态
	public void update(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			OrderDao dao = sqlSession.getMapper(OrderDao.class);
			dao.update(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//查所有
	public List<Order> selectAll(Integer pageNum,Integer pageSize){
		List list = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			OrderDao dao = sqlSession.getMapper(OrderDao.class);
			list = dao.selectAll(pageNum, pageSize);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
}

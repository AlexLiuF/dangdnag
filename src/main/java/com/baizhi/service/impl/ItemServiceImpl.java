package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.ItemService;
import com.baizhi.util.MyBatisUtil;

public class ItemServiceImpl implements ItemService {

	@Override
	public void insert(Item item) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ItemDao dao = sqlSession.getMapper(ItemDao.class);
			dao.insert(item);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}	
	}
	//根据orderId查
	public List<Item> selectByOrderId(Integer orderId){
		List<Item> list = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ItemDao dao = sqlSession.getMapper(ItemDao.class);
			list = dao.selectByOrderId(orderId);
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

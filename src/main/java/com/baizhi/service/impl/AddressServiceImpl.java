package com.baizhi.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.util.MyBatisUtil;

public class AddressServiceImpl implements AddressService {

	@Override
	public void insert(Address address) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDao dao = sqlSession.getMapper(AddressDao.class);
			dao.insert(address);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDao dao = sqlSession.getMapper(AddressDao.class);
			dao.delete(id);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}	
	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDao dao = sqlSession.getMapper(AddressDao.class);
			dao.update(address);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}

	@Override
	public List<Address> selectAll() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		List<Address> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDao dao = sqlSession.getMapper(AddressDao.class);
			list = dao.selectAll();
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
	//根据userId查
	public List<Address> selectByUserId(Integer userId){
		SqlSession sqlSession = null;
		List<Address> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			AddressDao dao = sqlSession.getMapper(AddressDao.class);
			list = dao.selectByUserId(userId);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
}

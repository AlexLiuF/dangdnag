package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.CategoryFrontDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryFrontService;
import com.baizhi.util.MyBatisUtil;

public class CategoryFrontServiceImpl implements CategoryFrontService {

	@Override
	public List<Category> selectAll() {
		SqlSession sqlSession = null;
		List<Category> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryFrontDao dao = sqlSession.getMapper(CategoryFrontDao.class);
			list = dao.selectAllSort();
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
	//根据parent_id查询
	public List<Category> selectByParentId(Integer fid){
		SqlSession sqlSession = null;
		List<Category> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryFrontDao dao = sqlSession.getMapper(CategoryFrontDao.class);
			list = dao.selectByParentId(fid);
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

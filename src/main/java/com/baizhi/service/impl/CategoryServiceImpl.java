package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.MyBatisUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> selectByLevels(Integer pageNum, Integer pageSize, Integer levels) {
		SqlSession sqlSession = null;
		List<Category> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			list = dao.selectByLevels(pageNum,pageSize,levels);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
	
	//根据id删除先查再删除
	public void  delete(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			List<Category> selectByParentId = dao.selectByParentId(id);
			if(selectByParentId.size()>0) {
				throw new  RuntimeException("删除失败,该类别下面存在二级类别");
			}
			dao.delete(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}
		
		MyBatisUtil.close(sqlSession);
		
	}
	//根据id查
	public List<Category> selectByParentId(Integer id) {
		List<Category>  list = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			list = dao.selectByParentId(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return  list;
	}
	//添加一级类别
	public void insertOneGarde(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			Category category = new Category(1, name, 1, null);
			dao.insert(category);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	
	//跟据id查询
	public Category selectById(Integer id){
		Category category = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			category = dao.selectById(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return category;
	}
	//为二级添加
	public void inertTwoGarde(String name, Integer parentId) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			dao.insertTwoGarde(name, parentId);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//根据等级查所有并不分页
	public List<Category> selectAllByLevels(Integer levels){
		List<Category> list=null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			CategoryDao dao = sqlSession.getMapper(CategoryDao.class);
			list = dao.selectByLevelsSelectAll(levels);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
}

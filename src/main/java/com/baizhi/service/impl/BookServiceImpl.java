package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.MyBatisUtil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> selectAll(Integer pageNum, Integer pageSize) {
		SqlSession sqlSession = null;
		List<Book> list = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
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
	
	//添加
	public void insert(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			dao.insert(book);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}	
	}
	//删除
	public void  delete(Integer id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			Integer sale=dao.selectById(id).getSale();
			if(sale>0) {
				throw new  RuntimeException("有订单不能删除");
			}
			dao.delete(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//根据id查询
	public Book selectById(Integer id) {
		Book book = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			book = dao.selectById(id);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new  RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return book;
	}
	//修改
	public void update(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			dao.update(book);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
	}
	//根据条件查询
	public List<Book> selectByQuery(String query,String value,Integer pageNum,Integer pageSize){
		List<Book> list = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDao dao = sqlSession.getMapper(BookDao.class);
			list = dao.selectByQuery(query, value, pageNum, pageSize);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtil.close(sqlSession);
		}
		return list;
	}
	//编辑推荐查询
		public List<Book> selectRecommend(){
			SqlSession sqlSession = null;
			List<Book> list = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectRecommend();
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//查询热销图书
		public List<Book> selectHotSale(){
			SqlSession sqlSession = null;
			List<Book> list = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectHotSale();
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//查询最新上架
		public List<Book> selectNewUp(){
			SqlSession sqlSession = null;
			List<Book> list = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectNewUp();
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//查询新书热卖
		public List<Book> selectHotNewSale(){
			SqlSession sqlSession = null;
			List<Book> list = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectHotNewSale();
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//前台模糊查询
		public List<Book> selectByValue(String value,Integer pageNum,Integer pageSize){
			List<Book> list = null;
			SqlSession sqlSession = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectByValue(value, pageNum, pageSize);
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//根据二级类别查询
		public List<Book> selectByCategoryTwo(Integer sid,Integer pageNum,Integer pageSize){
			List<Book> list = null;
			SqlSession sqlSession = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectByCategoryTwo(sid, pageNum, pageSize);
				sqlSession.commit();
			} catch (Exception e) {
				sqlSession.rollback();
				throw new RuntimeException(e);
			}finally {
				MyBatisUtil.close(sqlSession);
			}
			return list;
		}
		//根据一级类别查询
		public List<Book> selectByCategory(Integer fid,Integer pageNum,Integer pageSize){
			List<Book> list =  null;
			SqlSession sqlSession = null;
			try {
				sqlSession = MyBatisUtil.getSqlSession();
				BookDao dao = sqlSession.getMapper(BookDao.class);
				list = dao.selectByCategory(fid, pageNum, pageSize);
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

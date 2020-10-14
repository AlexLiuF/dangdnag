package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;

public interface BookDao {
	//增
	void insert(Book book);
	//删除
	void delete(Integer id);
	//改
	void update(Book book);
	//查
	List<Book> selectAll(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	//根据id查
	Book selectById(Integer id);
	//根据条件模糊查询
	List<Book> selectByQuery(@Param("query")String query,@Param("value")String value,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	//编辑推荐查询
	List<Book> selectRecommend();
	//查询热销图书
	List<Book> selectHotSale();
	//查询最新上架
	List<Book> selectNewUp();
	//查询新书热卖
	List<Book> selectHotNewSale();
	//前台模糊查询
	List<Book> selectByValue(@Param("value")String value,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	//根据二级级类别查询
	List<Book> selectByCategoryTwo(@Param("categoryId")Integer categoryId,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	//根据一级类别查询
	List<Book> selectByCategory(@Param("fid")Integer fid,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
 }

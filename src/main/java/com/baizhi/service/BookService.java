package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;

public interface BookService {
	//查询所有
	List<Book> selectAll(Integer pageNum,Integer pageSize);
	//添加
	void insert(Book b);
	//删除
	void  delete(Integer id);
	//根据id查询
	Book selectById(Integer id);
	//修改
	void update(Book book);
	//根据条件查询
	List<Book> selectByQuery(String query,String value,Integer pageNum,Integer pageSize);
	//编辑推荐查询
	List<Book> selectRecommend();
	//查询热销图书
	List<Book> selectHotSale();
	//查询最新上架
	List<Book> selectNewUp();
	//查询新书热卖
	List<Book> selectHotNewSale();
	//前台模糊查询
	List<Book> selectByValue(String value,Integer pageNum,Integer pageSize);
	//根据二级类别查询
	List<Book> selectByCategoryTwo(Integer sid,Integer pageNum,Integer pageSize);
	//根据一级类别查询
	List<Book> selectByCategory(Integer fid,Integer pageNum,Integer pageSize);
}

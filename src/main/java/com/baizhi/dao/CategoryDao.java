package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface CategoryDao {
	//增
	void insert(Category category);
	//删
	void delete(Integer id);
	//查一级
	List<Category> selectByLevels(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("levels") Integer levels);
	//根据父亲id查
	List<Category> selectByParentId(@Param("parentId")Integer parentId);
	//根据id查
	Category selectById(Integer id);
	//增加第二级
	void insertTwoGarde(@Param("name")String name,@Param("parentId") Integer parentId);
	//根据等级查所有
	List<Category> selectByLevelsSelectAll(Integer levels);
}

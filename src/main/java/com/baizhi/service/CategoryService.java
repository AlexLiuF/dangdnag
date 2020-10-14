package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface CategoryService {
	List<Category> selectByLevels(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize,Integer levels);
	//根据id删除
	void delete(Integer id);
	//根据parentId查
	List<Category> selectByParentId(Integer id);
	//添加一级类别
	void insertOneGarde(String name);
	//根据id查
	Category selectById(Integer id);
	//添加二级类别
	void inertTwoGarde(String name, Integer parentId);
	//根据等级查找所有不分页
	List<Category> selectAllByLevels(Integer levels);
}

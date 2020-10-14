package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface CategoryFrontDao {
	//查询所有一级和二级分类
	List<Category> selectAllSort();
	//根据怕parent查询所有二级的
	List<Category> selectByParentId(Integer parentId);
}

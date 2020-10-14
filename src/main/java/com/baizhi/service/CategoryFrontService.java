package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;


public interface CategoryFrontService {
	List<Category> selectAll();
	//根据parent_id查询
	List<Category> selectByParentId(@Param("fid")Integer fid);
}

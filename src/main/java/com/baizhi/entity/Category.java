package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private Integer id;
	private String name;
	private Integer levels;
	private Integer parentId;
	private List<Category> lis;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String name, Integer levels, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.parentId = parentId;
	}
	public Category(Integer id, String name, Integer levels, Integer parentId, List<Category> lis) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.parentId = parentId;
		this.lis = lis;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public List<Category> getLis() {
		return lis;
	}
	public void setLis(List<Category> lis) {
		this.lis = lis;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", levels=" + levels + ", parentId=" + parentId + ", lis="
				+ lis + "]";
	}
	
	
}

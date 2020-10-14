package com.baizhi.entity;

import java.util.Date;

public class Order {
	private Integer id;
	private Double total;
	private Integer status;
	private String name;
	private String mobile;
	private String province;
	private String city;
	private String district;
	private String town;
	private String address;
	private Date createDate;
	private Integer userId;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id, Double total, Integer status, String name, String mobile, String province, String city,
			String district, String town, String address, Date createDate, Integer userId) {
		super();
		this.id = id;
		this.total = total;
		this.status = status;
		this.name = name;
		this.mobile = mobile;
		this.province = province;
		this.city = city;
		this.district = district;
		this.town = town;
		this.address = address;
		this.createDate = createDate;
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", total=" + total + ", status=" + status + ", name=" + name + ", mobile=" + mobile
				+ ", province=" + province + ", city=" + city + ", district=" + district + ", town=" + town
				+ ", address=" + address + ", createDate=" + createDate + ", userId=" + userId + "]";
	}

	
	
}

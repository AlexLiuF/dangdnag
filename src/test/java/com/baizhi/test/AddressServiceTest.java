package com.baizhi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Address;
import com.baizhi.service.impl.AddressServiceImpl;

public class AddressServiceTest {
	@Test
	public void AddressServiceImplInsertTest() throws ParseException{
		AddressServiceImpl ads = new AddressServiceImpl();
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
        Date p1 = si.parse("2009-1-10");
		Address address = new Address(1,"yaya" , "21213123", "河南", "许昌", "及哪敢", "闫家村", "hahah",p1, 71);
		ads.insert(address);
	}
	@Test
	public void AddressServiceImplDeleteTest() {
		AddressServiceImpl ads = new AddressServiceImpl();
		ads.delete(21);
	}
	@Test
	public void AddressServiceImplUpdateTest() throws ParseException {
		AddressServiceImpl ads = new AddressServiceImpl();
		SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
        Date p1 = si.parse("2009-1-10");
		Address address = new Address(21,"heihei" , "21213123", "河南", "许昌", "及哪敢", "闫家村", "hahah",p1, 71);
		ads.update(address);
	}
	@Test
	public void AddressServiceImplSelectAllTest() {
		AddressServiceImpl ads = new AddressServiceImpl();
		List<Address> list = ads.selectAll();
		for (Address address : list) {
			System.out.println(address);
		}
	}
	@Test
	public void selectByUserId() {
		AddressServiceImpl ads = new AddressServiceImpl();
		List<Address> list = ads.selectByUserId(71);
		for (Address address : list) {
			System.out.println(address);
		}
	}
}

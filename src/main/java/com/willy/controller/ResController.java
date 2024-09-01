package com.willy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.willy.human.Address;
import com.willy.human.Result;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ResController {
	@RequestMapping("/hello")
	public Result hello() {
		return Result.success("Hello World!");
	}
	
	@RequestMapping("/getAddr")
	public Result getAddr() {
		Address addr = new Address();
		addr.setProvince("Province a");
		addr.setCity("city b");
		return Result.success(addr);
	}
	
	@RequestMapping("/listAddr")
	public Result listAddr() {
		List<Address> list = new ArrayList<>();
		
		Address addr = new Address();
		addr.setProvince("Province a");
		addr.setCity("city b");
		
		Address addr2 = new Address();
		addr2.setProvince("Province a2");
		addr2.setCity("city b2");
		
		list.add(addr);
		list.add(addr2);
		
		return Result.success(list); 
		
	}
	
	
}
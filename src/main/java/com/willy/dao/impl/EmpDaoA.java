package com.willy.dao.impl;

import java.util.List;

import com.willy.human.Emp;
import com.willy.dao.EmpDao;
import com.willy.utils.XmlParserUtils;

public class EmpDaoA implements EmpDao{
	
	@Override
	public List<Emp> listEmp() throws Exception {
		// TODO Auto-generated method stub
		String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
		System.out.println(file);
		List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
		return empList;
	}
}
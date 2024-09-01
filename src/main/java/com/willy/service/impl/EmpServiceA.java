package com.willy.service.impl;

import java.util.List;

import com.willy.human.Emp;
import com.willy.dao.EmpDao;
import com.willy.dao.impl.EmpDaoA;
import com.willy.dao.impl.EmpDaoA;
import com.willy.service.EmpService;

public class EmpServiceA implements EmpService{
	private EmpDao empDao = new EmpDaoA();
	
	
	@Override
	public List<Emp> listEmp() throws Exception {

		List<Emp> empList = empDao.listEmp();
		// TODO Auto-generated method stub
		empList.stream().forEach(emp -> {
			// gender
			String gender = emp.getGender();
			if ("1".equals(gender)) {
				emp.setGender("男");
			}else if ("2".equals(gender)) {
				emp.setGender("女");
			}
			
			//job
			String job = emp.getJob();
			if ("1".equals(job)) {
				emp.setJob("doctor");
			}else if ("2".equals(job)) {
				emp.setJob("developer");
			}
		});
		
		return empList;
	}
}
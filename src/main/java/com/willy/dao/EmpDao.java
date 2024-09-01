package com.willy.dao;

import java.util.List;

import com.willy.human.Emp;

public interface EmpDao {
	// 獲取員工數據
	public List<Emp> listEmp() throws Exception;
}
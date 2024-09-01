package com.willy.controller;

import java.util.List;

import javax.swing.JFileChooser;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willy.human.Result;
import com.willy.service.EmpService;
import com.willy.service.impl.EmpServiceA;
import com.willy.human.Emp;

@RestController
public class EmpController {
//要調用誰 就創他的實體在這
	private EmpService empService = new EmpServiceA();
	
	@RequestMapping("/listEmp")
	public Result list() throws Exception {
		List<Emp> empList = empService.listEmp();	
		return Result.success(empList);

	}
}

//@RequestMapping("/listEmp")
//public Result list() throws Exception {
//	
//	
//	//1.加載並解析emp.xml
//	
//	String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//	
//	//2.轉換處理gender, job
//
//	empList.stream().forEach(emp -> {
//		// gender
//		String gender = emp.getGender();
//		if ("1".equals(gender)) {
//			emp.setGender("男");
//		}else if ("2".equals(gender)) {
//			emp.setGender("女");
//		}
//		
//		//job
//		String job = emp.getJob();
//		if ("1".equals(job)) {
//			emp.setJob("doctor");
//		}else if ("2".equals(job)) {
//			emp.setJob("developer");
//		}
//	});
//	
//	return Result.success(empList);
//
//}
//}
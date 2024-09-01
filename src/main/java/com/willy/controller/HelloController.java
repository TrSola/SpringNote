package com.willy.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.willy.human.User;

@RestController
@CrossOrigin(origins = "http://localhost:5173") //CORS可加上此行 port可自訂5173為vue
public class HelloController {
	@RequestMapping("/JSONParam")
	public String requestMethodName(@RequestBody User user)  {
		System.out.println(user);
		return "user post ok";
	}
	
	@RequestMapping("complexPojo")
	public String complexPojo(User user) {
		System.out.println(user);
		return "OK";
	}
	
	@RequestMapping("/simpleParam")
	public String simpleParam(@RequestParam(name = "name") String username, Integer age) {
		System.out.println(username + ": " + age);
		return "simpleParam post ok";
	}
	
	@RequestMapping("listParam")
	public String listParam(@RequestParam List<String> hobby) {
		System.out.println(hobby);
		return "listParam post ok";
	}
	
	@RequestMapping("dateParam")
	public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
		System.out.println(updateTime);
	return "dateParam post ok";
	}
	
	@RequestMapping("/path/{id}/{name}")
	public String pathParam(@PathVariable Integer id, @PathVariable String name) {
		System.out.printf("%d: %s" ,id, name);
		return "ok";
	}
}
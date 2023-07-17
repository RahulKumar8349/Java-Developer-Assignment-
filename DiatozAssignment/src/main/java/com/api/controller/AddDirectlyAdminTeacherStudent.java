package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.UserInfo;
import com.api.service.AdminService;

@RestController
@RequestMapping("/home")
public class AddDirectlyAdminTeacherStudent {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo)
	{
		return adminService.addUser(userInfo);
	}

}

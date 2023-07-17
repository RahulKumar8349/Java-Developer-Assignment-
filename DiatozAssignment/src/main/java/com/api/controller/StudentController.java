package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.CurrentUserDetails;
import com.api.model.UserInfo;
import com.api.service.StudentService;

@RestController
@RequestMapping("/home")
//@EnableMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
public class StudentController {

	@Autowired
	private StudentService studentService ;
	

	@PreAuthorize("hasAuthority('ROLE_STUDENT')")
	@GetMapping("/student")
	public ResponseEntity<List<UserInfo>> student()
	{
		return studentById(CurrentUserDetails.currentactiveid);
	}
	
	@PreAuthorize("hasAuthority('ROLE_STUDENT')")
 	//@GetMapping("/student/{id}")
	private ResponseEntity<List<UserInfo>> studentById( int id)
	{		
		List<UserInfo> list= studentService.getStudentById(id);
		if(list!=null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
}

package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.CurrentUserDetails;
import com.api.model.UserInfo;
import com.api.service.TeacherSercive;

@RestController
@RequestMapping("/home")
public class TeacherController {
	
	@Autowired
	private TeacherSercive teacherSercive;
	
	@PreAuthorize("hasAuthority('ROLE_TEACHER')")
	@GetMapping("/teacher")
	public ResponseEntity<List<UserInfo>> adminUser()
	{
		return teacherById(CurrentUserDetails.currentactiveid);
	}
	
	@PreAuthorize("hasAuthority('ROLE_TEACHER')")
 	//@GetMapping("/teacher/{id}")
	private ResponseEntity<List<UserInfo>> teacherById( int id)
	{		
		List<UserInfo> list= teacherSercive.getTeacherById(id);
		if(list!=null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_TEACHER')")
	@PostMapping("/teacher/student/add")
	public String addNewUser(@RequestBody UserInfo userInfo)
	{
		return teacherSercive.addUser(userInfo);
	}
	
		@PreAuthorize("hasAuthority('ROLE_TEACHER')")
	 	@GetMapping("/teacher/student")
		public ResponseEntity<List<UserInfo>> allStudnent()
		{		
			List<UserInfo> list= teacherSercive.allStudent();
			if(list!=null && list.size()<=0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	
	 	
		@PreAuthorize("hasAuthority('ROLE_TEACHER')")
	 	@GetMapping("/teacher/student/{id}")
		public ResponseEntity<List<UserInfo>> StudentById(@PathVariable("id") int id)
		{		
			List<UserInfo> list= teacherSercive.getStudentById(id);
			if(list!=null && list.size()<=0)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	 	
	 	
	 	
		@PreAuthorize("hasAuthority('ROLE_TEACHER')")
		@DeleteMapping("/teacher/student/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable("id") int id)
		{
			String ans="";
			try {
				ans=this.teacherSercive.delete(id);
				return ResponseEntity.ok().body(ans);
			} catch (Exception e) {
				System.out.println("id not present bro");
			}
			return ResponseEntity.ok().body(ans);
		}
		
		@PreAuthorize("hasAuthority('ROLE_TEACHER')")
		@PutMapping("/teacher/student/update/{id}")
		public ResponseEntity<String> update(@RequestBody UserInfo userInfo,@PathVariable("id") int id)
		{
			String ans="";
			try {
				ans=this.teacherSercive.update(userInfo,id);
				
				return ResponseEntity.ok().body(ans);
			} catch (Exception e) {
				System.out.println(" no id for this");
			}
			return ResponseEntity.ok().body(ans);
		}
}

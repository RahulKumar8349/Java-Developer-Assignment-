package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.CurrentUserDetails;
import com.api.model.UserInfo;
import com.api.service.AdminService;


@RestController
@RequestMapping("/home")
//@EnableMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
public class AdminController {
	
	@Autowired
	private AdminService adminService;

 	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public ResponseEntity<List<UserInfo>> adminUser()
	{
		return adminById(CurrentUserDetails.currentactiveid);
	}
 	
 	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	//@GetMapping("/admin/{id}")
	private ResponseEntity<List<UserInfo>> adminById( int id)
	{		
		List<UserInfo> list= adminService.getAdminById(id);
		if(list!=null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
 	
 	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	@GetMapping("/admin/all")
	public ResponseEntity<List<UserInfo>> getAll()
	{		
		List<UserInfo> list= adminService.getAll(); 
		if(list != null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
 	

 	
 	
 	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	@GetMapping("/admin/teacher")
	public ResponseEntity<List<UserInfo>> allTeachers()
	{		
		List<UserInfo> list= adminService.getTeachers();
		if(list!=null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
 	
 	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	@GetMapping("/admin/teacher/{id}")
	public ResponseEntity<List<UserInfo>> TeachersById(@PathVariable("id") int id)
	{		
		List<UserInfo> list= adminService.getTeacherById(id);
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
 	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	@GetMapping("/admin/student")
	public ResponseEntity<List<UserInfo>> allStudents()
	{		
		List<UserInfo> list= adminService.getStudents();
		if(list != null && list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
 	@GetMapping("/admin/student/{id}")
	public ResponseEntity<List<UserInfo>> StudentById(@PathVariable("id") int id)
	{		
		List<UserInfo> list= adminService.getStudentById(id);
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/admin/add")
	public String add(@RequestBody UserInfo userInfo)
	{
		return adminService.addUser(userInfo);
	}
	

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
		
		if(adminService.dataAvailiability(id))
		{
		try {
			this.adminService.delete(id);
			return ResponseEntity.ok().body("data deleted successfully");
		} catch (Exception e) {
			System.out.println("id not present");
		}
		}
		return ResponseEntity.ok().body("There is no id exist , which you given");
	}
	
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@PutMapping("/admin/update/{id}")
		public ResponseEntity<String> update(@RequestBody UserInfo userInfo,@PathVariable("id") int id)
		{
			if(adminService.dataAvailiability(id))
			{
				try {
					String ans=this.adminService.update(userInfo,id);
					return ResponseEntity.ok().body(ans);
				} catch (Exception e) {
					System.out.println(" no id found for this id please check your id");
				}
			}
			
			return ResponseEntity.ok().body("There is no id exist , which you given");
			
	}

	
}

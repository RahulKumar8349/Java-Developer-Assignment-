package com.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HowThisProjectWillWork {
	
 	
	@GetMapping("/guideline")
	public ResponseEntity<String> PublicUser()
	{
		return ResponseEntity.ok(""
				+"\n\n In this project tables will be created automatically in database i have used my database name as diatoz \n"
				+"and automatically when table is created its name will be userinfo \n"
				+ "you can change database configuration at application.properties\n"
				+ "\n my database is MySql and  password is Rahul@123 you can change it through application.properties"
				+ "\n\n\nThis project contain 3 sections \n"
				+ "\n"
				+ "I have used spring security without authentication no one is allowed to access so first need to login "
				+ "for now if someone start this project /ndon't worry i have created add-directly-admin-teacher-student controller "
				+ "where you can directly add new admin or teacher or student   using    /home/new"
				+ "\n\n\n"
				+ "\t 1. Admin \n "
				+ "\t\t this require authentication\n\n"
				+ "\t\t\t home/admin   \t\t\t   get current admin details \n"
				+ "\t\t\t home/admin/all   \t\t   get all teachers and students \n"
				+ "\t\t\t home/admin/add   \t\t  add teacher or student \n"
				+ "\t\t\t home/admin/teacher   \t\t  get all teachers \n"
				+ "\t\t\t home/admin/teacher/{id}   \t  get teacher by id \n"
				+ "\t\t\t home/admin/student   \t\t  get all students \n"
				+ "\t\t\t home/admin/student/{id}   \t  get student by id \n"
				+ "\t\t\t home/admin/delete/{id}   \t  delete teacher or student by id \n"
				+ "\t\t\t home/admin/update/{id}   \t  update teacher or student by id \n\n\n\n"
				
				+ "\t 2. Teacher \n"
				+ "\t\t this require authentication\n\n"
				+ "\t\t\t home/teacher   \t\t   get current teacher details \n"
				+ "\t\t\t home/teacher/student  \t \t   get all student \n"
				+ "\t\t\t home/teacher/student/{id}  \t   get student by id \n"
				+ "\t\t\t home/teacher/student/add   \t   add student \n"
				+ "\t\t\t home/teacher/delete/{id}   \t   delete student by id \n"
				+ "\t\t\t home/teacher/update/{id}   \t   update student by id \n\n\n"
				
				+ "\t 3. Student \n"
				+ "\t\t this require authentication/n/n"
				+ "\t\t home/student  \t   get current student details \n\n\n"
				
				+ "\t 4. add-directly-admin-teacher-student : \n"
				+ "\t\t this does not require authentication/n/n"
				+ "\t\t /home/new "
				+ "\t\t\t here you can directly add admin or teacher or teacher without authentication\n"
				+ "I have developed this section for testing purpose\n\n\n"
				+ "i have used Spring Boot 4.4 ,Spring Security , Swagger , PostMan , MySql"
				+ "\n\n"
				+ "please check my documentation in swagger and test these api in swagger in chrome\n"
				+ "I have developed this in 5 days by working 16 hours daily "
				+ "\n Thank you soo much Sir for reading this "
				);
	}

}

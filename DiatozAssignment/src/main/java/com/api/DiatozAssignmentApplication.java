package com.api;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
@OpenAPIDefinition(
		info= @Info ( title = "Diatoz Java Developer Assignment ",
			  version="1.0.0",
			  description="The project is to store and manage all data and records related to College.\n"
			  		+ "There are three types of users in this system: admin, student and teacher. Admin\n"
			  		+ "handles the whole system and has rights to access the data of other users. He can\n"
			  		+ "add, delete, and modify the records of students and teachers. Teachers can keep track\n"
			  		+ "of marks and grades obtained by the student in exams. Students can view their details.\n"
			  		+ "Each user of the system has to login with a valid username and password in order to\n"
			  		+ "access the system "
			  		+ ".I had used MySQL  as database and Spring Securit for Authentication.",
			  termsOfService="Rahul Kumar Sen"  ,
			  contact = @Contact ( name = "Rahul Kumar Sen" , email ="123sen.rahul@gmail.com") ,
			  license = @License ( name = "licence",url="Rahul kumar sen")
			  
				)
		)
		
public class DiatozAssignmentApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DiatozAssignmentApplication.class, args);
		
		
		System.out.println("\nWelcome to Diatoz Java Developer Assignment \n\t\tdeveloped by Rahul Kumar sen \r\n");
		
	      
	}

}

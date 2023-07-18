# Java-Developer-Assignment-

the whole project is role based authenticated . so if you are a new user then you must have to create admin with roles "ROLE_ADMIN" and teacher with roles "ROLE_TEACHER" and student with role "ROLE_STUDENT" . 

you can create these using   home/new  . this section is not authenticated so you can create from here and you can login as admin or teacher or student .



 In this project tables will be created automatically in database i have used my database name as diatoz 
and automatically when table is created its name will be userinfo 
you can change database configuration at application.properties

 my database is MySql and  password is Rahul@123 you can change it through application.properties


This project contain 3 sections 

I have used spring security without authentication no one is allowed to access so first need to login for now if someone start this project /ndon't worry i have created add-directly-admin-teacher-student controller where you can directly add new admin or teacher or student   using    /home/new


	 1. Admin 
 		 this require authentication

			 home/admin   			   get current admin details 
			 home/admin/all   		   get all teachers and students 
			 home/admin/add   		  add teacher or student 
			 home/admin/teacher   		  get all teachers 
			 home/admin/teacher/{id}   	  get teacher by id 
			 home/admin/student   		  get all students 
			 home/admin/student/{id}   	  get student by id 
			 home/admin/delete/{id}   	  delete teacher or student by id 
			 home/admin/update/{id}   	  update teacher or student by id 



	 2. Teacher 
		 this require authentication

			 home/teacher   		   get current teacher details 
			 home/teacher/student  	 	   get all student 
			 home/teacher/student/{id}  	   get student by id 
			 home/teacher/student/add   	   add student 
			 home/teacher/delete/{id}   	   delete student by id 
			 home/teacher/update/{id}   	   update student by id 


	 3. Student 
		 this require authentication/n/n		 home/student  	   get current student details 


	 4. add-directly-admin-teacher-student : 
		 this does not require authentication/n/n		 /home/new 			 here you can directly add admin or teacher or teacher without authentication
I have developed this section for testing purpose


i have used Spring Boot 4.4 ,Spring Security , Swagger , PostMan , MySql

please check my documentation in swagger and test these api in swagger in chrome
I have developed this in 5 days by working 16 hours daily 
 Thank you soo much Sir for reading this 

package com.api.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.model.UserInfo;
import com.api.repository.UserInfoRespository;


@Service
public class AdminService {
	
	@Autowired
	private UserInfoRespository respository;    
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addUser(UserInfo userInfo)
	{

		if(dataAvailiability(userInfo.getId()))
		{
			return "user not add because user of that id is already exist , please leave this id section because our software generates automatic id";
		}
		
		
		if(userInfo.getRoles() !=null)
		if(userInfo.getRoles().equals("ROLE_STUDENT") || userInfo.getRoles().equals("ROLE_TEACHER") || userInfo.getRoles().equals("ROLE_ADMIN") )
		{
			if(userInfo.getPassword()!=null && !userInfo.getPassword().equals(""))
				userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			respository.save(userInfo);
			return "user added to system . well our system generates automatically id so it is not recommended to specify id ok";
		}
		
		if((userInfo.getId()==0 && userInfo.getRoles() == null) || userInfo.getId()==0 || userInfo.getId()!=0 )
		{
			userInfo.setRoles("ROLE_STUDENT");
			if(userInfo.getPassword()!=null && !userInfo.getPassword().equals(""))
				userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			respository.save(userInfo);
			return "you have not specified roles as \"ROLE_STUDENT\" or \"ROLE_TEACHER\" or \"ROLE_ADMIN\" but don't worry data is added with default roles as \" ROLE_STUDENT \" ";
		}
		return "data not added";
	}
	
	public List<UserInfo> getAll()
	{
		//List<UserInfo> list =(List<UserInfo>)this.respository.findAll();
		List<UserInfo> list =(List<UserInfo>)this.respository.findAllTeacherAndStudent("ROLE_TEACHER","ROLE_STUDENT");
		return list;
	}
	
	public List<UserInfo> getTeachers()
	{
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRoles("ROLE_TEACHER");
		return list;
	}
	
	public List<UserInfo> getStudents()
	{
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRoles("ROLE_STUDENT");
		return list;
	}
	
	public List<UserInfo> getAdminById(int id)
	{
		//List<UserInfo> list =(List<UserInfo>)this.respository.findAll();
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRolesAndId("ROLE_ADMIN",id);
		return list;
	}
	
	public List<UserInfo> getTeacherById(int id)
	{
		//List<UserInfo> list =(List<UserInfo>)this.respository.findAll();
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRolesAndId("ROLE_TEACHER",id);
		return list;
	}
	
	public List<UserInfo> getStudentById(int id)
	{
		//List<UserInfo> list =(List<UserInfo>)this.respository.findAll();
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRolesAndId("ROLE_STUDENT",id);
		return list;
	}

	public void delete(int id) {
		 respository.deleteById(id);
	}

	public String update(UserInfo userInfo, int id) {
		userInfo.setId(id);
		if(userInfo.getRoles()!=null && ( userInfo.getRoles().equals("ROLE_ADMIN") || userInfo.getRoles().equals("ROLE_TEACHER") || userInfo.getRoles().equals("ROLE_STUDENT")) )
		{
			if(userInfo.getPassword()!=null && !userInfo.getPassword().equals(""))
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			respository.save(userInfo);	
			return "data updated successfully";
		} 
		
		userInfo.setRoles("ROLE_STUDENT");
		if(userInfo.getPassword()!=null && !userInfo.getPassword().equals(""))
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		respository.save(userInfo);	
		return "You can specify roles as  :  ROLE_ADMIN , ROLE_TEACHER, ROLE_STUDENT   but no issue by defalut ROLE_STUDENT is saved as roles because you entered wrong choice of roles ";
		
	}
	
	public boolean dataAvailiability(int id)
	{
		Optional<UserInfo> find = respository.findById(id);
		return find.isPresent();
	}
	
	

}

package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.UserInfo;
import com.api.repository.UserInfoRespository;

@Service
public class StudentService {
	
	@Autowired
	private UserInfoRespository respository; 
	
	public List<UserInfo> getStudentById(int id)
	{
		List<UserInfo> list =(List<UserInfo>)this.respository.findUserinfoByRolesAndId("ROLE_STUDENT",id);
		return list;
	}

}

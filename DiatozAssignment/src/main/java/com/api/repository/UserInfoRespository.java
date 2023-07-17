package com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.model.UserInfo;

public interface UserInfoRespository extends JpaRepository<UserInfo, Integer>  {

	Optional<UserInfo> findByUsername(String username);
	
	@Query("select u from UserInfo u WHERE u.roles =:n")
	public List<UserInfo> findUserinfoByRoles(@Param("n") String roles);
	
	@Query("select u from UserInfo u WHERE u.roles =:n AND u.id=:id") 
	public List<UserInfo> findUserinfoByRolesAndId(@Param("n") String roles,int id);

	@Query("select u from UserInfo u WHERE u.roles =:n1 OR u.roles=:n2")
	List<UserInfo> findAllTeacherAndStudent(@Param("n1") String n1,@Param("n2") String n2);
}

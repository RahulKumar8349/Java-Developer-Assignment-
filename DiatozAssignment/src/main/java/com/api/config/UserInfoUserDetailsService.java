package com.api.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.model.UserInfo;
import com.api.repository.UserInfoRespository;



@Service
public class UserInfoUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserInfoRespository respository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo =respository.findByUsername(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found bro"+username));
	}

}

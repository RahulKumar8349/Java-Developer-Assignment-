package com.api.config;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
	
	public static final String[] 	PUBLIC_URLS= {  
		 										"/home/guideline",
		 										"/home/new",
		 										"/v3/api-docs/**" , 
		 										"/v2/api-docs/**", 
		 										"/swagger-resources/**" , 
		 										"/swagger-ui/**" , 
		 										"/webjars/**" 
		 									};
	

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return  new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new UserInfoUserDetailsService();
	}

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.
		csrf().disable().authorizeHttpRequests().
		
		requestMatchers(PUBLIC_URLS).permitAll().

		requestMatchers("/home/admin/**").
		authenticated().
		
		requestMatchers("/home/teacher/**").
		authenticated().
		
		requestMatchers("/home/student/**").
		authenticated().
		and().formLogin();
		
		return httpSecurity.build();
	}

}

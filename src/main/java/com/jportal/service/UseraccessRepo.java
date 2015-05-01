package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Useraccess;

public interface UseraccessRepo  extends JpaRepository<Useraccess,Integer>, Serializable{
	
	public final static String authUser = "select user from Useraccess user where user.username = :username and user.password = :password";
	public final static String loginUser = "select user from Useraccess user where user.username = :username";
	
		@Query(authUser)
		public Useraccess authUser(@Param("username") String username,@Param("password") String password);
		
		@Query(loginUser)
		public Useraccess loginUser(@Param("username") String username);
		

}

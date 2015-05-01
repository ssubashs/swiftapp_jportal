package com.jportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jportal.model.Useraccess;
import com.jportal.service.UseraccessRepo;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UseraccessRepo repository;
	

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try 
		{
			Useraccess loggedUser =  repository.loginUser(username);		
			 if (loggedUser == null) {
		            throw new UsernameNotFoundException("Invalid username/password.");
		        }
			 System.out.println("loggedUser :: "+loggedUser.getProfile());
			return loggedUser;
	
		} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}	

}

package com.jportal.service;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jportal.model.Useraccess;
import com.jportal.security.DomainUsernamePasswordAuthenticationToken;

//@Service
public class UserAuthenticationProviderService implements AuthenticationProvider {

//	@Autowired
	private UseraccessRepo repository;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		 DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
	        String userName = token.getName();
//	        String domain = token.getDomain();
//	        String email = userName + "@" + domain;
	        System.out.println("Security ::: : userName "+ userName);
	        Useraccess user = repository.loginUser(userName);
	        if(user == null) {
	            throw new UsernameNotFoundException("Invalid username/password");
	        }
	        String password = user.getPassword();
	        if(!password.equals(token.getCredentials())) {
	            throw new BadCredentialsException("Invalid username/password");
	        }
	        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
	        return new DomainUsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return DomainUsernamePasswordAuthenticationToken.class.equals(authentication);
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return repository.findLoggedUser(username);
//	}

}

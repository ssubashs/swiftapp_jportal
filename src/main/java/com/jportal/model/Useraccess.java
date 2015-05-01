package com.jportal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the useraccess database table.
 * 
 */
@Entity
@NamedQuery(name="Useraccess.findAll", query="SELECT u FROM Useraccess u")
public class Useraccess implements UserDetails,Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int profileid;

	@JsonIgnore
	private String password;

	private String username;
	
	

	public Useraccess( String username,String password,Profile profile) {
		super();	

		this.password = password;
		this.username = username;
		this.profile = profile;
		this.profileid = profile.getProfileid();
	}

	//bi-directional one-to-one association to Profile
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="profileid")
	private Profile profile;

	public Useraccess() {
	}

	public int getProfileid() {
		return this.profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		List<Userrole> userRoles =  this.getProfile().getUserroles();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Userrole role : userRoles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getRolecd()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public String toString() {
		return "Useraccess [profileid=" + profileid + ", password=" + password
				+ ", username=" + username + "]";
	}
	
	

}
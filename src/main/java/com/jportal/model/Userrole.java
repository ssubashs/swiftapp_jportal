package com.jportal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the userrole database table.
 * 
 */
@Entity
@NamedQuery(name="Userrole.findAll", query="SELECT u FROM Userrole u")
public class Userrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;

	private String rolecd;

	private String status;
	
	

	public Userrole(String rolecd, String status,Profile user) {
		super();
		this.rolecd = rolecd;
		this.status = status;
		this.profile = user;
	}

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid")
	private Profile profile;

	public Userrole() {
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolecd() {
		return this.rolecd;
	}

	public void setRolecd(String rolecd) {
		this.rolecd = rolecd;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Userrole [roleid=" + roleid + ", rolecd=" + rolecd
				+ ", status=" + status + "]";
	}
	
	

}
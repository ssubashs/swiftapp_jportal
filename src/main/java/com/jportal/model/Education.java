package com.jportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@NamedQuery(name="Education.findAll", query="SELECT e FROM Education e")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;

	private String city;

	private String country;

	private String degree;

	private String grade;

	@Temporal(TemporalType.DATE)
	private Date gradend;

	@Temporal(TemporalType.DATE)
	private Date gradstart;

	private String school;

	private String state;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid")
	@JsonIgnore
	private Profile profile;

	public Education() {
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getGradend() {
		return this.gradend;
	}

	public void setGradend(Date gradend) {
		this.gradend = gradend;
	}

	public Date getGradstart() {
		return this.gradstart;
	}

	public void setGradstart(Date gradstart) {
		this.gradstart = gradstart;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
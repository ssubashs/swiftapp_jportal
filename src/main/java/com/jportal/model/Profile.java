package com.jportal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileid;

	private String addline1;

	private String addline2;

	private String city;

	private String country;

	@Temporal(TemporalType.DATE)
	private Date dateofbirth;

	private String email;

	private String firstname;

	private String gender;

	private String hphone;

	private String lastname;

	private String middlename;

	private String mphone;

	private String state;

	private String username;

	//bi-directional many-to-one association to Doc
	@OneToMany(mappedBy="profile",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Doc> docs;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="profile",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Education> educations;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="profile",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Experience> experiences;

	//bi-directional many-to-one association to Technology
	@OneToMany(mappedBy="profile",fetch=FetchType.LAZY)	
	@JsonIgnore
	private List<Technology> technologies;

	//bi-directional one-to-one association to Useraccess
//	@OneToOne(mappedBy="profile")	
//	private Useraccess useraccess;

	//bi-directional many-to-one association to Userrole
	@OneToMany(mappedBy="profile",fetch=FetchType.LAZY)	
	@Cascade(value = CascadeType.PERSIST)
	@JsonIgnore
	private List<Userrole> userroles;

	public Profile() {
	}

	public int getProfileid() {
		return this.profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getAddline1() {
		return this.addline1;
	}

	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}

	public String getAddline2() {
		return this.addline2;
	}

	public void setAddline2(String addline2) {
		this.addline2 = addline2;
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

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHphone() {
		return this.hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getMphone() {
		return this.mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Doc> getDocs() {
		return this.docs;
	}

	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}

	public Doc addDoc(Doc doc) {
		getDocs().add(doc);
		doc.setProfile(this);

		return doc;
	}

	public Doc removeDoc(Doc doc) {
		getDocs().remove(doc);
		doc.setProfile(null);

		return doc;
	}

	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Education addEducation(Education education) {
		getEducations().add(education);
		education.setProfile(this);

		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		education.setProfile(null);

		return education;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setProfile(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setProfile(null);

		return experience;
	}

	public List<Technology> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	public Technology addTechnology(Technology technology) {
		getTechnologies().add(technology);
		technology.setProfile(this);

		return technology;
	}

	public Technology removeTechnology(Technology technology) {
		getTechnologies().remove(technology);
		technology.setProfile(null);

		return technology;
	}

//	public Useraccess getUseraccess() {
//		return this.useraccess;
//	}
//
//	public void setUseraccess(Useraccess useraccess) {
//		this.useraccess = useraccess;
//	}

	public List<Userrole> getUserroles() {
		if(this.userroles == null)
			this.userroles = new ArrayList<Userrole>();
		
		return this.userroles;
	}

	public void setUserroles(List<Userrole> userroles) {
		this.userroles = userroles;
	}

	public Userrole addUserrole(Userrole userrole) {
		getUserroles().add(userrole);
		userrole.setProfile(this);

		return userrole;
	}

	public Userrole removeUserrole(Userrole userrole) {
		getUserroles().remove(userrole);
		userrole.setProfile(null);

		return userrole;
	}
	


	@Override
	public String toString() {
		return "Profile [profileid=" + profileid + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", username=" + username
				+ ", userroles=" + userroles
				+ "]";
	}	
	
	

}
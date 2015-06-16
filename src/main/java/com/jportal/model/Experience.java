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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@Table(name="experience")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int expid;

	private String cancontact;

	@Temporal(TemporalType.DATE)

	private Date enddate;

	private String feedback;

	private String iscurrent;

	private String jobdescription;

	private String jobtitle;

	private String orgaddress;

	private String orgcategory;

	private String orgcountry;

	private String orgname;

	private String orgstate;

	private String orgzip;

	private int salary;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid")
	@JsonIgnore
	private Profile profile;

	public Experience() {
	}

	public int getExpid() {
		return this.expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}

	public String getCancontact() {
		return this.cancontact;
	}

	public void setCancontact(String cancontact) {
		this.cancontact = cancontact;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getIscurrent() {
		return this.iscurrent;
	}

	public void setIscurrent(String iscurrent) {
		this.iscurrent = iscurrent;
	}

	public String getJobdescription() {
		return this.jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getOrgaddress() {
		return this.orgaddress;
	}

	public void setOrgaddress(String orgaddress) {
		this.orgaddress = orgaddress;
	}

	public String getOrgcategory() {
		return this.orgcategory;
	}

	public void setOrgcategory(String orgcategory) {
		this.orgcategory = orgcategory;
	}

	public String getOrgcountry() {
		return this.orgcountry;
	}

	public void setOrgcountry(String orgcountry) {
		this.orgcountry = orgcountry;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgstate() {
		return this.orgstate;
	}

	public void setOrgstate(String orgstate) {
		this.orgstate = orgstate;
	}

	public String getOrgzip() {
		return this.orgzip;
	}

	public void setOrgzip(String orgzip) {
		this.orgzip = orgzip;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
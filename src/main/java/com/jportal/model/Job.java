package com.jportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@Table(name="job")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="job_id")
	private int jobId;

	@Column(name="benefit_pay_package")
	private String benefitPayPackage;

	@Column(name="benefit_relocation")
	private String benefitRelocation;

	@Column(name="employment_type")
	private String employmentType;

	@Column(name="job_contact_name")
	private String jobContactName;
	
	@Column(name="job_manager_phone")
	private String jobManagerPhone;

	@Column(name="job_manager_email")
	private String jobManagerEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="job_expiry")
	private Date jobExpiry;

	@Column(name="job_status")
	private String jobStatus;

	@Column(name="job_title")
	private String jobTitle;

	private String openings;

	@Column(name="req_education")
	private String reqEducation;

	@Column(name="req_experience")
	private String reqExperience;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;

	@Column(name="job_description")
	private String jobDescription;
	

	public Job() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getBenefitPayPackage() {
		return this.benefitPayPackage;
	}

	public void setBenefitPayPackage(String benefitPayPackage) {
		this.benefitPayPackage = benefitPayPackage;
	}

	public String getBenefitRelocation() {
		return this.benefitRelocation;
	}

	public void setBenefitRelocation(String benefitRelocation) {
		this.benefitRelocation = benefitRelocation;
	}

	public String getEmploymentType() {
		return this.employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getJobContactName() {
		return this.jobContactName;
	}

	public void setJobContactName(String jobContactName) {
		this.jobContactName = jobContactName;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getJobExpiry() {
		return this.jobExpiry;
	}

	public void setJobExpiry(Date jobExpiry) {
		this.jobExpiry = jobExpiry;
	}

	public String getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOpenings() {
		return this.openings;
	}

	public void setOpenings(String openings) {
		this.openings = openings;
	}

	public String getReqEducation() {
		return this.reqEducation;
	}

	public void setReqEducation(String reqEducation) {
		this.reqEducation = reqEducation;
	}

	public String getReqExperience() {
		return this.reqExperience;
	}

	public void setReqExperience(String reqExperience) {
		this.reqExperience = reqExperience;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getJobManagerPhone() {
		return jobManagerPhone;
	}

	public void setJobManagerPhone(String jobManagerPhone) {
		this.jobManagerPhone = jobManagerPhone;
	}

	public String getJobManagerEmail() {
		return jobManagerEmail;
	}

	public void setJobManagerEmail(String jobManagerEmail) {
		this.jobManagerEmail = jobManagerEmail;
	}

	

}
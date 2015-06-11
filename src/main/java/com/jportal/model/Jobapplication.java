package com.jportal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the jobapplication database table.
 * 
 */
@Entity
@NamedQuery(name="Jobapplication.findAll", query="SELECT j FROM Jobapplication j")
public class Jobapplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobapplicationPK id;

	@Temporal(TemporalType.DATE)
	private Date applieddate;

	private String status;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="jobid",insertable=false,updatable=false)
	private Job job;

	public Jobapplication() {
	}

	public JobapplicationPK getId() {
		return this.id;
	}

	public void setId(JobapplicationPK id) {
		this.id = id;
	}

	public Date getApplieddate() {
		return this.applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
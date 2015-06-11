package com.jportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the jobapplication database table.
 * 
 */
@Embeddable
public class JobapplicationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int jobid;

	@Column(insertable=false, updatable=false)
	private int profileid;

	public JobapplicationPK() {
	}
	public int getJobid() {
		return this.jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getProfileid() {
		return this.profileid;
	}
	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobapplicationPK)) {
			return false;
		}
		JobapplicationPK castOther = (JobapplicationPK)other;
		return 
			(this.jobid == castOther.jobid)
			&& (this.profileid == castOther.profileid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.jobid;
		hash = hash * prime + this.profileid;
		
		return hash;
	}
}
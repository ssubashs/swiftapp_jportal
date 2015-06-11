package com.jportal.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jobskills database table.
 * 
 */
@Embeddable
public class JobskillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int jobid;

	private String skill;

	public JobskillPK() {
	}
	public int getJobid() {
		return this.jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getSkill() {
		return this.skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobskillPK)) {
			return false;
		}
		JobskillPK castOther = (JobskillPK)other;
		return 
			(this.jobid == castOther.jobid)
			&& this.skill.equals(castOther.skill);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.jobid;
		hash = hash * prime + this.skill.hashCode();
		
		return hash;
	}
}
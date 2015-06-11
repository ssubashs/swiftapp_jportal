package com.jportal.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the profileskill database table.
 * 
 */
@Embeddable
public class ProfileskillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int profileid;

	private String skills;

	public ProfileskillPK() {
	}
	public int getProfileid() {
		return this.profileid;
	}
	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}
	public String getSkills() {
		return this.skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfileskillPK)) {
			return false;
		}
		ProfileskillPK castOther = (ProfileskillPK)other;
		return 
			(this.profileid == castOther.profileid)
			&& this.skills.equals(castOther.skills);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.profileid;
		hash = hash * prime + this.skills.hashCode();
		
		return hash;
	}
}
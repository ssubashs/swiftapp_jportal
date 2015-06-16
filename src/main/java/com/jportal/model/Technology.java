package com.jportal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the technology database table.
 * 
 */
@Entity
@Table(name="technology")
@NamedQuery(name="Technology.findAll", query="SELECT t FROM Technology t")
public class Technology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;

	private String selfrating;

	private String tags;

	private String techdescription;

	private String techskill;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid")
	@JsonIgnore
	private Profile profile;

	public Technology() {
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getSelfrating() {
		return this.selfrating;
	}

	public void setSelfrating(String selfrating) {
		this.selfrating = selfrating;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTechdescription() {
		return this.techdescription;
	}

	public void setTechdescription(String techdescription) {
		this.techdescription = techdescription;
	}

	public String getTechskill() {
		return this.techskill;
	}

	public void setTechskill(String techskill) {
		this.techskill = techskill;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
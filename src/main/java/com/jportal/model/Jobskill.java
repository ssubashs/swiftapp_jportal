package com.jportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jobskills database table.
 * 
 */
@Entity
@Table(name="jobskills")
@NamedQuery(name="Jobskill.findAll", query="SELECT j FROM Jobskill j")
public class Jobskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobskillPK id;

	private String rating;

	public Jobskill() {
	}

	public JobskillPK getId() {
		return this.id;
	}

	public void setId(JobskillPK id) {
		this.id = id;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
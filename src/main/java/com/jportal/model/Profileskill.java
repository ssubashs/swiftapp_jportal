package com.jportal.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the profileskill database table.
 * 
 */
@Entity
@Table(name="profileskill")
@NamedQuery(name="Profileskill.findAll", query="SELECT p FROM Profileskill p")
public class Profileskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfileskillPK id;

	private String rating;

	public Profileskill() {
	}

	public ProfileskillPK getId() {
		return this.id;
	}

	public void setId(ProfileskillPK id) {
		this.id = id;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
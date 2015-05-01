package com.jportal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the docs database table.
 * 
 */
@Entity
@Table(name="docs")
@NamedQuery(name="Doc.findAll", query="SELECT d FROM Doc d")
public class Doc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int docid;

	@Lob
	@JsonIgnore
	private byte[] content;

	private String docextn;

	private String docsize;

	private String doctype;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid")
	@JsonIgnore
	@RestResource(exported=false,rel="profile_doc")
	private Profile profile;

	public Doc() {
	}

	public int getDocid() {
		return this.docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getDocextn() {
		return this.docextn;
	}

	public void setDocextn(String docextn) {
		this.docextn = docextn;
	}

	public String getDocsize() {
		return this.docsize;
	}

	public void setDocsize(String docsize) {
		this.docsize = docsize;
	}

	public String getDoctype() {
		return this.doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
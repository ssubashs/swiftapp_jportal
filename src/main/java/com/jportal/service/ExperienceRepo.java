package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Experience;


public interface ExperienceRepo  extends PagingAndSortingRepository<Experience,Integer>, Serializable{
public final static String expByProfileid = "select exps from Experience exps where exps.profile.profileid = :profileid";
	
	@Query(expByProfileid)
	public List<Experience> expByProfileid(@Param("profileid")Integer profileid);


}

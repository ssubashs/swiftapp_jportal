package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Education;


public interface EducationRepo  extends PagingAndSortingRepository<Education,Integer>, Serializable{
public final static String eduByProfileid = "select edus from Education edus where edus.profile.profileid = :profileid";
	
	@Query(eduByProfileid)
	public List<Education> eduByProfileid(@Param("profileid")Integer profileid);

}

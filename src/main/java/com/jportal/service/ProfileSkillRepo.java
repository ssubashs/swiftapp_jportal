package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Profileskill;
import com.jportal.model.ProfileskillPK;


public interface ProfileSkillRepo  extends PagingAndSortingRepository<Profileskill,ProfileskillPK>, Serializable{
	public final static String skillByProfileid = "select skills from Profileskill skills where skills.id.profileid = :profileid";
	
	@Query(skillByProfileid)
	public List<Profileskill> skillByProfileid(@Param("profileid")Integer profileid);
	

}

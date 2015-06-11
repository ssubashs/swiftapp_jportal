package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Jobskill;
import com.jportal.model.JobskillPK;


public interface JobSkillRepo  extends PagingAndSortingRepository<Jobskill,JobskillPK>, Serializable{
	public final static String skillByJobid = "select skills from Jobskill skills where skills.id.jobid = :jobid";
	
	@Query(skillByJobid)
	public List<Jobskill> skillByJobid(@Param("jobid")Integer jobid);
	

}

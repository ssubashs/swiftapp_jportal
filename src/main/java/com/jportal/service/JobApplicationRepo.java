package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Jobapplication;
import com.jportal.model.JobapplicationPK;
import com.jportal.model.Jobskill;


public interface JobApplicationRepo  extends PagingAndSortingRepository<Jobapplication,JobapplicationPK>, Serializable{
	public final static String applicationByJobid = "select applications from Jobapplication applications where applications.id.jobid = :jobid";
	public final static String applicationByProfileid = "select applications from Jobapplication applications where applications.id.profileid = :profileid";
	
	@Query(applicationByJobid)
	public List<Jobapplication> applicationByJobid(@Param("jobid")Integer jobid);
	
	@Query(applicationByProfileid)
	public List<Jobapplication> applicationByProfileid(@Param("profileid")Integer profileid);
	

}

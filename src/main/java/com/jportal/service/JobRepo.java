package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Job;
import com.jportal.model.Jobapplication;


public interface JobRepo  extends PagingAndSortingRepository<Job,Integer>, Serializable{
	public final static String jobsByCompanyID = "select jobs from Job jobs where jobs.company.companyid = :companyid";
	
	
	@Query(jobsByCompanyID)
	public List<Job> jobsByCompanyID(@Param("companyid")Integer companyid);

	@Query("select jobs from Job jobs where jobs.company.city = :city and jobs.jobTitle like CONCAT('%',:jobtitle,'%') ")
	public List<Job> jobsByCity_title(@Param("city")String city,@Param("jobtitle")String jobtitle);

	@Query("select jobs from Job jobs where jobs.jobTitle like CONCAT('%',:jobtitle,'%') ")
	public List<Job> jobsBytitle(@Param("jobtitle")String jobtitle);

	@Query("select jobs from Job jobs where jobs.company.city like CONCAT('%',:city,'%')")
	public List<Job> jobsByCity(@Param("city")String city);

	@Query("select jobs from Job jobs where jobs.company.zipcode = :zip")
	public List<Job> jobsByzip(@Param("zip")String zip);
	

}

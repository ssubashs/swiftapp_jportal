package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Company;


public interface CompanyRepo  extends PagingAndSortingRepository<Company,Integer>, Serializable{
	
	@Query("select companies from Company companies where companies.companyName like CONCAT('%',:companyName,'%') ")
	public List<Company> companyByName(@Param("companyName")String companyName);

	@Query("select companies from Company companies where companies.zipcode = :zip")
	public List<Company> companyByZip(@Param("zip")String zip);

}

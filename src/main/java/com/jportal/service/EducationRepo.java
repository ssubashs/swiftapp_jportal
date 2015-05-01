package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jportal.model.Education;


public interface EducationRepo  extends PagingAndSortingRepository<Education,Integer>, Serializable{
	

}

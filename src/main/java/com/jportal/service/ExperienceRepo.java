package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jportal.model.Experience;


public interface ExperienceRepo  extends PagingAndSortingRepository<Experience,Integer>, Serializable{
	

}

package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jportal.model.Technology;


public interface TechnologyRepo  extends PagingAndSortingRepository<Technology,Integer>, Serializable{
	

}

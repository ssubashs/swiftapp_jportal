package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jportal.model.Profile;


public interface ProfileRepo  extends PagingAndSortingRepository<Profile,Integer>, Serializable{
	

}

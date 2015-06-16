package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Technology;


public interface TechnologyRepo  extends PagingAndSortingRepository<Technology,Integer>, Serializable{
public final static String techsByProfileid = "select techs from Technology techs where techs.profile.profileid = :profileid";
	
	@Query(techsByProfileid)
	public List<Technology> techsByProfileid(@Param("profileid")Integer profileid);

}

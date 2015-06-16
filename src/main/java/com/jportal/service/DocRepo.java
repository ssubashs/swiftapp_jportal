package com.jportal.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Doc;
import com.jportal.model.Profileskill;


public interface DocRepo  extends PagingAndSortingRepository<Doc,Integer>, Serializable{
public final static String docsByProfileid = "select docs from Doc docs where docs.profile.profileid = :profileid";
	
	@Query(docsByProfileid)
	public List<Doc> docsByProfileid(@Param("profileid")Integer profileid);

}

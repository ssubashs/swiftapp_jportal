package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jportal.model.Doc;


public interface DocRepo  extends PagingAndSortingRepository<Doc,Integer>, Serializable{
	

}

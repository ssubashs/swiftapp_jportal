package com.jportal.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jportal.model.Useraccess;
import com.jportal.model.Userrole;

public interface UserroleRepo  extends JpaRepository<Userrole,Integer>, Serializable{

}

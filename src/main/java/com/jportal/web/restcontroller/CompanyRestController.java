package com.jportal.web.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Company;
import com.jportal.service.CompanyRepo;



@Controller
@RequestMapping(value = "/api/company")
public class CompanyRestController 
{
	@Autowired
	private CompanyRepo repository;
	
	
	@RequestMapping(value = "/{companyID}",method = RequestMethod.GET)
	@ResponseBody
	public Company getCompany(@PathVariable Integer companyID) 
	{
		
		Company company = repository.findOne(companyID);
		
		
		return company;
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	@ResponseBody
	public List<Company> companySearch(@RequestParam(value="name", required=false) String companyName,@RequestParam(value="zip", required=false) String zip) 
	{
		if(zip !=null)
		{
			return repository.companyByZip(zip);
		}
		else if(companyName!=null)
		{
			return repository.companyByName(companyName);
		}		
		else
		{
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Company newCompany(@RequestBody Company company) 
	{
		if(company==null)
			return null;
		
		return repository.save(company);
	}
	
	@RequestMapping(value = "/{companyID}",method = RequestMethod.PUT)
	@ResponseBody
	public Company updateCompany(@RequestBody Company company,@PathVariable Integer companyID) 
	{
		if(companyID==null || companyID<1)
			return null;
		company.setCompanyid(companyID);
		return repository.save(company);
	}

}

package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Education;
import com.jportal.service.EducationRepo;



@Controller
@RequestMapping(value = "/api/education")
public class EducationRestController 
{
	@Autowired
	private EducationRepo repository;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Education newEducation(@RequestBody Education Education) 
	{
		return repository.save(Education);
	}
	
	/**
	 * Select an existing Education entity
	 * 
	 */
	@RequestMapping(value = "/{EducationId}", method = RequestMethod.GET)
	@ResponseBody
	public Education loadEducation(@PathVariable Integer EducationId) {
		
		return repository.findOne(EducationId);
	}
		

	/**
	 * Delete an existing Education entity
	 * 
	 */
	@RequestMapping(value = "/{EducationId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEducation(@PathVariable Integer EducationId) {
	
		repository.delete(EducationId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Education> listEducations() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Education entity
		 * 
		 */
		@RequestMapping(method = RequestMethod.PUT)
		@ResponseBody
		public Education saveEducation(@RequestBody Education education) {
			return repository.save(education);
		}
	
	

}

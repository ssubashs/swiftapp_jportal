package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Experience;
import com.jportal.service.ExperienceRepo;



@Controller
@RequestMapping(value = "/api/experience")
public class ExperienceRestController 
{
	@Autowired
	private ExperienceRepo repository;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Experience newprofile(@RequestBody Experience profile) 
	{
		return repository.save(profile);
	}
	
	/**
	 * Select an existing Experience entity
	 * 
	 */
	@RequestMapping(value = "/{experienceId}", method = RequestMethod.GET)
	@ResponseBody
	public Experience loadprofile(@PathVariable Integer experienceId) {
		
		return repository.findOne(experienceId);
	}
		

	/**
	 * Delete an existing Experience entity
	 * 
	 */
	@RequestMapping(value = "/{experienceId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteprofile(@PathVariable Integer experienceId) {
	
		repository.delete(experienceId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Experience> listprofiles() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Experience entity
		 * 
		 */
		@RequestMapping(method = RequestMethod.PUT)
		@ResponseBody
		public Experience saveprofile(@RequestBody Experience experience) {
			return repository.save(experience);
		}
	
	

}

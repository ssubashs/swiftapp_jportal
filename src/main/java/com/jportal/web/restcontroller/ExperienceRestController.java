package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Experience;
import com.jportal.model.Profile;
import com.jportal.service.ExperienceRepo;
import com.jportal.service.ProfileRepo;



@Controller
@RequestMapping(value = "/api/experience")
public class ExperienceRestController 
{
	@Autowired
	private ExperienceRepo repository;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@RequestMapping(value = "/{profileId}",method = RequestMethod.POST)
	@ResponseBody
	public Experience newexperience(@RequestBody Experience experience,@PathVariable Integer profileId) 
	{
		Profile profile = profileRepo.findOne(profileId);
		experience.setProfile(profile);
		return repository.save(experience);
	}
	
	/**
	 * Select an existing Experience entity
	 * 
	 */
	@RequestMapping(value = "/{experienceId}", method = RequestMethod.GET)
	@ResponseBody
	public Experience loadexperience(@PathVariable Integer experienceId) {
		
		return repository.findOne(experienceId);
	}
		

	/**
	 * Delete an existing Experience entity
	 * 
	 */
	@RequestMapping(value = "/{experienceId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteexperience(@PathVariable Integer experienceId) {
	
		repository.delete(experienceId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Experience> listexperiences() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Experience entity
		 * 
		 */
		@RequestMapping(value = "/{profileId}",method = RequestMethod.PUT)
		@ResponseBody
		public Experience saveexperience(@RequestBody Experience experience,@PathVariable Integer profileId) {
			if(profileId == null || profileId<=0 || experience == null || experience.getExpid() <= 0)
				return null;
			else
			{
				Profile profile = profileRepo.findOne(profileId);
				experience.setProfile(profile);
				return repository.save(experience);
			}
			
			
		}
	
	

}

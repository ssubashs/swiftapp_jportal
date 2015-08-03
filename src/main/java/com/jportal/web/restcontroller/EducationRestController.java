package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Education;
import com.jportal.model.Profile;
import com.jportal.service.EducationRepo;
import com.jportal.service.ProfileRepo;



@Controller
@RequestMapping(value = "/api/education")
public class EducationRestController 
{
	@Autowired
	private EducationRepo repository;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@RequestMapping(value = "/{profileId}",method = RequestMethod.POST)
	@ResponseBody
	public Education newEducation(@RequestBody Education education,@PathVariable Integer profileId) 
	{
		
		Profile profile = profileRepo.findOne(profileId);
		education.setProfile(profile);
		
		return repository.save(education);
	}
	
	/**
	 * Select an existing Education entity
	 * 
	 */
	@RequestMapping(value = "/{educationId}", method = RequestMethod.GET)
	@ResponseBody
	public Education loadEducation(@PathVariable Integer educationId) {
		
		return repository.findOne(educationId);
	}
		

	/**
	 * Delete an existing Education entity
	 * 
	 */
	@RequestMapping(value = "/{educationId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEducation(@PathVariable Integer educationId) {
	
		repository.delete(educationId);
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
		@RequestMapping(value = "/{profileId}",method = RequestMethod.PUT)
		@ResponseBody
		public Education saveEducation(@RequestBody Education education,@PathVariable Integer profileId) {
			if(profileId == null || profileId<=0 || education == null || education.getEid() <=0)
				return null;
			else
			{
				Profile profile = profileRepo.findOne(profileId);
				education.setProfile(profile);
				return repository.save(education);
			}
			
		}
	
	

}

package com.jportal.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Jobapplication;
import com.jportal.model.Profile;
import com.jportal.model.Profileskill;
import com.jportal.service.JobApplicationRepo;
import com.jportal.service.ProfileRepo;
import com.jportal.service.ProfileSkillRepo;



@Controller
@RequestMapping(value = "/api/profile")
public class ProfileRestController 
{
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private ProfileSkillRepo profileSkillRepo;
	
	@Autowired
	private JobApplicationRepo jobapplicationRepo;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Profile newprofile(@RequestBody Profile profile) 
	{
		return profileRepo.save(profile);
	}
	
	/**
	 * Select an existing Profile entity
	 * 
	 */
	@RequestMapping(value = "/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public Profile loadprofile(@PathVariable Integer profileId) {
		
		return profileRepo.findOne(profileId);
	}
	
	/**
	 * Select an existing Profile entity
	 * 
	 */
	@RequestMapping(value = "/skills/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Profileskill> loadprofileskills(@PathVariable Integer profileId) {
		
		return profileSkillRepo.skillByProfileid(profileId);
	}
	
	/**
	 * Select an existing Profile entity
	 * 
	 */
	@RequestMapping(value = "/jobsapplied/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Jobapplication> loadappliedJobs(@PathVariable Integer profileId) {
		
		return jobapplicationRepo.applicationByProfileid(profileId);
	}
		

	/**
	 * Delete an existing Profile entity
	 * 
	 */
	@RequestMapping(value = "/{profileId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteprofile(@PathVariable Integer profileId) {
	
		profileRepo.delete(profileId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Profile> listprofiles() {
	    return profileRepo.findAll();
	  }
	 
	 /**
		 * Save an existing Profile entity
		 * 
		 */
		@RequestMapping(method = RequestMethod.PUT)
		@ResponseBody
		public Profile saveprofile(@RequestBody Profile profile) {
			return profileRepo.save(profile);
		}
	
	

}

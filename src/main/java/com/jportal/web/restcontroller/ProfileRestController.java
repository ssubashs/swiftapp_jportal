package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Profile;
import com.jportal.service.ProfileRepo;



@Controller
@RequestMapping(value = "/api/profile")
public class ProfileRestController 
{
	@Autowired
	private ProfileRepo profileRepo;
	
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

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
import com.jportal.model.Technology;
import com.jportal.service.ProfileRepo;
import com.jportal.service.TechnologyRepo;



@Controller
@RequestMapping(value = "/api/technology")
public class TechnologyRestController 
{
	@Autowired
	private TechnologyRepo repository;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@RequestMapping(value = "/{profileId}",method = RequestMethod.POST)
	@ResponseBody
	public Technology newtechnology(@RequestBody Technology technology,@PathVariable Integer profileId) 
	{
		Profile profile = profileRepo.findOne(profileId);
		technology.setProfile(profile);
		return repository.save(technology);
	}
	
	/**
	 * Select an existing Technology entity
	 * 
	 */
	@RequestMapping(value = "/{technologyId}", method = RequestMethod.GET)
	@ResponseBody
	public Technology loadtechnology(@PathVariable Integer technologyId) {
		
		return repository.findOne(technologyId);
	}
		

	/**
	 * Delete an existing Technology entity
	 * 
	 */
	@RequestMapping(value = "/{technologyId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletetechnology(@PathVariable Integer technologyId) {
	
		repository.delete(technologyId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Technology> listtechnologys() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Technology entity
		 * 
		 */
		
		@RequestMapping(value = "/{profileId}",method = RequestMethod.PUT)
		@ResponseBody
		public Technology savetechnology(@RequestBody Technology technology,@PathVariable Integer profileId) {
			if(profileId == null || profileId<=0 || technology == null || technology.getTid() <=0)
				return null;
			else
			{
				Profile profile = profileRepo.findOne(profileId);
				technology.setProfile(profile);
				return repository.save(technology);
			}
			
			
		}
	

}

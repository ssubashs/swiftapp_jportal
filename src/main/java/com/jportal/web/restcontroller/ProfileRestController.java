package com.jportal.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Doc;
import com.jportal.model.Education;
import com.jportal.model.Experience;
import com.jportal.model.Jobapplication;
import com.jportal.model.Profile;
import com.jportal.model.Profileskill;
import com.jportal.model.Technology;
import com.jportal.service.DocRepo;
import com.jportal.service.EducationRepo;
import com.jportal.service.ExperienceRepo;
import com.jportal.service.JobApplicationRepo;
import com.jportal.service.ProfileRepo;
import com.jportal.service.ProfileSkillRepo;
import com.jportal.service.TechnologyRepo;



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
	
	@Autowired
	private DocRepo docRepo;
	
	@Autowired
	private EducationRepo eduRepo;
	
	@Autowired
	private ExperienceRepo expRepo;
	
	@Autowired
	private TechnologyRepo techRepo;
	
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
	@RequestMapping(value = "/skills/{profileId}", method = RequestMethod.POST)
	@ResponseBody
	public Profileskill saveprofileskill(@PathVariable Integer profileId,@RequestBody Profileskill skill ) {
		if(skill == null || profileId == null || profileId <= 0)
		{
			return null;
		}
		return profileSkillRepo.save(skill);
	}
	
	/**
	 * Select an existing Profile entity
	 * 
	 */
	@RequestMapping(value = "/skills/{profileId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delprofileskill(@PathVariable Integer profileId,@RequestBody Profileskill skill ) {
		if(skill == null || profileId == null || profileId <= 0)
		{
			return "Error data to delete";
		}
		profileSkillRepo.delete(skill);
		return "Successfully Deleted skill ";
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
	
	@RequestMapping(value = "/docs/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Doc> loadprofileDocs(@PathVariable Integer profileId) {
		
		return docRepo.docsByProfileid(profileId);
	}
	
	@RequestMapping(value = "/education/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Education> loadprofileEducation(@PathVariable Integer profileId) {
		
		return eduRepo.eduByProfileid(profileId);
	}
	
	@RequestMapping(value = "/experience/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Experience> loadprofileExperience(@PathVariable Integer profileId) {
		
		return expRepo.expByProfileid(profileId);
	}
	
	@RequestMapping(value = "/technology/{profileId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Technology> loadprofileTechnology(@PathVariable Integer profileId) {
		
		return techRepo.techsByProfileid(profileId);
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

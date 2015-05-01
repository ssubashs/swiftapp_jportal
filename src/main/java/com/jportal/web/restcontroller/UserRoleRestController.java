package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Userrole;
import com.jportal.service.UserroleRepo;



@Controller
@RequestMapping(value = "/api/roles")
public class UserRoleRestController 
{
	@Autowired
	private UserroleRepo repository;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Userrole newrole(@RequestBody Userrole role) 
	{
		return repository.save(role);
	}
	
	/**
	 * Select an existing Userrole entity
	 * 
	 */
	@RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public Userrole loadrole(@PathVariable Integer roleId) {
		
		return repository.findOne(roleId);
	}
		

	/**
	 * Delete an existing Userrole entity
	 * 
	 */
	@RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleterole(@PathVariable Integer roleId) {
	
		repository.delete(roleId);
	}


	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Userrole> listroles() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Userrole entity
		 * 
		 */
		@RequestMapping(method = RequestMethod.PUT)
		@ResponseBody
		public Userrole saverole(@RequestBody Userrole role) {
			return repository.save(role);
		}
	
	

}

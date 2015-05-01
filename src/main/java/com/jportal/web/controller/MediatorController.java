package com.jportal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jportal.model.Useraccess;
import com.jportal.service.UserContext;


@Controller
public class MediatorController {
	
	@Autowired
	private UserContext usercontext;

	
	@RequestMapping(value = "/dashboard")
	public String dashboardRequest(Model model)
	{

		Useraccess user =usercontext.getCurrentUser();
		if(user==null)
			throw new SecurityException("principle user null");
		model.addAttribute("user",user.getProfile());
		model.addAttribute("appname","testApp");
		System.out.println("dashboard mediator controller ");
		return "appTest";
	}
	
	
	@RequestMapping(value = "/")
	public String defaultRequest(Model model)
	{
		System.out.println("default mediator controller ");
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/denied")
	public String accessDenied(Model model)
	{
		System.out.println("Access denied controller ");
		return "accessDenied";
	}
	
	@RequestMapping(value = "/buildstatus")
	public String buildStatus(Model model)
	{
		System.out.println("default mediator controller ");
		return "buildsuccess";
	}


}

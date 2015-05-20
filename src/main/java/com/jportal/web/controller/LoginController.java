package com.jportal.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jportal.model.Profile;
import com.jportal.model.SignupForm;
import com.jportal.model.Useraccess;
import com.jportal.model.Userrole;
import com.jportal.service.ProfileRepo;
import com.jportal.service.UserContext;
import com.jportal.service.UseraccessRepo;
import com.jportal.service.UserroleRepo;

@Controller
public class LoginController 
{
	@Autowired
	private ProfileRepo profilerepo;
	
	@Autowired
	private UseraccessRepo useraccessrepo;
	
	@Autowired
	private UserroleRepo rolerepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserContext usercontext;
	
	@RequestMapping(value= "/applogin", headers={"X-Requested-With!=XMLHttpRequest", "Accept=text/html"})
	public String renderLoginView(Model model,HttpServletRequest request,HttpServletResponse response, @RequestParam(value="redirect",required=false) String redirect)
	{
		model.addAttribute("appName", "Profile Management");
		model.addAttribute("redirect",redirect);		
		return "login";
	}
	
	@RequestMapping(value="/applogin/process")
	public String postLogin(Model model)
	{
//		Hperson user =usercontext.getCurrentUser();
//		if(user==null)
//			throw new SecurityException("principle user null");
//		
//		model.addAttribute("user",user);
		return "redirect:/dashboard";
	}
	
	 @RequestMapping("/applogin/signup")
	    public String signup(@ModelAttribute SignupForm signupForm,Model model) {
			model.addAttribute("appName", "Profile Management");			
			model.addAttribute("target","signup");
			 model.addAttribute("userData",signupForm);
			return "signup";
	    }
	
//	@RequestMapping(value="/applogin/registration")
//	public String postRegistration(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes,Model model)
//	{
//		 if(result.hasErrors()) {		
//			 
//			 model.addAttribute("message", "error");	
//			 model.addAttribute("userData",signupForm);
//			 model.addAttribute("errorMessage","Correct the errors !!!");
//	            return "signup";
//	        }
//
//	        String username = signupForm.getUsername();
//	        if(username !=null && repository.findLoggedUser(username) != null) {	        	
//	            result.rejectValue("username", "errors.signup.username", "username is already in use.");
//	            model.addAttribute("appName", "Profile Management");
//	            model.addAttribute("message", "error");
//	            model.addAttribute("userData",signupForm);
//	            model.addAttribute("errorMessage","username is already present !!!");
//	            return "signup";
//	        }
//	        else if(username == null)
//	        {
//	        	 model.addAttribute("message", "error");				 
//				 model.addAttribute("errorMessage","Server error, Try later");
//		         return "signup";
//	        }
//	        
//	        Hperson user = new Hperson();
//	        user.setFirstname(signupForm.getFirstName());
//	        user.setLastname(signupForm.getLastName());
//	        user.setUsername(signupForm.getUsername());
//	        user.setPassword(signupForm.getPassword());
//	        user.addHuserrole(new Huserrole("ROLE_USER","Active"));
//	        repository.save(user);
//	        usercontext.setCurrentUser(user);
//
//	        redirectAttributes.addFlashAttribute("message", "You have successfully signed up and logged in.");
//	        return "redirect:/dashboard";
//		}
	
	@RequestMapping(value="/applogin/registration")
	public String postRegistration(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes,Model model)
	{
		 if(result.hasErrors()) {		
			 
			 model.addAttribute("message", "error");	
			 model.addAttribute("userData",signupForm);
			 model.addAttribute("errorMessage","Correct the errors !!!");
	            return "signup";
	        }

	        String username = signupForm.getUsername();
	        if(username !=null && useraccessrepo.loginUser(username) != null) {	        	
	            result.rejectValue("username", "errors.signup.username", "username is already in use.");
	            model.addAttribute("appName", "Profile Management");
	            model.addAttribute("message", "error");
	            model.addAttribute("userData",signupForm);
	            model.addAttribute("errorMessage","username is already present !!!");
	            return "signup";
	        }
	        else if(username == null)
	        {
	        	 model.addAttribute("message", "error");				 
				 model.addAttribute("errorMessage","Server error, Try later");
		         return "signup";
	        }
	        
	        Profile user = new Profile();
	        user.setFirstname(signupForm.getFirstName());
	        user.setLastname(signupForm.getLastName());
	        user.setUsername(signupForm.getUsername());
	       
	        //user.setUseraccess(useraccess);
	        user = profilerepo.save(user);
	        Userrole userrole = new Userrole("ROLE_USER","Active",user);
		       user.addUserrole(userrole);
	        
			
			
		    Useraccess useraccess = new Useraccess(signupForm.getUsername(),passwordEncoder.encode(signupForm.getPassword()),user); 
	        useraccess = useraccessrepo.save(useraccess);
	        userrole = rolerepo.save(userrole);
	      
	        System.out.println("user inserted is  "+ user.toString());	            
	               
	        //user = repository.save(user);
	        useraccess = useraccessrepo.findOne(user.getProfileid());
	        usercontext.setCurrentUser(useraccess);
	        redirectAttributes.addFlashAttribute("message", "You have successfully signed up and logged in.");
	        return "redirect:/dashboard";
		}


}

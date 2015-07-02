package com.jportal.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Company;
import com.jportal.model.Job;
import com.jportal.model.Jobapplication;
import com.jportal.model.Jobskill;
import com.jportal.service.CompanyRepo;
import com.jportal.service.JobApplicationRepo;
import com.jportal.service.JobRepo;
import com.jportal.service.JobSkillRepo;



@Controller
@RequestMapping(value = "/api/job")
public class JobRestController 
{
	@Autowired
	private JobRepo jobrepo;
	
	@Autowired
	private JobSkillRepo jobskillrepo;
	
	@Autowired
	private JobApplicationRepo jobapplicationrepo;
	
	@Autowired
	private CompanyRepo companyrepo;
	
	
	@RequestMapping(value = "/{jobid}",method = RequestMethod.GET)
	@ResponseBody
	public Job getJobDetails(@PathVariable Integer jobid) 
	{
		
		Job job = jobrepo.findOne(jobid);
		return job;
	}
	
	@RequestMapping(value = "/skills/{jobid}",method = RequestMethod.GET)
	@ResponseBody
	public List<Jobskill> getJobSkills(@PathVariable Integer jobid) 
	{		
		List<Jobskill> skills = jobskillrepo.skillByJobid(jobid);
		return skills;
	}
	
	@RequestMapping(value = "/appliedById/{jobid}",method = RequestMethod.GET)
	@ResponseBody
	public List<Jobapplication> getAppliedJobById(@PathVariable Integer jobid) 
	{		
		List<Jobapplication> jobsapplied = jobapplicationrepo.applicationByJobid(jobid);
		return jobsapplied;
	}
	
	@RequestMapping(value = "/appliedByProfile/{profileid}",method = RequestMethod.GET)
	@ResponseBody
	public List<Jobapplication> getAppliedJobByProfile(@PathVariable Integer profileid) 
	{		
		List<Jobapplication> jobsapplied = jobapplicationrepo.applicationByProfileid(profileid);
		return jobsapplied;
	}
	
	@RequestMapping(value = "/byCompany/{companyid}",method = RequestMethod.GET)
	@ResponseBody
	public List<Job> getJobsByProfile(@PathVariable Integer companyid) 
	{		
		List<Job> jobs = jobrepo.jobsByCompanyID(companyid);
		return jobs;
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	@ResponseBody
	public List<Job> getJobsSearch(@RequestParam(value="zip", required=false) String zip,@RequestParam(value="city", required=false) String city,@RequestParam(value="jobtitle", required=false) String jobtitle,@RequestParam(value="employmentType", required=false) String employmentType) 
	{
		if(jobtitle!=null && city!=null)
			return jobrepo.jobsByCity_title(city,jobtitle);
		else if(jobtitle!=null)
			return jobrepo.jobsBytitle(jobtitle);
		else if(city!=null)
			return jobrepo.jobsByCity(city);
		else if(zip !=null)
			return jobrepo.jobsByzip(zip);
		else if(employmentType !=null)
			return jobrepo.jobsByemploymentType(employmentType);
		else
		return null;
	}
	
	@RequestMapping(value = "/for/{companyid}",method = RequestMethod.POST)
	@ResponseBody
	public Job newJob(@RequestBody Job job,@PathVariable Integer companyid) 
	{
		if(companyid==null)
			return null;
		else
		{
			Company company = companyrepo.findOne(companyid);
			if(company == null)
				return null;
			else if(job!=null)
			{
				job.setCompany(company);
				return jobrepo.save(job);
			}
			return null;	
		}		
		
	}
	
	@RequestMapping(value = "/byid/{jobid}",method = RequestMethod.PUT)
	@ResponseBody
	public Job saveJob(@RequestBody Job job,@PathVariable Integer jobid) 
	{
		if(jobid==null)
			return null;
		else
		{
			Job oldJob = jobrepo.findOne(jobid);
			if(oldJob == null)
				return null;
			else if(oldJob.getCompany()!=null)
			{
				job.setCompany(oldJob.getCompany());
				return jobrepo.save(job);
			}
			return null;	
		}		
		
	}
	
	
	
}

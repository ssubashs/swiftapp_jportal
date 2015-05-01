package com.jportal.web.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jportal.model.Doc;
import com.jportal.service.DocRepo;



@Controller
@RequestMapping(value = "/api/doc")
public class DocRestController 
{
	@Autowired
	private DocRepo repository;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Doc newDoc(@RequestBody Doc data) 
	{
		return repository.save(data);
	}
	
	/**
	 * Select an existing Doc entity
	 * 
	 */
	@RequestMapping(value = "/{DocId}", method = RequestMethod.GET)
	@ResponseBody
	public Doc loadDoc(@PathVariable Integer DocId) {
		
		return repository.findOne(DocId);
	}
		

	/**
	 * Delete an existing Doc entity
	 * 
	 */
	@RequestMapping(value = "/{DocId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteDoc(@PathVariable Integer DocId) {
	
		repository.delete(DocId);
	}

	
	 @RequestMapping(method = RequestMethod.GET)
	 @ResponseBody
	  public Iterable<Doc> listDocs() {
	    return repository.findAll();
	  }
	 
	 /**
		 * Save an existing Doc entity
		 * 
		 */
		@RequestMapping(method = RequestMethod.PUT)
		@ResponseBody
		public Doc saveDoc(@RequestBody Doc doc) {
			return repository.save(doc);
		}
	
	

}

package com.jportal.web.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jportal.model.Doc;
import com.jportal.service.DocRepo;
import com.jportal.service.ProfileRepo;



@Controller
@RequestMapping(value = "/api/doc")
public class DocRestController 
{
	@Autowired
	private DocRepo repository;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@RequestMapping(value = "/{profileId}",method = RequestMethod.POST)
	@ResponseBody
	public Doc newDoc(@PathVariable Integer profileId, @RequestParam("file") MultipartFile file, @RequestParam("description") String desc, @RequestParam("filetype") String doctype ) 
	{
		if(file!=null && !file.isEmpty())
		{
			Doc newfile = new Doc();
			try {
				
				newfile.setContent(file.getBytes());				
				newfile.setProfile(profileRepo.findOne(profileId));
				newfile.setDocname(file.getOriginalFilename());
				newfile.setDoctype(doctype);
				newfile.setDocsize(file.getSize());
				newfile.setDescription(desc);
				return repository.save(newfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
		else return null;
	}
	
	/**
	 * Select an existing Doc entity
	 * 
	 */
	@RequestMapping(value = "/info/{DocId}", method = RequestMethod.GET)
	@ResponseBody
	public Doc loadDoc(@PathVariable Integer DocId) {
		
		return repository.findOne(DocId);
	}
	
	/**
	 * Select an existing Doc entity
	 * 
	 */
	@RequestMapping(value = "/download/{DocId}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<byte[]> downloadDoc(@PathVariable Integer DocId) {
		Doc doc = repository.findOne(DocId);
		  byte[] documentBody = doc.getContent() ;

		    HttpHeaders header = new HttpHeaders();
		    if(doc.getDocname().contains(".pdf"))
		    	header.setContentType(new MediaType("application", "pdf"));
		    else if(doc.getDocname().contains(".jpeg"))
		    	header.setContentType(new MediaType("image", "jpeg"));
		    else if(doc.getDocname().contains(".gif"))
		    	header.setContentType(new MediaType("image", "gif"));
		    else if(doc.getDocname().contains(".png"))
		    	header.setContentType(new MediaType("image", "png"));
		    else if(doc.getDocname().contains(".tiff"))
		    	header.setContentType(new MediaType("image", "tiff"));
		    else if(doc.getDocname().contains(".doc"))		    	
		    	header.setContentType(new MediaType("application", "msword"));
		    else	
		    	header.setContentType(new MediaType("application", "octet-stream"));
		    
		    header.set("Content-Disposition",
		                   "attachment; filename=" + doc.getDocname());
		    header.setContentLength(documentBody.length);

		    return new HttpEntity<byte[]>(documentBody, header);
		
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
	 
	 
	
	

}

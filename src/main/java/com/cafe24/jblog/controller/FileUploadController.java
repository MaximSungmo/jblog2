package com.cafe24.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.service.FileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value= "/{id}/admin/basic", method = RequestMethod.POST)
	public String form(
			@RequestParam("title") String title,
			@RequestParam("logo-file") MultipartFile file,
			Model model) {
		
		String url = fileUploadService.restore(file);
		model.addAttribute("url",url);
		return "/blog/result";
		
	}
}

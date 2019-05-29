package com.cafe24.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Controller
public class AdminController {
	
	@Autowired
	private BlogService blogService;

//	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
//	public String main(
//			@PathVariable("id") String id, 
//			@PathVariable("PathNo2") String pathNo2,
//			Model model) {
//		
//		model.addAttribute("id", id);
//		return "blog/test";
//	}
	
	
	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.GET)
	public String adminBasic(
			@PathVariable("id") String id, 
			Model model) {
		
		model.addAttribute("id", id);
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value = "/{id}/admin/category", method = RequestMethod.GET)
	public String adminCategory(
			@PathVariable("id") String id, 
			Model model) {
		
		model.addAttribute("id", id);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value= "/{id}/admin/category", method= RequestMethod.POST)
	public String addCategory(
			@ModelAttribute CategoryVo categoryVo,
			Model model
			) {
		System.out.println("addCategory Mehod :" + categoryVo);
		blogService.addCategory(categoryVo);
		return "redirect:/blog/blog-admin-category";
	}
	
	
	@RequestMapping(value = "/{id}/admin/write", method = RequestMethod.POST)
	public String adminWrite(
			@PathVariable("id") String id,
			@ModelAttribute PostVo postVo,
			Model model) {
		
		model.addAttribute("id", id);
		return "blog/blog-admin-write";
	}
}

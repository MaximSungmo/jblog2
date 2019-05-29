package com.cafe24.jblog.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = {"/{id}", "/{id}/main" }, method=RequestMethod.GET)
	public String main(@PathVariable("id") String id, 
			Model model) {
		List<CategoryVo> categoryList = blogService.getCategoryList(id);
		List<PostVo> postList = blogService.getPostList(id);
		BlogVo blogvo = blogService.getBlog(id);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("postList", postList);
		model.addAttribute("blogvo", blogvo);
		System.out.println("id : "+id);
		return "blog/blog-main";
	}
	
	@RequestMapping(value = {"/{id:{?!assets).*}/{categoryNo}/{postNo}"})
	public String post(
			@PathVariable("{id}") String id,
			@PathVariable("{categoryNo}") Optional<Long> categoryNo,
			@PathVariable("{postNo}") Optional<Long> postNo,
			Model model){
		System.out.println("id : " + id);
		System.out.println("cate: " + categoryNo);
		System.out.println("postNo : " + postNo);
		return "blog/result";		
	}
	
	

	

}

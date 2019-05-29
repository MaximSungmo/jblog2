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
import com.cafe24.jblog.vo.CategoryVo;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = {"/{id}", "/{id}/main" }, method=RequestMethod.GET)
	public String main(@PathVariable("id") String id, 
			Model model) {
//		List<CategoryVo> categoryList = blogService.getCategoryList(id);
//		List<PostVo> postList = blogService.getCategoryList;
//		List<BlogVo> blogList = blogService.getCategoryList;
//		model.addAttribute("list", list);
//		model.addAttribute("categoryList", categoryList);
//		for(int i =0; i<categoryList.size(); i++) {
//			System.out.println(categoryList.get(i));
//		}
		System.out.println("id : ");
		return "blog/blog-main";
	}

	

}

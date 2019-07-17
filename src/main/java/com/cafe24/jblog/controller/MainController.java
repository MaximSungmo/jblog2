package com.cafe24.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping({"","/main"})
	public String main() {
		return "main/index";
	}	
	
	@RequestMapping("/forGuest")
	public String forGuest() {
		return "forGuest";
	}
	
	@RequestMapping("/forMember")
	public String forMember() {
		return "forMember";
	}
	
	@RequestMapping("/forManager")
	public String forManager() {
		return "forManager";
	}
	
	@RequestMapping("/forAdmin")
	public String forAdmin() {
		return "forAdmin";
	}
}

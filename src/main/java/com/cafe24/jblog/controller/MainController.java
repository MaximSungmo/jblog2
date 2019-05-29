package com.cafe24.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//	/{id:{?!assets).*}
	@RequestMapping({ "/", "/main", "/{bbs}" })
	public String main(@PathVariable("bbs") String bbs, Model model) {
		System.out.println("bbs 테스트 ::::" + bbs);
		return "main/index";
	}

	@RequestMapping(value = "/notice/{bbs}.do")
	 public String noticeCallList( @PathVariable("bbs") String bbs){
		System.out.println("bbs 테스트 ::::"+ bbs);
		return "blog/test";
	}
	
	
}

package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.dao.BlogDAO;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.BlogVo;


@Service
public class BlogService {

	@Autowired
	private BlogDAO blogDAO;
	
	
	public boolean addCategory(CategoryVo categoryVo) {
		return blogDAO.insertCategory(categoryVo);
	}
	
	public List<CategoryVo> getCategoryList(String id){		
		return blogDAO.getCategoryList(id);
	}
	
	public List<PostVo> getPostList(String id){		
		return blogDAO.getPostList(id);
	}
	
	public BlogVo getBlog(String id){		
		return blogDAO.getBlog(id);
	}
}

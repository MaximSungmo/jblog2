package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.dao.BlogDAO;
import com.cafe24.jblog.vo.CategoryVo;

@Service
public class BlogService {

	@Autowired
	private BlogDAO blogDAO;
	
	public boolean addCategory(CategoryVo categoryVo) {
		return blogDAO.insert(categoryVo);
	}
	
	public List<CategoryVo> getCategoryList(String id){		
		return blogDAO.getCategoryList(id);
	}
}

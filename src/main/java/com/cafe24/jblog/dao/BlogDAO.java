package com.cafe24.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BlogDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(CategoryVo categoryVo) {
		int count = sqlSession.insert("blog.insert_cat", categoryVo);
		return count == 1;
	}
	
	public List<CategoryVo> getCategoryList(String id){
		List<CategoryVo> result = sqlSession.selectList("blog.getCategoryList", id);
		return result;
		
	}
	
	
}

package com.cafe24.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Repository
public class BlogDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insertCategory(CategoryVo categoryVo) {
		int count = sqlSession.insert("blog.insertCategory", categoryVo);
		return count == 1;
	}
	
	public List<CategoryVo> getCategoryList(String id){
		List<CategoryVo> result = sqlSession.selectList("blog.getCategoryList", id);
		return result;
		
	}
	public List<PostVo> getPostList(String id){
		List<PostVo> result = sqlSession.selectList("blog.getPostList", id);
		return result;
	}
	public BlogVo getBlog(String id){
		BlogVo result = sqlSession.selectOne("blog.getBlog", id);
		return result;
	}
	
	
}

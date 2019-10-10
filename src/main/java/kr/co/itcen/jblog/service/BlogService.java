package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;
import kr.co.itcen.jblog.vo.CategoryVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	// main Page에서 카테고리 목록이 보이도록 하는 기능
	public List<CategoryVo> categoryMain(String userId){
		List<CategoryVo> list = blogDao.categoryMain(userId); 
		return list;
	}
	
	// 카테고리 설정에서 카테고리 리스트를 보이도록 하는 기능
	public List<CategoryVo> categoryList(String userId){
		List<CategoryVo> list = blogDao.categoryList(userId);
		return list;
	}
	
	

}

package kr.co.itcen.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.CategoryVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> categoryMain(String userId){
		List<CategoryVo> list = sqlSession.selectList("blog.categorymain", userId);
		return list;
	}
	
	public List<CategoryVo> categoryList(String userId){
		List<CategoryVo> list = sqlSession.selectList("blog.categoryList", userId);
		return list;
	}
	

}
package kr.co.itcen.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// User 생성시 기본값 설정해주는 기능  
	public boolean defaultBlog(String id) {
		Boolean result = false;
		if(id != null) {
			sqlSession.insert("blog.defaultBlog", id);
			result = true;
		}
		return result;
	}
	
	

}

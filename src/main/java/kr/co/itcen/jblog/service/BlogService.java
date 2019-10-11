package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.BlogDao;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

	// User 생성시 기본값을 설정해주는 기능
	public boolean defaultBlog(String id) {
		Boolean result = false;
		if (id != null) {
			blogDao.defaultBlog(id);
			result = true;
		}
		return result;
	}

}

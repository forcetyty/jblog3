package kr.co.itcen.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public Boolean existUser(String id) {
		return userDao.get(id) != null;
	}

}

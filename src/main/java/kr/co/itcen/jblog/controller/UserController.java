package kr.co.itcen.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//회원가입을 위한 처리
	@RequestMapping("/join")
	public String join() {
		
		return "/user/join";
	}
	
	

}

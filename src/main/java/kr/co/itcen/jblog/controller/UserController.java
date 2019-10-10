package kr.co.itcen.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.itcen.jblog.service.UserService;
import kr.co.itcen.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입을 위한 처리
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {

		return "user/join";
	}

	// 회원가입 폼
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {

		// result 에러 확인
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel()); // result.getModel()이 Map을 리턴해주어, 키/값을 자동으로 셋팅해준다.
			return "user/join"; // Error가 있다면 join으로 리턴
		}
		userService.insertUser(userVo);
		return "user/joinsuccess";
	}

	// login 화면으로 이동하게 하는 기능
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "result", required = false) String result, Model model) {
		model.addAttribute("result", result);

		return "user/login";
	}
	
	// login 처리를 하는 기능 
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public void auth() {
		System.out.println("auth & login");
	}
	
	// logout
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		System.out.println("logout");
	}
	
	

}

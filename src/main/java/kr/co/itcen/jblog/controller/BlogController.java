package kr.co.itcen.jblog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import kr.co.itcen.jblog.security.AuthUser;
import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.vo.CategoryVo;
import kr.co.itcen.jblog.vo.UserVo;

@Controller
@RequestMapping("/{userId:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = {"", "/{pathNo1}", "/{pathNo1}/{pathNo2}" })
	public String blogMain(@PathVariable(value = "userId") String userId, 
	@PathVariable(value = "pathNo1") Optional<Long> pathNo1,
	@PathVariable(value = "pathNo2") Optional<Long> pathNo2,
	Model model) {
		
		System.out.println("블로그 메인 화면");
		
		List<CategoryVo> list = blogService.categoryMain(userId);
		
		model.addAttribute("list", list);
		
		return "blog/blog-main";
	}
	
	@RequestMapping(value = "/blog-admin-basic")
	public String blogBasic() {
		System.out.println("블로그 관리 화면");
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value = "/blog-admin-category", method = RequestMethod.GET )
	public String blogCategory(@AuthUser UserVo authUser, Model model) {
		
		System.out.println("auth :" + authUser.getId());
		
		List<CategoryVo> list = blogService.categoryList(authUser.getId());
		model.addAttribute("categoryList", list);
		
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value = "/blog-admin-write")
	public String blogWrite() {
		return "blog/blog-admin-write";
	}

}

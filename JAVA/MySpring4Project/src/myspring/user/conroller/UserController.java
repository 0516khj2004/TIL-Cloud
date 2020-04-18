package myspring.user.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//사용자 목록 조회 
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();
		return new ModelAndView("userList.jsp", "userList", userList); // = request.setAttribute("userList", users);
	
	}
	//사용자 상제정보 조회
	@RequestMapping("/userDetail.do")
	public String userDetail(@RequestParam String userid, Model model ) { // @RequestParam = request.getParameter("id")
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail.jsp";
	}
}

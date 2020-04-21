package myspring.user.conroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return new ModelAndView("userList", "userList", userList); // = request.setAttribute("userList", users);
	
	}
	//사용자 상제정보 조회
	@RequestMapping("/userDetail.do")
	//@RequestParam => request.getParameter()
	//QueryString ? key1=value&key2=value2
	public String userDetail(@RequestParam String userid, Model model ) { // @RequestParam = request.getParameter("id")
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail";
	}
	//사용자 등록 Form 조회 
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		//session에 genderList저장 
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		cityList.add("인천");
		//session에 cityList저장
		session.setAttribute("cityList", cityList);

		return "userInsert";
	}
	//사용자 등록 처리 
	@RequestMapping(value = "/userInsert.do", method = RequestMethod.POST)
	public String usertInsert(@ModelAttribute UserVO user) {
		System.out.println(">> UserVo" + user);
		userService.insertUser(user);
		
		//사용자 목록조회를 처리하는 요청으로 포워딩  하겠다
		return "redirect:/userList.do";
	}
	
	//사용자 삭제처리 -> userDelete.do/gildog(userid) url / base으로 append하는 방식  @PathVariable
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		return "redirect:/userList.do";
	
	}

	//사용자 updateform
	   @RequestMapping("/updateUserForm.do")
	   public String updateUserForm(HttpSession session, @RequestParam String id) {
	      UserVO user = userService.getUser(id);

	      List<String> genderList = new ArrayList<String>();
	      genderList.add("남");
	      genderList.add("여");
	      //session객체 genderList 객체를 저장
	      session.setAttribute("genderList", genderList);

	      List<String> cityList = new ArrayList<String>();
	      cityList.add("서울");
	      cityList.add("경기");
	      cityList.add("부산");
	      cityList.add("대구");
	      cityList.add("인천");
	      //session객체에 cityList 객체를 저장
	      session.setAttribute("cityList", cityList);
	      session.setAttribute("user", user);
	      return "userUpdate";
	   }

	   //사용자 update처리
	   @RequestMapping("/userUpdate.do")
	   public String userUpdate(@ModelAttribute UserVO user) {
	      userService.updateUser(user);
	      return "redirect:/userList.do";
	   }
}

package myspring.user.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@RestController
//controller + responseBody

public class RestUserController {
	@Autowired
	UserService userService;
	
	//json형태
	//사용자 목록 
	@GetMapping("/users")
	public List<UserVO> userList(){
		return userService.getUserList();
	}
	
	//사용자 상세 조회
	@GetMapping("/users/{id}")
	public UserVO userDetail(@PathVariable("id") String userid) { // @PathVariable String id {id}와 변수이름을 맞추면 variable안써도 된다
		
		return userService.getUser(userid);
	}
	//사용자 등록 
	@PostMapping("/users")
	public Boolean userInsert(@RequestBody UserVO user) {
		if(user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	//사용자 수정 
	@PutMapping("/users")
	public Boolean userUpdate(@RequestBody UserVO user) {
		if(user != null) {
			userService.updateUser(user);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	//사용자 삭제
	@DeleteMapping("/users/{id}")
	public Boolean userDBoolean(@PathVariable String id) {
		if(id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;
		}
	}
	
	//xml형태
	//사용자 목록
	@GetMapping("/usersxml")
	public UserVOXML userListXml() {
		List<UserVO> userList = userService.getUserList();
		return new UserVOXML("success", userList);	
	}
}

package com.koo9.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koo9.myspringboot.entity.User;
import com.koo9.myspringboot.exception.CustomException;
import com.koo9.myspringboot.exception.ResourceNotFoundException;
import com.koo9.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	//예외처리 
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView("error/generic_error", "errMsg", ex.getMessage());
		
	}
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomerExceprion(CustomException ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());
		return model;
	}
	// add user
	@GetMapping("/signup")
	public String showSignupForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}
		userRepository.save(user);

		return "redirect:index";
	}

	// update user
	@GetMapping("/edit/{id}")
	public ModelAndView showUpdateForm(@PathVariable long id) {
		// supplier : T get()
//		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		User user = userRepository.findById(id).orElseThrow(() -> new CustomException("E001", String.format("요청하신 id %s 가 존재하지 않습니다.", id)));
		return new ModelAndView("update-user", "user", user);
	}

	@PostMapping("/edituser/{id}")
	public String updateUser(@PathVariable long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}
		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	// delete user
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		User user = userRepository.findById(id).orElseThrow(() -> new CustomException("E001", String.format("요청하신 id %s 가 존재하지 않습니다.", id)));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
	
	// list user
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/leaf")
	public ModelAndView leaf() {
		return new ModelAndView("leaf", "name", "웰컴 타임리프 ");
	}
}

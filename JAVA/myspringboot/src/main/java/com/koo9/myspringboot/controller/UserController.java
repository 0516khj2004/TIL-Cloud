package com.koo9.myspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koo9.myspringboot.entity.User;
import com.koo9.myspringboot.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

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
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

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

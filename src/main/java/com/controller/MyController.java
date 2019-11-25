package com.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.dao.LoginValidator;

@Controller
public class MyController {

	@RequestMapping("/")
	public ModelAndView getWelcomePage() {
		ModelAndView mView = new ModelAndView("login");
		return mView;
	}

	@RequestMapping("/validateLogin")
	public ModelAndView validateUserLogin(@RequestParam("inputEmail") String email,
			@RequestParam("inputPassword") String password) {
		boolean isValid = new LoginValidator().validateCredentials(email, password);
		ModelAndView mv = null;
		if (isValid)
			mv = new ModelAndView("login");
		else
			mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("register.html")
	public String hrefResolver() {
		return "register";
	}
}

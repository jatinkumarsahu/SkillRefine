package com.jks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jks.model.dto.AppUser;
import com.jks.service.AppUserServiceImpl;

@RestController
public class MyController {
	@Autowired
	AppUserServiceImpl appUserSericeImpl;

	@RequestMapping("/")
	public ModelAndView getWelcomePage() {
		ModelAndView mView = new ModelAndView("login");
		appUserSericeImpl.saveOrUpdate(new AppUser("Jatin", "Sahu", "j@j.com", "1234"));
		return mView;
	}

	@RequestMapping("/validateLogin")
	public ModelAndView validateUserLogin(@RequestParam("inputEmail") String email,
			@RequestParam("inputPassword") String password, HttpServletRequest request) {
		boolean isValid = appUserSericeImpl.validateLogin(email, password);
		ModelAndView mv = new ModelAndView("login");
		request.getSession().setAttribute("userEmail", email);
		if (isValid)
			mv = new ModelAndView("blank");
		else
			mv = new ModelAndView("login");

		return mv;
	}

	@RequestMapping("/signUp")
	public ModelAndView registerUser(@ModelAttribute("appUser") AppUser appUser) {
		appUserSericeImpl.createUser(appUser);
		return new ModelAndView("login");
	}

	@GetMapping("register.html")
	public ModelAndView hrefResolver() {
		return new ModelAndView("register");
	}
}

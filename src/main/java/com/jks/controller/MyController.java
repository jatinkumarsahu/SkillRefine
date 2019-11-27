package com.jks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		return mView;
	}

	@RequestMapping("/validateLogin")
	public ModelAndView validateUserLogin(@RequestParam("inputEmail") String email,
			@RequestParam("inputPassword") String password) {
		//boolean isValid = new LoginValidator().validateCredentials(email, password);
		appUserSericeImpl.saveOrUpdate(new AppUser("Jatin", "Sahu", email, password));
		
		ModelAndView mv = new ModelAndView("login");;
		/*
		 * if (isValid) mv = new ModelAndView("login"); else mv = new
		 * ModelAndView("login");
		 */
		return mv;
	}

	@GetMapping("register.html")
	public ModelAndView hrefResolver() {
		return new ModelAndView("register");
	}
}

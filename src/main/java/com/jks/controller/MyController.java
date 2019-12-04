package com.jks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jks.model.dto.AppUser;
import com.jks.model.dto.SubjectStreams;
import com.jks.model.dto.TestPaper;
import com.jks.service.AppUserService;
import com.jks.service.TestCreaterService;

@RestController
public class MyController {
	@Autowired
	AppUserService<AppUser> appUserSerice;

	@Autowired
	TestCreaterService testCreaterService;

	@RequestMapping("/")
	public ModelAndView getWelcomePage() {
		ModelAndView mView = new ModelAndView("login");
		return mView;
	}

	@ModelAttribute
	public void addCommonObjects(Model model) {
		List<SubjectStreams> subjectStreams = testCreaterService.getAllSubjects();
		model.addAttribute("subjectList", subjectStreams);
	}

	@RequestMapping("/validateLogin")
	public ModelAndView validateUserLogin(@RequestParam("inputEmail") String email,
			@RequestParam("inputPassword") String password, HttpServletRequest request) {
		String isValid = appUserSerice.validateLogin(email, password);
		ModelAndView mv = new ModelAndView("login");
		request.getSession().setAttribute("userEmail", email);
		if (!isValid.equals("Not Found")) {
			mv = new ModelAndView("redirect:userDashBoard");
			request.getSession().setAttribute("userEmail", email);
			request.getSession().setAttribute("userName", isValid);
		} else {
			mv = new ModelAndView("login");
			mv.addObject("errorMessage", "Wrong Id/Password !!!");
		}
		return mv;
	}

	@RequestMapping("/userDashBoard")
	public ModelAndView dashboard(HttpSession session) {
		if (session.getAttribute("userEmail") == null) {
			ModelAndView mView = new ModelAndView("login");
			return mView;
		}

		ModelAndView mView = new ModelAndView("userDashBoard");
		return mView;
	}

	@RequestMapping("/signUp")
	public ModelAndView registerUser(@ModelAttribute("appUser") AppUser appUser) {
		appUserSerice.createUser(appUser);
		return new ModelAndView("login");
	}

	@GetMapping("register.html")
	public ModelAndView hrefResolver() {
		return new ModelAndView("register");
	}

	@RequestMapping("/validateEmail/{email}")
	public boolean getEmailValidation(@PathVariable String email) {
		boolean found = appUserSerice.getUserByEmail(email);
		return found;
	}

	@RequestMapping("/userDashBoard/{subject}")
	public ModelAndView getSubjectTests(@PathVariable("subject") String subject, HttpSession session) {
		System.out.println(subject);
		List<TestPaper> papers = testCreaterService.getAllTestForSubject(subject);
		ModelAndView modelAndView = new ModelAndView("testList");
		modelAndView.addObject("testPaperList", papers);
		modelAndView.addObject("currentSubject", subject);
		// modelAndView.addObject("userName",session.getAttribute("userName"));
		return modelAndView;
	}

	@RequestMapping("/startTest/{testId}")
	public ModelAndView getQuestions(@PathVariable("testId") int testId) {
		ModelAndView mv = new ModelAndView("testPaper");
		try {
			TestPaper tp = testCreaterService.getTestPaperById(testId);
			ObjectMapper mapper = new ObjectMapper();
			mv.addObject("testPaper", mapper.writeValueAsString(tp));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * @RequestMapping("/test/{testId}") public TestPaper
	 * getQuestions111(@PathVariable("testId") int testId) { TestPaper tp =
	 * testCreaterService.getTestPaperById(testId); return tp; }
	 */
}

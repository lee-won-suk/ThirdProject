package com.jin.hobby;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "test")
	public String test(Model model) {
		
		return "test";
	}
	@RequestMapping(value = "/test2")
	public String test2(Model model) {
		return "test2";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("formpath", "main/mainProc");
		//return "home";
		
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model model,
			@RequestParam String formpath) {
		model.addAttribute("formpath", formpath);
		return "index";
	}
	@RequestMapping(value = "/logoutmain")
	public String logoutmain() {
		return "main/logoutmain";
	}
	
	@RequestMapping(value = "/loginmain")
	public String loginmain() {
		return "main/loginmain";
	}
	
	@RequestMapping(value = "/membership")
	public String membership() {
		return "membership/membership";
	}
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	
	
	
	@RequestMapping(value = "/socialmain")
	public String socialmain() {
		return "social/socialmain";
	}
	@RequestMapping(value = "/moimmain")
	public String moimmain() {
		return "social/moimmain";
	}
	@RequestMapping(value = "/CreateSocial")
	public String CreateSocial() {
		return "social/CreateSocial";
	}@RequestMapping(value = "/CreateInnerSocial")
	public String CreateInnerSocial() {
		return "social/CreateInnerSocial";
	}
	
	
	
	
	
	@RequestMapping(value = "/profile")
	public String profile() {
		return "profile/profile";
	}
	
	
	@RequestMapping(value = "/classMain")
	public String classMain() {
		return "class/classMain";
	}
	@RequestMapping(value = "/classDetail")
	public String classDetail() {
		return "class/classDetail";
	}
	@RequestMapping(value = "/classMember")
	public String classMember() {
		return "class/classMember";
	}
	@RequestMapping(value = "/classMemberDetail")
	public String classMemberDetail() {
		return "class/classMemberDetail";
	}
	@RequestMapping(value = "/classwriteForm")
	public String classwriteForm() {
		return "class/classwriteForm";
	}
	
	
	
	
	
	
	
}

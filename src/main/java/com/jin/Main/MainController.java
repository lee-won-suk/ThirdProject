package com.jin.Main;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.Login.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("main")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private iMainService iMainServ;
	
	
	@RequestMapping(value = "/mainProc")
	public String loginProc(Model model, Member member) {

	
		//현재 인기있는 소셜 모임
		List<Socialmeeting> hotSocialList=iMainServ.getMainSocial();
		//현재 인기있는 클래스
		
		
		//model.addAttribute("msg", "잘못된 계정정보입니다.");
		 return "main/loginmain";
	}

	

	
	
}

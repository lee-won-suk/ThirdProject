package com.jin.Login;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("login")
public class LoginController {

	/*
	 * 둘중 하나가 비어있을 경우
	 * 
	 * 
	 * 
	 * 
	 */
	@Autowired
	ILoginService iLoginServ;

	private final int LOGINSUCCESS = 1;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/loginProc")
	public String loginProc(Model model, Member member) {

		int loginResult = iLoginServ.LoginProc(member);
		
		//로그인 성공시
		if(loginResult==LOGINSUCCESS) return "forward:/index?formpath=/main/mainProc";
		  
		// 틀렸을 경우 틀렸습니다 출력
		 model.addAttribute("msg", "잘못된 계정정보입니다.");
		 return "forward:/index?formpath=login";
	}



	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/main/mainProc";
	}

}

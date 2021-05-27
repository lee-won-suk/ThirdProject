package com.jin.Social;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("social")
public class SocialController {

	@Autowired
	private ISocialService iSocialServ;

	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);


	@RequestMapping(value = "/SocialMainProc")
	public String SocialMainProc(Model model) {

		List<Socialmeeting> SocialInfo = iSocialServ.SocialMainProc();
		model.addAttribute("SocialLst", SocialInfo);

		return "forward:/index?formpath=socialmain";
	}
	
	//소셜 모임정보
	@RequestMapping(value = "/CreateSocial")
	public String CreateSocial() {
		iSocialServ.SocialInsert(null); //추가 필요;
		return "forward:/index?formpath=CreateSocial";
	}
	//소셜 모임 생성
	@RequestMapping(value = "/SocialInsert")
	public String SocialInsert(Model model) {
		
		return "forward:/index?formpath=socialmain";
	}
	//소모임 생성 페이지 이동
	@RequestMapping(value = "/")
	public String CreateInnerSocial() {
		
		return "forward:/index?formpath=CreateInnerSocial";
	}

}

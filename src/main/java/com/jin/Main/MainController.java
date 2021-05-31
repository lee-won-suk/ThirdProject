package com.jin.Main;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;
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
	public String loginProc(Model model, Member member, HttpSession session) {

	
		//현재 인기있는 소셜 모임
		List<Socialmeeting> hotSocialList=iMainServ.getMainSocial();
		//현재 인기있는 클래스	
		List<ClassInfo> hotClassList=iMainServ.getMainClass();
		
		
		
		//사용자 선호 장르 가져오기
		if((String)session.getAttribute("id")!=null)
		{
	List<String> usrgenre =iMainServ.getUsrgenre( (String)session.getAttribute("id") );	
			//사용자 선호장르 기반 소셜
	List<Socialmeeting> usrSocialList=iMainServ.getUsrsocial(usrgenre);
			//사용자 선호장르 기반 클래스
	List<ClassInfo> usrClassList=iMainServ.getUsrClass(usrgenre);
		
		model.addAttribute("usrSocialList", usrSocialList);
		model.addAttribute("usrClassList", usrClassList);
		
				
		}

		
		model.addAttribute("SocialList", hotSocialList);
		model.addAttribute("ClassList", hotClassList);
		
		
		
		 return "main/loginmain";
	}

	

	
	
}

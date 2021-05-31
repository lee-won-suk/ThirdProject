package com.jin.Profile;

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
import com.jin.Login.Member;
import com.jin.Main.Socialmeeting;
import com.jin.Social.SocialMeetList;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private IProfileService iProfileServ;
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@RequestMapping(value = "/profileProc")
	public String profileProc(Model model, Member member, HttpSession session) {

		String nickname=(String)session.getAttribute("nickname");
		//가입 소셜 리스트
		List<SocialMemberList> joinSocialList=iProfileServ.getjoinSocial(nickname);
		
		
		//참가예정 소셜 및 클래스 리스트
		List<SocialMeetList> futureSocialList=iProfileServ.getfutureSocial(nickname);
		List<ClassDateList> futureclassList=iProfileServ.getfutureClass(nickname);
		

		model.addAttribute("joinSocialList",joinSocialList);
		model.addAttribute("futureSocialList",futureSocialList);
		model.addAttribute("futureclassList",futureclassList);
		
		return "profile/profile";
	}
	

	
	
}

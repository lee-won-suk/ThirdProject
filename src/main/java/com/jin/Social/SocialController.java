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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;
import com.jin.Classes.Classreviews;

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
		
		List<Socialmeeting> socialInfo = iSocialServ.SocialMainProc();
		logger.warn("사이즈는 : "+socialInfo.size());
		model.addAttribute("socialLst", socialInfo);
		
		return "forward:/index?formpath=socialmain";
	}
	
	//소셜 상세 페이지 이동
		@RequestMapping(value = "/MoimMainProc")
		public String MoimMainProc(Socialmeeting smeeting) {
			iSocialServ.SocialInfo(smeeting);
			return "forward:/index?formpath=moimmain";
		}
	
		@RequestMapping(value = "/SocialCreate")
		public String SocialCreate(Model model, Socialmeeting smeeting ,HttpSession session) {
			 iSocialServ.SocialCreate(smeeting);
			return "forward:/index?formpath=classMain";
		}
		
		//소모임 개최 추가하기
		@RequestMapping(value = "/MoimaddProc")
		public String MoimaddProc(Model model, @RequestParam int month, @RequestParam int day,
				@RequestParam int year, SocialCreateInfo info, @RequestParam String mname,
				@RequestParam int starthour, @RequestParam int startmin, @RequestParam int endhour,
				@RequestParam int endmin) {
			
			
			info.setMdate((year*10000)+(month*100)+day);
			info.setMstarttime((starthour*100)+startmin);
			info.setMendtime((endhour*100)+endmin);
			
			model.addAttribute("mname",mname);
			
			iSocialServ.Moimadd(info);
			logger.warn(mname);
			return "forward:/social/SocialMainProc";
			
		}
}

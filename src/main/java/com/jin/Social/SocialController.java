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
	
	//소셜 상세 설명 페이지 이동
		@RequestMapping(value = "/SocialDetailProc")
		public String SocialDetailProc(Model model , @RequestParam String mname, @RequestParam String mgenre)
		{
			List<SocialCreateInfo> mdetails= iSocialServ.getMDetails(mname);
			List<SocialCreateInfo> mestablish= iSocialServ.getMestablish(mname);
			
			List<int[]>  dateLst = new ArrayList<int[]>() ;
			for(SocialCreateInfo item : mestablish)
			{
				int [] data= new int [3];
				data[0]=( item.getMdate()-(item.getMdate()%1000) )/10000      ;
				data[1]= (  (item.getMdate()%1000)-(item.getMdate()%100)  )/100;
				data[2]=(item.getMdate()%100);
				dateLst.add(data);
			}
			model.addAttribute("mname", mname);		
			model.addAttribute("mgenre",mgenre);
			model.addAttribute("mestablish",mestablish);
			model.addAttribute("mdetails", mdetails);
			model.addAttribute("dateLst",dateLst);
			
			return "forward:/index?formpath=CreateInnerSocial";
		}
	
	
	
	
	
	
	
	
	
	
}

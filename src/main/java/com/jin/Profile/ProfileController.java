package com.jin.Profile;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
		
		List<Map<String,Object>>  fsocialdateLst = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>>  fclassdateLst = new ArrayList<Map<String,Object>>();
		if(futureSocialList.size()!=0) 
			{
			for(SocialMeetList item : futureSocialList)
				{
					Map<String,Object> map=new HashMap<String, Object>();
					map.put("year",(item.getMdate()-(item.getMdate()%10000) )/10000) ;
					map.put("month",(  (item.getMdate()%10000)-(item.getMdate()%100)  )/100  ) ;
					map.put("day", item.getMdate()%100 ) ;
					fsocialdateLst.add(map);
					
					logger.warn(map.get("year")+"aa");
				}
			}
		
		if(futureclassList.size()!=0) 
		{
		for(ClassDateList item : futureclassList)
			{
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("year",(item.getCdate()-(item.getCdate()%10000) )/10000) ;
				map.put("month",(  (item.getCdate()%10000)-(item.getCdate()%100)  )/100  ) ;
				map.put("day", item.getCdate()%100 ) ;
				fclassdateLst.add(map);
			}
		}
		


		model.addAttribute("joinSocialList",joinSocialList);
		model.addAttribute("futureSocialList",futureSocialList);
		model.addAttribute("futureclassList",futureclassList);
		
		model.addAttribute("fsocialdateLst",fsocialdateLst);
		model.addAttribute("fclassdateLst",fclassdateLst);
		
		
		
		
		return "profile/profile";
	}
	

	
	
}

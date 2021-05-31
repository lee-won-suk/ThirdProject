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
import com.jin.Social.SocialCreateInfo;

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

	
		//���� �α��ִ� �Ҽ� ����
		List<Socialmeeting> hotSocialList=iMainServ.getMainSocial();
		//���� �α��ִ� Ŭ����	
		List<ClassInfo> hotClassList=iMainServ.getMainClass();
		
		
		
		//����� ��ȣ �帣 ��������
		if((String)session.getAttribute("id")!=null)
		{
			List<String> usrgenre =iMainServ.getUsrgenre( (String)session.getAttribute("id") );	
					
			
			
			//������� ������� ���� ����Ʈ
			List<SocialCreateInfo> nowusrLst=iMainServ.nowUsrList( (String)session.getAttribute("nickname") );
				
			//��õ �˰��� ����Ʈ
			List<ClassInfo> recomendClassList=iMainServ.getRecommendClass();
			
			
			//����� ��ȣ�帣 ��� �Ҽ�
	List<Socialmeeting> usrSocialList=iMainServ.getUsrsocial(usrgenre);
			//����� ��ȣ�帣 ��� Ŭ����
	List<ClassInfo> usrClassList=iMainServ.getUsrClass(usrgenre);
		
		model.addAttribute("usrSocialList", usrSocialList);
		model.addAttribute("usrClassList", usrClassList);
		model.addAttribute("nowusrLst", nowusrLst);
		model.addAttribute("recomendClassList", recomendClassList);
				
		}

		
		model.addAttribute("SocialList", hotSocialList);
		model.addAttribute("ClassList", hotClassList);
		
		
		
		 return "main/loginmain";
	}

	

	
	
}

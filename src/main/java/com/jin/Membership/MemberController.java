package com.jin.Membership;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("membership")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired 
	private IMemberService iMemberServ;
	//id중복확인
	@RequestMapping(value = "IdCheck")
	public String IdCheck(Model model, Member member) {
		model.addAttribute("msg", iMemberServ.IdCheck(member));
		return "forward:/index?formpath=membership";
	}
	//닉네임중복 확인
	@RequestMapping(value = "NicknameCheck")
	public String NicknameCheck(Model model, Member member) {
		model.addAttribute("msg", iMemberServ.NicknameCheck(member));
		return "forward:/index?formpath=membership";
	}
	//인증번호전송
	@RequestMapping(value = "sendAuth")
	public String sendAuth(Model model, Member member) {
		iMemberServ.sendAuth(member);
		model.addAttribute("msg", "인증번호가 전송되었습니다.");
		return "forward:/index?formpath=membership";
	}
	//인증번호 확인
	@RequestMapping(value = "authConfirm")
	public String authConfirm(Model model, Member member, @RequestParam String authNum) {
		model.addAttribute("msg", iMemberServ.authConfirm(authNum));

		return "forward:/index?formpath=membership";
	}
	//가입시도
	@RequestMapping(value = "memberProc")
	public String memberProc(Model model, Member member, choiceMember cmember) {
		String msg = iMemberServ.MemberProc(member, cmember);

		model.addAttribute("msg", msg);
		return "forward:/index?formpath=membership";
	}

}

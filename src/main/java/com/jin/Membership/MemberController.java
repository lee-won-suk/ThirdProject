package com.jin.Membership;


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
	//id�ߺ�Ȯ��
	@RequestMapping(value = "/IdCheck")
	public String IdCheck(Model model, Member member) {
		model.addAttribute("msg", iMemberServ.IdCheck(member));
		return "forward:/index?formpath=membership";
	}
	//�г����ߺ� Ȯ��
	@RequestMapping(value = "/NicknameCheck")
	public String NicknameCheck(Model model, Member member) {
		model.addAttribute("msg", iMemberServ.NicknameCheck(member));
		return "forward:/index?formpath=membership";
	}
	//������ȣ����
	@RequestMapping(value = "/sendAuth")
	public String sendAuth(Model model, Member member) {
		iMemberServ.sendAuth(member);
		model.addAttribute("msg", "������ȣ�� ���۵Ǿ����ϴ�.");
		return "forward:/index?formpath=membership";
	}
	//������ȣ Ȯ��
	@RequestMapping(value = "/authConfirm")
	public String authConfirm(Model model, Member member, @RequestParam String authNum) {
		model.addAttribute("msg", iMemberServ.authConfirm(authNum));

		return "forward:/index?formpath=membership";
	}
	//���Խõ�
	@RequestMapping(value = "/memberProc")
	public String memberProc(Model model, Member member, choiceMember cmember) {
		String msg = iMemberServ.MemberProc(member, cmember);
		if(msg != null) {
			logger.warn("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}
		model.addAttribute("msg", msg);
		return "forward:/index?formpath=main/mainProc";
	}

}

package com.jin.Membership;


import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements IMemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private IMemberDao iMemberDao;
	private final int EXISTID = 1;
	
	@Autowired
	private HttpSession session;
	
	//id 중복 체크
	@Override
	public String IdCheck(Member member) {
		if(iMemberDao.IdCheck(member.getId())==EXISTID)
			return "중복된 아이디입니다.";
		return "사용 가능한 아이디 입니다.";
	}
	//닉네임 중복체크
	@Override
	public String NicknameCheck(Member member) {
		if(iMemberDao.NicknameCheck(member.getNickname())==EXISTID)
			return "중복된 닉네임입니다.";
		return "사용 가능한 닉네임입니다.";
	}
	//인증번호 전송
	@Override
	public void sendAuth(Member member) {
		String authNum = (String)session.getAttribute("authNum");
		
		if (authNum == null ) {
			Random rand = new Random();
			String randNum = String.format("%04d", rand.nextInt(10000));
			
			session.setAttribute("authNum", randNum);
			session.setMaxInactiveInterval(180);
			logger.warn(randNum);
		}
	}
	//인증번호 확인
	@Override
	public String authConfirm(String authNum) {
		String sAuthNum = (String)session.getAttribute("authNum");

		if (sAuthNum == null)	return "인증번호를 생성하세요";

		if(authNum.contentEquals(sAuthNum)) {
			session.setAttribute("authState", true);
			return "인증 완료";
		}

		return "인증 실패";
	}
	
	//계정 생성
	@Override
	public String MemberProc(Member member, choiceMember cmember) {
		iMemberDao.InsertMember(member);
		
		return "회원가입 완료";
	 	
	}
}

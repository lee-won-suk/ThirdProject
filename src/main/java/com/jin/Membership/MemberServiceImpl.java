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
	
	//id �ߺ� üũ
	@Override
	public String IdCheck(Member member) {
		if(iMemberDao.IdCheck(member.getId())==EXISTID)
			return "�ߺ��� ���̵��Դϴ�.";
		return "��� ������ ���̵� �Դϴ�.";
	}
	//�г��� �ߺ�üũ
	@Override
	public String NicknameCheck(Member member) {
		if(iMemberDao.NicknameCheck(member.getNickname())==EXISTID)
			return "�ߺ��� �г����Դϴ�.";
		return "��� ������ �г����Դϴ�.";
	}
	//������ȣ ����
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
	//������ȣ Ȯ��
	@Override
	public String authConfirm(String authNum) {
		String sAuthNum = (String)session.getAttribute("authNum");

		if (sAuthNum == null)	return "������ȣ�� �����ϼ���";

		if(authNum.contentEquals(sAuthNum)) {
			session.setAttribute("authState", true);
			return "���� �Ϸ�";
		}

		return "���� ����";
	}
	
	//���� ����
	@Override
	public String MemberProc(Member member, choiceMember cmember) {
		iMemberDao.InsertMember(member);
		
		return "ȸ������ �Ϸ�";
	 	
	}
}

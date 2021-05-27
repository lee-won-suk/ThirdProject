package com.jin.Login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements ILoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired private ILoginDao iLoginDao;
	@Autowired private HttpSession session;
	
	/*
	 * ���ǿ� ������ �����ϴ� �޼ҵ�
	 * id, ���� �� �α��ν� ������ ���� ����
	 */
	private void setSession(int cnt, String id,String nickname) {
		if(cnt==1) {
			session.setAttribute("id", id);
			session.setAttribute("nickname",nickname);
		}
	}
	@Override
	public int LoginProc(Member member) {

		int cnt = iLoginDao.LoginProc(member);
		String nickname=iLoginDao.getNickname(member.getId());
		setSession(cnt, member.getId(),nickname);		
		return cnt;
	}
	
}

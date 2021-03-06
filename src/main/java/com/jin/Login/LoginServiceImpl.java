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
	 * 세션에 정보를 저장하는 메소드
	 * id, 권한 등 로그인시 적용할 정보 저장
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

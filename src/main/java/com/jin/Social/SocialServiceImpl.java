package com.jin.Social;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialServiceImpl implements ISocialService {
	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);
	
	public static final int NICKNAMEEXIST=1;
	@Autowired
	private ISocialDao iSocialDao;
	
	//소셜 메인페이지 조회
	@Override
	public List<Socialmeeting> SocialMainProc() {
		return iSocialDao.SocialMainProc();	
	}
	
	//소셜모임생성
	@Override
	public void SocialInsert(Map<String, Object> smeeting) {
		
		iSocialDao.SocialInsert();
	}
	//소모임 생성
	
}

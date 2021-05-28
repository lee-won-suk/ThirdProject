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

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;
import com.jin.Classes.Classreviews;

@Service
public class SocialServiceImpl implements ISocialService {
	private static final Logger logger = LoggerFactory.getLogger(SocialController.class);
	
	public static final int NICKNAMEEXIST=1;
	@Autowired
	private ISocialDao iSocialDao;
	

	@Override
	public List<Socialmeeting> SocialMainProc() {
		return iSocialDao.SocialMainProc();
	}
	@Override
	public List<SocialCreateInfo> getMDetails(String mname) {
		return null;
	}


	@Override
	public List<SocialCreateInfo> getMestablish(String mname) {
		return null;
	}
	
	/*
	@Override
	public List<Float> getStarVal(List<ClassInfo> classInfo) {
		// TODO Auto-generated method stub
		return iClassDao.getStarVal(classInfo);
	}

	@Override
	public List<ClassInfo> getDetailClass(String detailname) {
		List<ClassInfo> classes= iClassDao.getDetailClass(detailname);
		
		if (classes!=null)
		return classes;
		
		return null;
	}

	@Override
	public List<ClassInfo> ClassSearch(Map<String, Object> searchMap) {
		logger.warn(searchMap.get("line")+"");
		return iClassDao.ClassSearch(searchMap);
	}

	@Override
	public List<Classreviews> getReview(String classname) {
		
		return iClassDao.getReview(classname);
	}

	@Override
	public List<Classcreateinfo> getCreateList(String classname) {
		// TODO Auto-generated method stub
		return iClassDao.getCreateList(classname);
	}

	
	public int getdate() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");      
	 return Integer.parseInt(date.format(today));
		
	}
	
	@Override
	public int ClassJoin(String classname, String usrnickname) {
		
		Map<String,Object> joinMap=new HashMap<String, Object>();
		joinMap.put("classname",classname);
		joinMap.put("nickname", usrnickname);
		joinMap.put("date", iClassDao.getrecentDate(joinMap) );//가장 빠르면서 오늘날짜보다 이전엔 클래스 예정날짜를 가져와야 한다.
		
		
		//닉네임 있는지 여부
		int nickCnt= iClassDao.findNickname(joinMap);
		
		if(nickCnt!=NICKNAMEEXIST) {
		iClassDao.ClassJoin(joinMap);
		//iClassDao.increaseJoinMember(joinMap);		
		return 1;
		}
		return 0; //이미 신청을 한경우
		
	}

	@Override
	public void ClassDetailCreate(Classcreateinfo info) {
		iClassDao.ClassDetailCreate(info);
	}

	@Override
	public void SaveReview(Classreviews classreviews) {
		iClassDao.SaveReview(classreviews);
		
	}

	@Override
	public void ClassCreate(ClassInfo classinfo) {
		iClassDao.ClassCreate(classinfo);
	}
*/





}

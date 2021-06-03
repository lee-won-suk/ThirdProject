package com.jin.Profile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.Social.SocialMeetList;


@Service
public class ProfileServiceImpl implements IProfileService{

	@Autowired
	private IProfileDao iProfileDao;
	
	@Override
	public List<SocialMemberList> getjoinSocial(String nickname) {

		return iProfileDao.getjoinSocial(nickname);	
	}
	
	
	public int getdate() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");      
	 return Integer.parseInt(date.format(today));
		
	}
	
	@Override
	public List<SocialMeetList> getfutureSocial(String nickname) {
		Map<String,Object> getListMap=new HashMap<String, Object>();
		getListMap.put("nickname",nickname);
		getListMap.put("date",getdate());//가장 빠르면서 오늘날짜보다 이전엔 클래스 예정날짜를 가져와야 한다.
		
			
		return iProfileDao.getfutureSocial(getListMap);
	}

	@Override
	public List<ClassDateList> getfutureClass(String nickname) {
		Map<String,Object> getListMap=new HashMap<String, Object>();
		getListMap.put("nickname",nickname);
		getListMap.put("date",getdate());//가장 빠르면서 오늘날짜보다 이전엔 클래스 예정날짜를 가져와야 한다.
		
		return iProfileDao.getfutureClass(getListMap);
	}

}

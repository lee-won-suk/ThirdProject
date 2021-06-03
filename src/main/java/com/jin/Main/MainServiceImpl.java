package com.jin.Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.jin.Social.SocialCreateInfo;

@Service
public class MainServiceImpl implements iMainService{
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired 
	private IMainDao iMainDao;
	
	public int getdate() {
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");      
	 return Integer.parseInt(date.format(today));
		
	}
	
	@Override
	public List<Socialmeeting> getMainSocial() {
		
		//오늘 날짜 구하고 6개월 이
		int date=getdate();
		int nowmonth=date%10000-date%100;
		
		
		//현재 월이 6보다 작으면 현재 월에 6을 더하고 년도를 1뺀다.
		//현재월이 6월이면 12월로 바꾸고 년도 -1
		if(nowmonth<=6)
			date=date+600-10000;
		//현재월이 6보다 크면 -6
		if(nowmonth>6)
			date=date-600;
		
		//개설한지 반년 일정 모임
		List<Socialmeeting>	meetingLst = iMainDao.getTotalSocial(date);
		
		//인원참석률이 0.6이상인 일정 찾기
		//맵을 사용해서 그냥 하나씩 for문으로 받아오자.
		List<Socialmeeting>Lst=new ArrayList<Socialmeeting>();
		
		//소셜모임 이름과 인원을 받아와서 참여율이 6
		for(Socialmeeting item : meetingLst)
		{
			
		Map<String,Object> LstMap=new HashMap<String, Object>();
		LstMap.put("name", item.getMname());
		LstMap.put("people", item.getMpeople());
		//참가율
		float meetPercent=iMainDao.getMainSocial(LstMap) ;
		logger.warn(meetPercent+"");
		if( meetPercent>=0.6 )
		Lst.add( iMainDao.getSocial(item.getMname()) );
		
		}
		

		
		
		return Lst;
		
	}

	@Override
	public List<ClassInfo> getMainClass() {
		
		return iMainDao.getClasses();
	}

	@Override
	public List<String> getUsrgenre(String id) {	
		String Usrgenre= iMainDao.getUsrgenre(id);
		 
		 String[] genre=Usrgenre.split(" ");
		 List<String> genres=new ArrayList<String>();
		 for(String item : genre)
		 {	 item=item.trim();
		 	genres.add(item);
		 }
		 
		 
		 
		 return genres;
	
	}

	@Override
	public List<Socialmeeting> getUsrsocial(List<String> usrgenre) {
		
		return iMainDao.getUsrsocial(usrgenre);
		
	}

	@Override
	public List<ClassInfo> getUsrClass(List<String> usrgenre) {
		// TODO Auto-generated method stub
		return iMainDao.getUsrClass(usrgenre);
	}

	@Override
	public List<SocialCreateInfo> nowUsrList(String nickname) {
		return iMainDao.nowUsrList(nickname);
	}

	@Override
	public List<ClassInfo> getRecommendClass() {		
		return  iMainDao.getRecommendClass();
	}

}

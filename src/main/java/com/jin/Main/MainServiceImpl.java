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
		
		//���� ��¥ ���ϰ� 6���� ��
		int date=getdate();
		int nowmonth=date%10000-date%100;
		
		
		//���� ���� 6���� ������ ���� ���� 6�� ���ϰ� �⵵�� 1����.
		//������� 6���̸� 12���� �ٲٰ� �⵵ -1
		if(nowmonth<=6)
			date=date+600-10000;
		//������� 6���� ũ�� -6
		if(nowmonth>6)
			date=date-600;
		
		//�������� �ݳ� ���� ����
		List<Socialmeeting>	meetingLst = iMainDao.getTotalSocial(date);
		
		//�ο��������� 0.6�̻��� ���� ã��
		//���� ����ؼ� �׳� �ϳ��� for������ �޾ƿ���.
		List<Socialmeeting>Lst=new ArrayList<Socialmeeting>();
		
		//�Ҽȸ��� �̸��� �ο��� �޾ƿͼ� �������� 6
		for(Socialmeeting item : meetingLst)
		{
			
		Map<String,Object> LstMap=new HashMap<String, Object>();
		LstMap.put("name", item.getMname());
		LstMap.put("people", item.getMpeople());
		//������
		float meetPercent=iMainDao.getMainSocial(LstMap) ;
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

}

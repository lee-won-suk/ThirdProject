package com.jin.Classes;

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
public class ClassServiceImpl implements IClassService {
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	
	public static final int NICKNAMEEXIST=1;
	@Autowired
	private IClassDao iClassDao;
	
	@Override
	public List<ClassInfo> ClassMainProc() {
		//�丮 Ŭ���� ���� ��������

		return iClassDao.ClassMainProc();	
	}

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
		Map<String,Object> getListMap=new HashMap<String, Object>();
		getListMap.put("classname",classname);
		getListMap.put("date",getdate());//���� �����鼭 ���ó�¥���� ������ Ŭ���� ������¥�� �����;� �Ѵ�.
		
		
		
		return iClassDao.getCreateList(getListMap);
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
		joinMap.put("date", iClassDao.getrecentDate(joinMap) );//���� �����鼭 ���ó�¥���� ������ Ŭ���� ������¥�� �����;� �Ѵ�.
		
		
		//�г��� �ִ��� ����
		int nickCnt= iClassDao.findNickname(joinMap);
		
		if(nickCnt!=NICKNAMEEXIST) {
		iClassDao.ClassJoin(joinMap);
		iClassDao.increaseJoinMember(joinMap);		
		return 1;
		}
		return 0; //�̹� ��û�� �Ѱ��
		
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

	



}

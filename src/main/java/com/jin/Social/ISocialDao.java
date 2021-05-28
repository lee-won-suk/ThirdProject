package com.jin.Social;

import java.util.List;
import java.util.Map;

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;
import com.jin.Classes.Classreviews;

public interface ISocialDao {

	public List<Socialmeeting> SocialMainProc();
	
	public List<SocialCreateInfo> getMDetails(String mname);

	public List<SocialCreateInfo> getMestablish(String mname);

	
/*	public List<Float> getStarVal(List<ClassInfo> classInfo);

	public List<ClassInfo> getDetailClass(String detailname);

	public List<ClassInfo> ClassSearch(Map<String, Object> searchMap);


	public void ClassJoin(Map<String, Object> joinMap);

	public int findNickname(Map<String, Object> joinMap);

	public int getrecentDate(Map<String, Object> joinMap);

	public void ClassDetailCreate(Classcreateinfo info);

	public void SaveReview(Classreviews classreviews);

	public void ClassCreate(ClassInfo classinfo); */
}

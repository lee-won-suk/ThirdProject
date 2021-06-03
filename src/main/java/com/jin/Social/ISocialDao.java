package com.jin.Social;

import java.util.List;
import java.util.Map;

public interface ISocialDao {

	public List<Socialmeeting> SocialMainProc();
	
//	public void SocialInfo(Socialmeeting smeeting);
	
	public void SocialCreate(Socialmeeting smeeting);

	public void SocialMoimCreate(SocialCreateInfo info);

	
	

//	public List<> ClassSearch(Map<String, Object> searchMap);
	
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

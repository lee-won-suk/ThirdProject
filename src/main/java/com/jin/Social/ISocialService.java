package com.jin.Social;

import java.util.List;
import java.util.Map;

import com.jin.Classes.Classcreateinfo;
import com.jin.Classes.Classreviews;


public interface ISocialService {
	public List<Socialmeeting> SocialMainProc();
	
	public List<SocialCreateInfo> getMDetails(String mname);

	public List<SocialCreateInfo> getMestablish(String mname);
	
/*
	public List<Float> getStarVal(List<SocialInfo> SocialInfo);

	public List<SocialInfo> getDetailSocial(String detailname);

	public List<SocialInfo> SocialSearch(Map<String, Object> searchMap);

	public List<Socialreviews> getReview(String Socialname);

	public List<Socialcreateinfo> getCreateList(String Socialname);

	public int SocialJoin(String Socialname, String nickname);

	public void SocialDetailCreate(Socialcreateinfo info);

	public void SaveReview(Socialreviews Socialreviews);

	public void SocialCreate(SocialInfo Socialinfo);
*/
	
}

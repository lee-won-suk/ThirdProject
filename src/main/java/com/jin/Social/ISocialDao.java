package com.jin.Social;

import java.util.List;
import java.util.Map;

public interface ISocialDao {

	public List<Socialmeeting> SocialMainProc();
	public void SocialInsert(Map<String, Object> smeeting);
	
}

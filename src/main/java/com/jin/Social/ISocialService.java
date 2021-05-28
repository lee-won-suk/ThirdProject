package com.jin.Social;

import java.util.List;
import java.util.Map;

public interface ISocialService {
	public List<Socialmeeting> SocialMainProc();
	public void SocialInsert(Map<String, Object> smeeting);
}

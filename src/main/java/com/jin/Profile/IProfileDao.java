package com.jin.Profile;

import java.util.List;
import java.util.Map;

import com.jin.Social.SocialMeetList;

public interface IProfileDao {

	List<SocialMemberList> getjoinSocial(String nickname);

	List<SocialMeetList> getfutureSocial(Map<String, Object> getListMap);

	List<ClassDateList> getfutureClass(Map<String, Object> getListMap);

}

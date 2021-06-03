package com.jin.Profile;

import java.util.List;

import com.jin.Social.SocialMeetList;

public interface IProfileService {

	List<SocialMemberList> getjoinSocial(String nickname);

	List<SocialMeetList> getfutureSocial(String nickname);

	List<ClassDateList> getfutureClass(String nickname);

}

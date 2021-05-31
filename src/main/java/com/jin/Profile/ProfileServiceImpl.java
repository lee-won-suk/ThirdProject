package com.jin.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.Social.SocialMeetList;


@Service
public class ProfileServiceImpl implements IProfileService{

	@Autowired
	private IProfileDao iProfileDao;
	
	@Override
	public List<SocialMemberList> getjoinSocial(String nickname) {

		return iProfileDao.getjoinSocial(nickname);	
	}

	@Override
	public List<SocialMeetList> getfutureSocial(String nickname) {
		return iProfileDao.getfutureSocial(nickname);
	}

	@Override
	public List<ClassDateList> getfutureClass(String nickname) {
		return iProfileDao.getfutureClass(nickname);
	}

}

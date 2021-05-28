package com.jin.Main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements iMainService{

	
	@Autowired 
	private IMainDao iMainDao;
	@Override
	public List<Socialmeeting> getMainSocial() {
		return iMainDao.getMainSocial();
	}

}

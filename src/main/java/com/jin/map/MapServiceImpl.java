package com.jin.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements IMapService {
	
	@Autowired 
	private IMapDao iMapDao;

	@Override
	public Map Searching(String searchname) {
		return iMapDao.Search(searchname);
	}
}

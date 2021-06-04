package com.jin.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("map")
public class MapController {

	@Autowired
	private IMapService iMServ;
	
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	//�Ҽ� �� ������ �̵�
			@RequestMapping(value = "/Searching")
			public String Searching(Model model,@RequestParam String searchname) {
				
				
				Map locationAddressMap=iMServ.Searching(searchname);
				
				logger.warn(locationAddressMap.getLat()+"");
				
				
				return "forward:/mapForm";
			}
			
			
			
}

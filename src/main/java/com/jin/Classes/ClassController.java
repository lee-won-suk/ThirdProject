package com.jin.Classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("class")
public class ClassController {
	
	@Autowired
	private IClassService iClassServ;
	
	private static final Logger logger = LoggerFactory.getLogger(ClassController.class);
	

	//ClassMainProc() 클래스 사진 및 설명(클래스 정보 DB데이터랑 후기DB에서 별점평균 가져온다.
	//기본값 요리로띄움mhj
	@RequestMapping(value = "/ClassMainProc")
	public String ClassMainProc(Model model) {
		
		List<ClassInfo> classInfo=	iClassServ.ClassMainProc();		
		//별점 가져오기
		List<Float>	starvalue= iClassServ.getStarVal(classInfo);
		
	 
		
		model.addAttribute("classLst", classInfo);
		model.addAttribute("starvalue",starvalue);
		
		return "forward:/index?formpath=classMain";
	}
	
	//클래스 상세 설명 페이지 이동
	@RequestMapping(value = "/ClassDetailProc")
	public String ClassDetailProc(Model model , @RequestParam String classname,
			@RequestParam String classcontent, @RequestParam String nickname)
	{
		List<Classreviews> reviews= iClassServ.getReview(classname);
		List<Classcreateinfo> createList= iClassServ.getCreateList(classname);
		
	List<Map<String,Integer>>  dateLst = new ArrayList<Map<String,Integer>>();
	List<Map<String,Object>>  timeLst = new ArrayList<Map<String,Object>>();
	List<Map<String,Object>>  endtimeLst = new ArrayList<Map<String,Object>>();
	if(createList.size()!=0) 
		{
		for(Classcreateinfo item : createList)
		{
			Map<String,Integer> map=new HashMap<String, Integer>();
			map.put("year",(item.getCdate()-(item.getCdate()%10000) )/10000) ;
			map.put("month",(  (item.getCdate()%10000)-(item.getCdate()%100)  )/100  ) ;
			map.put("day", item.getCdate()%100 ) ;

			dateLst.add(map);

			
			Map<String,Object> map2=new HashMap<String,Object>();
			int min=item.getStarttime()%100;
		
			map2.put("hour", (item.getStarttime()-item.getStarttime()%100)/100 ) ;
			map2.put("min", (String.format("%02d",min))	) ;
			timeLst.add(map2);
			
			
			
			
			Map<String,Object> endmap=new HashMap<String,Object>();
		    min=item.getStarttime()%100;
		
		    endmap.put("hour", (item.getEndtime()-item.getEndtime()%100)/100 ) ;
		    endmap.put("min", (String.format("%02d",min))	) ;
			endtimeLst.add(endmap);
		}
		}
		
		
		
		
		
		
		model.addAttribute("nickname",nickname);		
		model.addAttribute("classname",classname);
		model.addAttribute("classcontent",classcontent);
		model.addAttribute("reviews",reviews);
		model.addAttribute("createList",createList);
		model.addAttribute("dateLst",dateLst);
		model.addAttribute("timeLst",timeLst);
		model.addAttribute("endtimeLst",endtimeLst);
		return "forward:/index?formpath=classDetail";
	}
	
	
	
	//클래스 일정 생성페이지 이동
	@RequestMapping(value = "/ClassMemberDetailProc")
	public String ClassMemberDetailProc(Model model , @RequestParam String classname,
			@RequestParam String classcontent, @RequestParam String nickname)
	{	
		model.addAttribute("nickname",nickname);		
		model.addAttribute("classname",classname);
		model.addAttribute("classcontent",classcontent);

		return "forward:/index?formpath=classMemberDetail";
	}
	
	
	@RequestMapping(value = "/ClassCreate")
	public String ClassCreate(Model model, ClassInfo classinfo,HttpSession session) {
		
		 classinfo.setNickname((String)session.getAttribute("nickname") );
		 iClassServ.ClassCreate(classinfo);
			//conline 매핑이 안되고 있음
		
		
		
		
		
		
		
		List<ClassInfo> classInfo=	iClassServ.ClassMainProc();		
		//별점 가져오기
		List<Float>	starvalue= iClassServ.getStarVal(classInfo);
		
	
		
		model.addAttribute("classLst", classInfo);
		model.addAttribute("starvalue",starvalue);
		
		return "forward:/index?formpath=classMain";
	}
		
		@RequestMapping(value = "/WriteReview")
		public String WriteReview(Model model , @RequestParam String classname,
				HttpSession session,
				@RequestParam String classcontent)
		{	
			
			
			
			model.addAttribute("nickname",(String)session.getAttribute("nickname"));		
			model.addAttribute("classname",classname);
			model.addAttribute("classcontent",classcontent);
			
			return "forward:/index?formpath=classwriteForm";
		}
	
		@RequestMapping(value = "/SaveReview")
		public String SaveReview(Model model /*,  @RequestParam String classname,
				@RequestParam String nickname */,
				@RequestParam String classcontent,
				Classreviews classreviews )
		{	
			classreviews.setClassname(classreviews.getClassname().trim());
			iClassServ.SaveReview(classreviews);

			model.addAttribute("nickname",classreviews.getNickname());		
			model.addAttribute("classname",classreviews.getClassname());
			model.addAttribute("classcontent",classcontent);
			
			
			
			return "forward:/class/ClassMainProc";
		}
	
	
	
	//클래스 일정 추가하기
	@RequestMapping(value = "/ClassDetailcreate")
	public String ClassDetailcreate(Model model , @RequestParam String classname,
			@RequestParam String classcontent, @RequestParam String nickname
			,@RequestParam int year ,@RequestParam int month ,@RequestParam int day,
			@RequestParam int starthour, @RequestParam int startmin ,
			@RequestParam int endhour, @RequestParam int endmin)
	{
		Classcreateinfo	info=new Classcreateinfo();
		info.setClassname(classname);
		info.setCpeople(1);
		info.setCdate(year*10000+month*100+day);
		info.setStarttime(starthour*100+startmin);
		info.setEndtime(endhour*100+endmin);
		info.setPlace("test");
		iClassServ.ClassDetailCreate(info);
		
		model.addAttribute("nickname",nickname);		
		model.addAttribute("classname",classname);
		model.addAttribute("classcontent",classcontent);
		
		logger.warn("test");
		
		return "forward:/class/ClassMainProc";
		
	}
	
	
	
	
	
	
	
	
	 
	@RequestMapping(value = "/ClassJoin")
	public String ClassJoin(Model model,@RequestParam String classname,
			@RequestParam String classcontent,@RequestParam String nickname,
			HttpSession session, HttpServletResponse response
			) throws IOException {
		
		//데이터가 없으면 classdatelst에 데이터 추가
		int isjoined=iClassServ.ClassJoin(classname,(String)session.getAttribute("nickname"));
		
		if(isjoined==0)//이미 가입했으면
		{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 가입하셨습니다');</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('가입되었습니다.');</script>");
			out.flush();
		}
		
		
		//+ 구글캘린더에 일정 등록하기 추가 필요.
		
		
		//classcreatelst의 인원 증가
		
		model.addAttribute("nickname",nickname);	
		model.addAttribute("classname",classname);
		model.addAttribute("classcontent",classcontent);
	
		
		return "forward:/class/ClassDetailProc";
	}
	
	
	@RequestMapping(value = "/getDetailClass")
	public String getDetailClass(Model model  , @RequestParam String detailname) {
		
		logger.warn(detailname);
		//세부장르의 클래스 가져오기
		
		  List<ClassInfo> classDetailInfo= iClassServ.getDetailClass(detailname); //별점 가져오기 List<Float>
		  List<Float>  starvalue;
		  
		  if(classDetailInfo.size()!=0) {
			  starvalue= iClassServ.getStarVal(classDetailInfo);
			  model.addAttribute("starvalue",starvalue);
			  
				 	 
		  }
		  model.addAttribute("classLst", classDetailInfo);
		 
		return "forward:/index?formpath=classMain";
	}
	
	
	 
	@RequestMapping(value = "/ClassSearch")
	public String ClassSearch(Model model, @RequestParam String word, @RequestParam int line) {
		
		//세부장르의 클래스 가져오기
		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("word", word);
		searchMap.put("line",line);
		
		
		
		
		 List<ClassInfo> classDetailInfo= iClassServ.ClassSearch(searchMap); //별점 가져오기 List<Float>
		  List<Float>  starvalue;
		  
		  if(classDetailInfo.size()!=0) {
			  starvalue= iClassServ.getStarVal(classDetailInfo);
			  model.addAttribute("starvalue",starvalue);	 	 
		  }
		  model.addAttribute("classLst", classDetailInfo);
		
		
		return "forward:/index?formpath=classMain";
	}
	
}

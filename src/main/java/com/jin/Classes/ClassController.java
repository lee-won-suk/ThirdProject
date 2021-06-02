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
	

	//ClassMainProc() Ŭ���� ���� �� ����(Ŭ���� ���� DB�����Ͷ� �ı�DB���� ������� �����´�.
	//�⺻�� �丮�ζ��mhj
	@RequestMapping(value = "/ClassMainProc")
	public String ClassMainProc(Model model) {
		
		List<ClassInfo> classInfo=	iClassServ.ClassMainProc();		
		//���� ��������
		List<Float>	starvalue= iClassServ.getStarVal(classInfo);
		
	 
		
		model.addAttribute("classLst", classInfo);
		model.addAttribute("starvalue",starvalue);
		
		return "forward:/index?formpath=classMain";
	}
	
	//Ŭ���� �� ���� ������ �̵�
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
	
	
	
	//Ŭ���� ���� ���������� �̵�
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
			//conline ������ �ȵǰ� ����
		
		
		
		
		
		
		
		List<ClassInfo> classInfo=	iClassServ.ClassMainProc();		
		//���� ��������
		List<Float>	starvalue= iClassServ.getStarVal(classInfo);
		
	
		
		model.addAttribute("classLst", classInfo);
		model.addAttribute("starvalue",starvalue);
		
		return "forward:/index?formpath=classMain";
	}
	
	
	
	
	
	
		@RequestMapping(value = "/WriteReview")
		public String WriteReview(Model model , @RequestParam String classname,
				@RequestParam String nickname,
				@RequestParam String classcontent)
		{	
			
			
			model.addAttribute("nickname",nickname);		
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
	
	
	
	//Ŭ���� ���� �߰��ϱ�
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
		
		//�����Ͱ� ������ classdatelst�� ������ �߰�
		int isjoined=iClassServ.ClassJoin(classname,(String)session.getAttribute("nickname"));
		
		if(isjoined==0)//�̹� ����������
		{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�̹� �����ϼ̽��ϴ�');</script>");
			out.flush();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('���ԵǾ����ϴ�.');</script>");
			out.flush();
		}
		
		
		//+ ����Ķ������ ���� ����ϱ� �߰� �ʿ�.
		
		
		//classcreatelst�� �ο� ����
		
		model.addAttribute("nickname",nickname);	
		model.addAttribute("classname",classname);
		model.addAttribute("classcontent",classcontent);
	
		
		return "forward:/class/ClassDetailProc";
	}
	
	
	@RequestMapping(value = "/getDetailClass")
	public String getDetailClass(Model model  , @RequestParam String detailname) {
		
		logger.warn(detailname);
		//�����帣�� Ŭ���� ��������
		
		  List<ClassInfo> classDetailInfo= iClassServ.getDetailClass(detailname); //���� �������� List<Float>
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
		
		//�����帣�� Ŭ���� ��������
		Map<String, Object> searchMap=new HashMap<String, Object>();
		searchMap.put("word", word);
		searchMap.put("line",line);
		
		
		
		
		 List<ClassInfo> classDetailInfo= iClassServ.ClassSearch(searchMap); //���� �������� List<Float>
		  List<Float>  starvalue;
		  
		  if(classDetailInfo.size()!=0) {
			  starvalue= iClassServ.getStarVal(classDetailInfo);
			  model.addAttribute("starvalue",starvalue);	 	 
		  }
		  model.addAttribute("classLst", classDetailInfo);
		
		
		return "forward:/index?formpath=classMain";
	}
	
}

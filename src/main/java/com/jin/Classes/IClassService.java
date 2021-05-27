package com.jin.Classes;

import java.util.List;
import java.util.Map;

public interface IClassService {

	public List<ClassInfo> ClassMainProc();

	public List<Float> getStarVal(List<ClassInfo> classInfo);

	public List<ClassInfo> getDetailClass(String detailname);

	public List<ClassInfo> ClassSearch(Map<String, Object> searchMap);

	public List<Classreviews> getReview(String classname);

	public List<Classcreateinfo> getCreateList(String classname);

	public int ClassJoin(String classname, String nickname);

	public void ClassDetailCreate(Classcreateinfo info);

	public void SaveReview(Classreviews classreviews);

	public void ClassCreate(ClassInfo classinfo);

	
	
}

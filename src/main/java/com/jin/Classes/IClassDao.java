package com.jin.Classes;

import java.util.List;
import java.util.Map;

public interface IClassDao {

	public List<ClassInfo> ClassMainProc();

	public List<Float> getStarVal(List<ClassInfo> classInfo);

	public List<ClassInfo> getDetailClass(String detailname);

	public List<ClassInfo> ClassSearch(Map<String, Object> searchMap);

	public List<Classreviews> getReview(String classname);

	public List<Classcreateinfo> getCreateList(Map<String, Object> getListMap);

	public void ClassJoin(Map<String, Object> joinMap);

	public int findNickname(Map<String, Object> joinMap);

	public int getrecentDate(Map<String, Object> joinMap);

	public void ClassDetailCreate(Classcreateinfo info);

	public void SaveReview(Classreviews classreviews);

	public void ClassCreate(ClassInfo classinfo);

	public void increaseJoinMember(Map<String, Object> joinMap);

	
}

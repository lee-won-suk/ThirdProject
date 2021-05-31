package com.jin.Main;

import java.util.List;
import java.util.Map;

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;

public interface IMainDao {

	public Float getMainSocial(Map<String, Object> lstMap);

	public List<Socialmeeting> getTotalSocial(int date);

	public Socialmeeting getSocial(String mname);

	public List<ClassInfo> getClasses();

	public String getUsrgenre(String id);

	public List<Socialmeeting> getUsrsocial(List<String> usrgenre);

	public List<ClassInfo> getUsrClass(List<String> usrgenre);

}

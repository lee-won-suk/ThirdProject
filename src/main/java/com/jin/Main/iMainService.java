package com.jin.Main;

import java.util.List;

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;
import com.jin.Social.SocialCreateInfo;

public interface iMainService {

	public List<Socialmeeting> getMainSocial();

	public List<ClassInfo> getMainClass();

	public List<String> getUsrgenre(String id);

	public List<Socialmeeting> getUsrsocial(List<String> usrgenre);

	public List<ClassInfo> getUsrClass(List<String> usrgenre);

	public List<SocialCreateInfo> nowUsrList(String attribute);

	public List<ClassInfo> getRecommendClass();

}

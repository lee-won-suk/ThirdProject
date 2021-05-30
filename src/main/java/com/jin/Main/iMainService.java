package com.jin.Main;

import java.util.List;

import com.jin.Classes.ClassInfo;
import com.jin.Classes.Classcreateinfo;

public interface iMainService {

	public List<Socialmeeting> getMainSocial();

	public List<ClassInfo> getMainClass();

	public List<String> getUsrgenre(String id);

	public List<Socialmeeting> getUsrsocial(List<String> usrgenre);

}

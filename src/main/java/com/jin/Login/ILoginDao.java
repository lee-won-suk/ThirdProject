package com.jin.Login;

public interface ILoginDao {

	
	public int LoginProc(Member member);

	public String getNickname(String id);
}

package com.jin.Membership;

public interface IMemberService {
	//아이디 중복확인
	public String IdCheck(Member member);
	//닉네임 중복확인
	public String NicknameCheck(Member member);
	//인증번호
	public void sendAuth(Member member);
	//인증번호 확인
	public String authConfirm(String authNum);
	//가입
	public String MemberProc(Member member, choiceMember cmember);
}

package com.jin.Membership;



public interface IMemberDao {
	public int IdCheck(String id);
	public int NicknameCheck(String nickname);
	public void InsertMember(Member member);
	public void InsertChoiceMember(choiceMember cmember);
}

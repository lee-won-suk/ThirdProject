package com.jin.Membership;

public interface IMemberService {
	//���̵� �ߺ�Ȯ��
	public String IdCheck(Member member);
	//�г��� �ߺ�Ȯ��
	public String NicknameCheck(Member member);
	//������ȣ
	public void sendAuth(Member member);
	//������ȣ Ȯ��
	public String authConfirm(String authNum);
	//����
	public String MemberProc(Member member, choiceMember cmember);
}

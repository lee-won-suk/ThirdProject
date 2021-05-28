package com.jin.Membership;

public class choiceMember extends Member{
	  // 아이디 
    private String id;

    // 성별 
    private String gender;

    // 지역 
    private String addr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}

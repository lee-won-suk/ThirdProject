package com.jin.Social;

public class SocialCreateInfo {
	 // 모임명 
    private String mname;

    // 개최모임내용 
    private String mcdetails;

    // 모임일정날짜 
    private Integer mdate;

    // 장소 
    private String mplace;

    // 시간 
    private Integer mstarttime;

    // 종료시간 
    private Integer mendtime;

    // 모임유형 
    private Integer monline;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMcdetails() {
        return mcdetails;
    }

    public void setMcdetails(String mcdetails) {
        this.mcdetails = mcdetails;
    }

    public Integer getMdate() {
        return mdate;
    }

    public void setMdate(Integer mdate) {
        this.mdate = mdate;
    }

    public String getMplace() {
        return mplace;
    }

    public void setMplace(String mplace) {
        this.mplace = mplace;
    }

    public Integer getMstarttime() {
        return mstarttime;
    }

    public void setMstarttime(Integer mstarttime) {
        this.mstarttime = mstarttime;
    }

    public Integer getMendtime() {
        return mendtime;
    }

    public void setMendtime(Integer mendtime) {
        this.mendtime = mendtime;
    }

    public Integer getMonline() {
        return monline;
    }

    public void setMonline(Integer monline) {
        this.monline = monline;
    }
}

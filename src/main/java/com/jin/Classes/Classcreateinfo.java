package com.jin.Classes;

//클래스추가DB 
public class Classcreateinfo {

 // 클래스명 
 private String classname;

 // 날짜 
 private Integer cdate;

 // 장소 
 private String place;

 // 인원 
 private Integer cpeople;

 // 시간 
 private Integer starttime;

 // 종료시간 
 private Integer endtime;

 public String getClassname() {
     return classname;
 }

 public void setClassname(String classname) {
     this.classname = classname;
 }

 public Integer getCdate() {
     return cdate;
 }

 public void setCdate(Integer cdate) {
     this.cdate = cdate;
 }

 public String getPlace() {
     return place;
 }

 public void setPlace(String place) {
     this.place = place;
 }

 public Integer getCpeople() {
     return cpeople;
 }

 public void setCpeople(Integer cpeople) {
     this.cpeople = cpeople;
 }

 public Integer getStarttime() {
     return starttime;
 }

 public void setStarttime(Integer starttime) {
     this.starttime = starttime;
 }

 public Integer getEndtime() {
     return endtime;
 }

 public void setEndtime(Integer endtime) {
     this.endtime = endtime;
 }


}
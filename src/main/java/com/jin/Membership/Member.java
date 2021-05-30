package com.jin.Membership;

//필수항목 
public class Member {

 // 아이디 
 private String id;

 // 패스워드 
 private String pw;

 // 이메일 
 private String email;

 // 장르 
 private String genre;

 // 휴대폰번호 
 private String phoneno;

 // 닉네임 
 private String nickname;

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getPw() {
     return pw;
 }

 public void setPw(String pw) {
     this.pw = pw;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getGenre() {
     return genre;
 }

 public void setGenre(String genre) {
     this.genre = genre;
 }

 public String getPhoneno() {
     return phoneno;
 }

 public void setPhoneno(String phoneno) {
     this.phoneno = phoneno;
 }

 public String getNickname() {
     return nickname;
 }

 public void setNickname(String nickname) {
     this.nickname = nickname;
 }

}
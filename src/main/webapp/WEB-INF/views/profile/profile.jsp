<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<center>
<form action="${home }board/${proc}" method="post" >
<table border="1" style="width: 800px;" >
   <tr>
      <td align="center" colspan="2">
         <input type="image" > 
      </td>
      <td align="center"  colspan="2">
      	리워드 이미지 
         <br/><br/><br/><br/>
      </td>
   </tr>
   
   <tr align="center">      
      <td >title</td>   
      <td>id</td>
      <td>소셜 모임 리스트 
      	<br/><br/>
      </td>
      <td><input type="button" value="탈퇴"></td>
   </tr>
   
   <tr align="center">
      <td colspan="2">
         <input  type="button" value="회원정보 수정"/>
      </td>
      <td>참가 예정 리스트
      	<br/><br/>
      </td>
      <td><input type="button" value="취소"></td>
   </tr>   
   
</table>
</form>
</center>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>
<center>
<form action="${home }" method="post" >
<input type="hidden" name="nickname" value='${nickname}'		/>
<table class="classDatail" style="width: 1200px;"  border="1" >
	<tr align="center" >
		<td style="width: 80px; height:40px;" ></td>
		<td style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
		<td  style="width: 80px; height:40px;"></td>
	</tr>
	

	
	<tr align="center">
		<td   colspan="4" rowspan="4">
		<img style="width:150px;height: 200px;"	 />		
		<br/>타이틀<br/> ${nickname}<br/>

	
		<button style="width: 140px;">회원정보 수정</button>	
		
		</td>
		
		<td    style="width: 80px; height:40px;" colspan="5"  >
		<div style="width: 600px; border: 1px solid"	>
		보유중인 뱃지<br/>
		ac
		</div>	
		
		</td>				
	</tr>

	<tr >
		
		<td  align="center" style="width: 80px; height:40px;" colspan="5"  >

		<br/><br/>
		<div style="width:600px; border: 1px solid"	>
		가입 소셜모임 리스트 <br/>
		<c:forEach var="joinSocialList" items="${joinSocialList}"  >
		${joinSocialList.mname}<br/>
		</c:forEach>
		
		</div>	
		<div> <button>탈퇴</button></div>
		<br/><br/>
		
		
		<div style="width: 600px; border: 1px solid"	>
		참가예정 소셜모임 /클래스 리스트<br/>
		
		<c:forEach var="futureSocialList" items="${futureSocialList}"  >
		${futureSocialList.mname} ${futureSocialList.mdate}	<br/>
		</c:forEach>	
		
		<c:forEach var="futureclassList" items="${futureclassList}"  >
		${futureclassList.classname} ${futureclassList.cdate}<br/>
		</c:forEach>
		
		</div>	
		 <button>취소</button>
			</td>
		</tr>
	</table>

	

</form>
</center>
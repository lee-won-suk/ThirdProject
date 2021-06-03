<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<head>
	<link rel="stylesheet" href="${home}resources/css/classdetail.css" type="text/css">
</head>

<center>
<form action="${home }" method="post" >
<input type="hidden" name="nickname" value='${nickname}'		/>
<table class="classDatail" style="width: 1300px;"   >
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
	<td  style="width: 80px; height:40px;"></td>
	<td  style="width: 95px; height:40px;"></td>
	<td class="className1" style= "width:600px;" colspan="5"  >모임사진<br/><br/></td>
	</tr>

	
	<tr align="center">
		<td    style="width: 80px; height:40px;" colspan="5"  >
		<div align="center" style="width:600px; height:200px; border: 1px solid ; ">
		모임 소개글
		<img src="${home}/resources/assets/img/${classname}.jpg"  style="width:600px; height:200px;"/>
		</div>
		<br/>
		<div align="center" style="width:600px; height:200px; border: 1px solid ; ">
			모임 멤버 리스트
		</div>
		</td>
		
		<td   colspan="4" rowspan="4">
		개최 예정 소모임 리스트
		<div class="test1"  >
		<br/><br/>
		<c:forEach var="createList" items="${createList}" varStatus="status"  >
		
		<div  class="test2"  >내용 ${dateLst[status.index][0]}년${dateLst[status.index][1]}월${dateLst[status.index][2]}일  
		<br/>날짜${createList.starttime}
		<br/> 시간${createList.place} 장소${createList.cpeople}
		</div>
		<br/><br/>
		</c:forEach>
		
		
		
		</div>
		<c:if test="${!empty createList   && !empty id  }"   >
		<button  formaction="${home}class/ClassJoin?classname=${classname}&&classcontent=${classcontent}"  style="width: 100px; ">참가 신청</button>
		</c:if>
		
		
		<button formaction="${home}/index?formpath=CreateInnerSocial" style="width: 140px;">소모임 개최</button>	
		</td>
		
				
	</tr>

	<tr >
		<td   style="width: 80px; height:40px;" colspan="5"  >
		<hr/>
		${classcontent}
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		</td>
			
	</tr>
	</table>

	
	<table class="classDatail" style="width: 1000px;"   >
	
	<tr align="center" >
	
		<td   style="width: 80px; height:40px;" colspan="5"  >
		
		<c:forEach var="reviews" items="${reviews}" >
		
		 <div  class="border-bottom">		 
		 <div  class="block">
		 <div  class="cname">${reviews.nickname} 님  &nbsp${reviews.starvalue } </div> 
		</div>	
		</div> 
		<div data-v-6ae11e50="" class="Ccontents" style="white-space: pre-line;">${reviews.review}</div> 
		<br/>
		
		</c:forEach>
		</td>

		<td   style="width: 80px; height:40px;"></td>
		<td   style="width: 80px; height:40px;"></td>
		<td   style="width: 80px; height:40px;"></td>
	</tr>
</table>
</form>
</center>
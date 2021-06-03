<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url var="home" value="/"/>
<head>
	<link rel="stylesheet" href="${home}resources/css/classmain.css" type="text/css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
let count=0;
$(document).ready(function(){
	$(".leftmove").click(function() {		
		$(".topbutton1").prop('hidden', false);
		$(".topbutton2").prop('hidden', true);		
	})
	
	$(".rightmove").click(function() {		
		$(".topbutton1").prop('hidden', true);
		$(".topbutton2").prop('hidden', false);		
	})
	
	$("#searchgenre").click(function() {		
	
     var searchword=$("#searchWord").val();
     var line=$("input:checkbox[class='line']:checked").val();
    	 

   
     
     
     $(location).attr('href', ${home}+"class/ClassSearch?word="+searchword+"&&line="+line);
     
	})
	
	
	
	
	$(".topbutton1").click(function() {		
		var detailgenre= $(this).attr('value').split(" ");	
	
	
		$("#genredetail").html("");
		
		
		for (var i = 0; i <detailgenre.length; i++) {
			  
			$("#genredetail").append("<a href="+${home}+"class/getDetailClass?detailname="+detailgenre[i]+"  >"+detailgenre[i]+"</a>");
			$("#genredetail").append("<br/><br/>");
		     
		
			};	
	})
	
	$(".topbutton2").click(function() {		
		var detailgenre= $(this).attr('value').split(" ");	
	
	
		$("#genredetail").html("");
		
		
		for (var i = 0; i <detailgenre.length; i++) {
			  
			$("#genredetail").append("<a href="+${home}+"class/getDetailClass?detailname="+detailgenre[i]+"  >"+detailgenre[i]+"</a>");
			$("#genredetail").append("<br/><br/>");
			};	
	})
	
	
	
	
	

});

</script>

<center>
<form id="frm" action="${home }board/${proc}" method="post" >
	<hr/>
	<table style="width:1300px;"  >
	<tr align="center"  border="1" >
		<td  style="width: 80px; height:40px;"></td>
		
		<td >
		<button type="button" class="leftmove" color="transparent">
		<span class="sc-eCssSg hmocIu"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path fill-rule="evenodd" d="M15.5 5.5l-6 6.5 6 6.5L14 20l-7.5-8L14 4l1.5 1.5z" fill="#1a1a1a"></path></svg></span></button>
		</td>
		
		
		
		<td><button type="button" class="topbutton1" value="한식 양식 중식 일식 베이킹/제과" >요리</button></td>
		<td><button type="button"  class="topbutton1" value="가죽 목공 도예 조향 캔들 비누 기타" >공예</button></td>
		<td><button type="button" class="topbutton1" value="보컬 작곡 디제잉 악기" >음악</button></td>
		<td><button type="button" class="topbutton1" value="영어 중국어 일본어 기타언어" >외국어</button></td>
		<td><button type="button"  class="topbutton1" value="방송댄스 무용 스트릿댄스" >댄스</button></td>
		
		<td><button type="button"  hidden="true" class="topbutton2" value="온라인 모바일 콘솔" >게임</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="등산/트레킹 낚시 클라이밍 사냥" >레저/엑티비티</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="영화 공연/연극 뮤지컬/오페라" >문화생활</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="주식 부동산 비트코인 부업" >제태크</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="축구 야구 농구" >스포츠</button></td>
		
	<td>
	<button type="button" class="rightmove" 
	color="transparent"><span class="sc-eCssSg hmocIu"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path fill-rule="evenodd" d="M8.5 18.5l6-6.5-6-6.5L10 4l7.5 8-7.5 8-1.5-1.5z" fill="#1a1a1a"></path></svg></span></button>
		</td>
	
	
	<td><button 
	formaction="${home}/index?formpath=CreateSocial"  class="topbutton3"  >모임생성</button></td>
	
	
	
	</tr>
	</table>
	
	
	<br/><br/><br/><br/>
	
	
	
	
	
	<div  class="content" ng-show="!klass.purchase &amp;&amp; klass.prices &amp;&amp; !showing_live&amp;&amp; !klass.checking_demand" 
	style="width: 20%; height:500px;  float: left;">
	 <div class="position-relative d-flex text-left bg-gray-100 border rounded w-100">
              <input type="search" id="searchWord" name="query" placeholder="검색" class="Search" > 
              <button type="button" id="searchgenre"   style="line-height: 26px; margin-top: 1px; margin-right: 1px; margin-bottom: 1px;"><img src="https://d1t14blt4pnnxx.cloudfront.net/static/images/icn-search-line-gray-700.svg" class="search-input__icon">
              </button></div>
                세부장르<br/><br/>
                <div id="genredetail"></div>
	</div>
	<div style="width: 75%;  float: right;">
	<table style="width: 1000px;"  >
	<br/><br/>
	
	
	<c:set var="i" value="0" />
 <c:set var="j" value="2" />

  <c:choose>
   <c:when test="${socialLst != null && fn:length(socialLst) > 0 }">
    <c:forEach var="socialLst" items="${socialLst}" varStatus="status" >
     <c:if test="{i%j == 0}">
      <tr align="center">
     </c:if>
     <td>
    <a 	href="${home}social/MoimMainProc">
    <img src="${home}/resources/assets/img/${socialLst.mname}.jpg"	 style="width: 300px; height:200px;"/></a>
		
		<br/>
		${socialLst.mname}<br/>
		
		<br/>
		지역(수정중) ${socialLst.mcity} 
		</td>
    <c:if test="${i%j == j-1}">
     </tr><tr><td><br/></td></tr>
    </c:if> 
   <c:set var="i" value="${i+1}" />
    </c:forEach>
   </c:when>
  <c:otherwise>
   <tr>
    <td>존재하지 않습니다.</td>
   </tr>
  </c:otherwise>
  </c:choose>
</table>
	
	
	</div>
	
	
	
	
	

</form>
</center>
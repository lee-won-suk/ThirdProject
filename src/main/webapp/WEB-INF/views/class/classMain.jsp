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
		
		
		
		<td><button type="button" class="topbutton1" value="?????? ?????? ?????? ?????? ?????????/??????" >??????</button></td>
		<td><button type="button"  class="topbutton1" value="?????? ?????? ?????? ?????? ?????? ?????? ??????" >??????</button></td>
		<td><button type="button" class="topbutton1" value="?????? ?????? ????????? ??????" >??????</button></td>
		<td><button type="button" class="topbutton1" value="?????? ????????? ????????? ????????????" >?????????</button></td>
		<td><button type="button"  class="topbutton1" value="???????????? ?????? ???????????????" >??????</button></td>
		
		<td><button type="button"  hidden="true" class="topbutton2" value="????????? ????????? ??????" >??????</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="??????/????????? ?????? ???????????? ??????" >??????/????????????</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="?????? ??????/?????? ?????????/?????????" >????????????</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="?????? ????????? ???????????? ??????" >?????????</button></td>
		<td><button type="button"  hidden="true" class="topbutton2" value="?????? ?????? ??????" >?????????</button></td>
		
	<td>
	<button type="button" class="rightmove" 
	color="transparent"><span class="sc-eCssSg hmocIu"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path fill-rule="evenodd" d="M8.5 18.5l6-6.5-6-6.5L10 4l7.5 8-7.5 8-1.5-1.5z" fill="#1a1a1a"></path></svg></span></button>
		</td>
	
	
	<td><button 
	formaction="${home}/index?formpath=classMember"  class="topbutton3"  >????????? ??????</button></td>
	
	
	
	</tr>
	</table>
	
	
	<br/><br/><br/><br/>
	
	
	
	
	
	<div  class="content" ng-show="!klass.purchase &amp;&amp; klass.prices &amp;&amp; !showing_live&amp;&amp; !klass.checking_demand" 
	style="width: 20%; height:500px;  float: left;">
	 <div class="position-relative d-flex text-left bg-gray-100 border rounded w-100">
              <input type="search" id="searchWord" name="query" placeholder="??????" class="Search" > 
              <button type="button" id="searchgenre"   style="line-height: 26px; margin-top: 1px; margin-right: 1px; margin-bottom: 1px;"><img src="https://d1t14blt4pnnxx.cloudfront.net/static/images/icn-search-line-gray-700.svg" class="search-input__icon">
              </button></div>
				?????? <input type="checkbox" class="line"  value="1" />?????????
					<input type="checkbox" class="line"   value="0" />????????????<br/> 
                <hr>
                ????????????<br/><br/>
                <div id="genredetail"></div>
	</div>
	<div style="width: 75%;  float: right;">
	<table style="width: 1000px;"  >
	<br/><br/>
	
	
	<c:set var="i" value="0" />
 <c:set var="j" value="2" />

  <c:choose>
   <c:when test="${classLst != null && fn:length(classLst) > 0 }">
    <c:forEach var="classinfo" items="${classLst}" varStatus="status" >
     <c:if test="{i%j == 0}">
      <tr align="center" style="width: 300px">
     </c:if>
     <td>
    <a 	href="${home}class/ClassDetailProc?classname=${classinfo.classname}&&classcontent=${classinfo.contents}
    &&nickname=${classinfo.nickname}"
    	><img src="${home}/resources/assets/img/${classinfo.classname}.jpg"	 style="width: 300px; height:200px;"/></a>
		
		<br/>
		${classinfo.classname}<br/>
		${classinfo.nickname} 
		<c:if test="${starvalue[status.index] ne null}">${starvalue[status.index]}</c:if>
		<c:if test="${ empty starvalue[status.index] }">0.0</c:if>  
		${classinfo.price}<br/>
		<c:if test="${classinfo.conline eq 1}">?????????</c:if>
		<c:if test="${classinfo.conline eq 0}">????????????</c:if> ??????
		</td>
    <c:if test="${i%j == j-1}">
     </tr><tr><td><br/></td></tr>
    </c:if> 
   <c:set var="i" value="${i+1}" />
    </c:forEach>
   </c:when>
  <c:otherwise>
   <tr>
    <td>???????????? ????????????.</td>
   </tr>
  </c:otherwise>
  </c:choose>
</table>
	
	
	</div>
	
	
	
	
	

</form>
</center>
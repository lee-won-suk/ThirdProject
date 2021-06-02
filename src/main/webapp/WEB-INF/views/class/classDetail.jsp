<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<head>
	<link rel="stylesheet" href="${home}resources/css/classdetail.css" type="text/css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function gocal(){
	
	
	window.open("${home}test.jsp",
            "childForm", "width=570, height=350, resizable = no, scrollbars = no");


	
}

</script>


<center>

<form id='frm'  method="get" >
<input type="hidden" id="year" value='${dateLst[0].year}'		/>
<input type="hidden" id="month" value='${dateLst[0].month}'/>
<input type="hidden" id="day" value='${dateLst[0].day}'/>
<input type="hidden" id="shour" value='${timeLst[0].hour}'/>
<input type="hidden" id="smin" value='${timeLst[0].min}'/>
<input type="hidden" id="ehour" value='${endtimeLst[0].hour}'/>
<input type="hidden" id="emin" value='${endtimeLst[0].min}'/>
<input type="hidden" id="classname" value='${classname}'/>


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
	<td class="className1" style= "width:600px;" colspan="5"  >${classname}<br/><br/></td>
	</tr>

	
	<tr align="center">
		<td    style="width: 80px; height:40px;" colspan="5"  >
		<div align="center" style="width:600px; height:200px; border: 1px solid ; ">
		<img src="${home}/resources/assets/img/${classname}.jpg"  style="width:600px; height:200px;"/>
		
		
		</div>
		
		</td>
		
		
		<td   colspan="4" rowspan="4">
		개최 예정 클래스 리스트
		<div class="test1"  >
		<br/><br/>
		<c:forEach var="createList" items="${createList}" varStatus="status"  >
		
		<div  class="test2"  >날짜 ${dateLst[status.index].year}년${dateLst[status.index].month}월${dateLst[status.index].day}일  
		<br/>시간 ${timeLst[status.index].hour} : ${timeLst[status.index].min}
		<br/> 장소${createList.place} 인원 ${createList.cpeople}명
		</div>
		<br/><br/>
		</c:forEach>
		
		
		
		</div>
		
		<c:if test="${!empty createList   && !empty id  }"   >
		<button id='authorize_button' style="width: 100px;" formaction="${home}class/ClassJoin?classname=${classname}&&classcontent=${classcontent}"
		  >참가신청</button>
		 <br/><button onclick="gocal()" >캘린더에 저장</button> 
		</c:if>
		 
		 
		
		<button formaction="${home}class/ClassMemberDetailProc?classname=${classname}&&classcontent=${classcontent}" style="width: 140px;">클래스일정 추가</button>	
		<%--
		<c:if test="${id==nickname}"   >
		<button formaction="${home}class/ClassJoin?classname=${classname}&&classcontent=${classcontent}" style="width: 100px;">클래스일정 추가</button>
		</c:if>
		--%>
		
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

		
		

   <button class="more" formaction="${home}class/WriteReview?classname=${classname}&&
   nickname=${nickname}&&classcontent=${classcontent}">
        후기 남기기
      </button>
	<button class="more">
        더보기
      </button>	
		
		




		</td>

		<td   style="width: 80px; height:40px;"></td>
		<td   style="width: 80px; height:40px;"></td>
		<td   style="width: 80px; height:40px;"></td>
	</tr>
	
	<tr align="center">
		<td  border: 1px solid   style="width: 80px; height:40px;" colspan="5"  >
		<div align="center" style="width:600px; height:200px; border: 1px solid ; ">
		<input type="image" style="width:600px; height:200px;"/>
		</div>
		</td>
		
		
	</tr>
</table>
</form>
</center>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:url var="home" value="/"/>

    <style type="text/css">

    	.fclass {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #333;
}
.fclass:after{
    content:'';
    display: block;
    clear:both;
}
#class {
    float: left;
}
#class a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
#class a:hover:not(.active) {
    background-color: #111;
}
.active {
    background-color: #4CAF50;
}
    </style>
    
    <center>
        <!-- Portfolio Grid-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">  
                 <div>
                  <c:if test="${ empty id	 }">
               		 <p align="left">인기있는 소셜 모임</p>
               		 
               		 <table style="width: 1300px"  >
               		 <tr	align="left">             		
               		 <c:forEach var="SocialList" items="${SocialList}"  >
               		 	<td >
               		 	<img src="${home}/resources/assets/img/${SocialList.mname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${SocialList.mname}<br/>
							${SocialList.mgenre} ${SocialList.mdetailgenre}<br/>							        		 		
               		 	</td>
               		 	</c:forEach> 	
               		 	</tr>
               		 	</table>
               		 	<br/><br/>
               		 	
               		 	<p align="left">현재 인기있는 클래스</p>
               		 	
               		 	<table style="width: 1300px"  >
               		 	<tr	align="left">
               		 	 <c:forEach var="classinfo" items="${ClassList}"  >
               		 	<td>
               		 	<a 	href="${home}class/ClassDetailProc?classname=${classinfo.classname}&&classcontent=${classinfo.contents}
   							 &&nickname=${classinfo.nickname}"
    				><img src="${home}/resources/assets/img/${classinfo.classname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${classinfo.classname}<br/>
							${classinfo.cgenre} ${classinfo.cdetailgenre}<br/>			        		 		
               		 	</td>
               		 	</c:forEach>
               		 	</tr>		 	
               		 </table>
               		 <br/><br/>
               		 </c:if>
               		
               		
              
              
              
              <c:if test="${ ! empty id	 }">
              		<p align="left"> ${nickname}님의 모임 소식</p>
               		 <table style="width: 1300px" >
               		 <tr	align="left">             		
               		 <c:forEach var="nowusrLst" items="${nowusrLst}"  >
               		 	<td style="width:400px">
               		 	<img src="${home}/resources/assets/img/${nowusrLst.mname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${nowusrLst.mname}<br/>
               		 		${nowusrLst.mdate}
							<br/>${nowusrLst.mstarttime} ${nowusrLst.mplace}<br/>							        		 		
               		 	</td>
               		 	</c:forEach> 	
               		 	</tr>
               		 	</table>
               		 <br/><br/>
              
              
              <p align="left">내 손으로 직접 만드는 생면 파스타 강의를 수강한 사람들이 함께 수강한 클래스</p>
               		 <table style="width: 1300px" >
               		 <tr	align="left">             		
               		 <c:forEach var="recomendClassList" items="${recomendClassList}"  >
               		 	<td style="width:400px">
               		 	<a 	href="${home}class/ClassDetailProc?classname=${recomendClassList.classname}&&classcontent=${recomendClassList.contents}
   							 &&nickname=${recomendClassList.nickname}">
   							 <img src="${home}/resources/assets/img/${recomendClassList.classname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${recomendClassList.classname}<br/>
               		 		${recomendClassList.cgenre} ${recomendClassList.cdetailgenre}						        		 		
               		 	</td>
               		 	</c:forEach> 	
               		 	</tr>
               		 	</table>
              			<br/><br/>
              
              
              
              
               		 <p align="left"> ${nickname}님께 추천드리는 소셜 모임</p>
               		 <table style="width: 1300px"  >
               		 <tr	align="left">             		
               		 <c:forEach var="usrSocialList" items="${usrSocialList}"  >
               		 	<td style="width:400px">
               		 	<img src="${home}/resources/assets/img/${usrSocialList.mname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${usrSocialList.mname}<br/>
							${usrSocialList.mgenre} ${usrSocialList.mdetailgenre}<br/>							        		 		
               		 	</td>
               		 	</c:forEach> 	
               		 	</tr>
               		 	</table>
               		 	<br/><br/>
               		 
               		 
               		 	<p align="left">${nickname}님이 추천드리는 클래스</p>
               		 	<table style="width: 1300px"  >
               		 	<tr	align="left">
               		 	 <c:forEach var="classinfo" items="${usrClassList}"  >
               		 	<td	style="width:400px">
               		 	<a 	href="${home}class/ClassDetailProc?classname=${classinfo.classname}&&classcontent=${classinfo.contents}
   							 &&nickname=${classinfo.nickname}"
    				><img src="${home}/resources/assets/img/${classinfo.classname}.jpg"	 style="width: 300px; height:200px;"/></a>
               		 		<br/>${classinfo.classname}<br/>
							${classinfo.cgenre} ${classinfo.cdetailgenre}<br/>			        		 		
               		 	</td>
               		 	</c:forEach>
               		 	</tr>		 	
               		 </table>
               		 <br/><br/> 
               		 </c:if>
               		
               		
               		
                   		 
               </div>
               
               
                
<form>
<table style="width: 1000px;"  >
	<tr>
	<c:forEach var="classinfo" items="${classLst}" varStatus="status" >
	<td>
    <a 	href="${home}class/ClassDetailProc?classname=${classinfo.classname}&&classcontent=${classinfo.contents}
    &&nickname=${classinfo.nickname}"
    	><img src="${home}/resources/assets/img/${classinfo.classname}.jpg"	 style="width: 300px; height:200px;"/></a>
		
		<br/>
		${classinfo.classname}<br/>
		${classinfo.nickname} 		
		</td>
	</c:forEach>	
		
	</tr>	
</table>
</form>
                   
                    
                    
                    
                    
                    
                </div>
                
                
            </div>
        </section>
    </center>     

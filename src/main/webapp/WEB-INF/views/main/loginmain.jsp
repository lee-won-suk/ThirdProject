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
               		 <p align="left">이용자님의 모임 소식</p>
               		 <table>
               		 	<td>
               		 		모임명<br/>
							내용<br/>
							날짜<br/>
							시간 장소           		 		
               		 	</td>
               		 	
               		 </table>
               </div>
               
               
                <div class="row">
                <p align="left">이용자님에게 인기있는 클래스</p>
                   

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

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	/*
	 * request를 통해 session을 얻어올 수 있으며 내부 인자가 
	 * true인 경우 session이 없으면 별도로 생성하고
	 * false인 경우 별도로 생성하지 않고 null을 반환함.
	 */
	HttpSession topSession = request.getSession(false);
	String sessionId = (String)topSession.getAttribute("id");
%>
<c:url var="topHome" value="/"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>메인</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${topHome}resources/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${topHome}resources/css/styles.css" rel="stylesheet" />
    </head>
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
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
               
                <a class="navbar-brand" href="${topHome}index?formpath=main/mainProc"><img src="${topHome}resources/assets/img/mainlogo.jpg" alt="..."/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto  ">
                    
                    <% if(sessionId==null){		%>
                        <li class="nav-item"><a class="nav-link" href="${topHome}index?formpath=login">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="${topHome}index?formpath=membership">회원가입</a></li>
                        	<%}else{ %>
              	    	<li class="nav-item"><a class="nav-link" href="${topHome}index?formpath=profile/profileProc">프로필</a></li>
                        <li class="nav-item"><a class="nav-link" href="${topHome}index?formpath=login/logout">로그아웃</a></li>
							<%} %>
                    </ul>
                </div>  
                  
            </div>
        </nav>
        <!-- Portfolio Grid-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div class="text-center">
                    <ul align="left" class="fclass">
   					      <li id="class"><a href="${topHome}/class/ClassMainProc">클래스</a></li>
   					      <li id="class"><a href="${topHome}social/SocialMainProc">소셜모임</a></li>
    				</ul>	
                </div>
            </div>
        </section>
        
    </body>
</html>

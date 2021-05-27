<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<center>
<h4><font color="red">${msg }</font></h4>
<form action="${home }login/loginProc" method="post">
<table style="margin: 20px" >
	<tr><td><br/><br/><br/><br/></td></tr>
	<tr>
		<td>아이디</td>
		<td><input type=text name='id' placeholder='ID 입력'/></td>
	</tr>
		<tr><td><br/></td></tr>
		
	<tr>
		<td>패스워드</td>
		<td><input type=password name='pw' placeholder='PW 입력'/></td>
	</tr>
		<tr><td><br/></td></tr>
	
	<tr>
	
	<td></td>
		<td  align='center'>
			<input type=submit value='로그인' style="width: 212px; "/>
		</td>
	</tr>
	
		<tr><td></td></tr>
	 	<tr align="center">
	 	<td></td>
	 	<td>아이디찾기/비밀번호 찾기/<br/>
	 	회원가입</td>
	 	
	 	</tr>
</table>
</form>
</center>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<center>
<form action="${home}class/SaveReview?classname=${classname}
  &&classcontent=${classcontent}" method="post">
   <input type="hidden" name="nickname" value="${nickname}"/>
<table style="width: 650px; ">
	<br/><br/><br/>
	<tr>
		<td  colspan="2" align="center">클래스 참가 리뷰를 남겨주세요.</td>
	</tr>
	<tr align="center">
		<td  style="width: 100px; height:40px;">별점</td>
		
		<td style="width: 570px; height:40px;">
			<select name="starvalue">
    <option value=0.0>0.0</option>
    <option value=0.5>0.5</option>
    <option value=1.0>1.0</option>
    <option value=1.5>1.5</option>
    <option value=2.0>2.0</option>
    <option value=2.5>2.5</option>
    <option value=3.0>3.0</option>
    <option value=3.5>3.5</option>
    <option value=4.0>4.0</option>
    <option value=4.5>4.5</option>
    <option value=5.0>5.0</option>
    </select>  	
		</td>
		
	</tr>
	
	<tr align="center">
	<td  style="width:100px; height:40px;" >리뷰</td>		
		<td  >
		<textarea name="review" style="width: 400px; height: 200px"></textarea></td>
		
	</tr>
	
	
	<tr align="center">
		<td align='center' height=40 colspan=2>
			<br/><br/>
			<input type=submit value='제출' style="width: 100px; "/>
			<input type=reset value='취소' style="width: 100px; "/>	 
		</td>
	</tr>
</table>
</form>
</center>
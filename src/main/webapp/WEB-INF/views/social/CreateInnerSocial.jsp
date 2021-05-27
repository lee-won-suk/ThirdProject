<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>소셜모임생성</title>
</head>
<body>
<table align="center">
	<tr><td>내용 <input type=text name='contents' style="text-align:center; width:300px; height:30px; letter-spacing: -5px"/></td></tr>
	<tr><td>날짜 <input type=text name='day' style="text-align:center; width:300px; height:30px; letter-spacing: -5px"/></td></tr>
	<tr><td>시간 <input type=text name='time' style="text-align:center; width:300px; height:30px; letter-spacing: -5px"/></td></tr>
	<tr>
		<td colspan="4">모임유형 &emsp;
			온라인<input type=checkbox name='gender' value='m' />
			오프라인<input type=checkbox name='gender' value='w' /> 
		</td>
	</tr>
	<tr><td>장소 <input type=text name='place' style="text-align:center; width:300px; height:30px; letter-spacing: -5px"/></td></tr>
	<tr align="center"><td><button>소모임 생성</button></td></tr>
</table>
</html>
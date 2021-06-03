<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<html>
<head>
<title>소셜모임생성</title>
</head>
<body>
<script type="text/javascript">
function openPop(){
    var popup = window.open("${home}mapForm", 'map', 'width=700px,height=800px,scrollbars=yes');
}
</script>
<form action="${home}social/MoimaddProc?mname=${mname}"  method="post">
<table align="center">
	<tr><td><input type="hidden" name='mname' value='${mname }'/>
	<input type="hidden" name='year' value='2021'/></td></tr>
	<tr><td>내용 <input type=text name='mcdetails' style="text-align:center; width:300px; height:30px; letter-spacing: -5px"/></td></tr>
	<tr><td>날짜<select name="month">
    <option value=01>01</option>
    <option value=02>02</option>
    <option value=03>03</option>
    <option value=04>04</option>
    <option value=05>05</option>
    <option value=06>06</option>
    <option value=07>07</option>
    <option value=08>08</option>
    <option value=09>09</option>
    <option value=10>10</option>
    <option value=11>11</option>
    <option value=12>12</option>
	</select> 

	<select name="day">
    <option value=01>01</option>
    <option value=02>02</option>
    <option value=03>03</option>
    <option value=04>04</option>
    <option value=05>05</option>
    <option value=06>06</option>
    <option value=07>07</option>
    <option value=08>08</option>
    <option value=09>09</option>
    <option value=10>10</option>
    <option value=11>11</option>
    <option value=12>12</option>
    <option value=13>13</option>
    <option value=14>14</option>
    <option value=15>15</option>
    <option value=16>16</option>
    <option value=17>17</option>
    <option value=18>18</option>
    <option value=19>19</option>
    <option value=20>20</option>
    <option value=21>21</option>
    <option value=22>22</option>
    <option value=23>23</option>
    <option value=24>24</option>
    <option value=25>25</option>
    <option value=26>26</option>
    <option value=27>27</option>
    <option value=28>28</option>
    <option value=29>29</option>
    <option value=30>30</option>
    <option value=31>31</option>
    	</select> </td></tr>
	<tr>
		<td align="left" style="width :200px;" >시간
	<select name="starthour">
	
	<option value=00>00</option>			
    <option value=01>01</option>
    <option value=02>02</option>
    <option value=03>03</option>
    <option value=04>04</option>
    <option value=05>05</option>
    <option value=06>06</option>
    <option value=07>07</option>
    <option value=08>08</option>
    <option value=09>09</option>
    <option value=10>10</option>
    <option value=11>11</option>
    <option value=12>12</option>
    <option value=13>13</option>			
    <option value=14>14</option>
    <option value=15>15</option>
    <option value=16>16</option>
    <option value=17>17</option>
    <option value=18>18</option>
    <option value=19>19</option>
    <option value=20>20</option>
    <option value=21>21</option>
    <option value=22>22</option>
    <option value=23>23</option>
	</select> 			
	<select name="startmin">
    <option value="30">30</option>
    <option value="00">00</option>
    </select> 		
	&nbsp;종료 시간		
	<select name="endhour">
	
	<option value=00>00</option>			
    <option value=01>01</option>
    <option value=02>02</option>
    <option value=03>03</option>
    <option value=04>04</option>
    <option value=05>05</option>
    <option value=06>06</option>
    <option value=07>07</option>
    <option value=08>08</option>
    <option value=09>09</option>
    <option value=10>10</option>
    <option value=11>11</option>
    <option value=12>12</option>
    <option value=13>13</option>			
    <option value=14>14</option>
    <option value=15>15</option>
    <option value=16>16</option>
    <option value=17>17</option>
    <option value=18>18</option>
    <option value=19>19</option>
    <option value=20>20</option>
    <option value=21>21</option>
    <option value=22>22</option>
    <option value=23>23</option>
	</select> 			
	<select name="endmin" >
    <option value=30>30</option>
    <option value=00>00</option>
    </select> 		
	</td>
	</tr>
	<tr>
		<td colspan="4">모임유형 &emsp;
			온라인<input type=checkbox name='monline' value='1' />
			오프라인<input type=checkbox name='monline' value='0' /> 
		</td>
	</tr>
	<tr><td>장소<input type="text" name="mplace"/><input type="button" onclick="openPop()" value="주소찾기"></td></tr>
	<tr align="center"><td><input type="submit" name="mplace" value="소모임 생성"/></td></tr>
</table>
</form>
</body>
</html>
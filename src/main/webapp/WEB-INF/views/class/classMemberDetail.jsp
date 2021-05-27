<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>


<center>
<h3><font color="red">${msg }</font></h3>
<form  action="${home}class/ClassDetailcreate?classname=${classname}
&&classcontent=${classcontent}&&nickname=${nickname}"  method="post">
<table>
	<tr>
		<td align='right'  height=40>날짜</td>		
		
		<td  style="width :200px;">
	<select name="year">
    <option value=2021>2021</option>
		</select> 
		
	<select name="month">
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
    	</select> 
			
		</td>	
		
		<td >
		</td>				
		<td >
		
		</td>
		
	
	</tr>
	<tr>
	
	
		<td   height=40>시작 시간</td>		
	<td align="left" style="width :200px;" >
	<select name="starthour">
	
	<option value=00>01</option>			
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
    <option value="01">30</option>
    <option value="02">00</option>
    </select> 		
	</td>


		<td align="left"  height=40>종료 시간</td>		
		<td align="left" style="width :200px;">		
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
		<td align='right'  height=40>장소</td>
		<td  colspan="3">
			<input   type=text  name='id'  style="width: 475px; height:30px"  /> 
		</td>
		
	</tr>
	<tr>
		<td align='right'>인원</td>
		<td colspan="3">
			<input type=text name='addr1' id='addr1' style="width: 475px; height:30px"/> 
		</td>
	</tr>

	<tr>
		<td align='center' height=40 colspan=4>
		<!-- get방식으로 적던가 파라미터 다르게 전달하기 -->
			<input type="submit"   value="클래스생성" style="width: 120px;"/>
			<input type=reset value='취소' style="width: 120px; "/>	 
		</td>
	</tr>
</table>
</form>
</center>
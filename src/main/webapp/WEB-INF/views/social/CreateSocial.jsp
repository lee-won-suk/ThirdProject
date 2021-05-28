<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="home" value="/"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function itemChange(){
	var dance = ["방송댄스","무용","스트릿댄스"];
	 
	var sport = ["축구","야구","농구"];
	var activity =["등산/트래킹","낚시","클라이밍","사냥"]; 
	var music = ["보컬","작곡","디제잉","악기"]; 
	var made = ["가죽","목공","도예","조향","캔들","비누","기타"];
	var foreign =["영어","중국어","일본어","기타언어"]; 	
	var game = ["온라인","모바밀","콘솔"];
	var culture =["영화","공연/연극","뮤지컬/오페라" ]; 
	var cook = ["한식","양식","중식","일식","베이킹/제과"];
	var remoney = ["주식","부동산","비트코인","부업"];
	
	var selectItem = $("#select1").val();
	var changeItem;	  
	if(selectItem == "댄스"){
	  changeItem = dance;
	}
	else if(selectItem == "스포츠"){
	  changeItem = sport;
	}
	else if(selectItem == "레저/액티비티"){
	  changeItem =  activity;
	}
	else if(selectItem == "음악"){
		  changeItem =  music;
		}
	else if(selectItem == "공예"){
		  changeItem =  made;
		}
	else if(selectItem == "외국어"){
		  changeItem =  foreign;
		}
	else if(selectItem == "게임"){
		  changeItem =  game;
		}
	else if(selectItem == "문화생활"){
		  changeItem =  culture;
		}
	else if(selectItem == "요리"){
		  changeItem =  cook;
		}
	else if(selectItem == "재테크"){
		  changeItem =  remoney;
		}
	
	
	$('#select2').empty();	 
	for(var count = 0; count < changeItem.length; count++){                
	                var option = $("<option>"+changeItem[count]+"</option>");
	                $('#select2').append(option);
	            }
	 
	}

</script>

<center>
<h3><font color="red">${msg }</font></h3>
<form action="${home }social/SocialCreate" method="post">
<table>


	<tr>
	<br/><br/><br/>
		<td align='right'  height=40>모임명</td>
		<td  colspan="3">
			<input   type=text id="mname"  name='mname' placeholder='모임 입력' style="width: 475px;"  /> 
		</td>
		
	</tr>
	<tr>
		<td align='right' height=40>장르</td>
		<td>
	<select id="select1" name="mgenre" onchange="itemChange()">
    <option ></option>
    <option value="댄스">댄스</option>
    <option value="스포츠">스포츠</option>
    <option value="레저/액티비티">레저/액티비티</option>
    <option value="음악">음악</option>
    <option value="공예">공예</option>
    <option value="외국어">외국어</option>
    <option value="게임">게임</option>
    <option value="문화생활">문화생활</option>
    <option value="요리">요리</option>
    <option value="재테크">재테크</option>
    </select>  
		</td>
		<td align='right'>세부 장르</td>
		<td>
			<select id="select2" name="mdetailgenre"  ></select> 
		</td>
	</tr>
	<tr>
		<td align='right' height=40>지역</td>
		<td colspan="2" >
			<input type=text name='mcity' placeholder='지역 입력'  style="width: 300px;" /> 
		</td>
	</tr>
	
	
	<tr>
		<td align='right'>모임 설명</td>
			<td  colspan="3" >
		<textarea name="mdetails" style="width: 475px; height:100px"></textarea></td>
	</tr>

	<tr>
		<td align='right' width=120>사진 업로드</td>
		<td >
		<td align='right' height=40 colspan=2>
			<input type=file name="uploadfile" style="width: 300px; "/> 
		</td>
		</td>
		
		
		
	</tr>
	
	<tr>
		<td align='center' height=40 colspan=4>
			<input type=submit value='소셜 모임 생성' style="width: 120px; "/>
			<input type=reset value='취소' style="width: 120px; "/>	 
		</td>
	</tr>
</table>
</form>
</center>
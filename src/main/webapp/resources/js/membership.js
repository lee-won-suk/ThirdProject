//비밀번호 일치여부 확인
function test() {
	var p1 = document.getElementById('pw').value;
	var p2 = document.getElementById('pwok').value;

	if (p1.length < 6) {
		alert('입력한 글자가 6글자 이상이어야 합니다.');
		return false;
	}

	if (p1 != p2) {
		alert("비밀번호불일치");
		return false;
	} else {
		alert("비밀번호가 일치합니다");
		return true;
	}
}

//약관 동의여부 확인
function chk() {
	var agree = document.form.agree.checked;
	var num = 0;
	if (agree == true) {
		num = 1;
	}
	if (num == 1) {
		document.form.submit();
	} else {
		alert("개인정보 약관에 동의하셔야 합니다.");
	}
}


//동적 select box 설정
function populate(s1, s2) {
	var s1 = document.getElementById(s1);
	var s2 = document.getElementById(s2);

	s2.innerHTML = "";

	if (s1.value == "seoul") {
		var optionArray = ['강남구|강남구', '송파구|송파구', '서초구|서초구', '강동구|강동구',
			'동작구|동작구', '관악구|관악구', '영등포구|영등포구', '강서구|강서구',
			'양천구|양천구', '구로구|구로구', '금천구|금천구', '종로구|종로구', '중구|중구',
			'마포구|마포구', '용산구|용산구', '성동구|성동구', '광진구|광진구', '은평구|은평구',
			'서대문구|서대문구', '성북구|성북구', '강북구|강북구', '도봉구|도봉구', '노원구|노원구'];
	} else if (s1.value == 'incheon') {
		var optionArray = ['서구|서구', '북구|북구', '연수구|연수구', '남구|남구'];
	}
	for (var option in optionArray) {
		var pair = optionArray[option].split("|");
		var newoption = document.createElement("option");

		newoption.value = pair[0];
		newoption.innerHTML = pair[1];
		s2.options.add(newoption);
	}
}




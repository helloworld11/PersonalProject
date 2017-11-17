<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css?v=5" rel="stylesheet" type="text/css">
<link href="css/Login.css?v=4" rel="stylesheet" type="text/css">
<link href="css/Join.css?v=3" rel="stylesheet" type="text/css">

</head>
<body>
	<!-- 헤더파일들어가는 곳 -->
	<jsp:include page="../inc/top.jsp" />
	<!-- 헤더파일들어가는 곳 -->
	<!-- 본문 -->
    <div class="secondmenu">
            <div><p id="join">회원가입</p></div>
            <div id="menu2">
                <p>아이디</p>
                <p>비밀번호</p>
                <p>비밀번호 확인</p>
                <p>비밀번호 확인 질문</p>
                <p>비밀번호 확인 답변</p>
                <p>이름</p>
                <p>주소</p>
            </div>
            <div id="form2">
                <form>
                    <p><input type="text" name="id"> <input type="button" value="Check" /> (영문소문자/숫자, 4~16자)</p>
                    <p><input type="password" name="pw" /> (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자~16자)</p>
                    <p> <input type="password" name="re_pw" /></p>
                    <select name="pw_question">
                        <option value="q1">기억에 남는 추억의 장소는?</option>
                        <option value="q2">자신의 인생 좌우명은?</option>
                        <option value="q3">자신의 보물 제1호는?</option>
                        <option value="q4">가장 기억에 남는 선생님 성함은?</option>
                        <option value="q5">타인이 모르는 자신만의 신체비밀이 있다면?</option>
                        <option value="q6">추억하고 싶은 날짜가 있다면?</option>
                        <option value="q7">받았던 선물 중 기억에 남는 독특한 선물은?</option>
                        <option value="q8">유년시절 가장 생각나는 친구 이름은?</option>
                        <option value="q9">인상 깊게 읽은 책 이름은?</option>
                        <option value="q10">읽은 책 중에서 좋아하는 구절이 있다면?</option>
                    </select>
                    <p><input type="text" name="pw_answer" /> </p>
                    <p><input type="text" name="name" /> </p>
                    <p><input type="text" name="zip" size="6" /> <input type="button" value="Zipcode" />  </p>
                    <p><input type="text" name="address1" /> 기본주소 </p>
                    <p><input type="text" name="address2" /> 나머지주소 </p>
                </form>
            </div>
            <div id="menu3">
                <p>휴대전화</p>
                <p>일반전화</p>
                <p>SMS 수신여부</p>
                <p>이메일</p>
                <p>뉴스메일</p>
            </div>
            <div id="form3">
                <p>
                    <select name="PhoneNo">
                        <option value="010">010</option>
                        <option value="017">017</option>
                        <option value="017">011</option>
                    </select>
                    - 
                    <input type="text" name="PhoneNo1" size="3" />
                    -
                    <input type="text" name="PhoneNo2" size="3" />
                </p>

                <p>
                    <select name="Tel">
                        <option value="02">02</option>
                        <option value="031">031</option>
                        <option value="051">051</option> (유선번호 항목은 선택사항 입니다.)
                    </select>
                    -
                    <input type="text" name="Tel1" size="3" />
                    -
                    <input type="text" name="Tel2" size="3" />
                </p>
                <p style="line-height:10%;"><input type="radio" name="sms" value="smsY" /> 수신함 <input type="radio" name="sms" value="smsN" /> 수신안함 </p>
                <p style="line-height:10%;"> 쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.</p>
                <p style="line-height:10%;">
                    <input type="text" name="email1" /> @ <input type="text" name="email2"/>
                    <select name="email2">
                        <option value="naver">naver.com</option>
                        <option value="daum">daum.net</option>
                        <option value="nate">nate.com</option>
                        <option value="hotmail">hotmail.com</option>
                        <option value="gmail">gamil.com</option>
                    </select><br />
                </p>
                <p style="line-height:10%;"> 주문 및 배송확인 정보 등이 E-mail로 발송되므로 반드시 수신가능한 E-mail 주소를 입력하여 주십시오.<br /></p>
                <p>
                    뉴스 메일을 받으시겠습니까? <input type="radio" name="email" />수신함 <input type="radio" name="email" />수신안함
                </p>
            </div>
        </div>
        <div><p id="additionalinfo">추가정보</p></div>
        <br />
        <div id="menu4"><p>생년월일 </p></div>
        <div id="form4">
            <form>
                <p>
                    <input type="text" name="year" size="4" />&nbsp;&nbsp;년&nbsp;&nbsp;<input type="text" name="month" size="4" />&nbsp;&nbsp;월&nbsp;&nbsp;
                    <input type="text" name="day" size="4" />&nbsp;&nbsp;일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="yangruck" value="yangruck"/> 양력
                    <input type="radio" name="yangruck" value="umruck" /> 음력
                </p>
            </form>
        </div>
        <br />
        <br />
        <br />
        <br />



<div class="btn_div">
<input type="submit" value="회원가입">
<input type="button" value="취소">
</div>
	<!-- 본문 -->
	<!-- 푸터 들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp" />
	<!-- 푸터 들어가는 곳 -->
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/default.css?v=4" rel="stylesheet" type="text/css">
<link href="css/front.css?v=0" rel="stylesheet" type="text/css">
<link href="css/Login.css?v=3" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/Login.js"></script>
<script type="text/javascript" src="js/Main_slider.js"></script>
<script src="js/jquery-3.2.1.js"></script>

</head>
<body>
	<!-- 헤더파일들어가는 곳 -->
	<jsp:include page="../inc/top.jsp" />



	<!-- 헤더파일들어가는 곳 -->
	<!-- 본문 -->
	<div id="Main_slide">
		<div id="Main_slide_img">
			<img class="Main_Bigimage" src="images/Main/Main_Image1.jpg"
				width="1000px" height="740px"> <img class="Main_Bigimage"
				src="images/Main/Main_Image2.jpg" width="1000px" height="740px">
			<img class="Main_Bigimage" src="images/Main/Main_Image3.jpg"
				width="1000px" height="740px"> <img class="Main_Bigimage"
				src="images/Main/Main_Image4.jpg" width="1000px" height="740px">
		</div>
		<div class="slider_nav">
			<div class="slider_arrow slider_arrow__left" onclick="plusIndex(-1)"></div>
			<div class="slider_arrow slider_arrow__right" onclick="plusIndex(1)"></div>
		</div>
		<div class="slider_control-nav"></div>
	</div>
	</div>
	<ul id="Main_List">
		<li>
			<div class="p_box">
				<div id="Main_image">
					<a href="#"><img src="images/Main/EXID.jpg" width="100%"
						height="200px"></a>

				</div>
				<div class="Main_image_info">
					<div>
						<h4>EXID 무대의상</h4>
					</div>
					<div>
						<h5>128,600원</h5>
					</div>
				</div>
			</div> <input type="button" value="1231123" onclick="autoSlide()">
			<script type="text/javascript">
				autoSlide();
			</script>
		</li>
	</ul>
	<!-- 본문 -->
	<!-- 푸터 들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp" />
	<!-- 푸터 들어가는 곳 -->
</body>
</html>
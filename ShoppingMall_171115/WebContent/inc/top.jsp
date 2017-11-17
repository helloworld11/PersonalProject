<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<header id="header" class ="header">

  <div class="top" id="header_Login">
    <a href="#" class="navLink" onclick="document.getElementById('id01').style.display='block'">Login&Join</a>
    <a href="#">JOIN US</a>
    <a href="#">CART</a>
    <a href="#">QNA</a>
    
  </div>
  
<div id="id01" class="modal">
  
  <form class="modal-content animate">


    <div class="container">
      <label><b>아이디</b></label>
      <input type="text" placeholder="아이디" name="uname" required>

      <label><b>비밀번호</b></label>
      <input type="password" placeholder="비밀번호" name="psw" required>
        
      <button type="submit" >로그인</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">취소</button>
       <button type="button" onclick="location.href='./Joinreg.me'" class="cancelbtn">회원가입</button>
      
      <span class="psw"> <a href="#">아이디찾기</a>
      <span class="psw"> <a href="#">비밀번호찾기</a></span>
    </div>
  </form>
</div>








	<!-- 로고들어가는 곳 -->
	<div id="header_logo">
		<img src="images/Main/Logo.png" alt="catshop">
	</div>
	<!-- 로고들어가는 곳 -->
	<nav id="header_menu">
		<ul>
			<li><a href="#">OUTER</a></li>
			<li><a href="#">TOP</a></li>
			<li><a href="#">BOTTOM</a></li>
			<li><a href="#">SKIRT/OPS</a></li>
			<li><a href="#">SHOES/BAG</a></li>
			<li><a href="#">ACC</a></li>
			<li><a href="#">SALE</a></li>
		</ul>
	</nav>
	<div class="clear"></div>

</header>
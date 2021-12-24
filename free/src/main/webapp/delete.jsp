<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jungeun_free.domain.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Div'in Korea</title>
<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
<body>
	<div align="center">
	<br><br><br>
	<header class="text-dark" style="text-align:center;">Resign Membership</header>
	<br><br>
	
	<form action="http://localhost:8080/jungeun_free/MemberServlet?cmd=delete" method="post">
	
		<%
			MemberVO member = (MemberVO)request.getAttribute("member");
		%>
		<fieldset>
			<legend style="text-align:center; font-family:'Jeju Myeongjo', serif; color:white; background-color:#212529">Account Verification</legend>
			
			<div>
				<table>
				<tr><td id="td" style="text-align:right;">ID:</td> <td id="td"><input type="text" name="id" value=<%=member.getID()%> readonly></td></tr>
				<tr><td id="td" style="text-align:right;">PASSWORD:</td> <td id="td"><input type="password" name="passwd" value="" autofocus required placeholder="비밀번호를 입력하세요"></td></tr>
				
				</table>
			</div>
		</fieldset>
		<br>
		<fieldset>
			<input type="submit" name="submit" value="최종 탈퇴">						
		</fieldset>	

	
	</form>
	</div>
	<section class="py-4">
        <div class="container my-4">
            <div class="row justify-content-center">
			</div>
		</div>
	</section>
	<footer class="py-4 bg-dark">
        <div class="container">
        <p class="m-0 text-center text-white">
        <a style="color:white" href="index.html">메인 페이지로 이동</a></p></div>
   </footer>

</body>
</html>
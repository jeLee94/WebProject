<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jungeun_free.domain.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
<body>
	<div align="center">
	<br><br><br>
	<header class="text-dark" style="text-align:center;">Member Update</header>
	<br><br>
	<form action="http://localhost:8080/jungeun_free/MemberServlet?cmd=update" method="post">
	
		<%
			MemberVO member = (MemberVO)request.getAttribute("member");
			%>
		<fieldset>
			<legend style="text-align:center; font-family:'Jeju Myeongjo', serif; color:white; background-color:#212529">Information Update</legend>
			
			<div>
				<table>
				<tr><td id="td" style="text-align:right;">ID:</td> <td id="td"><input type="text" name="id" value=<%=member.getID()%> readonly></td></tr>
				<tr><td id="td" style="text-align:right;">PASSWORD:</td> <td id="td"><input type="password" name="passwd" value="" autofocus required placeholder="비밀번호를 입력하세요"></td></tr>
				<tr><td id="td" style="text-align:right;">USERNAME:</td> <td id="td"><input type="text" name="username" value=<%=member.getUsername()%>></td></tr>
				<tr><td id="td" style="text-align:right;">MOBILE:</td> <td id="td"><input type="text" name="mobile" value=<%=member.getMobile()%>></td></tr>
				<tr><td id="td" style="text-align:right;">ADDRESS:</td> <td id="td"><input type="text" name="address" value=<%=member.getAddress()%>></td></tr>
				<tr><td id="td" style="text-align:right;">EMAIL:</td> <td id="td"><input type="text" name="email" value=<%=member.getEmail()%>></td></tr>
				</table>
			</div>
		</fieldset>
		<br>
		<fieldset>
			<input type="submit" name="submit" value="최종 수정">
			<input type="reset" name="reset" value="다시 작성">
						
		</fieldset>	

	
	</form>
	</div>
	<div align=center>
	<br>
	<a class="nav-link" href="http://localhost:8080/jungeun_free/MemberServlet?cmd=delete&id=<%=member.getID()%>" target="_self">회원탈퇴하기</a>
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
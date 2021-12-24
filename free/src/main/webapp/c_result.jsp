<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jungeun_free.domain.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Div'in Korea</title>
	<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
	
<body>
	<br><br><br>
	<header class="text-dark" style="text-align:center;">Complete</header>
	<br><br><br>
	<section>
	<div>
	<p style="align:center; text-align:center; color:black" ><%=request.getAttribute("greetings") %><br>
	</div>
	</section>
	
	<div align=center>
	<table id="sect">
		<tr>
		<td width ="80">계정</td>
		<td width ="80">이메일</td>
		<td width ="200">문의내용</td>
		</tr>
	
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
	%>
		<tr>
			<td><%=member.getID()%></td>
			<td><%=member.getEmail()%></td>
			<td><%=member.getMessage()%></td>
		</tr>

	</table>
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

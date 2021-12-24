<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jungeun_free.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Div'in Korea</title>
	<link rel="stylesheet" href="resources/styles.css" type="text/css"></link>
</head>
	<body>
	<br><br><br>
	<header class="text-dark" style="text-align:center;">Member List</header>
	<br><br>
	<hr>
	<div align=center>
	<table id=sect>
		<tr>
		<td width ="10">계정</td>
		<td width ="10">이름</td>
		<td width ="10">핸드폰</td>
		<td width ="20">주소</td>
		<td width ="10">메일주소</td>
		</tr>
		
		<%
			List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
					for(MemberVO vo : memberList){
			%>
			<tr>
				<td><a href ="http://localhost:8080/jungeun_free/MemberServlet?cmd=update&id=<%=vo.getID()%>" target="_self"><%=vo.getID()%></a></td>
				<td><%=vo.getUsername() %></td>
				<td><%=vo.getMobile() %></td>
				<td><%=vo.getAddress() %></td>
				<td><%=vo.getEmail() %></td>
			</tr>
		<%
			} 
		%>
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
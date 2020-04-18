<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 상세 정보</h2>
<!-- 	request의 user -->
	<table border = "2">
		<tr>
			<th>이름</th>
			<th>성별</th>
			<th>지역</th>
		</tr>
		<tr>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.city}</td>
		</tr>	
	</table>
</body>
</html>
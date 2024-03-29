<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>사용자 정보 등록</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 정보 등록</h2>
		<div>
			<form method="post" action="userInsert.do"  >
				<table  class="table table-bordered table table-hover">
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="userId"  /></td>
					</tr>
					<tr>
						<td>이름 :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>성별 :</td>
						<td><c:forEach var="genderName" items="${sessionScope.genderList}">
									<input type="radio" name="gender" value="${genderName}">${genderName}
							  </c:forEach></td>
					</tr>
					<tr>
						<td>거주지 :</td>
						<td><select name="city">
								<c:forEach var="cityName" items="${sessionScope.cityList}">
									<option value="${cityName}">${cityName}</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
					<td colspan="2"  class="text-center">
						<input type="submit" value="등록" /></td>
					</tr>
					<tr>					
						<td colspan="2" class="text-center"><a href="userList.do">사용자 목록보기</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>

label, input {
	margin-bottom: 10px;
}

label {
	padding-right: 10px;
}
</style>


</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div>
		<a href="">홈</a> | <a href="">위치 히스토리 목록</a> | <a href="">Open API
			와이파이 정보 가져오기</a>
	</div>
	<form action="" method="get" class="form-example">
		<label for="name">LAT: </label> <input type="text"
			name="name" id="name" required>
		<label for="email">LNT: </label> <input type="email"
			name="email" id="email" required>
		<button>내 위치 가져오기</button>
		<input type="submit" value="근처 WIFI 정보 보기">
	</form>
	<%
	out.print("hello, this is java");
	%>
</body>
</html>
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
<script type="text/javascript" src="index.js"></script>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div>
		<a href="">홈</a> | <a href="">위치 히스토리 목록</a> | <a
			href="getWifiResult.jsp">Open API 와이파이 정보 가져오기</a>
	</div>
	<form action="" method="get" class="form-example">
		<label for="LAT">LAT: </label>
		 <input type="text" name="LAT" id="LAT"
			value="" required> 
		<label for="LNT">LNT: </label> 
		<input
			type="text" name="LNT" id="LNT" value="" required>
		<button onClick="getCurrentPosition()">내 위치 가져오기</button>
		<input type="submit" value="근처 WIFI 정보 보기">
	</form>

	

</body>

</html>
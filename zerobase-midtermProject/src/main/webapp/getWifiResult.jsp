<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.WifiDTO"%>
<%@page import="dto.WifiService"%>
<%@page import="service.ApiExplorer"%>
<%@page import="service.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
		ApiExplorer apiExplorer = new ApiExplorer();
		JsonService jsonParser = new JsonService();
		WifiService wifiService = new WifiService();
		
		// api 총 결과 개수 받기
		String api = apiExplorer.getApi(1, 1);
		int limit = jsonParser.getTotalCount(api);
		
		// wifiDTO list 받아서
		int start = 1, end = 20;
		
		List<List<WifiDTO>> list = new ArrayList<>();
		while (start < limit) {
			String t = apiExplorer.getApi(start, end);
			start += 20;
			end += 20;
			list.add(jsonParser.parseJsonTOWifiDTO(t));
		}	
		
		// Db 에 데이터 저장
		wifiService.dbInsert(list);
	%>
	<p> <%=limit%>개의 WIFI 정보를 정상적으로 저장하였습니다.</p>
	<a href="index.jsp">내 위치 가져오기</a>
</body>
</html>
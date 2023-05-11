<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request 컨트롤러를 이용한 요청 처리 작업 중!</h2>
	
	<form action="/basic/request/basic01">
		<input type = "submit" value = "get 요청">
	</form>
	
	<form action="/basic/request/basic01" method = "post">
		<input type = "submit" value = "post 요청">
	</form>
</body>
</html>
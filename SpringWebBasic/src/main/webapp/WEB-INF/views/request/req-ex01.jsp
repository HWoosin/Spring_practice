<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request ��Ʈ�ѷ��� �̿��� ��û ó�� �۾� ��!</h2>
	
	<form action="/basic/request/basic01">
		<input type = "submit" value = "get ��û">
	</form>
	
	<form action="/basic/request/basic01" method = "post">
		<input type = "submit" value = "post ��û">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>jstl/jstl_login</h1>
	<form action="${pageContext.request.contextPath}/sessionLogin3.do" method="post">
		<div>아이디 : <input type="text" name="userId" value="asdf"></div>
		<div>비 번 : <input type="password" name="userPw" value="1234"></div>
		<div>
			<input type="submit" value="로그인">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>
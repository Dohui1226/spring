<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
${userVO}<br>
${sessionScope.userVO}<br>
<hr>
<a href="${pageContext.request.contextPath}/board">게시글</a><br>
<a href="${pageContext.request.contextPath}/board/write">새글등록</a><br>
<!-- 겟방식으로 writeForm으로감 -->
<c:if test="${empty userVO}">
<a href="${pageContext.request.contextPath}/login">로그인</a>
</c:if>
<c:if test="${not empty userVO}">
<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
</c:if>

</body>
</html>
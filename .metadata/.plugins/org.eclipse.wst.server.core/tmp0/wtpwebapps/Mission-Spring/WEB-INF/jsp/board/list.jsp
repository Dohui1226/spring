<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resourse/css/layout.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resourse/css/board.css"></link>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	
<script type="text/javascript">
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = "writeForm.jsp"
		})
	})
	
	function doAction(no){ 
		<c:choose>
			<c:when test="${not empty userVO}">
				location.href = 'detail.jsp?no='+no+'&type=list';/* 리스트쪽에서 호출 */
			</c:when>
			<c:otherwise>
				if(confirm('로그인이 필요한 서비스 입니다.\n 로그인페이지로 이동하시겠습니까?'))
					location.href = "/Misson-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
	}
</script>
</head>
<body>
	<%-- <header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header> --%>
	
	<section>
		<div align="center">
		<hr width="80%">
		<h2>게시판 목록</h2>
		<hr width="80%">
		<br>
		<table border="1" style="width: 80%" id="list">
			<tr >
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<!-- .jsp 가 엔진을 통해 서블릿으로 바뀜. 서블릿이 동적으로 el,JSTL, 자바코드 해석 수행 response할때는 el은 객체이름이 안보임 choose/if태그에서 만들어진것도 안보임? 하지만 테스트에 알맞게 선택된 애만 해석됨? 이후 웹에서 자바스크립트 해석이됨. -->
			<!-- JSP 자바 jstl ,el해석 후 클라이언트 응답후 자바스크립트의 if, dowhile등이 실행됨 -->
			<c:forEach items="${requestScope.list}" var="board" varStatus="loop"> <%-- <c:set var="board value="${list[0]}">랑 같은말 숫자는 01234... 쭉 올라감. --%>
				<tr <c:if test="${loop.index mod 2 ne 0}" > class="odd" </c:if>> <!-- 2의 배수일때 클래스 이름 odd라고 한다 -->
					<td>${board.no}</td>
					<td>
					<%-- 	<a href="${pageContext.request.contextPath}/board/detail?no=${board.no}"> --%>
						<a href="${pageContext.request.contextPath}/board/${board.no}">
	
						<%-- 가상의 url는 상대경로 조금 애햊다ㅏ.. 절대경로로 쓰셈 --%>
							<c:out value="${board.title}" /> 
						</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${not empty userVO}">
		<button id="addBtn">새글등록</button>
		</c:if>
	</div>
	</section>
		
	<%-- <footer>
<!-- 		http://localhost:9999/Misson-web/jsp/board/list.jsp
		a태그나 form 태그에서 /는 localhost:9999/까지 말함.
		xml, include, forward에서 /는 localhost:9999/Misson-Web/ 까지를 말함. 3개 예외니까 외우길 -->
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer> --%>
</body>
</html>


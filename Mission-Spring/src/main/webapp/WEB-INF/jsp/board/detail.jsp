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
<script>
	function Btn(type){
		switch(type){
		case'U':
			location.href="updateForm.jsp?no=${param.no}"
			break;
		case'D':
			if(confirm('게시글을 삭제할까요?'))
				location.href ="delete.jsp?no=${param.no}"
			break;
		case'L':
			location.href="${pageContext.request.contextPath}/board"
			break;
		}
	}

$(document).ready(function() {
	
/* 	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/board/${board.no}",
		data: {"content":content, "no":no,"writer":writer},
		success:function(result){
			alert("댓글이 등록되었습니다.")
		}
	});
	 */
	
	
	$("#btnReply").click(function(){
			var content=$("#ccontent").val();
			var no="${board.no}";
			var writer=$("#cwriter").val();
			
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/board/"+no+"/addComment",
				data: {"content":content, "no":no,"writer":writer},
				success:function(result){
					alert("댓글이 등록되었습니다.")
				}
			});
		})
	})	
</script>
</head>
<body>
	<%-- <header>
		<jsp:include page="/jsp/include/topMenu.jsp"/>
	</header>
	 --%>
	<section>
		<div align = "center">
		<hr width="80%">
		<h2>게시판 상세</h2>
		<hr width="80%">
		<table border="1" style="width:80%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${board.no}"/></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td><c:out value="${board.title}"/></td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td><c:out value="${board.writer}"/></td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${board.content}</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${board.viewCnt}</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${board.regDate}</td>
			</tr>
			<tr>
				<th width="25%">첨부파일</th>
				<td>
					<c:forEach items="${fileList}" var="file">
					<a href="/Mission-Web/upload/${file.fileSaveName}" download="${file.fileOriName}">
						<%-- 서버상 실제위치 --%>
						<c:out value="${ file.fileOriName }"/>
					</a>
						(${file.fileSize}bytes)
						<br>
					</c:forEach>
				</td>
			</tr>
		</table>
		<br>
		<%-- <a href="updateForm.jsp?no=${board.no}"><button >수정</button></a> --%>
		
		<%-- <a href="delete.jsp?no=${board.no}"><button>삭제</button></a> --%>
		
		<!-- <a href="list.jsp"><button>목록</button></a> -->
		<button onclick="Btn('U')">수정</button>
		<button onclick="Btn('D')">삭제</button>
		<button onclick="Btn('L')">목록</button>
		
	</div>
	<hr>
	
	댓글 : <input type="text" id="ccontent" />
	작성자 : <input type="text" id="cwriter" />
	<a href="${pageContext.request.contextPath}/board/${board.no}"><button id="btnReply">댓글등록</button>
	<hr>
	<c:forEach items="${clist}" var="comment" varStatus="loop"> 
	<table>
				<tr><td> 
					내용 : ${comment.content}</td>
				<tr>	
					<td>작성자 :${comment.writer}</td>
					</tr>
				<tr>	<td>작성일자 :${comment.regDate}</td>
				</tr>
				</table>
			</c:forEach>
	
	</section>
		
	<%-- <footer>
<!-- 		http://localhost:9999/Misson-web/jsp/board/list.jsp
		a태그나 form 태그에서 /는 localhost:9999/까지 말함.
		xml, include, forward에서 /는 localhost:9999/Misson-Web/ 까지를 말함. 3개 예외니까 외우길 -->
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer> --%>
</body>
</html>


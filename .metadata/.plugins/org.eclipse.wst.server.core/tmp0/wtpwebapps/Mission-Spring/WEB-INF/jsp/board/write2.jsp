<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css" />
<link rel="stylesheet" href="/${pageContext.request.contextPath}/resources/css/board.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
<script>

	$(document).ready(function() {
		$('#goListBtn').click(function() {
			location.href = "${pageContext.request.contextPath}/board"
		})
	})
	
	function doWrite() {
		
		let f = document.writeForm
		if(f.title.value == '') {
			alert('제목을 입력하세요')
			f.title.focus()
			return false
		}
		
		if(f.content.value == '') {
			alert('내용을 입력하세요')
			f.content.focus()
			return false
		}
		
	
		return true
	}
	
	/* function checkExt(obj){
		let forbidName = ['exe', 'java','jsp','js','class']
		let fileName = obj.value
		let ext =fileName.substring(fileName.lastIndexOf('.')+1)
		
		for(let i=0; i<forbidName.length; i++){
			if(forbidName[i]==ext){
				alert(ext + '업로드 할 수 없는 파일 확장자 입니다.')
				return true
			}
		}
		return false
	} */
</script>
</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp" />
 --%>	</header>
	<section>
		<div align="center">
			<hr width="80%">
			<h2>게시글 등록폼</h2>
			<hr width="80%">
			<br>
			<!-- 포스트방식은 생략해도됨 action 그이유는 get에서 날라온 그주소를 post해주거든. -->
			<form method="post" 
				  name="writeForm" onsubmit="return doWrite()">
			
				<table border="1" style="width: 80%">
					<tr>
						<th width="25%">제목</th>
						<td>
							<input type="text" size="60" name="title">
						</td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td>
							<%-- <c:out value="${ userVO.id }" /> --%>
							<input type="text" size="60" name="writer"> 
						</td>
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td>
							<textarea rows="8" cols="60" name="content"></textarea>
						</td>
					</tr>
					
				</table>
				<br>
				<input type="submit" value="등록">
				<input type="button" value="목록" id="goListBtn">
			</form>
		</div>
	</section>
	<footer>
	<%-- 	<%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>
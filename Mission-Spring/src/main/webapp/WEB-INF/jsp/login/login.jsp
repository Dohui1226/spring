<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resourse/css/layout.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resourse/css/board.css"></link>
<script src ="${pageContext.request.contextPath}/resourse/js/myJS.js"></script>
<script>
/* 	function isNull(obj, msg){
		if(obj.value == ''){
			alert(msg)
			obj.focus()
			return true
		}
		return false
	}
 */

 
 if('${msg}')
	 alert('${msg}')

	function checkForm(){
		let f = document.loginForm
		
		if(isNull(f.id,'아이디를 입력하세요.'))
			return false
		if(isNull(f.password,'비밀번호를 입력하세요.'))
			return false
		
/* 		if(f.id.value == ''){
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}
		
		if(f.password.value == ''){
			alert('패스워드를를 입력하세요')
			f.password.focus()
			return false
		} */
		
		return true
	}
</script>
</head>
<body>
	<header>
		<%-- <jsp:include page="/jsp/include/topMenu.jsp"/>
 --%>	</header>
	
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
			
			<form  method="post" name="loginForm" onsubmit="return checkForm()" >
				<table style="width:50%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id" id="userId"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
					<td rowspan="2">
					<input type="checkbox" name="idSaveCheck">아이디저장
					</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="로그인">
			</form>
		</div>
	</section>
		
	<footer>
		<%-- <%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>
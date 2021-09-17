<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!doctype html>
<html class="no-js" lang="en">

<jsp:include page="../header.jsp" />
<!-- header end -->
<!-- Start breadcumb Area -->
<div class="page-area">
	<div class="breadcumb-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="breadcrumb text-center">
					
					<ul class="breadcrumb-bg">
						<li >관심</li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End breadcumb Area -->
<!-- Start Slider Area -->
<div class="invest-area bg-color page-padding-2">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="section-headline text-center">
					<h3>포트폴리오</h3>
				<p> <div align="center" class="basic-tb-hd">
                            <label for="start">날짜선택:</label>  
                            <input type="date" id="day" name="day" value="2021-09-18">
                          	<input id="daysubmit" type="submit" onclick="dayinput()" value="선택">
                        </div></p>
				</div>
			</div>
		</div>
	 <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <div class="normal-table-list mg-t-30">
                       
                        <div class="bsc-tbl-st">
                       <div id="tabl1">
                          
                         	
                            <table width="70%" class="table table-striped">
                         	<thead>
                         	<tr>
                         	<th width="15%" align="center">닉네임</th>
                         	<th width="15%" align="center">종목타입</th>
  							<th width="15%" align="center">비중</th>
  						
                         	</tr>
                         	</thead>
                                <tbody>
                                 <c:forEach items="${requestScope.port}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                        <td style="vertical-align:middle" rowspan="${fn:length(ranklist.value)}" >
                                        <strong>${ranklist.key}</strong><br><br>&nbsp;&nbsp;
                                        <button class="gut" value="${ranklist.key}" onclick="cc(this.value)">추천</button></td>
                                   			
                                   		 <c:forEach items="${ranklist.value}" var="ranklist1" varStatus="loop"> 
                                   			 <td>${ranklist1.key}</td>
                                   			 <td>${ranklist1.value*100}%</td> </tr> 
                                   		
                                   		</c:forEach>
                                   			<%-- //<td rowspan="${fn:length(ranklist.value)}">dd</td> --%>
                                    
                                    </c:forEach>
                                </tbody>
                            </table>
                       			</div>
                        
                 
                    </div>
                </div>
            </div>
			</div>
						
					</div>
	
<jsp:include page="../footer.jsp" />
	
</body>
<script>	

var dayinfo;
function dayinput(){	
	dayinfo =document.querySelector("#day").value;

	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/like/port/select",
		data:{day :dayinfo}, 
		dataType : "text"
	}).done(function(result){
		console.log("결과확인")
		var html = jQuery('<div>').html(result)
		var contents =html.find('div#ajax').html();
		console.log(contents)
		console.log(html)
		$("#tabl1").html(contents)
	}).fail(function (jqXHR, textStatus, errorThrown) {
		console.log("에러"); 
		console.log(jqXHR);
		console.log(textStatus);
		console.log(errorThrown);
		});

	
}

	
function cc(param){
  
	console.log(param)
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/port/recom",
		data:{day :dayinfo,nickname:param}, 
		success:function(){
		}
	})
	
}


</script>
</html>
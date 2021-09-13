<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js" lang="en">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/bootstrap.min.css">
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/font-awesome.min.css">
   
   
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/animate.css">
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/normalize.css">

   
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/jquery.dataTables.min.css">
   
   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/style.css">
  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/green-horizotal/css/responsive.css">


<jsp:include page="../header.jsp" />
<!-- header end -->
<!-- Start breadcumb Area -->
<div class="page-area">
	<div class="breadcumb-overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="breadcrumb text-center">
					<div class="section-headline white-headline">
						<h3>와글와글</h3>
					</div>
					<ul class="breadcrumb-bg">
						<li class="home-bread">Waggle</li>
						<li>랭킹 살펴보기</li>
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
					<h3>랭킹순위</h3>
					<p>상위 투자자 랭킹을 살펴볼 수 있습니다.</p>
				</div>
			</div>
		</div>
		<div class="row">
		  <div class="data-table-area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="data-table-list">
                      
                        <div class="table-responsive">
                            <table id="data-table-basic" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>닉네임</th>
                                        <th>하트수량</th>
                                        <th>수익률</th>
                                        <th>총거래금액</th>
                                        <th>포트폴리오</th>
                                       
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.ranklist}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                        <td>${ranklist.nickname}</td>
                                        <td>${ranklist.hart}</td>
                                        
                                       <td> <fmt:formatNumber value="${ranklist.rate}" pattern="#.##"/>%</td>
                                        <td><fmt:formatNumber value="${ranklist.stockvalue}" pattern="###,###,###,###"/></td>
                                      	<td><a href="${pageContext.request.contextPath}/waggle/rankInfo/${ranklist.no}">확인하기</a></td>
                                    </tr>
                                   </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>
                                    
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="../footer.jsp" />
</body>


    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/vendor/jquery-1.12.4.min.js"></script>
  
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/counterup-active.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/data-table/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/data-table/data-table-act.js"></script>
     <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/tawk-chat.js"></script>
</html>
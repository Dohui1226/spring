<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<h3>관심유저</h3>
				<p></p>
				</div>
			</div>
		</div>
	 <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="normal-table-list mg-t-30">
                        <div class="basic-tb-hd">
                           
                        </div>
                        <div class="bsc-tbl-st">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>닉네임</th>
                                        <th>하트</th>
                                        <th>손익</th>
                                        <th>총거래금액</th>
                                        <th>포트폴리오보기</th>
                                        <th>주문</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${requestScope.ranklist}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                        <td width="10%">${ranklist.rank}</td>
                                        <td width="20%">${ranklist.nickname}</td>
                                        <td width="10%">${ranklist.hart}</td>
                                        <td width="25%"> <fmt:formatNumber value="${ranklist.rate}" pattern="#.##"/>%</td>
                                        <td width="20%"><fmt:formatNumber value="${ranklist.stockvalue}" pattern="###,###,###,###"/></td>
                                      	<td><a href="${pageContext.request.contextPath}/waggle/rankInfo/${ranklist.no}">확인하기</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            
                             <div align="center" class="basic-tb-hd">
                            <br>
                          <br>
                            <table  class="table table-striped">
                            <thead>
            
                                <tr class="warning">
                                <th width="10%">${mylist.rank}</th>
                                <th width="20%">${mylist.nickname}</th>
                                <th width="10%">${mylist.hart}</th>
                                 <th width="25%"> <fmt:formatNumber value="${mylist.rate}" pattern="#.##"/>%</th>
                                        <th width="20%"><fmt:formatNumber value="${mylist.stockvalue}" pattern="###,###,###,###"/></th>
                                      	<th><a href="${pageContext.request.contextPath}/waggle/rankInfo/${mylist.no}">확인하기</a></th>
                                </tr>
                                </thead>
                                
                            </table>
                        </div>
                    </div>
                </div>
            </div>
			
						</div>
					</div>
		


<jsp:include page="../footer.jsp" />
</body>


  
</html>
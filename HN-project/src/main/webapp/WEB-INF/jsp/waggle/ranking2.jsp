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
						<li >랭킹</li>
						
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
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="normal-table-list mg-t-30">
                        <div class="basic-tb-hd">
                           
                        </div>
                        <div class="bsc-tbl-st">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>순위</th>
                                        <th>닉네임</th>
                                        <th>하트 수량</th>
                                        <th>수익률</th>
                                        <th>총 거래 금액</th>
                                        <th>포트폴리오</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <c:forEach items="${requestScope.ranklist}" var="ranklist" varStatus="loop"> 
                                    <tr>
                                 
                                      
                                       <td width="10%"> 
                                       <c:if test="${ranklist.rank eq 1}">
                                       <i class="ti-crown" style="color: burlywood"></i> </c:if>
                                        <c:if test="${ranklist.rank eq 2}">
                                       <i class="ti-crown" style="color: darkgrey"></i> </c:if>
                                        <c:if test="${ranklist.rank eq 3}">
                                       <i class="ti-crown" style="color: brown"></i> </c:if>
                                      ${ranklist.rank}</td>
                                      
                                        <td width="20%">${ranklist.nickname}</td>
                                        <td width="10%">${ranklist.hart}</td>
                                        <td width="25%"> <fmt:formatNumber value="${ranklist.rate*100}" pattern="#.##"/>%</td>
                                        <td width="20%"><fmt:formatNumber value="${ranklist.stockvalue}" pattern="###,###,###,###"/></td>
                                      	<td><a href="#paymodal" data-id=" ${ranklist.rank}" data-value="${ranklist.no}" data-toggle="modal" class="move">확인</a></td>
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
                                 <th width="25%"> <fmt:formatNumber value="${mylist.rate*100}" pattern="#.##"/>%</th>
                                        <th width="20%"><fmt:formatNumber value="${mylist.stockvalue}" pattern="###,###,###,###"/></th>
                                      	<th><a href="${pageContext.request.contextPath}/waggle/rankInfo/${mylist.no}">확인하기</a></th>
                                </tr>
                                </thead>
                                
                            </table>
                        </div>
                    </div>
                </div>
            </div>
               
		

<div class="modal fade" id="paymodal" >
	<div class="modal-dialog modal-m">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">하트 사용 확인</h4>
					
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<form method="post" action="${pageContext.request.contextPath}/ranking/payheart">
			<div class="modal-body">
				<p style="text-align:center">
				선택하신 포트폴리오 및 필요 하트 수는 다음과 같습니다.<br>
				하트를 사용하시겠습니까?</p>
				<p style="text-align:center"><strong>랭킹 :<input name="rank" text="text" style="border:none;text-align:right;width: 50px;" value="" id="rankingvalue" readonly>위</strong><br>
				<input type="hidden" value="" name="no" id="novalue">
				<strong>필요하트 :<input text="text" style="text-align:right;border:none;width: 50px;" value="" id="heart" readonly>
				개</strong><br>
				
				</p>
				</div>
			
			
			<div class="modal-footer">
				
				<input type="submit" id="button-modal" value="사용"></form>
				<button id="button-modal2"  data-dismiss="modal">닫기</button>
				</div></div>
				
			</div>
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />
</body>


<script>
$(document).on("click", ".move", function() {
	var rank = $(this).attr('data-id');
	var no = $(this).attr('data-value')
	if(rank==1||rank==2||rank==3){
		$(".modal-body #heart").val(100);
		$(".modal-body #rankingvalue").val(rank);
		$(".modal-body #novalue").val(no);
	}
	else{
		$(".modal-body #heart").val(50);
	$(".modal-body #rankingvalue").val(rank);
	$(".modal-body #novalue").val(no);
}
});

</script>

  
  <script src="${pageContext.request.contextPath}/resources/third/js/apps.js"></script> 
  
  
</html>
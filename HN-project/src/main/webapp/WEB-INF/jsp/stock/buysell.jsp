<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/green-horizotal/style.css">
<html class="no-js" lang="en">
<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
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
						<li >매수/매도</li>
						
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

			<div class="section-headline text-center">
				<h3>${stockcode.stock_name}</h3>
				<h6>${stockcode.stock_index}&nbsp;${stockcode.stock_type}</h6>
				<div align="center" class="price-btn">
					<a class="blue-button" style="background: #E00400; border: none;"
						data-toggle="modal" href="#modal">매수</a> <a class="blue-button"
						style="background: #003ace; border: none;" data-toggle="modal"
						href="#modal2">매도</a><br>
						
                       <button id="button-modal" onclick="likecompany()">관심등록</button>
                               
					<hr>
				</div>
			</div>
		</div>
	</div>

	<div class="pricing-content" align="center"">
		<h4>${stocktoday.stock_close}</h4>
		<c:if test="${stocklist.stock_diff lt 0}">
				전일대비<td style="color: blue">▼${Math.abs(stocklist.stock_diff)}</td>
		</c:if>
		<c:if test="${stocklist.stock_diff gt 0}">
				전일대비<td style="color: red">▲ ${stocklist.stock_diff}</td>
		</c:if>
		<c:if test="${stocklist.stock_diff eq 0}">
				전일대비<td>${stocklist.stock_diff}</td>
		</c:if>

	</div>

	<div class="blog-left-content">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="single-blog">
				<div class="sale-statistic-inner notika-shadow mg-tb-30">
					<div class="curved-inner-pro"></div>
					<div id="dynamic-chart" class="flot-chart dyn-ctn-fr bar-hm-three"></div>
				</div>
			</div>
		</div>

	</div>
	
	<div class="blog-sidebar-right">
	<div class="col-md-8 col-sm-8 col-xs-12">
	</div>
	
	</div>
</div>



<div class="modal fade" id="modal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">결제창</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<a class="support-images" href="#"><i
					class="flaticon-035-savings"></i></a>
				<div class="support-content">
					<h6>매수 정보를 입력하세요.</h6>
					<form
						action="${pageContext.request.contextPath}/stock/buy/${stockcode.stock_code}"
						method="post">
						주문 금액 : ${stocktoday.stock_close}<br> <select id="buyorder"
							onchange="order1(this.value)">
							<option value="">가능</option>
							<option value="1">100%</option>
							<option value="2">50%</option>
							<option value="4">25%</option>
							<option value="10">10%</option>
						</select> <input type="text" id="changemodal1" name="stock_num"
							placeholder="수량" value=""><br>
						총 거래금액:<input type="text" id="totalcost1" style="border: none;" value="" readonly><br> 
						<br>*매수시 거래금액의 0.015% 수수료가 부과됩니다.&nbsp; <br>
						<%-- 	<fmt:formatNumber id="fee1" value="" pattern="#,###" /> --%>
						<!-- <input type="hidden" name="fee" id="feerate1" style="border:none;" value=""> <br> -->
				</div>
			</div>
			<div class="modal-footer">
				<input type="submit" id="button-modal" value="매수">
				<button id="button-modal2" data-dismiss="modal">닫기</button>
				</form>
			</div>
		</div>
	</div>
</div>
</div>

<div class="modal fade" id="modal2" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">결제창</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<a class="support-images" href="#"><i
					class="flaticon-035-savings"></i></a>
				<div class="support-content">
					<h6>매도 정보를 입력하세요.</h6>
					<form
						action="${pageContext.request.contextPath}/stock/sell/${stockcode.stock_code}" method="post">
						주문 금액 : ${stocktoday.stock_close}<br> <select name="sellorder" onchange="order2(this.value)">
							<option value="">가능</option>
							<option value="1">100%</option>
							<option value="2">50%</option>
							<option value="4">25%</option>
							<option value="10">10%</option>
						</select> <input type="text" id="changemodal2" name="stock_num"
							placeholder="수량" value=""><br> 
							총 거래금액:<input type="text" id="totalcost2" style="border: none;" value="" readonly><br> 
							<br>*매도시 증권거래세를 포함하여 거래금액의 0.25% 수수료가 부과됩니다.
						<%-- 		<fmt:formatNumber id="fee2" value="" pattern="#,###" /> --%>
						<input type="hidden" name="fee" id="feerate2"
							style="border: none;" value=""> <br>
				</div>
			</div>
			<div class="modal-footer">
				<input type="submit" id="button-modal" value="매도">
				<button id="button-modal2" data-dismiss="modal">닫기</button>
				</form>
			</div>
		</div>
	</div>
</div>



<!-- all js here -->
<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />

<!-- End Footer area -->


</body>

<%-- 	 <script src="${pageContext.request.contextPath}/resources/green-horizotal/js/bootstrap.min.js"></script> --%>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/vendor/jquery-1.12.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.resize.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.pie.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.tooltip.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.orderBars.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/curvedLines.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/flot-active.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/sparkline/jquery.sparkline.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/sparkline/sparkline-active.js"></script>

<script>



function order1(param){

	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/myasset/stock/cash",
		success:function(data){
			var num1 = data/'${stocktoday.stock_close}'/param			
			$('#changemodal1').val(Math.floor(num1))
			var price =  ${stocktoday.stock_close} * Math.floor(num1)
		 	$('#totalcost1').val(price) 
			$('#feerate1').val(price*0.00015)
		}
	})		
}

function order2(param){
	
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/myasset/mystock",
		data: {stock_code:"${stockcode.stock_code}"},
		success:function(data){
			var num = data/param
			$('#changemodal2').val(Math.floor(num))
			var price2 =  ${stocktoday.stock_close} * Math.floor(num)
			$('#totalcost2').val(price2) 
			$('#feerate2').val(price2*0.0025)
		}
	})		
}

function likecompany(){
	
	$.ajax({
		type:"get",
		url:"${pageContext.request.contextPath}/like/"+'${stockcode.stock_code}',		
		success:function(){
			alert("관심등록이 완료되었습니다.")
			
		}
	})		
}






</script>


</html>


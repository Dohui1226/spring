<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/green-horizotal/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jqbar.css" />
<!doctype html>
<html class="no-js" lang="en">

<!-- 
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.1/Chart.min.js"></script> -->


<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.1/Chart.min.js"></script>
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
					<div class="section-headline white-headline">
						<h3>와글와글</h3>
					</div>
					<ul class="breadcrumb-bg">
						<li class="home-bread">Waggle</li>
						<li>가입하기</li>
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
					<h3>${waggle.nickname}</h3>
					<h5>
						<img
							src="${pageContext.request.contextPath}/resources/img/heart.png">&nbsp;<span
							class="counter">${waggle.hart}</span>
					</h5>
					<i class="fa fa-envelope-o">&nbsp;<a
						href="${pageContext.request.contextPath}/chat">메세지</a></i>&nbsp;&nbsp;&nbsp;
					<i class="ti-layers">;&nbsp;<a onclick="copy()">복사</a></i>
				</div>
			</div>
		</div>
	</div>
	<div class="blog-area fix page-padding">
		<div class="container">
			<div class="row">
				<div class="blog-sidebar-right">
					<div class="col-md-8 col-sm-8 col-xs-12">
						<div class="row">
							<div class="blog-left-content">
								<!-- Start single blog -->
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="single-blog ">
										<div class="blog-image">
											<!-- <h6 align="center">수익률 비교</h6> -->
											<h6 align="center">포트폴리오 확인</h6>
											<%--    <canvas align="middle" height="140vh" width="180vw"
											id="linechart"></canvas> --%>
											<div class="chart">
												<canvas id="myPieChart" height="380vh" width="420vw"></canvas>
											</div>
										</div>
										<br> <br>
										<div class="left-head-blog right-side">

											<div class="left-blog-page">
												<div class="left-blog blog-category">
													<h4>보유 섹터 순위</h4>
													<ul>
														<c:forEach items="${requestScope.value}" var="ranklist" varStatus="status">
															<li><span>${status.count}</span> 
																<a data-toggle="collapse" id="type" href ="#" value="${ranklist.stock_type}" onclick="company()">${ranklist.stock_type}&nbsp;&nbsp;&nbsp; 
																<fmt:formatNumber value="${ranklist.value}"  pattern="###,###,###,###" />원
																<label text-align="right">
																<fmt:formatNumber value="${ranklist.valuerate*100}" pattern="##.##" />%	
																</a>
															<div >
																<div id="bb" class="index"></div>
															</div>
															</li>
														</c:forEach>	
													</ul>
												</div>
											</div>
											<div class="left-blog-page">
												<div class="left-tags blog-tags">
													<div class="popular-tag left-side-tags left-blog">
														<h4>관심 종목</h4>
														<ul>

															<li><a href="#">Business</a></li>
															<li><a href="#">Agency </a></li>
															<li><a href="#">Media</a></li>
															<li><a href="#">Social</a></li>
															<li><a href="#">Photoshop</a></li>
															<li><a href="#">Seo</a></li>
															<li><a href="#">development</a></li>
															<li><a href="#">Search</a></li>
															<li><a href="#">Design</a></li>

														</ul>
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

				<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
					<div
						class="statistic-right-area notika-shadow mg-tb-30 sm-res-mg-t-0">
						<div class="left-blog blog-category">
							<h4>정보</h4>
							<p></p>
						</div>
						

						<div class="past-statistic-an">
							<div class="past-statistic-ctn">
								<h3>
									<span class="counter">${follower}</span>
								</h3>
								<p>팔로워</p>
							</div>
							<div class="past-statistic-graph">
								<div class="stats-line"></div>
							</div>
						</div>
						<div class="past-statistic-an">
							<div class="past-statistic-ctn">
								<h3>
									<span class="counter">${follow}</span>
								</h3>
								<p>팔로잉</p>
							</div>
							<div class="past-statistic-graph">
								<div class="stats-line"></div>
							</div>
						</div>
						<div class="past-statistic-an">
							<div class="past-statistic-ctn">
								<h3>
									<span class="counter"></span>
								</h3>
								<p>포트폴리오 복사</p>
							</div>
							<div class="past-statistic-graph">
								<div class="stats-bar-2"></div>
							</div>
						</div>
					</div>
					<div class="recent-items-wp notika-shadow sm-res-mg-t-30">
						<div class="rc-it-ltd">
							<div class="recent-items-ctn">
								<div class="left-blog blog-category">
									<h4>최근 매수 목록</h4>
									<ul>
								</div>
							</div>
							<div class="recent-items-inn">
								<table class="table table-inner table-vmiddle">
									<thead>
										<tr>
											<th text-alingn="center" style="width: 120px">종목</th>
											<th>금액</th>
											<th style="width: 100px">거래날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.listbuy}" var="listbuy" varStatus="status">
											<tr>
												<td>${listbuy.stock_name}</td>
												<td><fmt:formatNumber value="${listbuy.stock_price}" pattern="###,###,###,###" />원</td>
												<td><fmt:parseDate value="${listbuy.tra_date}" var="dateValue" pattern="yyyy-MM-dd" />
												 <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd" /></td>

											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="recent-items-wp notika-shadow sm-res-mg-t-30">
						<div class="rc-it-ltd">
							<div class="recent-items-ctn">
								<div class="left-blog blog-category">
									<h4>최근 매도 목록</h4>
									<ul>
								</div>
							</div>
							<div class="recent-items-inn">
								<table class="table table-inner table-vmiddle">
									<thead>
										<tr>
											<th text-alingn="center" style="width: 120px">종목</th>
											<th>금액</th>
											<th style="width: 100px">거래날짜</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.listsell}" var="listsell"
											varStatus="status">
											<tr>
												<td>${listsell.stock_name}</td>
												<td><fmt:formatNumber value="${listsell.stock_price}" pattern="###,###,###,###" /></td>
												<td><fmt:parseDate value="${listsell.tra_date}" var="dateValue" pattern="yyyy-MM-dd" /> <fmt:formatDate
														value="${dateValue}" pattern="yyyy-MM-dd" /></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
							<div id="recent-items-chart"
								class="flot-chart-items flot-chart vt-ct-it tb-rc-it-res"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- End Right Sidebar -->
	</div>
	<!-- End row -->
</div>
</div>
<!--End of Blog Area-->





</div>



<!-- all js here -->
<!-- Start Footer Area -->
<jsp:include page="../footer.jsp" />

<!-- End Footer area -->


</body>




<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.tooltip.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.orderBars.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/chat/moment.min.js"></script>


<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/tawk-chat.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/main.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/knob/jquery.knob.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/knob/jquery.appear.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/knob/knob-active.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/flot-active.js""></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/curvedLines.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.resize.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/flot/jquery.flot.js"></script>


<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/sparkline/sparkline-active.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/sparkline/jquery.sparkline.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/jquery.counterup.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/waypoints.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/counterup/counterup-active.js"></script>



<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/jquery.scrollUp.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/charts/Chart.js"></script>


<script>
	var pieLabels = [];
	var piedata = [];

	$(document).ready(function() {
		$.ajax({
				url : '${pageContext.request.contextPath}/waggle/rankInfo/piechart',
				type : 'post',
				data : {
				no : "${waggle.no}"},
				dataType : "json",
				success : function(map) {
				$.each(map.valuelist, function(index,item) {
					pieLabels.push(item.stock_type);
					var round = item.valuerate * 100
					piedata.push(round.toFixed(2));

				})
					doughnut()
					line()
					},error : function() {
							console.log("ajax실패!!!");
					}
		})

	})

	function line() {

		var ctx = document.getElementById('linechart').getContext('2d');
		var linechart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : [ '1월', '2월', '3월', '4월', '5월', '6월' ],
				datasets : [ {
					label : '상대방 수익률',
					type : 'line', // 'line' type
					fill : false,
					backgroundColor : '#00c292',
					borderColor : '#00c292',
					lineTension : 0, // 0이면 꺾은선 그래프, 숫자가 높을수록 둥글해짐
					pointRadius : 0, // 각 지점에 포인트 주지 
					data : [ 40, 50, 60, 70, 80, 90 ]
				}, {
					label : '내 수익률',
					type : 'line',
					fill : false,
					backgroundColor : '#fb9678',
					borderColor : '#fb9678',
					lineTension : 0,
					pointRadius : 0,
					data : [ 100, 120, 150, 100, 180, 200 ]
				} ]
			},

			options : {
				responsive : true,
				legend : {
					display : true
				},
				tooltips : {
					mode : 'index',
					intersect : false
				},

				hover : {
					mode : 'nearest',
					intersect : true
				}
			}
		})
	}

	function doughnut() {

		var sum = Number("{100}");

		var ctx3 = document.getElementById("myPieChart");
		var myPieChart = new Chart(ctx3, {
			type : 'doughnut',
			data : {
				labels : pieLabels,
				datasets : [ {
					data : piedata,
					backgroundColor : [ '#5093ce', "#7fc77f", '#36b9cc',
							'#35a1cc', '#7fc77f', "#dd6864", ],
					hoverBackgroundColor : [ "#78acd9", "#a3d7a3", '#2c9faf',
							'#a3d7a3', '#a3d7a3', "#e6918e" ],
					hoverBorderColor : "rgba(234, 236, 244, 1)",
				} ],
			},
			options : {
				maintainAspectRatio : false,
				tooltips : {
					backgroundColor : "rgb(255,255,255)",
					bodyFontColor : "#858796",
					borderColor : '#dddfeb',
					borderWidth : 1,
					xPadding : 15,
					yPadding : 15,
					displayColors : false,
					caretPadding : 10,
				},
				legend : {
					display : true
				},
			},
		});

	}
	
	function copy(){
		alert('포트폴리오 복사완료')
	}
	
	
	function company(){
		var stockname=[];
		var stockvalue=[];
		$("#type").each(function(){
			var typename= $(this).attr("value"); 
		
			$.ajax({
				url : '${pageContext.request.contextPath}/stock/typecompany',
				type : 'post',
				data : {no : "${waggle.no}", type: typename},
				dataType : "json",
				success : function(list) {
				
					console.log(list.list)
					$.each(list.list, function(index,item) {
						
					
						$('#bb').append(item.stock_name+'&nbsp;'+item.stock_value+'<br>')
												
						
					})

				}
			})		
		})				
	}
	
		
</script>
</html>
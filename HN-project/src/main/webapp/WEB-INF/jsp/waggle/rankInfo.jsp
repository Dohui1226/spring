<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<script src="${pageContext.request.contextPath}/resources/js/Chart.js}"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.1/Chart.min.js"></script>


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
						href="${pageContext.request.contextPath}/chat">메세지</a></i>

				</div>
			</div>
			<div class="row">
				<div class="pricing-content">
					<div class="faq-area bg-color page-padding">

						<div align="center">
							<div class="col-md-5 my-5 mx-auto">
								<div class="card text-center shadow">

									<div class="line-chart-wp chart-display-nn">
										<canvas height="140vh" width="180vw" id="linechart"></canvas>


										<h3>포트폴리오 확인</h3>

										<div class="card-header text-left">
											<div class="card-body">
												<div class="chart">
													<canvas id="myPieChart" height="280vh" width="240vw"></canvas>

													<table>

														<c:forEach items="${requestScope.value}" var="ranklist"
															varStatus="loop">
															<tr>
																<td>${ranklist.stock_type}</td>
															</tr>
															<tr>
																<td>${ranklist.value}</td>
															</tr>
														</c:forEach>

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
</div>


	<!-- all js here -->
	<!-- Start Footer Area -->
	<jsp:include page="../footer.jsp" />

	<!-- End Footer area -->


	</body>
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
	<%-- <script
		src="${pageContext.request.contextPath}/resources/green-horizotal/js/charts/line-chart.js"></script> --%>
	<%-- <script
		src="${pageContext.request.contextPath}/resources/green-horizotal/js/charts/pie-chart.js"></script> --%>

	<script>
	
	
	var pieLabels = [];
	var piedata = [];
	
	$(document).ready(function(){
	
	$.ajax({
		url : '${pageContext.request.contextPath}/waggle/rankInfo/piechart',
		type: 'post',
		data: {no:"${waggle.no}"},
		dataType: "json",	  
		success: function(map){		
					

  			$.each(map.valuelist, function(index, item){				
				pieLabels.push(item.stock_type);
				var round =item.valuerate*100
				piedata.push(round.toFixed(2));
				
  			})
  			doughnut()
  			line()
  					
		},error : function() {
  			console.log("ajax실패!!!");
  		}
	})	
	
		
	})
	
	
	
	function line(){
	
		        var ctx = document.getElementById('linechart').getContext('2d');
		        var linechart = new Chart(ctx, {   
		            type: 'line',
		            data: {
		            	labels: ['1월','2월','3월','4월','5월','6월'],
		            	   datasets: [ {
		                       label: '상대방 수익률',
		                       type : 'line',         // 'line' type
		                       fill : false,
		                       backgroundColor: '#00c292',
		                       borderColor: '#00c292',
		                       lineTension : 0,  // 0이면 꺾은선 그래프, 숫자가 높을수록 둥글해짐
		                       pointRadius : 0,    // 각 지점에 포인트 주지 
		                       data: [40, 50, 60, 70, 80, 90]
		                   }, {
		                       label: '내 수익률',
		                       type : 'line',
		                       fill : false,
		                       backgroundColor: '#fb9678',
		               	    	borderColor: '#fb9678',
		                       lineTension : 0,
		                       pointRadius : 0,
		                       data: [100, 120, 150, 100, 180, 200]
		                   }]
		            },

		            options: {
		            	responsive: true,
		                legend: {
		        	        display: true
		      	      },
			      	    tooltips: {
							mode: 'index',
							intersect: false
						},
						
						hover: {
							mode: 'nearest',
							intersect: true
						}  
		            } 
		       })
	}
		    
	
	
	
	function doughnut(){
	
	  var sum = Number("{100}");


	  var ctx3 = document.getElementById("myPieChart");
	  var myPieChart = new Chart(ctx3, {
	    type: 'doughnut',
	    data: {
	      labels: pieLabels,
	      datasets: [{
	        data: piedata,
	        backgroundColor: ['#5093ce', "#7fc77f", '#36b9cc','#35a1cc','#7fc77f',"#dd6864",],
	        hoverBackgroundColor: ["#78acd9", "#a3d7a3", '#2c9faf','#a3d7a3','#a3d7a3',"#e6918e"],
	        hoverBorderColor: "rgba(234, 236, 244, 1)",
	      }],
	    },
	    options: {
	      maintainAspectRatio: false,
	      tooltips: {
	        backgroundColor: "rgb(255,255,255)",
	        bodyFontColor: "#858796",
	        borderColor: '#dddfeb',
	        borderWidth: 1,
	        xPadding: 15,
	        yPadding: 15,
	        displayColors: false,
	        caretPadding: 10,
	      },
	      legend: {
	        display: true
	      },
	    },
	  });
	    
	}

	

	   


	
	</script>
</html>
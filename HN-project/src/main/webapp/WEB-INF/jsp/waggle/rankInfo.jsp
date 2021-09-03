<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<script src="${pageContext.request.contextPath}/resources/js/Chart.js}"></script>


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
					<h3>김왕자</h3>
					 <h5><img src="${pageContext.request.contextPath}/resources/img/heart.png">&nbsp;<span class="counter">58,444</span></h5>
                       <i class="fa fa-envelope-o">&nbsp;<a href="${pageContext.request.contextPath}/chat">메세지</a></i>     
				
			</div>
		</div>
		<div class="row">
			<div class="pricing-content">
				<div class="faq-area bg-color page-padding">

					<div align="center">
					<div class="col-md-5 my-5 mx-auto">
						<div class="card text-center shadow">

							<div class="line-chart-wp chart-display-nn">
								<canvas height="140vh" width="180vw" id="basiclinechart"></canvas>
							</div>
						</div>
						

					
   <canvas id="mychart" width="300" height="186"></canvas>

						
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
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/charts/line-chart.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/charts/pie-chart.js"></script>


</html>
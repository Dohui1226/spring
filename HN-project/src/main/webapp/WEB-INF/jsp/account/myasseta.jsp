<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jqbar.css" />


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
						<h3>내 자산</h3>
					</div>
					<ul class="breadcrumb-bg">
						<li class="home-bread">STOCK</li>
						<li>보유 종목</li>
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
					<h3>Deposite and withdrawals history</h3>
					<p>Help agencies to define their new business objectives and
						then create professional software.</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12"">


				
			

			</div>
			<br> <br>
			<div class="col-md-12">




				<div class="deposite-content">
					<div class="diposite-box">


						<div class="deposite-table">
							<div class="email-statis-wrap">
								<div class="email-round-nock" style="float:left">

									<input type="text" class="knob" value="0" data-rel="91"
										data-linecap="round" data-width="130" data-bgcolor="#E4E4E4"
										data-fgcolor="#00c292" data-thickness=".10"
										data-readonly="true">
									<!-- <div style="float: right"></div> -->

									<div style="float: right">
							
										&nbsp;&nbsp;&nbsp;&nbsp;계좌번호 : 110-4545-1313
										<br>
										<br>
										<br>&nbsp;&nbsp;&nbsp;&nbsp;
										주식 : 841,595
										<br>&nbsp;&nbsp;&nbsp;&nbsp;
										총 예탁금 : 945,333
									</div>
								</div>
							</div>
							<table>
								<tr>
									<th>종목명</th>
									<th>보유수량</th>
									<th>매입단가</th>
									<th>매입금액</th>
									<th>현재가</th>
									<th>손익률</th>
									<th>평가금액</th>
								</tr>
								<tr>
									<td>삼성전자</td>
									<td>100</td>
									<td>52000</td>
									<td>5200000</td>
									<td>75000</td>
									<td>44.23%</td>
									<td>7500000</td>
								</tr>
								<tr>
									<td>Jonshon</td>
									<td>Dec 12, 2019</td>
									<td>$5000</td>
									<td>USD</td>
									<td>USD</td>
									<td>USD</td>
									<td>USD</td>
								</tr>
								<tr>
									<td>Hopper</td>
									<td>Dec 22, 2019</td>
									<td>$4000</td>
									<td>Ripple</td>
									<td>Ripple</td>
									<td>Ripple</td>
									<td>Ripple</td>
								</tr>
								<tr>
									<td>Admond sayhel</td>
									<td>Jan 02, 2020</td>
									<td>$3000</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
								</tr>
								<tr>
									<td>Anjel july</td>
									<td>Jan 05, 2020</td>
									<td>$500</td>
									<td>USD</td>
									<td>USD</td>
									<td>USD</td>
									<td>USD</td>
								</tr>
								<tr>
									<td>Lagisha</td>
									<td>Jan 12, 2020</td>
									<td>$5000</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
									<td>Bitcoin</td>
								</tr>
							</table>
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

<script src="${pageContext.request.contextPath}/resources/js/jqbar.js"
	type="text/javascript"></script>

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
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/chat/jquery.chat.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/green-horizotal/js/chat/moment.min.js"></script>







<script type="text/javascript">

	$(document).ready(function () {
		$('#bar-7').jqbar({ label: 'Wal', value: 90, barColor: '#D64747', orientation: 'v' });
		$('#bar-8').jqbar({ label: 'Ohi', barColor: '#FF681F', value: 70, orientation: 'v' });
		$('#bar-9').jqbar({ label: 'Song', barColor: '#ea805c', value: 50, orientation: 'v' });
		$('#bar-10').jqbar({ label: 'Pisho', barColor: '#88bbc8', value: 90, orientation: 'v' });
		$('#bar-11').jqbar({ label: 'Mara', barColor: '#939393', value: 70, orientation: 'v' });
		$('#bar-12').jqbar({ label: 'Dagha', barColor: '#3a89c9', value: 50, orientation: 'v' });
	});
</script>


</html>
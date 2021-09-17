<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<script src="https://code.highcharts.com/highcharts.js"></script>	
<!-- Mirrored from rockstheme.com/rocks/aievari-live/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 03 Mar 2020 08:27:42 GMT -->
<jsp:include page="../header.jsp"/>
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
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="section-headline text-center">
                            <h3></h3>
                            <p>Help agencies to define their new business objectives and then create professional software.</p>
						
						<div id="container" style="height: 400px"></div></div>
					</div>
				</div>
                <div class="row">
                    <div class="col-md-12">
                     
                </div>
            </div>
          
        </div>
		<!-- all js here -->
        <!-- Start Footer Area -->
   <jsp:include page="../footer.jsp"/>
   
        <!-- End Footer area -->
		
		
	</body>
	
<script>	



/* 	
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/stock/report",
		data: {stock_code:"${stockcode.stock_code}"},
		
		success:function(data){
			var num = data/param
			$('#changemodal2').val(Math.floor(num))
			
		}
	})		
 */
$(document).ready(function(){

Highcharts.chart('container', {
    chart: {
        backgroundColor: '#FCFFC5',
        type: 'line'
    },
    xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug',
            'Sep', 'Oct', 'Nov', 'Dec']
    },
    legend: {
        layout: 'vertical',
        backgroundColor: '#FFFFFF',
        floating: true,
        align: 'left',
        x: 100,
        verticalAlign: 'top',
        y: 70
    },
    tooltip: {
        headerFormat: '<b>{series.name}</b><br/>',
        pointFormat: '{point.category}: {point.y}'
    },
    series: [{
        data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4,
            194.1, 95.6, 54.4]
    }]
})	
});
</script>
</html>
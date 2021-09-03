<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<script src="${pageContext.request.contextPath}/resources/js/Chart.js}"></script>
<script type="text/javascript">
var ctx=document.getElementById('myChart');
var config={
		type: 'doughnut',
		data: {
			datasets: [{
				data: [
					10,20,30,40,50
				],
				backgroundColor: [
					"red",
					"orange",
					"yellow",
					"green",
					"blue"
				],
				label:'Dataset 1'
			}],
			labels: [
				'Red',
				'Orange',
				'Yellow',
				'Green',
				'Blue'
			]
		},
		option:{
			responsive:false,
			legend: {
				position: 'top',
			},
			title: {
				display: true,
				text: '종목별 투자비율'
			},
			animation:{
				animateScale:true,
				animateRotate: true
			}
			
		}
};
var myDoughnutChart = new Chart(ctx,config);
</script>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
   <canvas id="myChart" width="300" height="186"></canvas>
</body>
</html>
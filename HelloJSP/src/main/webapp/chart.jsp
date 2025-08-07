<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
		google.charts.load('current', {'packages':['corechart']});
		
		let countPerUser = [['User','Count']]
		
		fetch('chartData.do')
		.then(resolve => resolve.json())
		.then(result => 
		{
			for(let prop in result)
			{
				console.log(prop,result[prop]);
				countPerUser.push([prop, result[prop]]);
			}
			google.charts.setOnLoadCallback(drawChart);
			console.log(countPerUser);
		})
		.catch(err => console.error(err))
		
		function drawChart() 
		{
		
			var data = google.visualization.arrayToDataTable(countPerUser);
			
			var options = 
			{
				title: 'My Daily Activities'
			};
			
			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			
			chart.draw(data, options);
		}
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>

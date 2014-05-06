<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="height=device-height, width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0">
	<title>CS Poll</title>

	<!-- Production Font
	<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet" type="text/css"> 
	 -->
	<link rel="stylesheet" href="libs/semantic-ui/css/semantic.css">

	<style>
	body {
		font-family: 'PT Sans', Helvetica, Arial, sans-serif;
		font-size: 16px;
		line-height: 25px;
	}
	h1 {
		font-family: 'Arvo', Georgia, Times, serif;
		font-size: 59px;
		line-height: 70px;
	}

	.float.left {
		float: left;
	}
	</style>
</head>
<body>


	<div class="ui page grid three column">
		<h1 class="ui icon blue center aligned header">
			<i class="info icon"></i> CS Poll Result
			<div class="sub header">A quick poll software</div>
		</h1>

		<div class="sixteen wide column">
			<div id="container" style="height: 400px"></div>
		</div>
	</div>


	<script src="libs/jquery/jquery-1.11.1.js"></script>	
	<script src="libs/semantic-ui/javascript/semantic.js"></script>	
	<script src="libs/high-charts/js/highcharts.js"></script>
	<script src="libs/high-charts/js/highcharts-3d.js"></script>
	<script>
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
				enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '${description}'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Total Count ${totalCount}',
            data: [
                <c:forEach var="option" items="${options}">
                	['${option.optionString}', ${option.optionCount}],
                </c:forEach>
            ]
        }]
    });
});	
	</script>
</body>
</html>
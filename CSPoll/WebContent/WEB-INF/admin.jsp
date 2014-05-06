<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="height=device-height, width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0">
<title>CS Poll</title>

<link href="http://fonts.googleapis.com/css?family=Arvo"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=PT+Sans"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/css/semantic.css">


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
			<i class="help icon"></i> CS Poll
			<div class="sub header">A quick poll software</div>
		</h1>

		<div class="sixteen wide column">
			<table class="ui table segment">
				<thead>
					<tr>
						<th>Description</th>
						<th>Total Count</th>
						<th>Result Link</th>
						<th>Vote Link</th>
						<th>Reset Poll</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="poll" items="${polls}">
						<tr>
							<td>${poll.description}</td>
							<td>${poll.totalVote}</td>
							<td>
								<a href="ViewResult?id=${poll.id}"></a>
							</td>
							<td>
								<a href="Vote?id=${poll.id}"></a>
							</td>
							<td>
								<div class="ui blue icon button">
									<i class="icon refresh"></i>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/javascript/semantic.js"></script>
</body>
</html>
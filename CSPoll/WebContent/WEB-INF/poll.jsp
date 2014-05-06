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
			<div class="ui piled blue segment">
				<form action="Vote" method="post">
					<div class="ui header">
						<c:out value="${description}"></c:out>
					</div>

					<div class="ui divider"></div>

					<div class="ui list">

						<c:forEach var="option" items="${options}">

							<div class="item">
								<c:if test="${allowMultipleAnswer}">
									<input type="checkbox" class="ui checkbox" name="selectedOptionsIds"
										value="${option.id}">
								</c:if>
								<c:if test="${not allowMultipleAnswer}">
									<input type="radio" class="ui radio checkbox" name="selectedOptionsIds"
										value="${option.id}">
								</c:if>
								<div class="content">
									<c:out value="${option.optionString}"></c:out>
								</div>
							</div>
						</c:forEach>


					</div>

					<input type="hidden" name="id" value="${id}" />

					<input type="submit"
						class="ui fluid blue labeled submit icon button" value="Vote" />

				</form>
			</div>
		</div>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/javascript/semantic.js"></script>
</body>
</html>
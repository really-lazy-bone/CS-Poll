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

	<form action="createPoll" method="POST">

		<div class="ui page grid three column">
			<h1 class="ui icon blue center aligned header">
				<i class="add sign icon"></i> Adding New CS Poll
				<div class="sub header">A quick poll software</div>
			</h1>

			<div class="sixteen wide column">
				<div class="ui piled blue segment form">
					<div class="field">
						<label>Poll Description</label>
						<textarea name="description"></textarea>
					</div>

					<div class="ui divider"></div>

					<div id="options" class="ui list">
						<div class="item">
							<div class="fluid field">
								<div class="ui left labeled icon input">
									<input type="text" name="options" placeholder="Vote Option 1">
									<i class="tag icon"></i>
								</div>
							</div>
						</div>
					</div>

					<div class="ui divider"></div>

					<div class="inline field">
						<div class="ui checkbox">
							<input type="checkbox" id="allowMultipleAnswer" name="allowMultipleAnswer">
							<label for="allowMultipleAnswer">Allow Multiple Vote Choices</label>
						</div>
					</div>

					<div class="ui buttons">
						<div id="add_option" class="ui green labeled icon button">
							<i class="icon add"></i> Add Vote Option
						</div>
						<div class="or"></div>
						<input type="submit" id="done" class="ui blue labeled submit icon button">
							<i class="icon edit"></i> Done
						</input>
					</div>
				</div>
			</div>
		</div>

	</form>

	<script src="libs/jquery/jquery-1.11.1.js"></script>	
	<script src="libs/semantic-ui/javascript/semantic.js"></script>	
	<script>
		var count = 1;

		$('#add_option').click(function() {
			count ++;
			$('#options')
				.append("<div class='item'>"
						+ "<div class='fluid field'>"
							+ "<div class='ui left labeled icon input'>"
								+ "<input type='text' name='options' placeholder='Vote Option " + count + " '>"
								+ "<i class='tag icon'></i>"
							+ "</div>"
						+ "</div>"
					+ "</div>");
		});
	</script>
</body>
</html>
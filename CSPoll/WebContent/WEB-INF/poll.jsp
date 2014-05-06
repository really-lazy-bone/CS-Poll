<!DOCTYPE html>
<html lang="en" >
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="height=device-height, width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0">
	<title>CS Poll</title>

	<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet" type="text/css"> 
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/css/semantic.css">

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

	<div class="ui styled sidebar">
		<h3 class="ui header">Login Here</h3>
		<div class="ui form">
			<div class="field">
				<label>Username</label>
				<div class="ui icon input">
					<i class="user icon"></i>
					<input type="text" placeholder="Username">
				</div>
			</div>
			<div class="field">
				<label>Password</label>
				<div class="ui icon input">
					<i class="key icon"></i>
					<input type="text" placeholder="Password">
				</div>
			</div>
			<div class="ui blue fluid button"><i class="ui icon unlock"></i> Login</div>
		</div>
	</div>

	<div class="ui page grid three column">
		<div id="login" class="ui blue icon button float left">
			<i class="key icon"></i>
		</div>

		<h1 class="ui icon blue center aligned header">
			<i class="help icon"></i> CS Poll
			<div class="sub header">A quick poll software</div>
		</h1>

		<div class="sixteen wide column">
			<div class="ui piled blue segment">
				<div class="ui header">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deserunt, quos accusantium voluptatibus officia laboriosam labore quibusdam quidem ab ut commodi. Reprehenderit ab sed accusantium nulla harum explicabo odio quo nisi.
				</div>

				<div class="ui divider"></div>

				<div class="ui list">
					<div class="item">
						<i class="checked checkbox icon"></i>
						<div class="content">
							dummy description
						</div>
					</div>
					<div class="item">
						<i class="checked checkbox icon"></i>
						<div class="content">
							dummy description
						</div>
					</div>
					<div class="item">
						<i class="checked checkbox icon"></i>
						<div class="content">
							dummy description
						</div>
					</div>
					<div class="item">
						<i class="checked checkbox icon"></i>
						<div class="content">
							dummy description
						</div>
					</div>
				</div>

				<div class="ui fluid blue labeled submit icon button">
					<i class="icon edit"></i> Vote
				</div>
			</div>
		</div>
	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/javascript/semantic.js"></script>	
	<script>
		$('.ui.sidebar')
			.sidebar()
		;

		$('#login').click(function() {
			$('.ui.sidebar')
			  .sidebar('toggle')
			;
		});
	</script>
</body>
</html>
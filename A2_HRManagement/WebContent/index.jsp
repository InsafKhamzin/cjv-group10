<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
		<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css" />
		<link rel="stylesheet" href="styles/main.css" type="text/css" />
	</head>
	<body>
		<div class="container">
			<div class="containerBody">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<img src="images/logo.png" class="logoClass" alt="logo"><span class="title">HR Management</span>
					</div>
				</div>
				<form action="Login" method="POST">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="inputRow">
								Type your username and password to login the system.
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">							
						</div>
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
							<span style="color:red;">${error}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="inputRow inputFont">
								User Name:
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
							<input class="inputClass" type="text" id="username" name="username" value="${username}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="inputRow inputFont">
								Password:
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
							<input class="inputClass" type="text" id="password" name="password" value="${password}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<input type="submit" value="Login" class="loginButton btn btn-primary">
						</div>
					</div>
				</form>
			</div>
		</div>
	
	</body>
</html>
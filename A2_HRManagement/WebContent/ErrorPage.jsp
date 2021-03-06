<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Search Page</title>
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="user-info-class">
					<form action="Logout" method="POST">
						<span>${cookie['firstname'].getValue()} ${cookie['lastname'].getValue()}</span> 
						<button type="submit" class="logoutBtn"><img src="images/logout.jpeg" class="logoutClass" alt="logout"></button>
					</form>
				</div>
			</div>
		</div>
		<div class="contentBody">
			<h3>Oops! Something is wrong... Try later</h3>
			
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="inputRow marginBottom10">
					<form action="EmployeeList" method="get">
						<input class="btn btn-secondary" type="submit" value="Employee list">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
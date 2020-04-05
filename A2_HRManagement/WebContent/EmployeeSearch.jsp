<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Search Employee</title>
		<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css" />
		<link rel="stylesheet" href="styles/main.css" type="text/css" />
	</head>
	<body>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="user-info-class">
				<span>${cookie['username'].getValue()}</span>
				<form action="Logout" method="POST">
					<button type="submit"><img src="images/logout.jpeg" class="logoutClass" alt="logout"></button>
				</form>
				</div>
			</div>
		</div>
		<div class="container">
			<%@ include file="header.jsp" %>
			<div class="contentBody">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="title marginTop10">Search for Employee Page</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="contentText">
							Search for an Employee by typing in any part of a name, email address, phone number or department.
						</div>
					</div>
				</div>
				<form action="EmployeeSearch" method="POST">
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
							<span style="color:red;">${error}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
							<input class="inputClass" type="text" id="searchValue" name="searchValue" required>
						</div>
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
							<div class="inputRow">
								<input type="submit" value="Go">
							</div>
						</div>
					</div>
				</form>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
		
	</body>
</html>
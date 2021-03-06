<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employee List</title>
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
			<%@ include file="header.jsp" %>
			<div class="contentBody">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="title marginTop10">Employee List Page</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="contentText">
							Show employees in a department by typing in the department id and click on the button next or click on the Show All Employees for all employees in the company.
						</div>
					</div>
				</div>
				<form action="EmployeeList" method="POST">
				<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<span style="color:red;">${error}</span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Department ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" id="deptID" name="deptID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<div class="inputRow">
								<input type="submit" class="btn btn-outline-info btnClass" value="Show Department Employees">
							</div>
						</div>
					</div>					
				</form>
				<form action="EmployeeList" method="POST">
				<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<div class="inputRow">
								<input type="submit" class="btn btn-outline-info btnClass" value="Show All Employees">
							</div>
						</div>
					</div>
				</form>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
		
	</body>
</html>
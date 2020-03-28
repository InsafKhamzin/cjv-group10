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
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="user-info-class">
				<span>User Name</span> <img src="images/logout.jpeg" class="logoutClass" alt="logout">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="contentBody">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="title marginTop10">Employee List</div>
					</div>
				</div>
				<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="inputRow">
								Here is the information of employees from department of Sales
							</div>
						</div>
					</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<table>
						  	<tr>
							    <th>Employee ID</th>
							    <th>First Name</th>
							    <th>Last Name</th>
							    <th>Email</th>
							    <th>Phone Number</th>
							    <th>Hire Date</th>
							    <th>Job ID</th>
							    <th>Salary</th>
							    <th>Commission Pct</th>
							    <th>Manager ID</th>
							    <th>Department ID</th>
						  	</tr>
						  	<tr>
							    <td>145</td>
							    <td>John</td>
							    <td>Russel</td>
							    <td>JRUSSEL</td>
							    <td>011.44.1344.429268</td>
							    <td>10/31/1996</td>
							    <td>SA_MAN</td>
							    <td>$8000.0</td>
							    <td>0.4</td>
							    <td>100</td>
							    <td>80</td>
						  	</tr>
							<tr>
							    <td>146</td>
							    <td>Kasei</td>
							    <td>Partner</td>
							    <td>KPARTNER</td>
							    <td>011.44.1344.429278</td>
							    <td>01/05/1997</td>
							    <td>SA_MAN</td>
							    <td>$8500.0</td>
							    <td>0.3</td>
							    <td>100</td>
							    <td>80</td>
						  	</tr>
						</table>
					</div>
				</div>
				<div class="row fixedFooter">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="contentText">
							To return the <i>Employee List</i> page, click on the Back button in your browser or the Return button shown below.
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<div class="inputRow marginBottom10">
							<input type="submit" value="Return">
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>
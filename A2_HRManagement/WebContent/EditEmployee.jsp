<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Edit Employee</title>
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
						<div class="title marginTop10">Edit Employee Page</div>
					</div>
				</div>
				<form action="" method="POST">
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Employee ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="empID" name="empID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								First Name:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="firstName" name="firstName" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Last Name:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="lastName" name="lastName" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Email:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="email" id="emailID" name="emailID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Phone Number:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" id="phNum" name="phNum" maxlength="10" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Hire Date:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="date" id="hireDate" name="hireDate" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Job ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="jobID" name="jobID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Salary:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" id="salary" name="salary" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Comm Pct:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="commission" name="commission" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Manager ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="managerID" name="managerID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Department:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="deptID" name="deptID" required>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<div class="row">
								<div class="col-lg-3 col-sm-3 col-md-3 col-xs-3">
									<div class="inputRow marginBottom10">
										<input type="submit" value="Update the Employee">
									</div>
								</div>
								<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
									<div class="inputRow marginBottom10">
										<input type="submit" value="Delete the Employee">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row fixedFooter">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="contentText">
								To return the <i>Employee List</i> page, click on the Back button in your browser or the <i>Return</i> button shown below.
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="inputRow marginBottom10">
								<input type="submit" value="Return">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
				<form action="Logout" method="POST">
					<span>${cookie['username'].getValue()}</span> 
					<button type="submit" class="logoutBtn"><img src="images/logout.jpeg" class="logoutClass" alt="logout"></button>
				</form>
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
				<form action="EmployeeEdit" method="POST" class="marginTop10">
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
								Employee ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="empID" name="empID" readonly="readonly" value="${employee.employeeId}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								First Name:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="firstName" name="firstName" required value="${employee.firstName}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Last Name:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="lastName" name="lastName" required value="${employee.lastName}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Email:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="email" name="email" required value="${employee.email}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Phone Number:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="phNum" name="phNum" placeholder="777.777.777" maxlength="11" required value="${employee.phoneNumber}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Hire Date:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="text" id="hireDate" name="hireDate" placeholder="yyyy-MM-dd" required value="${employee.hireDate}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Job ID:
							</div>
						</div>						
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">										
							<select class="inputClass" id="jobID" name="jobID">
								<c:forEach var="j" items="${jobs}">
									<option value="${j}" ${employee.jobId == j ? 'selected="selected"' : ''}>
										<c:out value="${j}" />
									</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Salary:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" step="0.1" id="salary" name="salary" required value="${employee.salary}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Comm Pct:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" step="0.01" max="0.99" id="commission" name="commission" required value="${employee.commissionPercent}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Manager ID:
							</div>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<input class="inputClass" type="number" id="managerID" name="managerID" required value="${employee.managerId}">
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
							<div class="inputRow inputFont">
								Department:
							</div>
						</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">										
						<select class="inputClass" id="deptID" name="deptID">
							<c:forEach var="d" items="${departments}">
								<option value="${d.id}" ${employee.departmentId == d.id ? 'selected="selected"' : ''}>
									<c:out value="${d.name}" />
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
					<div class="row">
						<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						</div>
						<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
							<div class="row">
								<div class="col-lg-3 col-sm-3 col-md-3 col-xs-3">
									<div class="inputRow marginBottom10">
										<input type="submit" class="btn btn-outline-success" value="Update Employee">
									</div>
								</div>
							</div>
						</div>
					</div>										
				</form>

			<div class="row">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<div class="row">
						<form action="EmployeeDelete" method="POST">
							<div class="col-lg-3 col-sm-3 col-md-3 col-xs-3">
								<div class="inputRow marginBottom10">
									<input type="hidden" name="empID" value="${employee.employeeId}"> 
									<input type="submit" class="btn btn-outline-danger" value="Delete Employee">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="contentText">
					To return the <i>Employee List</i> page, click on the Back button
					in your browser or the <i>Return</i> button shown below.
				</div>
			</div>
			<form action="EmployeeList" method="get">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="inputRow marginBottom10">
						<input type="submit" class="btn btn-outline-dark" value="Return">
					</div>
				</div>
			</form>
		</div>
		</div>
		
	</body>
</html>
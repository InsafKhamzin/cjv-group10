<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="title marginTop10">Employee List</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="inputRow">
						<% 
							String deptName = (String) request.getAttribute("deptName");
							if(deptName == null){
								out.print("Here is the information of all employees");
							} else{
								out.print("Here is the information of employees from department of " + deptName);
							}
						%>
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
						<c:forEach var="e" items="${employees}">
							<tr>
								<td><a href="EmployeeEdit?empId=${e.employeeId}"><c:out value="${e.employeeId}"/></a></td>
								<td><c:out value="${e.firstName}" /></td>
								<td><c:out value="${e.lastName}" /></td>
								<td><c:out value="${e.email}" /></td>
								<td><c:out value="${e.phoneNumber}" /></td>
								<td><c:out value="${e.hireDate}" /></td>
								<td><c:out value="${e.jobId}" /></td>
								<td><c:out value="${e.salary}" /></td>
								<td><c:out value="${e.commissionPercent}" /></td>
								<td><c:out value="${e.managerId}" /></td>
								<td><c:out value="${e.departmentId}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="contentText">
					To return the <i>Employee List</i> page, click on the Back button
					in your browser or the Return button shown below.
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="inputRow marginBottom10">
					<form action="EmployeeList" method="get">
						<input class="btn btn-outline-dark" type="submit" value="Return">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
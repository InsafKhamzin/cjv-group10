<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Employee Search</title>
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
						<div class="title marginTop10">Search for Employee</div>
					</div>
				</div>
				<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="inputRow">
								Employee search result for input: ${ searchValue }
							</div>
						</div>
					</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<table>
						  	<tr>
							    <th>Name</th>
							    <th>Department</th>
							    <th>Job ID</th>
							    <th>Salary</th>
							    <th>Email</th>
							    <th>Phone Number</th>
						  	</tr>
						  	<c:forEach var="e" items="${employees}">
								<tr>
									<td><c:out value="${e.firstName} ${e.lastName}" /></td>
									<td><c:out value="${e.departmentName}" /></td>
									<td><c:out value="${e.jobId}" /></td>
									<td><c:out value="${e.salary}" /></td>
									<td><a href="mailto:<c:out value="${e.email}"/>"><c:out value="${e.email}"/></a></td>
									<td><c:out value="${e.phoneNumber}" /></td>
								</tr>
						</c:forEach>
						</table>
					</div>
				</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="contentText">
					To return the <i>Search for Employee</i> page, click on the Back
					button in your browser or the Return button shown below.
				</div>
			</div>
			<form action="EmployeeSearch" method="get">
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
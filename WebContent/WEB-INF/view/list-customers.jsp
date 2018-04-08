<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="styLesheet"
		  href="${pageContext.request.contextPath}/resources/CSS/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
	
	<!--  Adding input button -->
	<input type="button" value="Add Customer"
		onclick="window.location.href='showFromForAdd'; return 	false";
		class="add-button"/>	
		
               <form:form action="searchCustomer" method="POST">
                Search customer: <input type="text" name="first_name" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
     
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
						
					<!-- url for customer update -->
					<c:url var="updateLink" value="/customers/showFromForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						
						
						<c:url var="deleteLink" value="/customers/showFromForDelete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
					<tr>
						<td> ${tempCustomer.first_name} </td>
						<td> ${tempCustomer.last_name} </td>
						<td> ${tempCustomer.email} </td>
						<td> <a href="${updateLink}">Update</a>
							<td> <a href="${deleteLink}">delete</a>
						<td>
						
						
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customers/list">Back to List</a>
		</p>
	
</body>

</html>










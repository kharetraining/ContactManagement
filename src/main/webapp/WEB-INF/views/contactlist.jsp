<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List</title>
</head>
<body>
<h1 align="center">Customer Contact Management</h1>
	<table align="center" border="1">
		<tr>
			<th>ContactId</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Status</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.contactId}</td>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.email}</td>
				<td>${contact.phoneNumber}</td>
				<td>${contact.status}</td>
				<td><a href="/customer/updatecontact/${contact.contactId}">editContact</a></td>
				<td><a href="/customer/deleteContact/${contact.contactId}">deleteContact</a></td>
			</tr>
		</c:forEach>
		<tr>
			</br>
			<td align="center"><a href="/customer/addContact">Add Contact</a></td>
		</tr>
	</table>
</body>
</html>
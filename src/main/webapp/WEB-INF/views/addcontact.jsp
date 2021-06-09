<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
<form:form method="post" action="/customer/addContact${contact.contactId}">
	<h1 align="center">Add New Contact</h1>
	<table align="center" border="1">
		<tr>
			<td>First Name :</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Phone Number :</td>
			<td><form:input path="phoneNumber"/></td>
		</tr>
		<tr>
			<td>Status :</td>
			<td><form:input path="status"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="AddContact"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>
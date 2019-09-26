<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hurricane Tracker - Web Version</title>
<style>
	table {
		padding: 5px;
	}
	td {
		padding: 5px;
	}
</style>
</head>
<body>
<h1>Welcome to the Web Hurricane Tracker!</h1>
<h4>Enter the information below to add a hurricane to our database:</h4>
<p>
<form action="addHurricaneServlet" method="post">
<table>
<tr><td>Name: </td><td><input type="text" name="name" required="required"></td></tr>
<tr><td>Year: </td><td><input type="text" name="year" required="required"></td></tr>
<tr><td>Category: </td><td><input type="text" name="cat" required="required"></td></tr>
<tr><td></td><td><input type="submit" value="Add Hurricane" style="float: right;"></td></tr>
</table>
</form>
</p>
<p>
${added.getAdded()}
</p>
<p>
<a href="viewAllHurricanesServlet">View All Hurricanes!</a>
</p>
</body>
</html>
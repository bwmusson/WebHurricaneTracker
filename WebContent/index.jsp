<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hurricane Tracker - Web Version</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="validation.js"></script>
</head>
<body>
<h1>Welcome to the Web Hurricane Tracker!</h1>
<h4>Enter the information below to add a hurricane to our database:</h4>
<p>
<form name="addForm" action="addHurricaneServlet" method="post" onsubmit="return validateForm(this);">
<table>
	<tr>
		<td>Name: </td>
		<td>
			<input type="text" id="name" name="name"><br>
			<span id="nameError"></span>
		</td>
	</tr>
	<tr>
		<td>Year: </td>
		<td>
			<input type="text" id="year" name="year"><br>
			<span id="yearError"></span>
		</td>
	</tr>
	<tr>
		<td>Category: </td>
		<td>
			<input type="text" id = "cat" name="cat"><br>
			<span id="catError"></span>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Add Hurricane" style="float: right;" onclick="return validateForm();"></td>
	</tr>
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
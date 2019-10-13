<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Hurricane | Hurricane Tracker - Web Version</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="validation.js"></script>
</head>
<body>
<h1>Edit Hurricane</h1>
<br>
<form action = "editHurricaneServlet" method="post" onsubmit="return validateForm(this);">
<table>
<tr>
		<td>Name: </td>
		<td>
			<input type="text" id="name" name="name" value="${itemToEdit.name}"><br>
			<span id="nameError"></span>
		</td>
	</tr>
	<tr>
		<td>Year: </td>
		<td>
			<input type="text" id="year" name="year" value="${itemToEdit.year}"><br>
			<span id="yearError"></span>
		</td>
	</tr>
	<tr>
		<td>Category: </td>
		<td>
			<input type="text" id = "cat" name="cat" value="${itemToEdit.category}"><br>
			<span id="catError"></span>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="hidden" name="id" value="${itemToEdit.id}"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Save Changes" style="float: right;" onclick="return validateForm();"></td>
	</tr>
</table>
</form>
</body>
</html>
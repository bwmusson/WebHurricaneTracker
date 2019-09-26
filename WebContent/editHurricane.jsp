<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Hurricane | Hurricane Tracker - Web Version</title>
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
<h1>Edit Hurricane</h1>
<br>
<form action = "editHurricaneServlet" method="post">
<table>
<tr><td>Name: </td><td><input type="text" name="name" value="${itemToEdit.name}"></td></tr>
<tr><td>Year: </td><td><input type="text" name="year" value="${itemToEdit.year}"></td></tr>
<tr><td>Category: </td><td><input type="text" name="cat" value="${itemToEdit.category}"></td></tr>
<tr><td></td><td><input type="hidden" name="id" value="${itemToEdit.id}"></td></tr>
<tr><td></td><td><input type="submit" value="Save Changes" style="float: right;"></td></tr>
</table>
</form>
</body>
</html>
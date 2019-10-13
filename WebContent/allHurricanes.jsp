<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Hurricanes | Hurricane Tracker - Web Version</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="validation.js"></script>
</head>
<body>
<h1>All Hurricanes</h1>
<h4>Below are all the hurricanes in our database:</h4>
<form method="post" action="navigationServlet" onsubmit="return validateNav(this);">
<table>
<tr>
 <th></th>
 <th>Name</th>
 <th>Year</th>
 <th>Category</th>
</tr>
<c:forEach items="${requestScope.allHurricanes}" var="currentHurricane">
<tr>
 <td><input type="radio" name="id" value="${currentHurricane.id}" 
 	onclick="document.getElementById('selectedId').value = ${currentHurricane.id};"></td>
 <td>${currentHurricane.name}</td>
 <td>${currentHurricane.year}</td>
 <td>${currentHurricane.category}</td>
 </tr>
</c:forEach>
<tr></tr>
<tr>
 <td></td>
 <td><input type="submit" value="Edit" name="doThisToItem" onclick="return validateNav();"></td>
 <td><input type="submit" value="Delete" name="doThisToItem" onclick="return validateNav();"></td>
 <td><input type="button" value="Add" onclick="location.href='index.jsp'"></td>
</tr>
</table>
</form>
<p><input hidden="hidden" type="text" id="selectedId" value="${selectedId}"></input><span id="formError"></span></p>
</body>
</html>
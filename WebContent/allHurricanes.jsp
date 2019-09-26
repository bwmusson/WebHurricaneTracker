<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Hurricanes | Hurricane Tracker - Web Version</title>
<style>
	table {
		padding: 5px;
		border-collapse: collapse;
	}
	td, th {
		border: 1px solid #ddd;
  		padding: 8px;
  		text-align: center;
	}
	tr:nth-child(even){
		background-color: #f2f2f2;
	}
	th {
		padding-top: 12px;
 	 	padding-bottom: 12px;
 	 	font-style: bold;
 	}
	
</style>
</head>
<body>
<h1>All Hurricanes</h1>
<h4>Below are all the hurricanes in our database:</h4>
<form method = "post" action = "navigationServlet">
<table>
<tr>
 <th></th>
 <th>Name</th>
 <th>Year</th>
 <th>Category</th>
</tr>
<c:forEach items="${requestScope.allHurricanes}" var="currentHurricane">
<tr>
 <td><input type="radio" name="id" value="${currentHurricane.id}"></td>
 <td>${currentHurricane.name}</td>
 <td>${currentHurricane.year}</td>
 <td>${currentHurricane.category}</td>
 </tr>
</c:forEach>
<tr></tr>
<tr>
 <td></td>
 <td><input type="submit" value="Edit" name="doThisToItem"></td>
 <td><input type="submit" value="Delete" name="doThisToItem"></td>
 <td><input type="submit" value="Add" name="doThisToItem"></td>
</tr>
</table>
</form>
</body>
</html>
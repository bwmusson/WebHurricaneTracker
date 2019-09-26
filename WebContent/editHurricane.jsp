<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editHurricaneServlet" method="post">
Name: <input type="text" name="name" value="${itemToEdit.name}">
Year: <input type="text" name="year" value="${itemToEdit.year}">
Category: <input type="text" name="cat" value="${itemToEdit.category}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Save Changes">
</form>
</body>
</html>
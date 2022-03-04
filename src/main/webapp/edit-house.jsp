<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="editHouseServlet" method="post">
		Street: <input type="text" name="street" value="${houseToEdit.street}">
		City: <input type="text" name="city" value="${houseToEdit.city}">
		State: <input type="text" name="state" value="${houseToEdit.state}">
		Zip Code: <input type="text" name="zip" value="${houseToEdit.zip}">
		<input type="hidden" name="id" value="${houseToEdit.id}">
		<input type="submit" value="Save Edit">
	</form>
</body>
</html>

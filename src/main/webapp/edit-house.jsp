<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit House</title>

<link rel="stylesheet" href="style.css">

</head>
<body>
	
	<h1>
		<strong>Edit House</strong>
	</h1>
	
	<ul> 
		<li><a href="index.html">Home</a></li>
		<li><a href="viewAllHousesServlet">View all houses for sale</a></li>
		<li><a href="viewAllShowingListsServlet">View all showing lists</a></li>
		<li><a href="addHousesForShowingListServlet">Create a new showing list</a></li>
	</ul>
	
	<div class="form-center">
	<form action="editHouseServlet" method="post">
		Street: <input type="text" name="street" value="${houseToEdit.street}">
		City: <input type="text" name="city" value="${houseToEdit.city}">
		State: <input type="text" name="state" value="${houseToEdit.state}">
		Zip Code: <input type="text" name="zip" value="${houseToEdit.zip}">
		<input type="hidden" name="id" value="${houseToEdit.id}">
		<input type="submit" value="Save Edit">
	</form>
	</div>
</body>
</html>

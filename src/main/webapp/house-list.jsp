<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Housing List</title>

<link rel="stylesheet" href="style.css">

</head>
<body>

	<h1>
		<strong>Housing List</strong>
	</h1>

	<ul> 
		<li><a href="index.html">Home</a></li>
		<li><a href="viewAllHousesServlet">View all houses for sale</a></li>
		<li><a href="viewAllShowingListsServlet">View all showing lists</a></li>
		<li><a href="addHousesForShowingListServlet">Create a new showing list</a></li>
	</ul>
	
	<div class="form-center">
	<form method="post" action="navigationServlet">
		<table>
			<!-- This is a JSP iteration tag from the Standard Tag Library (JSTL) -->
			<c:forEach items="${requestScope.allHouses}" var="currentItem">
				<tr>
					<td><input type="radio" name="id" value="${currentItem.id}"></td>
					<td>${currentItem.street}</td>
					<td>${currentItem.city}</td>
					<td>${currentItem.state}</td>
					<td>${currentItem.zip}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value = "add" name = "doThisToHouse">
		<input type = "submit" value = "edit" name="doThisToHouse">
		<input type = "submit" value = "remove" name="doThisToHouse">
	</form>
	</div>
</body>
</html>

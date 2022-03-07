<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Housing List</title>
</head>
<body>
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
</body>
</html>

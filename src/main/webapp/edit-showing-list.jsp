<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Showing</title>
</head>
<body>
	<form action="editShowingListServlet" method="post">
		<input type="hidden" name="id" value="${showingListToEdit.id}">
		Showing list name:<input type="text" name="listName" value= "${showingListToEdit.showingName}"><br />
		Showing date: <input type ="text" name="month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}"><br />
		Realtor name: <input type="text" name="realtorName" value="${showingListToEdit.realtor.name}"><br />
		Realtor company: <input type="text" name="realtorCompany" value="${showingListToEdit.realtor.company}"><br />

		Houses:<br />
		<select name="allHousesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allHouses}" var="currentItem">
	   			<option value = "${currentItem.id}">${currentItem.street} ${currentItem.city}, ${currentItem.state}, ${currentItem.zip}</option>
			</c:forEach>
		</select><br />

		<input type="submit" value="Submit">
	</form>
	<a href="index.html">Add houses instead</a>
</body>
</html>
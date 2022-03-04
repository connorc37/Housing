<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="showingListNavServlet">
		<table>
			<c:forEach items="${requestScope.allShowingLists}" var="item">
				<tr>
					<td><input type="radio" name="id" value="${item.id}"></td>
					<td><h2>${item.showingName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Showing Date: ${item.showingDate}</td>
				</tr>
				<tr>
					<td colspan="3">Realtor: ${item.realtor.name}</td>
				</tr>
				<c:forEach items="${item.listOfShowings}" var="currentItem">
					<tr>
						<td colspan="3">${currentItem.street} ${currentItem.city}, ${currentItem.state}, ${currentItem.zip}</td>
					</tr>
				</c:forEach>
				
			</c:forEach>
		</table>
		<input type="submit" value="add" name="doThisToShowingList">
		<input type="submit" value="edit" name="doThisToShowingList">
		<input type="submit" value="remove" name="doThisToShowingList">
	</form>
	<a href="index.html">Add a new house</a>
</body>
</html>
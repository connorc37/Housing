<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Showing</title>
</head>
<body>
	<form action="addShowingListServlet" method="post">
		Showing list name: 
		<input type="text" name="showingListName"><br />
		
		Showing date: 
		<input type="text" name="month" placeholder="mm" size="3">
		<input type="text" name="day" placeholder="dd" size="3">, 
		<input type="text" name="year" placeholder="yyyy" size="3"><br />
		
		Realtor name: 
		<input type="text" name="realtorName"><br /> 
		
		Realtor company:
		<input type="text" name="realtorCompany"><br />
		
		Houses:<br />
		<select name="housesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allHouses}" var="currentItem">
				<option value="${currentItem.id}"> 
					${currentItem.street}, ${currentItem.city}, ${currentItem.state} ${currentItem.zip}
				</option>
			</c:forEach>
		</select><br />
		<a href="index.html">House not listed? Add another!</a><br />
		<input type="submit" value="Create">
	</form>
</body>
</html>
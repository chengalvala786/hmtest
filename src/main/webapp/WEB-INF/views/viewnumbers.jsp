<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sorted Numbers Page</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/static/css/main.css" />" />
</head>
<body>
<h1>
	Generated Sorted Numbers
</h1>


<br>
<h3>Sort List</h3>
<c:if test="${!empty sortNumbers}">
	<table class="tg">
	<tr>
		<th width="80">Sort Number</th>
		
	</tr>
	<c:forEach items="${sortNumbers}" var="item">
		<tr>
			<td>${item.sortNumber}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>

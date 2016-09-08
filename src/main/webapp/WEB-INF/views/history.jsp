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
	Generate Sorted Numbers
</h1>
<c:url var="generateAction" value="/numbers/generate" ></c:url>

<form:form action="${generateAction}" commandName="sortInfo">
<table>
	
	<tr>
		<td>
			<form:label path="sizeOfNumbers">
				<spring:message text=" Enter the size of numbers : "/>
			</form:label>
		</td>
		<td>
			<form:input path="sizeOfNumbers" />
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			
				<input type="submit"
					value="<spring:message text="Generate Numbers"/>" />
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Sort List</h3>
<c:if test="${!empty sortList}">
	<table class="tg">
	<tr>
		<th width="80">Sort ID</th>
		<th width="120">Sort Swaps</th>
		<th width="120">Sort Dates</th>
		<th width="120">Sort number count</th>
		<th width="60">Action</th>
		
	</tr>
	<c:forEach items="${sortList}" var="sortInfo">
		<tr>
			<td>${sortInfo.id}</td>
			<td>${sortInfo.sortSwaps}</td>
			<td>${sortInfo.sortDate}</td>
			<td>${sortInfo.sizeOfNumbers}</td>
			<td><a href="<c:url value='/view/numbers/${sortInfo.id}' />" >View Numbers</a></td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>

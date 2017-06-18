<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add suit</title>
	<%--<link rel="stylesheet" href="/css/suitofdelivery.css" type="text/css">--%>
</head>
<body>

	<sf:form modelAttribute="suitofdelivery" action="/suitofdelivery?${_csrf.parameterName}=${_csrf.token}" method="post"
	enctype="multipart/form-data">
		<span style="color: #e74c3c; text-align: center">${suitException}</span>
			<input type="text" name="name"/>

			<input type="file" name="image"/>

		<button>save suit</button>

	</sf:form>



	<table style="border:  1px solid black">
		<tr>
			<th style="border:  1px solid black">image</th>
			<th style="border:  1px solid black">name</th>
			<th style="border:  1px solid black">delete</th>
			<th style="border:  1px solid black">update</th>

			<c:forEach var="u" items="${suitofdeliveries }">
		<tr>
			<th style="border:  1px solid black"> <img src="/${u.pathImage}" alt="" width="7%" height="8%"></th>
			<th style="border:  1px solid black"> ${u.name}</th>

			<th style="border:  1px solid black"> <a href="/deleteSuitOfDelivery/${u.id }">delete</a></th>
			<th style="border:  1px solid black"> <a href="/updateSuitOfDelivery/${u.id }">update</a></th>
		</tr>
		</c:forEach>
		</tr>



	</table>

</body>
</html>
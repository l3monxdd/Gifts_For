<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add suit</title>
	<link rel="stylesheet" href="/css/suitofdelivery.css" type="text/css">
</head>
<body>

	<sf:form action="/suitofdelivery" method="post">
		<span style="color: #e74c3c; text-align: center">${suitException}</span>
			<input type="text" name="name"/>

		<button>save suit</button>

	</sf:form>





<%--<div style="text-align: center;margin-top: 10%">--%>
	<%----%>
	<%--<form action="/suitofdelivery" method="post">--%>
		<%--<input type="text" name="name_of_suit" placeholder="name_of_suit">--%>
		<%--<br>--%>
		<%--<button>add name_of_suit"</button>--%>
	<%--</form>--%>

<%--</div>--%>


	<table style="border:  1px solid black">
		<tr>
			<th style="border:  1px solid black">name_of_suit</th>
			<th style="border:  1px solid black">delete</th>

			<c:forEach var="u" items="${suitofdeliveries }">
		<tr>
			<th style="border:  1px solid black"> ${u.name}</th>

			<th style="border:  1px solid black"> <a href="/deleteSuitOfDelivery/${u.id }">delete</a></th>
		</tr>
		</c:forEach>
		</tr>



	</table>

</body>
</html>
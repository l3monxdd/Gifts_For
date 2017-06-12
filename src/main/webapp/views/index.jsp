<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>

	<link rel="stylesheet" href="/css/index.css" type="text/css">


</head>
<body>
<h1 style="text-align: center;">index</h1>


	<li class="active">
		<sec:authentication property="name"/>
	</li>
	<sec:authorize access="isAuthenticated()">
	<li>
		<form:form action="/logout" method="post">
			<button class="btn btn-default">logout</button>
		</form:form>
	</li>
	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
	<li>
	<a href="/registration">Sign in and Registration</a>
	</li>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	<li>
		<a href="/profile">profile</a>
	</li>
	</sec:authorize>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<li>
			<a href="/suitofdelivery">Suitofdelivery</a>
		</li>
		<li>
			<a href="/measuringsystem">MeasuringSystem</a>
		</li>
		<li>
			<a href="/commodity">Commodity</a>
		</li>
		<li>
			<a href="/address">Address</a>
		</li>
	</sec:authorize>



<%--<div class="block3">--%>
<%--<c:forEach var="commodity" items="${commodities}">--%>
	<%--<li> ${commodity.name_of_commodity} ${commodity.price_id_uan} </li>--%>
<%--</c:forEach>--%>
<%--</div>--%>


<c:forEach var="commodity" items="${commodities}">
	<div class="block3">
		<li>${commodity.name_of_commodity} ${commodity.counter} ${commodity.price_id_uan}

			<%--<c:forEach var="ms" items="${commodity.measuringSystems}">--%>
				<%--${ms.name}--%>
			<%--</c:forEach>--%>
			<sec:authorize access="hasAnyRole('ROLE_USER')">
			<td>
				<a href="/addIntoBasket/${commodity.id}">basket</a>
			</td>
			</sec:authorize>

		</li>
	</div>
</c:forEach>











</body>
</html>
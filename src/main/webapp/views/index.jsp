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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="/js/index.js"></script>
	<%--<script language="JavaScript" type="text/javascript" src="/js/index.js"></script>--%>
	<%--<script type="text/javascript" src="webapp/js/index.js"></script>--%>
	<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>--%>




</head>


<body>




<div class="wrapper">
	<h1>Navigation</h1>
	<ul class="nav-list">
		<sec:authorize access="!isAuthenticated()">
		<li  class="registration"><a href="/registration">SignIn/Registration</a></li>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<li class="commodity"><a href="/commodity">commodity</a></li>
		<li class="measuringsystem"><a href="/measuringsystem">measuringsystem</a></li>
		<li class="suitofdelivery"><a href="/suitofdelivery">Suitofdelivery</a></li>
		<li class="address"><a href="/address">address</a> </li>
		</sec:authorize>
		<li class="au1">
			<sec:authorize access="isAuthenticated()">
				|user| - <sec:authentication property="name"/>
			</sec:authorize>
		</li>
		<li class="logout">
			<sec:authorize access="isAuthenticated()">
			<form:form action="/logout" method="post">
				<button class="btn btn-default">logout</button>
			</form:form>
			</sec:authorize>
		</li>

		<sec:authorize access="isAuthenticated()">
			<li class="profile"><a href="/profile">Your Profile</a> </li>
		</sec:authorize>
	</ul>
</div>


<c:forEach var="commodity" items="${commodities.content}">
	<form>
	<div class="block3" style="text-align:  center">
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
	</form>
</c:forEach>

<a href="/?page=${commodities.number}&size=${commodities.size}">previous</a>
<a href="/?page=${commodities.number+ 2}&size=${commodities.size}">next</a>











</body>
</html>
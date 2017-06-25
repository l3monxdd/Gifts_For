<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
		<li  class="registration"><a href="/registration"><spring:message code="label.registration"/></a></li>
		</sec:authorize>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
		<li class="commodity"><a href="/commodity"><spring:message code="label.commodity"/></a></li>
		<li class="measuringsystem"><a href="/measuringsystem"><spring:message code="label.measuringsystem"/></a></li>
		<li class="suitofdelivery"><a href="/suitofdelivery"><spring:message code="label.suitofdelivery"/></a></li>
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
				<button class="btn btn-default"><spring:message code="label.logout"/></button>
			</form:form>
			</sec:authorize>
		</li>

		<sec:authorize access="isAuthenticated()">
			<li class="profile"><a href="/profile"><spring:message code="label.profile"/></a> </li>
		</sec:authorize>

		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" role="button"
			   aria-haspopup="true" aria-expanded="false">
				<spring:message code="label.lang"/> <span class="caret"></span>
				<ul class="dropdown-menu">
					<li><a href="?lang=ua">ua</a></li>
					<li><a href="?lang=en">en</a></li>
				</ul>
			</a>
		</li>
	</ul>
</div>


<c:forEach var="commodity" items="${commodities.content}">
	<form>
	<div class="block3" style="text-align:  center">
		<li>${commodity.name_of_commodity} ${commodity.counter} ${commodity.price_id_uan}

				<%--<c:forEach var="ms" items="${commodity.measuringSystems}">--%>
				<%--${ms.name}--%>
				<%--</c:forEach>--%>
			<img src="${commodity.pathImage}" alt="" width="15%" height="30%">
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
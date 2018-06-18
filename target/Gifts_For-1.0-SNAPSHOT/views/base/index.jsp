<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



					<%--////////////////////////////--%>
							 <%--blocks here--%>
			<%--<link rel="stylesheet" href="/css/index.css" type="text/css">--%>
					<%--&lt;%&ndash;/////////////////////////////&ndash;%&gt;--%>
	<%--<link rel="stylesheet" href="/bootstrap/bootstrap-theme.css" type="text/css">--%>
	<%--<link rel="stylesheet" href="/bootstrap/bootstrap.css" type="text/css">--%>

	<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
	<%--<script src="/js/index.js"></script>--%>

	<%--//////////////////////////--%>
	<%--<script language="JavaScript" type="text/javascript" src="/js/index.js"></script>--%>
	<%--<script type="text/javascript" src="webapp/js/index.js"></script>--%>
	<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>--%>
	<%--////////////////////////////////--%>


	<br>
<table class="table table-hover">
	<thead>
	<tr>
		<th>image</th>
		<th>name</th>
		<th>quantity</th>
		<th>measuringSystem</th>
		<th>price</th>
		<th></th>
	</tr>
	</thead>

<c:forEach var="commodity" items="${commodities.content}">
	<div class="block3">
	<form>
	<%--<div class="block3" style="text-align:  center">--%>
		<tr>
			<td>
				<img src="${commodity.pathImage}" alt="" height="250px" width="250px">
			</td>
			<td>
				${commodity.name_of_commodity}
			</td>
			<td>
				${commodity.quantity}
			</td>
			<td>
					${commodity.measuringSystem.name}
			</td>
			<td>
				${commodity.price_id_uan}
			</td>

				<%--<c:forEach var="ms" items="${commodity.measuringSystems}">--%>
				<%--${ms.name}--%>
				<%--</c:forEach>--%>
			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<td>
				<c:choose>
					<c:when test="${uniquser.commodities.contains(commodity)}">
						<td>commodity already in basket</td>
					</c:when>
					<c:otherwise>
						<td>
							<a href="/addIntoBasket/${commodity.id}">basket</a>
						</td>
					</c:otherwise>
				</c:choose>
				</td>
				<%--<td>--%>
					<%--<a href="/addIntoBasket/${commodity.id}">basket</a>--%>
				<%--</td>--%>
			</sec:authorize>
		</tr>
	<%--</div>--%>
	</form>
	</div>
</c:forEach>
</table>

<a href="/?page=${commodities.number}&size=${commodities.size}">previous</a>
<a href="/?page=${commodities.number+ 2}&size=${commodities.size}">next</a>


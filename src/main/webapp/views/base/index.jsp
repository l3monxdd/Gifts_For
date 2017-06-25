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

<c:forEach var="commodity" items="${commodities.content}">
	<form>
	<div class="block3" style="text-align:  center">
		<li>${commodity.name_of_commodity} ${commodity.counter} ${commodity.price_id_uan}

				<%--<c:forEach var="ms" items="${commodity.measuringSystems}">--%>
				<%--${ms.name}--%>
				<%--</c:forEach>--%>
			<img src="${commodity.pathImage}" alt="" width="13%" height="25%">
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


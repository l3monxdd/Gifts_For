<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/commodity.css" type="text/css">

</head>
<body>

	<form:form modelAttribute="commodity" action="/commodity" method="post">

		<span style="color: #e74c3c; text-align: center";>${commodityNameException}</span>
		<form:input path="name_of_commodity" placeholder="name_of_commodity"/>
		<form:input path="price_id_uan" placeholder="price_id_uan"/>
		<form:input path="quantity" placeholder="counter"/>




		<select name="ms">
			<c:forEach var="ms" items="${measuringSystems}">
				<option value="${ms.id}">${ms.name}</option>
			</c:forEach>
		</select>

		<button>save commodity</button>

	</form:form>



	<%--<form action="/commodity" method="post">--%>

		<%--<input name="name_of_commodity" type="text" placeholder="name_of_commodity">--%>
		<%--<input name="counter" type="number" placeholder="counter">--%>
		<%--<input name="price_id_uan" type="text" placeholder="price_id_uan">--%>
		<%--<input name="bonus_money" type="text" placeholder="bonus_money">--%>



		<%--<select name="ms">--%>
			<%--<c:forEach var="ms" items="${measuringSystems}">--%>
				<%--<option value="${ms.id}">${ms.name}</option>--%>
			<%--</c:forEach>--%>
		<%--</select>--%>

		<%--<button>save commodity</button>--%>

	<%--</form>--%>


		<c:forEach var="commodity" items="${commodities.content}">
			<div class="block3">
			<li>${commodity.name_of_commodity} ${commodity.counter} ${commodity.price_id_uan}

				<c:forEach var="ms" items="${commodity.measuringSystems}">
					${ms.name}
				</c:forEach>

				<a href="/deleteCommodity/${commodity.id}">delete</a>
				<a href="/updateCommodity/${commodity.id}">update</a>
			</li>
			</div>
		</c:forEach>


	<a href="/commodity/?page=${commodities.number}&size=${commodities.size}">previous</a>
	<a href="/commodity/?page=${commodities.number+ 2}&size=${commodities.size}">next</a>

		
</body>
</html>
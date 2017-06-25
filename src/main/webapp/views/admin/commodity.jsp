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

	<form:form action="/commodity?${_csrf.parameterName}=${_csrf.token}" method="post"
			   enctype="multipart/form-data">

		<span style="color: #e74c3c; text-align: center">${commodityNameException}</span>
			<input name="name_of_commodity" type="text" placeholder="name_of_commodity"/>
			<input name="price_id_uan" type="text" placeholder="price_id_uan"/>
			<input name="quantity" type="text" placeholder="quantity"/>
			<input type="file" name="image" required="required"/>
			<select name="ms" >
				<c:forEach var="ms" items="${measuringSystems}">
					<option  value="${ms.id}">${ms.name}</option>
				</c:forEach>
			</select>

		<button>save commodity</button>

	</form:form>



		<c:forEach var="commodity" items	="${commodities.content}">
			<div class="block3">
			<li>${commodity.name_of_commodity} ${commodity.quantity} ${commodity.price_id_uan}
				<img src="/${commodity.pathImage}" alt="" width="10%" height="15%">


				${commodity.measuringSystem.name}


				<a href="/deleteCommodity/${commodity.id}">delete</a>
				<a href="/updateCommodity/${commodity.id}">update</a>
			</li>
			</div>
		</c:forEach>







	<a href="/commodity/?page=${commodities.number}&size=${commodities.size}">previous</a>
	<a href="/commodity/?page=${commodities.number+ 2}&size=${commodities.size}">next</a>

		
</body>
</html>
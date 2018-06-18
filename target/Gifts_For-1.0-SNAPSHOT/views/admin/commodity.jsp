<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


	<table class="table table-hover">
		<thead>
		<tr>
			<th>image</th>
			<th>name</th>
			<th>quantity</th>
			<th>measuringSystem</th>
			<th>price</th>
			<th>delete</th>
			<th>update</th>
			<th></th>
		</tr>
		</thead>

		<c:forEach var="commodity" items="${commodities.content}">
			<form>
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
					<td>
						<a href="/deleteCommodity/${commodity.id}">delete</a>
					</td>
					<td>
						<a href="/updateCommodity/${commodity.id}">update</a>
					</td>
				</tr>
			</form>
		</c:forEach>
	</table>







	<a href="/commodity/?page=${commodities.number}&size=${commodities.size}">previous</a>
	<a href="/commodity/?page=${commodities.number+ 2}&size=${commodities.size}">next</a>

		
</body>
</html>
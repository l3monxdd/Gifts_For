<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<%--<link rel="stylesheet" href="/css/suitofdelivery.css" type="text/css">--%>


	<sf:form action="/suitofdelivery?${_csrf.parameterName}=${_csrf.token}" method="post"
	enctype="multipart/form-data">
		<span style="color: #e74c3c; text-align: center">${suitException}</span>
			<input type="text" name="name"/>

			<input type="file" name="image"/>

		<button>save suit</button>

	</sf:form>


<table class="table table-hover">
	<thead>
	<tr>
		<th>image</th>
		<th>name</th>
		<th>delete</th>
		<th>update</th>
		<th></th>
	</tr>
	</thead>

	<c:forEach var="u" items="${suitofdeliveries }">
		<form>
			<tr>
				<td>
					<img src="/${u.pathImage}" alt="" height="250px" width="180px">
				</td>
				<td>
						${u.name}
				</td>
				<td>
					<a href="/deleteSuitOfDelivery/${u.id }">delete</a>
				</td>
				<td>
					<a href="/updateSuitOfDelivery/${u.id }">update</a>
				</td>
			</tr>
		</form>
	</c:forEach>
</table>


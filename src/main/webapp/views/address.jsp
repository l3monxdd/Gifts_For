<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/address.css" type="text/css">
</head>
<body>

	<form:form modelAttribute="address" action="/address" method="post">

		<span style="text-align: center; color: #e74c3c">${streetException}</span>
		<form:input path="floor" placeholder="floor"/>
		<form:input path="number_of_apartament" placeholder="number_of_apartament"/>
		<form:input path="number_of_build" placeholder="number_of_build"/>
		<form:input path="street" placeholder="street"/>

		<button>save address</button>


	</form:form>







	<%--<div style=" text-align: center; margin-top: 5%">--%>
		<%--<form action="/address" method="post">--%>
			<%--<input type="text" name="street" placeholder="street">--%>
			<%--<br>--%>
			<%--<input type="text" name="number_of_build" placeholder="number_of_build">--%>
			<%--<br>--%>
			<%--<input type="text" name="number_of_apartament" placeholder="number_of_apartament">--%>
			<%--<br>--%>
			<%--<input type="text" name="floor" placeholder="floor">--%>
			<%--<br>--%>
			<%--<button>Save address</button>--%>
		<%--</form>--%>
	<%--</div>--%>
	
	
	<table style="border:  1px solid black">
		<tr>
			<th style="border:  1px solid black">street</th>
			<th style="border:  1px solid black">number_of_build</th>
			<th style="border:  1px solid black">number_of_apartament</th>
			<th style="border:  1px solid black">floor</th>
			<th style="border:  1px solid black">delete</th>
			
			<c:forEach var="u" items="${addresses }">
				<tr>
					<th style="border:  1px solid black"> ${u.street}</th>
					<th style="border:  1px solid black"> ${u.number_of_build}</th>
					<th style="border:  1px solid black"> ${u.number_of_apartament}</th>
				    <th style="border:  1px solid black"> ${u.floor}</th>
				    <th style="border:  1px solid black"> <a href="/deleteAddress/${u.id }">delete</a></th>
				</tr>
			</c:forEach>
		</tr>
	

		<c:forEach items="${addresses}" var="a">
			${a.floor}
		</c:forEach>

	
	</table>
</body>
</html>
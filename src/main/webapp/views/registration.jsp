<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration</title>
	<link rel="stylesheet" href="/css/registration.css" type="text/css">
</head>
<body>

	<form:form modelAttribute="user" action="/registration" method="post">

		<span style="color: #e74c3c; text-align: center" >${loginException}</span>
		<span style="color: #e74c3c; text-align: center" >${emailException}</span>
		<form:input path="login" placeholder="login"/>
		<form:input path="firstname" placeholder="firstname"/>
		<form:input path="lastname" placeholder="lastname"/>

		<form:input path="email" placeholder="email"/>
		<form:input path="password" placeholder="password"/>
		<form:input path="phone_number"  placeholder="phone_number"/>

		<button>save user</button>

	</form:form>


		<%--<div style=" text-align: center; margin-top: 5%">--%>
			<%--<form action="/registration" method="post">--%>
				<%--<input type="text" name="name" placeholder="name">--%>
				<%--<br>--%>
				<%--<input type="text" name="username" placeholder="username">--%>
				<%--<br>--%>
				<%--<input type="email" name="email" placeholder="email">--%>
				<%--<br>--%>
				<%--<input type="text" name="password" placeholder="password">--%>
				<%--<br>--%>
				<%--<input type="text" name="phone_number" placeholder="phone_number">--%>
				<%--<br>--%>
				<%--<button>Save User</button>--%>
			<%--</form>--%>
		<%--</div>--%>
		
		<table style="border:  1px solid black">
		<tr>
			<th style="border:  1px solid black">name</th>
			<th style="border:  1px solid black">username</th>
			<th style="border:  1px solid black">email</th>
			<th style="border:  1px solid black">password</th>
			<th style="border:  1px solid black">phone_number</th>
			<th style="border:  1px solid black">delete</th>
			
			<c:forEach var="u" items="${users}">
				<tr>
					<th style="border:  1px solid black"> ${u.name}</th> 
					<th style="border:  1px solid black"> ${u.username}</th>
					<th style="border:  1px solid black"> ${u.email}</th>
					<th style="border:  1px solid black"> ${u.password}</th> 
				    <th style="border:  1px solid black"> ${u.phone_number}</th>
				    <th style="border:  1px solid black"> <a href="/deleteUser/${u.id }">delete</a></th>
				</tr>
			</c:forEach>
		</tr>
	
	
	
		</table>




		
		
</body>
</html>
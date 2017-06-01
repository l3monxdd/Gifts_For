<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/measuringsystem.css" type="text/css">
</head>
<body>

	<form:form modelAttribute="measuringSystem" method="post">
		<span style="color: #e74c3c; text-align: center">${measuringSystemException}</span>

		<form:input path="name"/>

		<button>save measuring system</button>

	</form:form>


<%--<div style="text-align: center;margin-top: 10%">--%>
	<%----%>
	<%--<form action="/measuringsystem" method="post">--%>
		<%--<input type="text" name="name" placeholder="name">--%>
		<%--<br>--%>
		<%--<button>add measuring system"</button>--%>
	<%--</form>--%>

<%--</div>--%>

	<ol>
	<c:forEach var="ms" items="${measuringsystems}">
		<li>${ms.name} <a href="/deleteMeasuringSystem/${ms.id}">delete</a> <a href="/updateMeasuringSystem/${ms.id}">update</a> </li>
	</c:forEach>
	</ol>






</body>
</html>
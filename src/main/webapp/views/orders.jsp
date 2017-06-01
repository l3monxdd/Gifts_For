<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


		<form:form modelAttribute="order" method="post">
			
			<form:input path="description"/>
			<%--<form:input path="date"/>--%>
			
			<form:select path="user" items="${users}" itemLabel="username" itemValue="id"/>


			<button>save order</button>

			
			
		</form:form>




<%--<div style="text-align: center;margin-top: 10%">--%>
	<%----%>
	<%--<form action="/order" method="post">--%>
		<%--<input type="text" name="description" placeholder="description">--%>
		<%--<br>--%>
		<%--<input type="date" name="date" placeholder="date">--%>
		<%--<br>--%>
		<%--<button>add order"</button>--%>
	<%--</form>--%>

<%--</div>--%>

</body>
</html>
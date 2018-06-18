<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 23.05.17
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateMeasuringSystem</title>
</head>
<body>

    <form action="/updateMeasuringSystem/${currentMeasuringSystem.id}?${_csrf.parameterName}=${_csrf.token}" method="post">
        <input type="text" name="name" value="${currentMeasuringSystem.name}">
        <button>update measuring system</button>
    </form>

</body>
</html>

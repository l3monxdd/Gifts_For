<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 24.05.17
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/updateCommodity/${commodity.id}">

        <input name="name_of_commodity" type="text" value="${commodity.name_of_commodity}" placeholder="name_of_commodity">
        <input name="counter" type="number" value="${commodity.counter}" placeholder="counter">
        <input name="price_id_uan" type="text" value="${commodity.price_id_uan}" placeholder="price_id_uan">



        <select name="ms">
            <c:forEach var="ms" items="${commodity.measuringSystems}">
                <option value="${ms.id}">${ms.name}</option>
            </c:forEach>
        </select>
            <button>update commodity</button>
    </form>

</body>
</html>

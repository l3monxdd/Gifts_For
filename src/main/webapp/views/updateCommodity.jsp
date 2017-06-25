<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 24.05.17
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <sf:form action="/updateCommodity/${commodity.id}?${_csrf.parameterName}=${_csrf.token}" method="post"
             enctype="multipart/form-data">

        <input name="name_of_commodity" type="text" value="${commodity.name_of_commodity}" placeholder="name_of_commodity">
        <input name="quantity" type="number" value="${commodity.quantity}" placeholder="quantity">
        <input name="price_id_uan" type="text" value="${commodity.price_id_uan}" placeholder="price_id_uan">
        <input type="file" name="image"/>
        <select name="ms">
            <option value="${commodity.measuringSystem.id}">current m s ${commodity.measuringSystem.name}</option>
            <c:forEach var="ms" items="${measuringSystems}">
                <option value="${ms.id}">${ms.name}</option>
            </c:forEach>
        </select>
            <button>update commodity</button>
    </sf:form>

    <table style="border:  1px solid black">
        <tr>
            <th style="border:  1px solid black">image</th>
            <th style="border:  1px solid black">name_of_commodityme</th>
            <th style="border:  1px solid black">price_id_uan</th>
            <th style="border:  1px solid black">quantity</th>
            <th style="border:  1px solid black">measuringSystems</th>


        <tr>
            <th style="border:  1px solid black"> <img src="/${commodity.pathImage}" alt="" width="7%" height="8%"></th>
            <th style="border:  1px solid black"> ${commodity.name_of_commodity}</th>
            <th style="border:  1px solid black"> ${commodity.price_id_uan}</th>
            <th style="border:  1px solid black"> ${commodity.quantity}</th>
            <th style="border:  1px solid black"> ${commodity.measuringSystem.name}</th>



        </tr>

        </tr>
    </table>

</body>
</html>

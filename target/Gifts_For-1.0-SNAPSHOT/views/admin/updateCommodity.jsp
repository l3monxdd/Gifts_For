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

<table class="table table-hover">
    <thead>
    <tr>
        <th>image</th>
        <th>name</th>
        <th>quantity</th>
        <th>measuringSystem</th>
        <th>price</th>
        <th></th>
    </tr>
    </thead>


        <form>
            <tr>
                <td>
                    <img src="/${commodity.pathImage}" alt="" height="250px" width="250px">
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
            </tr>
        </form>

</table>



<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 18.06.17
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


    <form  action="/updateSuitOfDelivery/${suitofdelivery.id}?${_csrf.parameterName}=${_csrf.token}" method="post"
             enctype="multipart/form-data">

        <span style="color: #e74c3c; text-align: center">${suitException}</span>
        <input type="text" name="name" value="${suitofdelivery.name}" placeholder="name"/>

        <input type="file" name="image"/>

        <button>update suit</button>

    </form>

<table class="table table-hover">
    <thead>
    <tr>
        <th>image</th>
        <th>name</th>
        <th></th>
    </tr>
    </thead>


    <form>
        <tr>
            <td>
                <img src="/${suitofdelivery.pathImage}" alt="" height="250px" width="250px">
            </td>
            <td>
                ${suitofdelivery.name}
            </td>
        </tr>
    </form>

</table>





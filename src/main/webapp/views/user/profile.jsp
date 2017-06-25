<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 07.06.17
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    pfofile

${user}
<br>
<c:forEach  var="com" items="${user.commodities}">
    ${com.name_of_commodity}
    <a href="/deleteFromBasket/${user.id}/${com.id}">delete</a>
    <br>
</c:forEach>





<form:form action="/buy/${user.id}" method="post">


        <input name="street" type="text" placeholder="street"/>
        <input name="number_of_build" type="text" placeholder="number_of_build"/>
        <input name="number_of_apartament" type="text" placeholder="number_of_apartament"/>
        <input name="town" type="text" placeholder="town"/>
    <br>
        <input name="description" type="text" placeholder="description"/>



    <select name="suit">
        <c:forEach var="suit_of" items="${suit_of_delivery}">
            <option value="${suit_of.id}">${suit_of.name}</option>
        </c:forEach>
    </select>

    <%--<c:forEach var="u" items="${suit_of_delivery }">--%>
        <%--<tr>--%>
            <%--<th style="border:  1px solid black"> <img src="/${u.pathImage}" alt="" width="7%" height="8%"></th>--%>

        <%--</tr>--%>
    <%--</c:forEach>--%>




    <button>buy</button>
</form:form>

<%--<form:form action="/buy" method="post">--%>
    <%--<button>buy</button>--%>
<%--</form:form>--%>
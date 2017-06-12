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
    pfofile

${user}
<br>
<c:forEach var="com" items="${user.commodities}">
    ${com.name_of_commodity}
    <a href="/deleteFromBasket/${user.id}/${com.id}">delete</a>
    <br>
</c:forEach>



<form:form action="/buy/${user.id}" method="post">
    <button>buy</button>
</form:form>

<%--<form:form action="/buy" method="post">--%>
    <%--<button>buy</button>--%>
<%--</form:form>--%>
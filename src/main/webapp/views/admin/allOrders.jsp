<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 06.07.17
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/commodity.css" type="text/css">


<sf:form action="/allOrders" method="post">
    <div>
        <c:forEach var="order" items="${orders}">
            ${order.date}
            ${order.user.lastname}
            <c:forEach var="comm" items="${order.commodityCounters}">
                ${comm.commodity.name_of_commodity}
                ${comm.counter}
            </c:forEach>

            <%--<c:if test="${order.done = true}">--%>


            <%--</c:if>--%>

            <c:choose>
                <c:when test="${order.done == true}">
                    <input type="checkbox" checked="checked" name="done">
                </c:when>
                <c:otherwise>
                    <input type="checkbox" name="done">
                </c:otherwise>
            </c:choose>
            <br>
        </c:forEach>

    </div>

    <button>save changes</button>

</sf:form>

<table class="table table-hover">
    <thead>
    <tr>
        <th>date</th>
        <th>lastname</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="order" items="${orders}">
        <form>
            <tr>
                <td>
                        ${order.date}
                </td>
                <td>
                        ${order.user.lastname}
                </td>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>name_of_commodity</th>
                        <th>counter</th>
                        <th></th>
                    </tr>
                    </thead>


                    <c:forEach var="comm" items="${order.commodityCounters}">
                        <form>
                            <tr>

                                <td>
                                        ${comm.commodity.name_of_commodity}
                                </td>
                                <td>
                                        ${comm.counter}
                                </td>


                            </tr>
                        </form>
                    </c:forEach>
                </table>


            </tr>
        </form>
    </c:forEach>
</table>
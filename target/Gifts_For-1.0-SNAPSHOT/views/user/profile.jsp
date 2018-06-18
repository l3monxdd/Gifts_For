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




<br>



<table class="table table-hover">
    <span>Your Profile and Order processing...</span>
    <thead>
    <tr>
        <th>login</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>email</th>
        <th></th>
    </tr>
    </thead>
    <tr>
        <td>
            ${testuser.login}
        </td>
        <td>
            ${testuser.firstname}
        </td>
        <td>
            ${testuser.lastname}rofile
        </td>
        <td>
            ${testuser.email}
        </td>
    </tr>
</table>







    <c:choose>
        <c:when test="${!user.commodities.isEmpty()}">
            <form:form action="/buy/${user.id}" method="get">
            <br>
            <br>
            <br>


            <table class="table table-hover">
                <thead>
                <tr>
                    <th>name_of_commodity</th>
                    <th>quantity</th>
                    <th>counter</th>
                    <th>delete</th>
                    <th></th>
                </tr>
                </thead>
                <span style="color: #e74c3c; text-align: center">${counterException}</span>


                <c:forEach var="com" items="${user.commodities}">
                    <%--<form>--%>
                    <tr>
                        <td>
                                ${com.name_of_commodity}
                        </td>
                        <td>
                                ${com.quantity}
                        </td>
                        <td>

                            <input type="text" name="counters">
                                <%--як мені вибрати для порівня поле каунтер ? --%>
                        </td>
                        <td>
                            <a href="/deleteFromBasket/${user.id}/${com.id}">delete</a>
                        </td>
                    </tr>
                    <%--</form>--%>
                </c:forEach>
            </table>


            <br>
            <br>
            <br>
            <br>


            <table class="table table-hover">
                <thead>
                <tr>
                    <th>street</th>
                    <th>number_of_build</th>
                    <th>number_of_apartament</th>
                    <th>town</th>
                    <th>description</th>
                    <th></th>
                </tr>
                </thead>


                <tr>

                    <td>
                            ${streetException}
                        <input name="street" type="text" placeholder="street"/>
                    </td>
                    <td>
                        ${numberOfBuildException}
                        <input name="number_of_build" type="text" placeholder="number_of_build"/>
                    </td>
                    <td>
                        ${numberOfApartamentException}
                        <input name="number_of_apartament" type="text" placeholder="number_of_apartament"/>
                    </td>
                    <td>
                        ${emptyTownException}
                        ${containNumber}
                        <input name="town" type="text" placeholder="town"/>
                    </td>
                    <td>
                        <input name="description" type="text" placeholder="description"/>
                    </td>
                </tr>


            </table>

            <%--<input name="street" type="text" placeholder="street"/>--%>
            <%--<input name="number_of_build" type="text" placeholder="number_of_build"/>--%>
            <%--<input name="number_of_apartament" type="text" placeholder="number_of_apartament"/>--%>
            <%--<input name="town" type="text" placeholder="town"/>--%>
            <%--<br>--%>
            <%--<input name="description" type="text" placeholder="description"/>--%>

            <%--<input name="counter" type="text" placeholder="counter"/>--%>


            <select name="suit">
                <c:forEach var="suit_of" items="${suit_of_delivery}">
                    <option value="${suit_of.id}">${suit_of.name}</option>
                    <tr>
                        <th style="border:  1px solid black"><img src="/${suit_of.pathImage}" alt="" width="7%" height="8%">
                        </th>
                    </tr>
                </c:forEach>
            </select>


            <c:forEach var="u" items="${suit_of_delivery }">
                <tr>
                    <th style="border:  1px solid black"><img src="/${u.pathImage}" alt="" width="7%" height="8%"></th>

                </tr>
            </c:forEach>

            <button>buy</button>
            </form:form>
        </c:when>
        <c:otherwise>
           <h1>Empty basket</h1>
        </c:otherwise>
    </c:choose>




<%--<form:form action="/buy" method="post">--%>
<%--<button>buy</button>--%>
<%--</form:form>--%>



<script>

    function validateCounter(id) {

        console.log(id)

        var quantity = document.getElementById('quantity' + id).innerHTML;

        var counter = document.getElementById('counter' + id).value;

        if (counter > quantity) {

            document.getElementById(id + 'error_msg').innerHTML = 'max quantity = ';
            document.getElementById(id + 'error_msg').style.color = 'red';
            document.getElementById(id + 'counter').value = 1;

        }

    }

</script>
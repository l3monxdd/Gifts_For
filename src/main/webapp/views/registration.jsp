<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 06.06.17
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/css/registration.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/registration.js"></script>
    <%--<link rel="stylesheet" href="/css/testOne.css" type="text/css">--%>
    <%--<script src="/js/testOne.js"></script>--%>
</head>



<body>

<div class="form-wrap">
    <div class="tabs">
        <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
        <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
        <div id="signup-tab-content" class="active">
            <form:form modelAttribute="user" class="signup-form" method="post">
                <h3 style="text-align: center;color: red">${loginException}</h3>
                <form:input path="login" type="text" class="input"  autocomplete="off"
                            placeholder="login"></form:input>

                <form:input path="firstname" type="text" class="input"  autocomplete="off"
                            placeholder="firstname"></form:input>

                <form:input path="lastname" type="text" class="input"  autocomplete="off"
                            placeholder="lastname"/>
                <h3 style="text-align: center;color: red">${emailException}</h3>
                <form:input path="email" type="text" class="input" id="user_email" autocomplete="off"
                            placeholder="Email"/>

                <form:input path="password" type="password" class="input" id="user_pass" autocomplete="off"
                            placeholder="Password"/>

                <form:input path="phone_number" type="text" class="input"  autocomplete="off"
                            placeholder="phone_number"/>

                <input type="submit" class="button" value="Sign Up">


            </form:form><!--.login-form-->
        </div><!--.signup-tab-content-->

        <div id="login-tab-content">
            <form:form class="login-form" action="/login" method="post">
                <input name="username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Username">
                <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">

                <input type="submit" class="button" value="Login">
            </form:form>
        </div
    </div>
</div>








<%--/////////////////////////////////////////////--%>


<%--<form:form modelAttribute="user" action="/registration" method="post">--%>


    <%--<span style="color: #e74c3c; text-align: center" >${loginException}</span>--%>
    <%--<span style="color: #e74c3c; text-align: center" >${emailException}</span>--%>

    <%--<br><form:input path="login" placeholder="login"/>--%>
    <%--<br><form:input path="firstname" placeholder="firstname"/>--%>
    <%--<br><form:input path="lastname" placeholder="lastname"/>--%>
        <%--<br><form:input path="email" placeholder="email"/>--%>
        <%--<br><form:input path="password" placeholder="password"/>--%>
        <%--<br><form:input path="phone_number"  placeholder="phone_number"/>--%>

        <%--<br><button>save user</button>--%>



<%--</form:form>--%>

<%--<form:form class="login-form" action="/login" method="post">--%>
    <%--<input name="username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Username">--%>
    <%--<input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">--%>
    <%--<input type="submit" class="button" value="Login">--%>
<%--</form:form><!--.login-form-->--%>



<%--/////////////////////////////delete form///////////////////////////////--%>


<%--<table style="border:  1px solid black">--%>
    <%--<tr>--%>
        <%--<th style="border:  1px solid black">login</th>--%>
        <%--<th style="border:  1px solid black">firstname</th>--%>
        <%--<th style="border:  1px solid black">lastname</th>--%>
        <%--<th style="border:  1px solid black">email</th>--%>
        <%--<th style="border:  1px solid black">password</th>--%>
        <%--<th style="border:  1px solid black">phone_number</th>--%>
        <%--<th style="border:  1px solid black">delete</th>--%>


        <%--<c:forEach var="u" items="${users}">--%>
    <%--<tr>--%>
        <%--<th style="border:  1px solid black"> ${u.login}</th>--%>
        <%--<th style="border:  1px solid black"> ${u.firstname}</th>--%>
        <%--<th style="border:  1px solid black"> ${u.lastname}</th>--%>
        <%--<th style="border:  1px solid black"> ${u.email}</th>--%>
        <%--<th style="border:  1px solid black"> ${u.password}</th>--%>
        <%--<th style="border:  1px solid black"> ${u.phone_number}</th>--%>
        <%--<th style="border:  1px solid black"> <a href="/deleteUser/${u.id }">delete</a></th>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>


</body>
</html>
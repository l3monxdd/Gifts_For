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

<%--<div class="login-page">--%>
    <%--<div class="form">--%>
        <%--<form:form modelAttribute="user" action="/registration" method="post" class="register-form">--%>
        <%--<span style="color: #e74c3c; text-align: center" >${loginException}</span>--%>
            <%--<span style="color: #e74c3c; text-align: center" >${emailException}</span>--%>
            <%--<form:input path="login" placeholder="login"/>--%>
            <%--<form:input path="firstname" placeholder="firstname"/>--%>
            <%--<form:input path="lastname" placeholder="lastname"/>--%>
            <%--<form:input path="email" placeholder="email"/>--%>
            <%--<form:input path="password" placeholder="password"/>--%>
            <%--<form:input path="phone_number"  placeholder="phone_number"/>--%>
            <%--<button>create</button>--%>
            <%--<p class="message">Already registered? <a href="#">Sign In</a></p>--%>
        <%--</form:form>--%>
        <%--<form class="login-form">--%>
            <%--<input type="text" placeholder="username"/>--%>
            <%--<input type="password" placeholder="password"/>--%>
            <%--<button>login</button>--%>
            <%--<p class="message">Not registered? <a href="#">Create an account</a></p>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</div>--%>

<!-- multistep form -->
    <%--<form:form modelAttribute="user" action="/registration" method="post"  id="msform">--%>

    <!-- progressbar -->

    <!-- fieldsets -->
    <%--<fieldset>--%>
        <%--<h2 class="fs-title">Create your account</h2>--%>
        <%--&lt;%&ndash;<input type="text" name="email" placeholder="Email" />&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="password" name="pass" placeholder="Password" />&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="password" name="cpass" placeholder="Confirm Password" />&ndash;%&gt;--%>
        <%--<span style="color: #e74c3c; text-align: center" >${loginException}</span>--%>
        <%--<span style="color: #e74c3c; text-align: center" >${emailException}</span>--%>
        <%--<form:input path="login" placeholder="login"/>--%>
        <%--<form:input path="firstname" placeholder="firstname"/>--%>
        <%--<form:input path="lastname" placeholder="lastname"/>--%>
        <%--<form:input path="email" placeholder="email"/>--%>
        <%--<form:input path="password" placeholder="password"/>--%>
        <%--<form:input path="phone_number"  placeholder="phone_number"/>--%>
        <%--<input type="submit" name="next" class="next action-button" value="save" />--%>
        <%--&lt;%&ndash;<button>save user</button>&ndash;%&gt;--%>


    <%--</fieldset>--%>
    <%--</form:form>--%>



<%--/////////////////////////////////////////////--%>


<form:form modelAttribute="user" action="/registration" method="post">


    <span style="color: #e74c3c; text-align: center" >${loginException}</span>
    <span style="color: #e74c3c; text-align: center" >${emailException}</span>

    <br><form:input path="login" placeholder="login"/>
    <br><form:input path="firstname" placeholder="firstname"/>
    <br><form:input path="lastname" placeholder="lastname"/>
        <br><form:input path="email" placeholder="email"/>
        <br><form:input path="password" placeholder="password"/>
        <br><form:input path="phone_number"  placeholder="phone_number"/>

        <br><button>save user</button>



</form:form>

<form:form class="login-form" action="/login" method="post">
    <input name="username" type="text" class="input" id="user_login" autocomplete="off" placeholder="Username">
    <input name="password" type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
    <input type="submit" class="button" value="Login">
</form:form><!--.login-form-->


<table style="border:  1px solid black">
    <tr>
        <th style="border:  1px solid black">login</th>
        <th style="border:  1px solid black">firstname</th>
        <th style="border:  1px solid black">lastname</th>
        <th style="border:  1px solid black">email</th>
        <th style="border:  1px solid black">password</th>
        <th style="border:  1px solid black">phone_number</th>
        <th style="border:  1px solid black">delete</th>


        <c:forEach var="u" items="${users}">
    <tr>
        <th style="border:  1px solid black"> ${u.login}</th>
        <th style="border:  1px solid black"> ${u.firstname}</th>
        <th style="border:  1px solid black"> ${u.lastname}</th>
        <th style="border:  1px solid black"> ${u.email}</th>
        <th style="border:  1px solid black"> ${u.password}</th>
        <th style="border:  1px solid black"> ${u.phone_number}</th>
        <th style="border:  1px solid black"> <a href="/deleteUser/${u.id }">delete</a></th>
    </tr>
    </c:forEach>
    </tr>



</table>
</body>
</html>
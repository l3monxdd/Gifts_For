
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 25.06.17
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--<link rel="stylesheet" href="/css/index.css">--%>
<%--<link rel="stylesheet" href="/bootstrap/bootstrap-theme.css">--%>
<%--<link rel="stylesheet" href="/bootstrap/bootstrap.css">--%>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--<script src="/js/index.js"></script>--%>

<%--<link rel="stylesheet" href="/css/header.css">--%>

<nav class="navbar navbar-default">
    <div class="container-fluid">



        <%--<div class="wrapper">--%>
        <%--<h1>Navigation</h1>--%>
        <%--<ul class="nav-list">--%>
        <%--<sec:authorize access="!isAuthenticated()">--%>
        <%--<li  class="registration"><a href="/registration"><spring:message code="label.registration"/></a></li>--%>
        <%--</sec:authorize>--%>
        <%--<sec:authorize access="hasAnyRole('ROLE_ADMIN')">--%>
        <%--<li class="commodity"><a href="/commodity"><spring:message code="label.commodity"/></a></li>--%>
        <%--<li class="measuringsystem"><a href="/measuringsystem"><spring:message code="label.measuringsystem"/></a></li>--%>
        <%--<li class="suitofdelivery"><a href="/suitofdelivery"><spring:message code="label.suitofdelivery"/></a></li>--%>
        <%--<li class="address"><a href="/address">address</a> </li>--%>
        <%--</sec:authorize>--%>
        <%--<li class="au1">--%>
        <%--<sec:authorize access="isAuthenticated()">--%>
        <%--|user| - <sec:authentication property="name"/>--%>
        <%--</sec:authorize>--%>
        <%--</li>--%>
        <%--<li class="logout">--%>
        <%--<sec:authorize access="isAuthenticated()">--%>
        <%--<form:form action="/logout" method="post">--%>
        <%--<button class="btn btn-default"><spring:message code="label.logout"/></button>--%>
        <%--</form:form>--%>
        <%--</sec:authorize>--%>
        <%--</li>--%>

        <%--<sec:authorize access="isAuthenticated()">--%>
        <%--<li class="profile"><a href="/profile"><spring:message code="label.profile"/></a> </li>--%>
        <%--</sec:authorize>--%>

        <%--<li class="dropdown">--%>
        <%--<a class="dropdown-toggle" data-toggle="dropdown" role="button"--%>
        <%--aria-haspopup="true" aria-expanded="false">--%>
        <%--<spring:message code="label.lang"/> <span class="caret"></span>--%>
        <%--<ul class="dropdown-menu">--%>
        <%--<li><a href="?lang=ua">ua</a></li>--%>
        <%--<li><a href="?lang=en">en</a></li>--%>
        <%--</ul>--%>
        <%--</a>--%>
        <%--</li>--%>
        <%--</ul>--%>
        <%--</div>--%>




        <header class="header" role="banner">
            <nav>
                <ul class="nav navbar-nav">

                    <li class="active">
                        <a href="/"><spring:message code="label.home"/></a>
                    </li>

                    <sec:authorize access="hasAnyRole('ROLE_USER')">
                        <li class="active">
                            <a href="/profile"><spring:message code="label.profile"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li>
                            <a href="/registration"><spring:message code="label.registration"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li>
                            <a href="/commodity"><spring:message code="label.commodity"/></a>
                        </li>
                        <li>
                            <a href="/measuringsystem"><spring:message code="label.measuringsystem"/></a>
                        </li>
                        <li>
                            <a href="/suitofdelivery"><spring:message code="label.suitofdelivery"/></a>
                        </li>
                        <li>
                            <a href="/allOrders">allOrders</a>
                        </li>

                    </sec:authorize>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">
                            <spring:message code="label.lang"/> <span class="caret"></span>
                            <ul class="dropdown-menu">
                                <li><a href="?lang=ua">ua</a></li>
                                <li><a href="?lang=en">en</a></li>
                            </ul>
                        </a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li>
                            <form:form action="/logout" method="post" cssStyle="float: right">
                                <button class="btn btn-default"><spring:message code="label.logout"/></button>
                            </form:form>
                        </li>
                        <li>
                            |user| - <sec:authentication property="name"/>
                        </li>
                    </sec:authorize>
                </ul>
            </nav>
        </header>



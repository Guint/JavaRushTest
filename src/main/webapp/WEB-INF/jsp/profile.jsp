<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="${register ? 'app.register' : 'app.profile'}"/></title>
    <%@include file="parts/header.jsp" %>
</head>
<body class="panel-body">
<div class="container">
    <%@include file="parts/navigation.jsp" %>
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="jumbotron pt-20">
                <form:form modelAttribute="userTo" class="form-horizontal" method="post"
                           action="${register ? 'register' : 'profile'}"
                           charset="utf-8" accept-charset="UTF-8">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:label path="name"><spring:message code="user.name"/></form:label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email"><spring:message code="user.email"/></form:label>
                        <form:input path="email" cssClass="form-control"/>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password"><spring:message code="user.password"/></form:label>
                        <form:password path="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message
                            code="common.save"/></button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

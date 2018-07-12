<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${register ? "Registration" : "My profile"}</title>
    <%@include file="parts/header.jsp" %>
</head>
<body class="panel-body">
<div class="container">
    <c:if test="${!register}">
        <%@include file="parts/navigation.jsp" %>
    </c:if>
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="jumbotron pt-20" style="margin-top: 25%">
                <form:form modelAttribute="userTo" class="form-horizontal" method="post"
                           action="${register ? 'register' : 'profile'}"
                           charset="utf-8" accept-charset="UTF-8">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email</form:label>
                        <form:input path="email" cssClass="form-control"/>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password</form:label>
                        <form:password path="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

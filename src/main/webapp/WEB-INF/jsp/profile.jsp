<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sec:authentication property="principal.username"/></title>
    <%@include file="parts/header.jsp" %>
</head>
<body class="panel-body">
    <div class="container">
        <%@include file="parts/navigation.jsp" %>
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="jumbotron pt-20">
                <form:form modelAttribute="user" class="form-horizontal" method="post" action="profile">
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

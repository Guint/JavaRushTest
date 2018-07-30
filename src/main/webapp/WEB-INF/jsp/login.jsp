<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><spring:message code="app.title"/></title>
    <jsp:include page="parts/header.jsp"/>
</head>
<body class="panel-body">
<div class="container">
    <%@include file="parts/navigation.jsp" %>
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="jumbotron pt-20">
                <c:if test="${param.success}">
                    <div class="alert alert-success" role="alert">
                        <p class="text-center"><spring:message code="app.registered"/></p>
                    </div>
                </c:if>
                <h3 class="text-center"><spring:message code="app.welcome"/></h3>
                <form:form name="form_login" action="${pageContext.request.contextPath}/spring_security_check" method="post">
                    <div class="form-group">
                        <label for="username"><spring:message code="app.login"/></label>
                        <input type="text" class="form-control" id="username" name="username"/>
                    </div>
                    <div class="form-group">
                        <label for="password"><spring:message code="app.password"/></label>
                        <input type="password" class="form-control" id="password" name="password"/>
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger mt-4" role="alert">
                                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                            </div>
                        </c:if>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="app.enter"/></button>
                </form:form>
                <a href="${pageContext.request.contextPath}/register"
                   class="badge badge-pill badge-primary"><spring:message code="app.register"/></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
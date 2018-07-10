<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Welcome</title>
    <jsp:include page="parts/header.jsp"/>
</head>
<body class="panel-body">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="jumbotron pt-20" style="margin-top: 25%">
                <h3 class="text-center">Please sign in</h3>
                <form name="form_login" action="${pageContext.request.contextPath}/spring_security_check" method="post">
                    <div class="form-group">
                        <label for="username">Login</label>
                        <input type="text" class="form-control" id="username" name="username"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password"/>
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger mt-4" role="alert">
                               Invalid username or password.
                            </div>
                        </c:if>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
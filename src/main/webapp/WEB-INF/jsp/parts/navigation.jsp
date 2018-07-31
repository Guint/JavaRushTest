<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row pt-2 pb-2">
    <div class="col-md-12">
        <nav class="navbar navbar-expand bg-dark">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <sec:authorize access="isAnonymous()">
                    <li class="nav-item active">
                        <a class="navbar-brand text-info"
                           href="${pageContext.request.contextPath}/login"><spring:message
                                code="app.main"/></a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item active">
                        <a class="navbar-brand text-info"
                           href="${pageContext.request.contextPath}/profile"><spring:message
                                code="app.profile"/></a>
                    </li>
                    <li class="nav-item active">
                        <a class="navbar-brand text-info"
                           href="${pageContext.request.contextPath}/books"><spring:message
                                code="books.title"/></a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item active">
                            <a class="navbar-brand text-info"
                               href="${pageContext.request.contextPath}/users"><spring:message code="user.title"/></a>
                        </li>
                    </sec:authorize>
                </sec:authorize>
                <li class="nav-item text-info dropdown">
                    <a class="dropdown-toggle nav-link my-1 ml-2"
                       data-toggle="dropdown"><spring:message code="commom.language"/></a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item"
                           href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">English</a>
                        <a class="dropdown-item"
                           href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru">Русский</a>
                    </div>
                </li>
            </ul>
            <sec:authorize access="isAuthenticated()">
                <form:form action="logout" method="post">
                    <button class="btn btn-primary" type="submit">
                        <span class="fa fa-sign-out"></span><spring:message code="app.logout"/>
                    </button>
                </form:form>
            </sec:authorize>
        </nav>
    </div>
</div>
<script type="text/javascript">
    var localeCode = "${pageContext.response.locale}";
</script>
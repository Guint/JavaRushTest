<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row pt-2 pb-2">
    <div class="col-md-12">
        <nav class="navbar navbar-expand bg-dark">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="navbar-brand text-info" href="${pageContext.request.contextPath}/profile">My profile</a>
                </li>
                <li class="nav-item active">
                    <a class="navbar-brand text-info" href="${pageContext.request.contextPath}/books">Books</a>
                </li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item active">
                        <a class="navbar-brand text-info" href="${pageContext.request.contextPath}/users">Users</a>
                    </li>
                </sec:authorize>
            </ul>
               <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/logout" >Выйти</a>
        </nav>
    </div>
</div>
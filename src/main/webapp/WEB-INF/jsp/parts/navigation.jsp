<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row pt-2 pb-2">
    <div class="col-md-12">
        <nav class="navbar navbar-expand bg-dark">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active" >
                    <a class="navbar-brand text-info" href="${pageContext.request.contextPath}/books">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-info" href="${pageContext.request.contextPath}/addForm">Add book</a>
                </li>
            </ul>
                <c:url var="search" value="/books/search"/>
                <form:form cssClass="form-inline bg-infog" action="${search}" method="get">
                <input class="form-control mr-2 mt-3" type="search" name="searchText" id="searchText"
                       placeholder="Search"/>

                <input class="btn btn-outline-info mt-2 mt-3" type="submit"
                       value=SEARCH>

                </form:form>
        </nav>
    </div>
</div>
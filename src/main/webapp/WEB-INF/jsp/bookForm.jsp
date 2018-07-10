<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <head>
        <title>Add/Edit book</title>
        <%@include file="parts/header.jsp"%>
    </head>
</head>
<body class="panel-body">

<div class="container border-info bg-info">
    <%@include file="parts/navigation.jsp"%>
    <div class="row justify-content-center">
        <div class="col-md-4 no-gutters">

        </div>
        <div class="col-md-4 bg-white border align-content-end mb-2">
            <h1 class="h1">Add/Edit book</h1>
            <br>
            <c:url var="save" value="/save"/>
            <form:form action="save" modelAttribute="book" method="post">
                <c:if test="${!empty book.id}">
                    <form:hidden path="id"/>
                </c:if>
                <div class="form-group">
                    <form:label path="title">Title</form:label>
                    <form:input path="title" cssClass="form-control"/>
                    <form:errors path="title" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Description</form:label>
                    <form:textarea rows="3" path="description" cssClass="form-control"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="author">Author</form:label>
                    <c:choose>
                        <c:when test="${!empty book.id}">
                            <form:input path="author" cssClass="form-control" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input path="author" cssClass="form-control"/>
                            <form:errors path="author" cssClass="text-danger"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="form-group">
                    <form:label path="isbn">ISBN</form:label>
                    <form:input path="isbn" cssClass="form-control"/>
                    <form:errors path="isbn" cssClass="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="printYear">PrintYear</form:label>
                    <form:input  path="printYear" cssClass="form-control"/>
                    <form:errors path="printYear" cssClass="text-danger"/>
                </div>
                <input class="btn btn-outline-info mb-2" type="submit"
                       value=Save>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>

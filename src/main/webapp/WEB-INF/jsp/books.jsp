<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Manager</title>
    <%@include file="parts/header.jsp"%>
</head>
<body class="panel-body">
<div class="container border">
    <%@include file="parts/navigation.jsp"%>
    <div class="row pt-2 pb-2">
        <div class="col-md-12">
            <c:choose>
                <c:when test="${!empty listBooks}">
                    <table class="table table-striped table-bordered table-responsive-md">
                        <tr class="text-center">
                            <th class="bg-info">Title</th>
                            <th class="bg-info">Description</th>
                            <th class="bg-info">Author</th>
                            <th class="bg-info">ISBN</th>
                            <th class="bg-info">PrintYear</th>
                            <th class="bg-info">isRead</th>
                            <th class="bg-info">Edit</th>
                            <th class="bg-info">Delete</th>
                            <th class="bg-info">Read</th>
                        </tr>
                        <c:forEach items="${listBooks}" var="book">
                            <tr>
                                <td>${book.title}</td>
                                <td class="size">${book.description}</td>
                                <td>${book.author}</td>
                                <td>${book.isbn}</td>
                                <td>${book.printYear}</td>
                                <td>${book.readAlready}</td>
                                <td>
                                    <c:url var="edit" value="/editForm">
                                        <c:param name="id" value="${book.id}"/>
                                    </c:url>
                                    <a href="${edit}">
                                        <button class="btn btn-info">Edit</button>
                                    </a>
                                </td>
                                <td>
                                    <a href="<c:url value='/delete/${book.id}'/>">
                                        <button class="btn btn-danger">Remove</button>
                                    </a>
                                </td>
                                <td><a href="<c:url value='/makeRead/${book.id}'/>">
                                    <button class="btn btn-success">Read</button>
                                </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <h2 class="text-center">Your bookList is empty. Add a book.</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <%@include file="parts/pagination.jsp"%>
</div>
</body>
</html>

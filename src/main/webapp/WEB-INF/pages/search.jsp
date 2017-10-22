<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <title>BOOK</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>

<body class="panel-body">
<a href="<c:url value="/books"/>">BACK</a>
<h1 class="text-center">Books Search Result</h1>
<c:if test="${!empty listBooks}">
    <table class="table table-striped table-bordered table-fesponsive">
        <tr class="text-center">
            <th class="bg-info" width="120">Title</th>
            <th class="bg-info le" width="120">Description</th>
            <th class="bg-info" width="120">Author</th>
            <th class="bg-info" width="120">ISBN</th>
            <th class="bg-info text-center" width="120">PrintYear</th>
            <th class="bg-info" width="80">isRead</th>
            <th class="bg-info" width="60">Edit</th>
            <th class="bg-info" width="60">Delete</th>
            <th class="bg-info" width="60">Read</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.title}</td>
                <td class="size" max>${book.description}</td>
                <td>${book.author}</td>
                <td>${book.isbn}</td>
                <td>${book.printYear}</td>
                <td>${book.readAlready}</td>
                <td><a href="<c:url value='/edit/${book.id}'/>">
                    <button class="btn btn-info">Edit</button>
                </a></td>
                <td><a href="<c:url value='/remove/${book.id}'/>">
                    <button class="btn btn-danger">Remove</button>
                </a></td>
                <td><a href="<c:url value='/makeread/${book.id}'/>">
                    <button class="btn btn-success">Read</button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty listBooks}">
    <h2 class="text-center">No books found matching your request.</h2>
</c:if>
</body>
</html>
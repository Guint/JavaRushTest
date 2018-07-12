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
    <%@include file="parts/header.jsp" %>
</head>
<body class="panel-body">

<div class="container">
    <%@include file="parts/navigation.jsp" %>
    <div class="row pt-2 pb-2">
        <div class="col-md-12">
            <table class="table table-striped table-bordered table-responsive-md" id="bookTable">
                <thead>
                <tr>
                    <th class="bg-info">Title</th>
                    <th class="bg-info">Description</th>
                    <th class="bg-info">Author</th>
                    <th class="bg-info">ISBN</th>
                    <th class="bg-info">PrintYear</th>
                    <th class="bg-info">isRead</th>
                    <%--<th class="bg-info">Edit</th>
                    <th class="bg-info">Delete</th>
                    <th class="bg-info">Read</th>--%>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    $(function() {
        $.ajax({
            url: "books",
            method: "POST",
            data: "json",
            success: function (data) {
                $('#bookTable').DataTable({
                    data: data,
                    "columns": [
                        {"data": "Title"},
                        {"data": "Description"},
                        {"data": "author"},
                        {"data": "printYear"},
                        {"data": "isRead"}
                    ]
                });
            }
        });
    });
</script>
</html>

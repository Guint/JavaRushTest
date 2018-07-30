<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="books.title"/></title>
    <link rel="stylesheet" href="resources/css/style.css">
    <%@include file="parts/header.jsp" %>
    <script src="${pageContext.request.contextPath}/resources/js/datatablesUtil.js" defer></script>
    <script src="${pageContext.request.contextPath}/resources/js/booksDatatables.js" defer></script>
</head>
<body class="panel-body">
<div class="container">
    <%@include file="parts/navigation.jsp" %>
    <div class="row pt-2 pb-2">
        <div class="col-md-12">
            <button class="btn btn-primary mb-3" onclick="add()">
                <span class="fa fa-plus"></span>
                <spring:message code="book.add"/>
            </button>
            <table class="table table-striped table-bordered" id="bookTable">
                <thead>
                <tr>
                    <th class="bg-info"><spring:message code="book.title"/></th>
                    <th class="bg-info"><spring:message code="book.description"/></th>
                    <th class="bg-info"><spring:message code="book.author"/></th>
                    <th class="bg-info"><spring:message code="book.isbn"/></th>
                    <th class="bg-info"><spring:message code="book.printYear"/></th>
                    <th class="bg-info"><spring:message code="book.isRead"/></th>
                    <th class="bg-info"></th>
                    <th class="bg-info"></th>
                </tr>
                </thead>
            </table>
            <div class="modal fade" tabindex="-1" id="editRow">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="modalTitle"></h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form id="detailsForm">
                                <input type="hidden" id="id" name="id">

                                <div class="form-group">
                                    <label for="title" class="col-form-label"><spring:message
                                            code="book.title"/></label>
                                    <input type="text" class="form-control" id="title" name="title" placeholder=
                                    <spring:message code="book.title"/>>
                                </div>

                                <div class="form-group">
                                    <label for="description" class="col-form-label"><spring:message
                                            code="book.description"/></label>
                                    <br>
                                    <textarea class="text-area" name="description" id="description" rows="3" cols="62"
                                              placeholder=<spring:message code="book.description"/>></textarea>
                                </div>

                                <div class="form-group">
                                    <label for="author" class="col-form-label"><spring:message
                                            code="book.author"/></label>
                                    <input type="text" class="form-control" id="author" name="author" placeholder=
                                    <spring:message code="book.author"/>>
                                </div>
                                <div class="form-group">
                                    <label for="isbn" class="col-form-label"><spring:message code="book.isbn"/></label>
                                    <input type="text" class="form-control" id="isbn" name="isbn" placeholder=
                                    <spring:message code="book.isbn"/>>
                                </div>
                                <div class="form-group">
                                    <label for="printYear" class="col-form-label"><spring:message
                                            code="book.printYear"/></label>
                                    <input type="text" class="form-control" id="printYear" name="printYear" placeholder=
                                    <spring:message code="book.printYear"/>>
                                </div>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="readAlready" name="readAlready">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                <span class="fa fa-close"></span>
                                <spring:message code="common.cancel"/>
                            </button>
                            <button type="button" class="btn btn-primary" onclick="save()">
                                <span class="fa fa-check"></span>
                                <spring:message code="common.save"/>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="parts/i18n.jsp">
    <jsp:param name="page" value="book"/>
</jsp:include>
</html>

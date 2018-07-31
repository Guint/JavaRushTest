<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.title"/></title>
    <link rel="stylesheet" href="resources/css/style.css">
    <%@include file="parts/header.jsp" %>
    <script src="${pageContext.request.contextPath}/resources/js/datatablesUtil.js" defer></script>
    <script src="${pageContext.request.contextPath}/resources/js/userDatatables.js" defer></script>
</head>
<body class="panel-body">
<div class="container">
    <%@include file="parts/navigation.jsp" %>
    <div class="row pt-2 pb-2">
        <div class="col-md-12">
            <button class="btn btn-primary mb-3" onclick="add()">
                <span class="fa fa-plus"></span>
                <spring:message code="user.add"/>
            </button>
            <table class="table table-striped table-bordered" id="userTable">
                <thead>
                <tr>
                    <th class="bg-info"><spring:message code="user.name"/></th>
                    <th class="bg-info"><spring:message code="user.email"/></th>
                    <th class="bg-info"><spring:message code="user.roles"/></th>
                    <th class="bg-info"><spring:message code="user.active"/></th>
                    <th class="bg-info"><spring:message code="user.registered"/></th>
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
                                    <label for="name" class="col-form-label"><spring:message code="user.name"/></label>
                                    <input type="text" class="form-control" id="name" name="name"
                                           placeholder=<spring:message code="user.name"/>>
                                </div>

                                <div class="form-group">
                                    <label for="email" class="col-form-label"><spring:message code="user.email"/></label>
                                    <input type="email" class="form-control" id="email" name="email"
                                           placeholder=<spring:message code="user.email"/>>
                                </div>

                                <div class="form-group">
                                    <label for="password" class="col-form-label"><spring:message code="user.password"/></label>
                                    <input type="password" class="form-control" id="password" name="password"
                                           placeholder=<spring:message code="user.password"/>>
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
    <jsp:param name="page" value="user"/>
</jsp:include>
</html>

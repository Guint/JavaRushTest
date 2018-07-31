<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    var i18n = [];
    i18n["read"] = '<spring:message code="book.isRead"/>';
    i18n["addTitle"] = '<spring:message code="${param.page}.add"/>';
    i18n["editTitle"] = '<spring:message code="${param.page}.edit"/>';
    <c:forEach var='key' items='<%=new String[]{"common.deleted", "common.saved", "common.enabled", "common.disabled", "common.search"}%>'>
    i18n['${key}'] = '<spring:message code="${key}"/>';
    </c:forEach>
</script>
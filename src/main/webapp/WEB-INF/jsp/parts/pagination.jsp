<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row justify-content-center">
    <div class="col-md-12 justify-content-center">
        <div id="pagination justify-content-center">
            <c:url value="${currentSort}" var="prev">
                <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <a href="<c:out value="${prev}" />" class="pn prev">
                    <button class="btn btn-info">PREV</button>
                </a>
            </c:if>

            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                <c:choose>
                    <c:when test="${page == i.index}">
                        <span>${i.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="${currentSort}" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <a href='<c:out value="${url}" />'>
                            <button class="btn btn-info">${i.index}</button>
                        </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="${currentSort}" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <a href='<c:out value="${next}" />' class="pn next">
                    <button class="btn btn-info">NEXT</button>
                </a>
            </c:if>
        </div>
    </div>
</div>

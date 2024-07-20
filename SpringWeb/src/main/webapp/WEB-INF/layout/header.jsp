
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="#">Login</a>
            </li>
            <c:forEach items="${cates}" var="c">
                <c:url value="/login" var="cateUrl">
                    <c:param name="category" value="${c.id}"/>
                </c:url>
                <li class="nav-item">
                    <a class="nav-link" href="${cateUrl}">${c.name}</a>
                </li>
            </c:forEach>

        </ul>
    </div>
</nav>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-md navbar-light bg-white shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="#">GESTION LOCATION</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav me-auto"></ul>
            <ul class="navbar-nav ms-auto">
                <c:if test="${account==null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a>
                </li>
                </c:if>
                <c:if test="${account!=null}">
                <li class="nav-item dropdown">
                    <a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>${account.username}</a>
                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">

                        <li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/reset-password">reset password</a>
<%--                        <form id="reset-password-form" action="${pageContext.request.contextPath}/reset-password" method="POST" class="d-none" />--%>
                        </li>
                        <li>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
<%--                        <form id="logout-form" action="${pageContext.request.contextPath}/logout" method="POST" class="d-none" />--%>
                        </li>
                    </ul>
                </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <jsp:include page="common/header.jsp" />
</head>

<body>
<div id="app">
    <jsp:include page="common/navbar.jsp" />
    <main class="py-4">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Login</div>
<%--                        <c:if test="${!empty errorMessage}"><div class="alert alert-danger" role="alert">${errorMessage}</div></c:if>--%>
                        <div class="card-body">
                            <form method="POST" action="${pageContext.request.contextPath}/connect">
                                <div class="row mb-3">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">Login</label>
                                    <div class="col-md-6">
                                        <input id="email" type="email" class="form-control"
                                               name="login" value="" required autocomplete="email" autofocus>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="password"
                                           class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input id="password" type="password" class="form-control"
                                               name="password" required autocomplete="current-password">
                                    </div>
                                </div>
                                <div class="row mb-0">
                                    <div class="col-md-8 offset-md-4">
                                        <button type="submit" class="btn btn-primary">Login</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>

</html>

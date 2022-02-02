<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
                        <div class="card-header">Inscription du bailleur</div>
                        <div class="card-body">
                            <c:if test="${!empty errorMessage}"><div class="alert alert-danger" role="alert">${errorMessage}</div></c:if>
                            <form method="POST" action="${pageContext.request.contextPath}/saveBailleur">
                                <div class="row mb-3">
                                    <label for="nom_bailleur" class="col-md-4 col-form-label text-md-right">Nom du Bailleur</label>
                                    <div class="col-md-6">
                                        <input id="nom_bailleur" type="text" class="form-control " name="nom_bailleur" value="${param.nom_bailleur}"
                                               required autocomplete="name" autofocus>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="prenom1" class="col-md-4 col-form-label text-md-right">prenom du Bailleur</label>
                                    <div class="col-md-6">
                                        <input id="prenom1" type="text" class="form-control " name="prenom1" value="${param.prenom1}"
                                               required autocomplete="name" autofocus>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="prenom2" class="col-md-4 col-form-label text-md-right">deuxieme prenom</label>
                                    <div class="col-md-6">
                                        <input id="prenom2" type="text" class="form-control " name="prenom2" value="${param.prenom2}"
                                               required autocomplete="name" autofocus>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="email_bailleur" class="col-md-4 col-form-label text-md-right">E-Mail
                                        du bailleur</label>
                                    <div class="col-md-6">
                                        <input id="email_bailleur" type="email" class="form-control" name="email_bailleur"
                                               value="${param.email_bailleur}" required autocomplete="email">
                                    </div>
                                </div> <div class="row mb-3">
                                <label for="telephone_bailleur" class="col-md-4 col-form-label text-md-right">telephone du bailleur</label>
                                <div class="col-md-6">
                                    <input id="telephone_bailleur" type="text" class="form-control" name="telephone_bailleur"
                                           value="${param.telephone_bailleur}" required autocomplete="telephone_Bailleur">
                                </div>
                            </div>
                                <div class="row mb-3">
                                    <label for="password"
                                           class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input id="password" type="password" class="form-control"
                                               name="password" required autocomplete="new-password">
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="password-confirm"
                                           class="col-md-4 col-form-label text-md-right">Confirm Password</label>
                                    <div class="col-md-6">
                                        <input id="password-confirm" type="password" class="form-control"
                                               name="password_confirmation" required autocomplete="new-password">
                                    </div>
                                </div>
                                <div class="row mb-0">
                                    <div class="col-md-6 offset-md-4">
                                        <button type="submit" class="btn btn-primary">enregistrer</button>
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

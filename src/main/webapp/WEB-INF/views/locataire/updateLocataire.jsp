<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderLocataire.jsp"/>
<div class="card">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/updateLocataire" method="post">
            <div class="col-6" hidden="true">
                <label for="id_locataire" class="form-label">Nom du Locataire</label>
                <input type="text" class="form-control is-valid" id="id_locataire"  name="nom_locataire" value="${updateLocataire.getIdLocataire()}" disabled>
            </div>
            <div class="col-6">
                <label for="nom_locataire" class="form-label">Nom du Locataire</label>
                <input type="text" class="form-control is-valid" id="nom_locataire"  name="nom_locataire" value="${updateLocataire.getNomLocataire()}" placeholder="nom du locataire" required>
            </div>
            <div class="col-6">
                <label for="prenom1" class="form-label">prenom 1 du locataire</label>
                <input type="text" class="form-control is-valid" id="prenom1" value="${updateLocataire.getPrenom1Locataire()}" name="prenom1" placeholder="prenom du locataire" required>
            </div>
            <div class="col-6">
                <label for="prenom2" class="form-label">prenom 2 du locataire</label>
                <input type="text" class="form-control is-valid" id="prenom2" name="prenom2" value="${updateLOcataire.getPrenom2Locataire()}" placeholder="2eme prenom du locataire">
            </div>

            <div class="col-6">
                <label for="telephone" class="form-label">telephone du locataire</label>
                <input type="text" class="form-control is-valid" id="telephone" value="${updateLocataire.getTelephoneLocataire()}" name="telephone" placeholder="telephone du locatairer" required>
            </div>

            <div class="col-3">
                <label for="addresse" class="form-label">addresse du locataire</label>
                <input type="text" class="form-control is-valid" id="addresse" value="${updateLocataire.getAddresseLocataire()}" name="addresse" placeholder="addresse du locatairer" required>
            </div>
            <div class="md-3">
                <label for="email" class="form-label">email du locataire</label>
                <input type="text" class="form-control is-valid" id="email" value="${updateLocataire.getEmailLocataire()}" name="email" placeholder="email du locatairer" required>
            </div>
            <div class="md-3">
                <label for="garant" class="form-label">garant du locataire</label>
                <input type="text" class="form-control is-valid" id="garant" value="<c:forEach items="${updateLocataire.getGarants()}" var="p">${p.getDesignation()}, </c:forEach> " name="garant" placeholder="donner les garant du locataire  separe par virgule..." required>
            </div>
            <div class="md-3">
                <button class="btn btn-primary" type="submit">enregistrer</button>
            </div>
        </form>
        </form>
    </div>
</div>

<jsp:include page="../common/Dfooter.jsp"/>


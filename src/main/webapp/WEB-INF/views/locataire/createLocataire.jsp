<jsp:include page="../common/DheaderLocataire.jsp"/>
<div class="card">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/saveLocataire" method="post">
            <div class="col-md-6">
                <label for="nom_locataire" class="form-label">Nom du Locataire</label>
                <input type="text" class="form-control is-valid" id="nom_locataire"  name="nom_locataire" value="" placeholder="nom du locataire" required>
            </div>
            <div class="col-md-6">
                <label for="prenom1" class="form-label">prenom 1 du locataire</label>
                <input type="text" class="form-control is-valid" id="prenom1" value="" name="prenom1" placeholder="prenom du locataire" required>
            </div>
            <div class="col-md-6">
                <label for="prenom2" class="form-label">prenom 2 du locataire</label>
                <input type="text" class="form-control is-valid" id="prenom2" name="prenom2" value="" placeholder="2eme prenom du locataire">
            </div>

            <div class="col-md-6">
                <label for="telephone" class="form-label">telephone du locataire</label>
                <input type="text" class="form-control is-valid" id="telephone" value="" name="telephone" placeholder="telephone du locatairer" required>
            </div>

            <div class="col-md-6">
                <label for="addresse" class="form-label">addresse du locataire</label>
                <input type="text" class="form-control is-valid" id="addresse" value="" name="addresse" placeholder="addresse du locatairer" required>
            </div>
            <div class="col-md-6">
                <label for="email" class="form-label">email du locataire</label>
                <input type="text" class="form-control is-valid" id="email" value="" name="email" placeholder="email du locatairer" required>
            </div>
            <div class="col-md-6">
                <label for="garant" class="form-label">garant du locataire</label>
                <input type="text" class="form-control is-valid" id="garant" value="" name="garant" placeholder="donner les garant du locataire  separe par virgule..." required>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">enregistrer</button>
            </div>
        </form>
        </form>
    </div>
</div>

<jsp:include page="../common/Dfooter.jsp"/>


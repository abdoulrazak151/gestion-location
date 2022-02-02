<jsp:include page="../common/DheaderBien.jsp"/>
<form action="${pageContext.request.contextPath}/saveBien" method="post" class="form-control">
    <div class="col-md-6">
        <label for="addresse_bien" class="form-label">Addresse du bien</label>
        <input type="text" class="form-control" id="addresse_bien"  name="addresse_bien" value="" placeholder="donner l'addresse de l'immobilier" required>
    </div>
    <br>
    <div class="col-md-6">
            <label for="surface_bien" class="form-label">Surface du bien</label>
        <input type="text" class="form-control" id="surface_bien" value="" name="surface_bien" placeholder="surface de l'immobilier" required>
    </div>
    <div class="col-md-6">
        <label for="equipement_bien" class="form-label">Equipements du bien</label>
        <input type="text" class="form-control" id="equipement_bien" name="equipement_bien" value="" placeholder="donner les equipements de l'immobilier separe" required>
    </div>

    <div class="col-12">
        <button class="btn btn-primary" type="submit">enregistrer</button>
    </div>
</form>
<jsp:include page="../common/Dfooter.jsp"/>


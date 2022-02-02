<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/Dheader.jsp"/>
<form action="/updateBien" method="post" class="form-control">
    <div class="md-3">
        <label for="id_bien" class="form-label">Addresse du bien</label>
        <input type="text" class="form-control" id="id_bien" name="id_bien" value="${updateBien.getIdBien()}" required>
    </div
    <div class="md-3">
        <label for="addresse_bien" class="form-label">Addresse du bien</label>
        <input type="text" class="form-control" id="addresse_bien" name="addresse_bien" value="${updateBien.getAddresseBien()}" placeholder="donner l'addresse de l'immobilier" required>
    </div>
    <div class="md-3">
        <label for="surface_bien" class="form-label">Surface du bien</label>
        <input type="text" class="form-control" id="surface_bien" value="${updateBien.getSurfaceBien()}" name="surface_bien" placeholder="surface de l'immobilier" required>
    </div>
    <div class="md-3">
        <label for="equipement_bien" class="form-label">Equipements du bien</label>
        <input type="text" class="form-control " id="equipement_bien" name="equipement_bien" value="<c:forEach items="${updateBien.getEquipements()}" var="p">${p.getDesignation()}, </c:forEach> " placeholder="donner les equipements de l'immobilier separe" required>
    </div>

    <div class="col-12">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>
<jsp:include page="../common/Dfooter.jsp"/>


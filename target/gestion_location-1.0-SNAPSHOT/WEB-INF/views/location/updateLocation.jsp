<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderLocation.jsp"/>
<br>
<br>
<c:if test="${! empty errorMessage}">${errorMessage}</c:if>
<div class="card">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/updateLocation" method="post">
            <div class="input-group form-floating mb-3"hidden="hidden">
                <input type="text" class="form-control is-valid"  name="id_location" value="${updateLocation.getIdLocation()}" disabled="true" hidden="true">
                <span class="input-group-text">mois</span>
            </div>
            <div class="mb-3">
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="bien" >
                    <option selected>${updateLocation.getBien().getAddresseBien()} ${updateLocation.getBien().getSurfaceBIen()}</option>
                    <c:forEach items="${biens}" var="p">
                        <option value="${p.getIdBien()}">${p.getAddresseBien()}</option
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3" disabled="true">
                <label for="equipement_bien" class="form-label">Equipements du bien</label>
                <input type="text" class="form-control is-valid" id="equipement_bien" name="equipement_bien" value=" " placeholder="donner les equipements de l'immobilier separe">
            </div>
            <div class="mb-3">
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="locataire">
                    <option selected>${updateLocation.getLocataire.getNomLocataire()}</option>
                    <C:forEach var="item" items="${locataires}">
                        <option value="${item.getIdLocataire()}">${item.getNomLocataire()}</option>
                    </C:forEach>
                </select>
            </div>
            <div class="input-group form-floating mb-3">
                <input type="number" class="form-control is-valid" id="duree"  name="duree" value="${updateLocation.getDuree()}" placeholder="duree de la location" required>
                <label for="duree" class="form-label">duree de la location</label>
                <span class="input-group-text">mois</span>
            </div>
            <div class="input-group form-floating mb-3">
                <input type="number" class="form-control is-valid" id="nomtant"  name="montant" value="${updateLocation.getMontant()}" placeholder="montant de la location" required>
                <label for="nomtant" class="form-label">montant de la location</label>
                <span class="input-group-text">F cfa</span>
            </div>
            <div class="md-3">
                <label for="date" class="form-label">date debut</label>
                <input type="datetime-local" class="form-control is-valid" id="date" value="${updateLocation.getDate()}" name="date" required>
            </div>
            <br>
            <div class="md-3">
                <label for="charge" class="form-label">charges de la location</label>
                <input type="text" class="form-control is-valid" id="charge" value="" name="charge" placeholder="donner les charges du locataire  separe par une virgule..." required>
            </div>
            <br>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">enregistrer</button>
            </div>
        </form>
        </form>
    </div>
</div>

<jsp:include page="../common/Dfooter.jsp"/>


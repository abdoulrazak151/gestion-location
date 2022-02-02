<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderPaiement.jsp"/>
<br>
<br>
<c:if test="${! empty errorMessage}">${errorMessage}</c:if>
<div class="card">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/savePaiement" method="post">
            <div class="mb-3">
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="location">
                    <option selected>choisir la location</option>
                    <c:forEach items="${paiements}" var="p">
                        <option value="${p.getIdLocation()}">${bien.getBien(p.getBien()).getAddresseBien()}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3" disabled="true">
                <label for="montant" class="form-label">montant pay&eacute;</label>
                <input type="number" class="form-control is-valid" id="montant" name="montant" value="" placeholder="montant de paiement">
            </div>

            <div class="input-group form-floating mb-3">
                <input type="datetime-local" class="form-control is-valid" id="duree"  name="date" value="" placeholder="date paiement" required>
                <label for="duree" class="form-label">montant de paiement</label>
                <span class="input-group-text">F cfa</span>
            </div>

            <br>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">enregistrer</button>
            </div>
        </form>
    </div>
</div>

<jsp:include page="../common/Dfooter.jsp"/>


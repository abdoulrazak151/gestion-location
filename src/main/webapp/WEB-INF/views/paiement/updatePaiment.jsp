<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderPaiement.jsp"/>
<br>
<br>
<c:if test="${! empty errorMessage}">${errorMessage}</c:if>
<div class="card">
    <div class="card-header"></div>
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/updatePaiement" method="post">
            <input type="text" value="${updatePaiement.getIdPaiement()}" name="id">
            <div class="mb-3">
                <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="location">
                    <option selected>${updatePaiement.getLocation().getIdLocation()}</option>
                    <c:forEach items="${paiements}" var="p">
                        <option value="${p.getLocation().getIdLocation()}">${p.getLocation().getBien().getIdBien()}</option
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3" disabled="true">
                <label for="montant" class="form-label">montant pay&eacute;</label>
                <input type="number" class="form-control is-valid" id="montant" name="montant" value="${updatePaiement.getMontant()}" placeholder="montant de paiement">
            </div>

            <div class="input-group form-floating mb-3">
                <input type="datetime-local" class="form-control is-valid" id="duree"  name="date" value="${updatePaiement.getDate()}" placeholder="date" required>
                <label for="duree" class="form-label">montant de paiement</label>
                <span class="input-group-text">F cfa</span>
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


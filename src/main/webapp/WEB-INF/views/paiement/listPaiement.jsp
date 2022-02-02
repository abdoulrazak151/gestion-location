<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/DheaderPaiement.jsp"/>
<br>

    <div class="bd-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Location</th>
                <th scope="col">Montant</th>
                <th scope="col">Date Paiement</th>
                <th>action</th>
            </tr>
            </thead>
            <tbody>

            <C:forEach items="${list}" var="p">
            <tr>

                <th scope="row">${p.getIdPaiement()}</th>
                <td>${p.getLocation().getBien().getAddresseBien()} loy&eacute; par ${p.getLocation().getLocataire().getNomLocataire()}</td>
                <td>${p.getMontantPaiement()}</td>
                <td>${p.getDatePaiement()}</td>
                <td><a href="${pageContext.request.contextPath}/updatePaiement?id=${p.getIdPaiement()}">modifier</a>  <a href="${pageContext.request.contextPath}/deletePaiement?id=${p.getIdPaiement()}">supprimer</a> </td>
            </tr>
            </C:forEach>

            </tbody>
        </table>
    </div>

<jsp:include page="../common/Dfooter.jsp"/>
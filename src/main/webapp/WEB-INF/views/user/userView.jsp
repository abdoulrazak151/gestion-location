<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderBien.jsp"/>
<br>

<div class="bd-example">
    <form action="${pageContext.request.contextPath}/updateUser">
    <input type="hidden" name="id" value="${updateUser.getIdUser()}">
    <ul class="list-group">

        <li class="list-group-item">${updateBailleur.getNomBailleur()}</li>
        <li class="list-group-item">${udpdateBailleur.getPrenom1Bailleur()}</li>
        <li class="list-group-item">${updateBailleur.getPrenom2Bailleur()}</li>
        <li class="list-group-item">${updateBailleur.getTelephoneBailleur()}</li>
        <li class="list-group-item">${updateBailleur.getEmailBailleur()}</li>
    </ul><br>
<input type="submit" name="modifier" class="btn-outline-success" value="modifier"/>
</form>
</div>


<jsp:include page="../common/Dfooter.jsp"/>
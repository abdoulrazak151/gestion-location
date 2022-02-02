<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderLocataire.jsp"/>
<br>
<div>
  <div class="bd-example">
    <table class="table table-striped">
      <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">nom et prenom</th>
        <th scope="col">addresse</th>
        <th scope="col">telephone</th>
        <th scope="col">email</th>
        <th>Garants</th>
        <th>Action</th>

      </tr>
      </thead>
      <tbody>
      <c:forEach items="${listLocataire}" var="p">
      <tr>

        <th scope="row">${p.getIdLocataire()}</th>
        <td>${p.getNomLocataire()} ${p.getPrenom1Locataire()}</td>
        <td>${p.getAddresseLocataire()}</td>
        <td>${p.getTelephoneLocataire()}</td>
        <td>${p.getEmailLocataire()}</td>
        <td><a href="${pageContext.request.contextPath}/updateLocataire?id=${p.getIdLocataire()}">modifier</a> <a href="${pageContext.request.contextPath}/deleteLocataire?id=${p.getIdLocataire()}">supprimer</a> </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <jsp:include page="../common/Dfooter.jsp"/>
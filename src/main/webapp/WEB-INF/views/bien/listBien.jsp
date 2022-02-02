<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/DheaderBien.jsp"/>
<br>

    <div class="bd-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Adresse</th>
                <th scope="col">Surface</th>
                <th scope="col">equipement</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <C:forEach var="l" items="${listBien}">
            <tr>
                <th scope="row">${l.getIdBien()}</th>
                <td>${l.getAddresseBien()}</td>
                <td>${l.getSurfaceBien()}</td>
                <td><C:forEach items="${l.getEquipements()}" var="n">${n.getDesignation()},</C:forEach> </td>
                <td><a href="${pageContext.request.contextPath}/updateBien?id=${l.getIdBien()}">modifier</a> <a href="${pageContext.request.contextPath}/deleteBien?id=${l.getIdBien()}">supprimer</a> </td>
            </tr>
            </C:forEach>

            </tbody>
        </table>
    </div>


<jsp:include page="../common/Dfooter.jsp"/>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/DheaderLocation.jsp"/>
<br>

    <div class="bd-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Bien</th>
                <th scope="col">Locataire</th>
                <th scope="col">Dur&eacutee</th>
                <th scope="col">Montant</th>
                <th scope="col">Date Debut</th>
                <th>charges</th>
                <th>action</th>
            </tr>
            </thead>

            <tbody>
            <C:forEach items="${locations}" var="p">
            <tr>
                <th scope="row">1</th>
                <td> a </td>
                <td>1</td>
                <td>0</td>
                <td>1</td>
                <td>0</td>
                <td>3</td>
                <td><a href="${pageContext.request.contextPath}/updateLocation">modifier</a>  <a href="#">supprimer</a> </td>
            </tr>
            </C:forEach>

            </tbody>
        </table>
    </div>


<jsp:include page="../common/Dfooter.jsp"/>
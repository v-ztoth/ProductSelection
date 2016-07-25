<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <h2>Customer id:</h2>
    <c:out value="${customerId}"/><br>
    <h2>The channels you selected are shown below:</h2>
    <br>
    <c:forEach var="channel" items="${selectedSportChannels}">
            <c:out value="${channel.productName}"/><br>
    </c:forEach>
    <c:forEach var="channel" items="${selectedNewsChannels}">
                <c:out value="${channel.productName}"/><br>
    </c:forEach>
</body>


</html>
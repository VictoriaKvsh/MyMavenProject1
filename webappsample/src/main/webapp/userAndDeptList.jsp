
<%@page import="by.grodno.vika.webappsample.service.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


	<br />


	<c:if test="${requestScope.users != null}">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Num</th>
					<th scope="col">Firstname</th>
					<th scope="col">Lastname</th>
					<th scope="col">Birthdate</th>
					<th scope="col">Sex</th>
					<th scope="col">Salary</th>
				</tr>
			</thead>

			<c:forEach var="i" begin="1" end="${fn:length(requestScope.users)}">
				<c:set var="currUser" scope="request"
					value="${requestScope.users[i-1]}" />
				<tr>
					<td scope="row">${i}</td>
					<td>${requestScope.currUser.firstName}</td>
					<td>${requestScope.currUser.lastName}</td>
					<td>
						<%
							Date userBirth = ((User) request.getAttribute("currUser")).getBirthdate();
						if (userBirth != null) {
							out.println(new SimpleDateFormat("yyyy-MM-dd").format(userBirth));
						}
						%>
					</td>
					<td><c:choose>
							<c:when test="${requestScope.currUser.male}">Male</c:when>
							<c:otherwise>Female</c:otherwise>
						</c:choose></td>


					<td>${requestScope.currUser.salary}</td>
					
				</tr>

			</c:forEach>
		</table>
	</c:if>

	<a class="btn btn-primary"
		href="http://localhost/webappsample/dep">Return</a>

	<br />
	<br />

</body>
</html>
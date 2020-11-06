<%@page import="by.grodno.vika.webappsample.service.Department"%>

<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<br />


	<c:if test="${requestScope.department != null}">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Num</th>
					<th scope="col">Department name</th>
					<th scope="col">Users of same Dept</th>
					<th scope="col">Action</th>

				</tr>
			</thead>

			<c:forEach var="department" items="${requestScope.department}">
				<tr>
					<td scope="row">${department.id}</td>
					<td>${department.depName}</td>


					<td><a class="btn btn-primary"
						href="http://localhost/webappsample/dep/listOfUsers?id=${department.id}">List
							of Users</a></td>

					<td><a class="btn btn-danger"
						href="http://localhost/webappsample/dep/delete?id=${department.id}">Delete
							department</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a class="btn btn-success"
		href="http://localhost/webappsample/depListAdd.jsp">Add Department</a>

</body>
</html>

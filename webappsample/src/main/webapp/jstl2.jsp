<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<body>
	<%@ include file="fragments/header.jsp"%>
	<form action="user" method="POST">


		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">First Name</span>
			</div>
			<input type="text" class="form-control" name="firstName"
				aria-describedby="basic-addon3"
				value="<%=(request.getParameter("firstName") != null) ? request.getParameter("firstName") : ""%>">
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">Last Name</span>
			</div>
			<input type="text" class="form-control" name="lastName"
				aria-describedby="basic-addon3"
				value="<%=(request.getParameter("lastName") != null) ? request.getParameter("lastName") : ""%>">
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">BirthDate</span>
			</div>
			<input type="text" class="form-control"
				placeholder="yyyy-mm-dd hh:mm:ss" name="birthdate"
				aria-describedby="basic-addon3"
				value="<%=(request.getParameter("birthdate") != null) ? request.getParameter("birthdate") : ""%>">
		</div>

		<div class="custom-control custom-radio">
			<input type="radio" id="male" name="male" value="true"
				${param.male == 'true' ? 'checked' : ''}
				class="custom-control-input"> <label
				class="custom-control-label" for="male">Male</label>
		</div>
		<div class="custom-control custom-radio">
			<input type="radio" id="female" name="male" value="false"
				${param.male == 'false' ? 'checked' : ''}
				class="custom-control-input"> <label
				class="custom-control-label" for="female">Female</label>
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">Number of
					Department</span>
			</div>
			<input type="text" class="form-control" name="department"
				aria-describedby="basic-addon3"
				value="<%=(request.getParameter("department") != null) ? request.getParameter("department") : ""%>">
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">Salary</span>
			</div>
			<input type="text" class="form-control" name="salary"
				aria-describedby="basic-addon3"
				value="<%=(request.getParameter("salary") != null) ? request.getParameter("salary") : ""%>">
		</div>

		<input type="hidden" name="id"
			value="<%=(request.getParameter("id"))%>" />


		<c:choose>

			<c:when test="${param.lastName == null}">

				<input type="submit" class="btn btn-secondary"
					value="Submit new user">
			</c:when>
			<c:otherwise>

				<input type="submit" class="btn btn-secondary"
					value="Update user's data" formaction="update">
			</c:otherwise>
		</c:choose>







	</form>
	<!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
</body>
</html>
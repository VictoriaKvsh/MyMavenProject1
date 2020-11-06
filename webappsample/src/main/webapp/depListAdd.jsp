<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<body>
	<%@ include file="fragments/header.jsp"%>
	<form action="add_dep" method="POST">


		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">Number of Department </span>
			</div>
			<input type="text" class="form-control" name="id"
				aria-describedby="basic-addon3">
		</div>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon3">Department Name</span>
			</div>
			<input type="text" class="form-control" name="department"
				aria-describedby="basic-addon3">
		</div>


		<input type="submit"
			class="btn btn-secondary" value="Add new department">
	</form>
	<!--POST localhost/webappsample/user?firstName=asd&lastName=qwe&birthdate=1234-12-12&male=true -->
</body>
</html>
<%@ page import="java.net.InetAddress" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- <link rel="stylesheet" href="bootstrap/css/bootstrap.css"> -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="http://datatables.github.com/Plugins/integration/bootstrap/dataTables.bootstrap.css">
<link href="css/docs.css" rel="stylesheet">
<!-- <script src="http://code.angularjs.org/1.0.2/angular.min.js"></script> -->
<!-- <script src="http://documentcloud.github.com/underscore/underscore-min.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/paging.js"></script>
<script src="datatables/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="http://datatables.github.com/Plugins/integration/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#employeeTable').dataTable({
		"sDom": "<'row-fluid'<'span6'T><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
		"oTableTools": {
			"aButtons": [
				"copy",
				"print",
				{
					"sExtends":    "collection",
					"sButtonText": 'Save <span class="caret" />',
					"aButtons":    [ "csv", "xls", "pdf" ]
				}
			]
		}
	} );
} );
</script>

</head>
<body>

	<div class="container">

		<div class="hero-unit">
			<h1>Employee Listing</h1>
			<p>Confidential</p>
		</div>

		<c:if test="${not empty errorMessage}">
			<div style="color:red">${errorMessage}</div> 			
		</c:if>
			
		<div style="color:blue" class="caption">
			Hostname: <%=InetAddress.getLocalHost().getHostName()%>
		</div> 			

        <div class="span8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>JDBC</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>JDBC URL</td><td>${jdbcUrl}</td>
                </tr>
                <tr>
                    <td>JDBC Driver</td><td>${jdbcDriver}</td>
                </tr>
                <tr>
                    <td>JDBC Username</td><td>${jdbcUsername}</td>
                </tr>
                <tr>
                    <td>JDBC Password</td><td>${jdbcPassword}</td>
                </tr>

                </tbody>
            </table>
        </div>
		
		<div>
			<c:if test="${not empty employees}">

				<table id="employeeTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Birthday</th>
							<th>EmployeeType</th>
							<th>Dept #</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${employees}">
							<tr>
								<td>${o.id}</td>
								<td>${o.firstName}</td>
								<td>${o.lastName}</td>
								<td>${o.birthday}</td>
								<td>${o.employeeType}</td>
								<td>${o.departmentNumber}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>

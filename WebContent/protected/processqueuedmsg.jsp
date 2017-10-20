<%@page import="com.bs.theme.bob.adapter.adaptee.PostingStagingAdaptee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>ProcessQueuedMsg</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/daterangepicker-bs3.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery.dataTables.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery-ui.datepicker.css"
	rel="stylesheet" />
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="../css/customized.css" rel="stylesheet" />

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<!-- <script src="../js/jquery-ui.datepicker.js" type="text/javascript"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("timenu");
	});
	function goBack() {
		window.history.back();
	};
</script>

</head>
<body>

	<div class="col-md-12">
		<jsp:include page="primarylimitmenu.jsp" />
	</div>
	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Process queued messages</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<%-- 	<jsp:include page="timezone.jsp" /> --%>
			</div>
		</div>

		<%
			if (request.getParameter("processQueueMessage") != null
					&& !request.getParameter("processQueueMessage").isEmpty()) {

				Thread t = new Thread() {
					public void run() {
						PostingStagingAdaptee postingStagingobj = new PostingStagingAdaptee();
						postingStagingobj.process();
					}
				};
				t.start();

			}
		%>
		<div class="row">
			<!-- Body content HTML -->
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<div class="col-sm-offset-0 col-lg-12">
						<form class="form-group">
							<div class="col-md-6">
								<input type="submit" name="processQueueMessage"
									value="processQueueMessage" class="btn btn-primary"
									id="processQueueMessage" />
							</div>
						</form>
						<br> <br> <br>
					</div>
				</div>
			</div>
		</div>

		<%
			if (request.getParameter("processQueueMessage") != null
					&& !request.getParameter("processQueueMessage").isEmpty()) {
		%>
		<div class="row">
			<div class="alert alert-success">button clicked! Message will
				flow...</div>
		</div>
		<%
			}
		%>

	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>

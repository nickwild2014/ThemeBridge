<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Dashboard  
--%>
<%@page import="com.bs.themebridge.dashboard.DashboardService"%>
<%@page import="com.bs.themebridge.dashboard.InterfaceStatusReport"%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ThemeBridge</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="../css/daterangepicker-bs3.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery.dataTables.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery-ui.min.css" />
<link type="text/css" rel="stylesheet" href="../css/customized.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery-ui.datepicker.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.peity.js"></script>
<script type="text/javascript" src="../js/raphael.2.1.0.min.js"></script>
<script type="text/javascript" src="../js/justgage.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("dash");
	});
</script>
<!-- //do ext javascript function -->
</head>
<body>

	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="col-md-12">
		<div class="container">
			<div class="col-md-12">
				<div class="row"></div>
			</div>
			<br>
		</div>
	</div>

	<%-- <jsp:include page="include_footer.jsp" /> --%>
</body>
</html>

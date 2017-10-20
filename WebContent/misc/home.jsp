<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: ThemeBridge index
--%>
<html lang="en">
<head>
<meta name="author" content="Themebridge">
<meta name="description" content="TIPlus Interface">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/font-awesome.css" />
<link type="text/css" rel="stylesheet"
	href="../css/daterangepicker-bs3.css" />
<link type="text/css" rel="stylesheet" href="../css/customized.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery-ui.datepicker.css" />
<link type="text/css" rel="stylesheet" href="../css/about.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css">

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript" src="../js/dashboard.js"></script>
<!-- <script type="text/javascript">
var loggedInUser = "<%=request.getRemoteUser()%>";
	if (!checkUserPrivileges(loggedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	}
</script> -->
<script type="text/javascript">
	var schemename = window.location.protocol;
	var domainname = window.location.host;
	var url = window.location.href;
	out.println("url " + url);
	var arr = url.split("/");
	var result = arr[0] + "//" + arr[2]
	out.println("result " + result);
	
	var full = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '');
	out.println(">>> " + location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: ''))
	
	var indzone = schemename + "//" + domainname + ":8884" + "/tiplus2-deploy1";
	// var indzone = "https://misyssitwebappmig1:8883/tiplus2-global";
	//var indzone = "https://bluescope-inspiron-535s:9450/tiplus2-global";

	$(document).ready(function() {
		$("#ind").attr("href", indzone);
	});
</script>
<!--<script type="text/javascript">

	function toggle_visibility(id) {
		var e = document.getElementById(id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';
	} 
</script>-->
</head>
<body>
	<%
		// Get context path
		String contextPath = request.getContextPath();
		// out.println("contextPath :" + contextPath);
		// result : /ThemeBridge

		String user = "";
		if (request.getRemoteUser() == null) {
			user = "Admin";
		}
	%>
	<!-- Content is here -->
	<div id="header">
		<%--<h3 class="heading" style="color: lightblue; font-family: verdana;">
			<img src="../images/custom/themebridge-logo2.png" alt="Mountain View"
			style="width: 75px; height: 30px; margin-left:20px;">THEMEBRIDGE</h3>--%>
		<h3 class="heading"
			style="color: lightblue; font-family: verdana; margin-left: 20px;">THEMEBRIDGE</h3>
	</div>
	<div id="intro" style="height: 2px; background-color: lightgreen"></div>


	<!-- Left column definition start -->
	<div id="nav">
		<jsp:include page="primarynavbar.jsp" />
	</div>
	<!-- Left column definition end -->


	<div class="col-lg-12 col-md-12 col-sm-12">
		<div id="section">
			<div class="col-lg-12 col-md-12 col-sm-12 row">
				<div class="col-lg-2 col-md-2 col-sm-2">
					<img src="../images/custom/themelogo3.png" alt="bridgeview"
						style="width: 80px; height: 50px;">
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<h4>THEMEBRIDGE</h4>
				</div>
			</div>
			<div>
				<legend></legend>
			</div>
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Time zone<br>
				</div>
				<br>
				<div><jsp:include page="timezone.jsp" /></div>
			</div>
			<!--  <br>
			<div>
				<div id="foo">
					 <span class="glyphicon glyphicon-plus-sign"></span> 
					&emsp;Test<br>
				</div>
				<br> &emsp;<a class="fa fa-list-alt" href="eodskipentry.jsp"> EOD Skip</a>
					&emsp;&emsp; <a class="fa fa-sitemap" href="eodschdetails.jsp"> EOD Details</a>
					&emsp;&emsp; <a	class="fa fa-database" href="eodschedule.jsp"> EOD Schedule</a>
					&emsp;&emsp;
			</div>-->
			<br>
			<!-- <div>
				<div id="foo">
					
					&emsp;Trend chart<br>
				</div>
				<br> &emsp;<a class="fa fa-bar-chart-o"
					href="staticdataloggraph.jsp"> Staticdata Chart</a>&emsp;&emsp; <a
					class="fa fa-bar-chart-o" href="serviceloggraph.jsp">
					Servicedata Chart</a>&emsp;&emsp; <a class="fa fa-bar-chart-o"
					href="transactionloggraph.jsp"> Transactiondata Chart</a>&emsp;&emsp;
			</div>
			<br> -->
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Enquiry Services<br>
				</div>
				<br> &emsp;<a class="fa fa-money" href="tbfetchfd.jsp"> FD
					Enquiry</a> &emsp;&emsp;<a class="fa fa-file-pdf-o"
					href="tbfetchsignature.jsp"> FD Marking</a> &emsp;&emsp;<a
					class="fa fa-sitemap" href="tbcollateralenq.jsp"> FD Reverse</a>
			</div>
			<br>
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Lookup<br>
				</div>
				<br> &emsp;<a href="settings.jsp"> Bridge Properties</a>
				&emsp;&emsp;<a href="lookupacctype.jsp"> Account Type</a>
				&emsp;&emsp;<a href="lookupglacc.jsp"> GL Account Type</a>
				&emsp;&emsp; <a href="lookupccycode.jsp"> Currency Code</a>
				&emsp;&emsp;<a href="eodpostinglog.jsp"> EOD Posting Log</a>
				&emsp;&emsp;<a href="notificationslog.jsp"> Notifications Log</a>
				&emsp;&emsp;
			</div>
			<br>
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Push Services<br>
				</div>
				<br> &emsp; <a href="ondemandaccount.jsp"> Account Data </a>&emsp;&emsp;<a
					href="ondemandcustomer.jsp"> Customer Data</a>&emsp;&emsp;<a
					href="ondemandcardrate.jsp"> Fx Rate </a>&emsp;&emsp;<a
					href="ondemandbaserate.jsp"> Base Rate</a>
			</div>
			<br>
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Miscellaneous<br>
				</div>
				<br> &emsp; <a href="readdirectory.jsp"> Directory Analysis</a>&emsp;&emsp;<a
					href="schematables.jsp"> Schema Analysis</a>&emsp;&emsp;<a
					href="bridgegateway.jsp"> Bridge Gateway </a>&emsp;&emsp;<a
					href="tiejbclient.jsp"> EJB Client</a>&emsp;&emsp;<a
					href="finaclegateway.jsp"> Finacle Client</a>
			</div>
			<br>
			<div>
				<div id="foo">
					<!-- <span class="glyphicon glyphicon-plus-sign"></span> -->
					&emsp;Miscellaneous Plus<br>
				</div>
				<br> &emsp; <a href="swiftgateway.jsp"> Swift Out</a>&emsp;&emsp;<a
					href="accountstatus.jsp"> Account Status</a>&emsp;&emsp;<a
					href="themestaginglog.jsp"> ThemeTransportClient</a>&emsp;&emsp;
			</div>
			<br>
		</div>
	</div>
	<!--<button name="test" >https://tiuat.fgb.ae/tiplus2-global/j_spring_security_logout</button>&emsp;&emsp;
	<a href="https://tiuat.fgb.ae/tiplus2-global/j_spring_security_logout"> Directory Analysis</a>&emsp;&emsp;
	<a href="https://tiuat.fgb.ae/tiplus2-global/pages/frames.jsp"> Schema Analysis</a>&emsp;&emsp; 
	https://tiuat.fgb.ae/tiplus2-global/pages_cscs/SecurityLogoutUser.jsf-->
</body>
</html>
<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: AbountThemebridge.
--%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bs.themebridge.entity.servlet.util.AboutMeImpl"%>
<html lang="en">
<head>
<meta name="author" content="Themebridge">
<meta name="description" content="TIPlus Interface">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>About Me</title>
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
<script type="text/javascript">
var loggedInUser = "<%=request.getRemoteUser()%>";
	if (!checkUserPrivileges(loggedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	}
</script>
<script type="text/javascript">
	var schemename = window.location.protocol;
	var domainname = window.location.host;
	//var uaezone = schemename + "//" + domainname
	//	+ "/tiplus2-global?zone=UAEZONE";
	//var sngzone = schemename + "//" + domainname
	//	+ "/tiplus2-global?zone=SNGZONE";
	//var qatarzone = schemename + "//" + domainname
	//		+ "/tiplus2-global?zone=QATARZONE";
	// var indzone = schemename + "//" + domainname + "/tiplus2-global";
	var indzone = "https://misyssitwebappmig1:8883/tiplus2-global";

	$(document).ready(function() {
		//$("#uae").attr("href", uaezone);
		//$("#sng").attr("href", sngzone);
		//$("#qatar").attr("href", qatarzone);
		$("#ind").attr("href", indzone);
	});
</script>
<script type="text/javascript">
<!--
	function toggle_visibility(id) {
		var e = document.getElementById(id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';
	}
//-->
</script>
</head>
<body>
	<%--<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<jsp:include page="include_header.jsp" />
	</div> --%>
	<%-- <div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<h3>Under constructions</h3>
			</div>
		</div> --%>
	<%
		// AboutMe about = new AboutMe();
		HashMap<String, String> aHashMap = AboutMeImpl.aboutMeProperties();
	%>
	<!-- Content is here -->
	<div id="header">
		<%--<h3 class="heading" style="color: lightblue; font-family: verdana;">
			<img src="images/custom/themebridge-logo2.png" alt="Mountain View"
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

	<%-- <div id="nav">
		<div id="nav">
			<div id="nav-menu">
				<span class="glyphicon glyphicon-user"></span> <a
					href="/migration-global/pages/frames.jsp" class="navbar-link"> <%=request.getRemoteUser()%></a><br>
				<a href="/migration-global/pages/frames.jsp"><span class="glyphicon glyphicon-off"></span> Logout</a><br><br>
				ThemeBridge 1.0<br>
				<a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a><br> 
				<a href="dashboard.jsp"><span class="glyphicon glyphicon-th"></span> Dashboard</a><br> 
				<a href="staticdatalog.jsp"><span class="glyphicon glyphicon-list-alt"></span> Static Log</a><br> 
				<a href="servicelog.jsp"><span class="glyphicon glyphicon-list-alt"></span>	Service Log</a><br> 
				<a href="transactionlog.jsp"><span class="glyphicon glyphicon-list-alt"></span> Transaction Log</a><br>
				<a href="stagingdatalog.jsp"><span class="glyphicon glyphicon-list-alt"></span> StagingData Log</a><br>
				<a href="eodpostinglog.jsp"><span class="glyphicon glyphicon-list-alt"></span> EodPosting Log</a><br>
				<a href="notificationslog.jsp"><span class="glyphicon glyphicon-list-alt"></span> Notifications Log</a><br>
				<!--<a href="index.jsp"><span class="glyphicon glyphicon-gift"></span> Bridge Properties</a><br>-->
				<!-- <a href="settings.jsp"><span class="fa fa-wrench"></span> Bridge Properties</a> -->
				<!--  Enquiry Services <br> <a id="fd" href="tbfetchfd.jsp"> FD</a> | <a id="collateral" href="tbcollateralenq.jsp"> Collateral</a> | <a id="sign" href="tbfetchsignature.jsp"> Signature</a><br> -->
				<br>
				<img src="images/custom/tileicon.png" alt="#" style="width: 15px; height: 15px;"> Trade Innovation 2.7 <br>
				<a id="ind" href="#"> TI Plus</a> <br> <br> Miscellaneous<br>
				<!--<a href=""><span class="glyphicon glyphicon-info-sign"></span> About</a><br>-->
				<a href="tiejbclient.jsp"><span class="fa fa-paw"></span> EJB Client</a><br> 
				<a href="finaclegateway.jsp"><span class="fa fa-pagelines"></span> CBS Client</a><br> 
				<a href="bridgegateway.jsp"><span class="fa fa-pagelines"></span> Bridge Gateway</a><br> 
				<a href="about.jsp"><span class="glyphicon glyphicon-info-sign"></span> About</a>
			</div>
		</div>		
	</div> --%>

	<div class="col-lg-12 col-md-12 col-sm-12">
		<div id="section">
			<div class="col-lg-12 col-md-12 col-sm-12 row">
				<div class="col-lg-2 col-md-2 col-sm-2">
					<img src="../images/custom/themebridge-logo.png" alt="Mountain View"
						style="width: 150px; height: 50px;">
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
					&nbsp;
					<!--<span class="glyphicon glyphicon-plus-sign"></span>-->
					Time zone<br>
				</div>
				<div>
					&nbsp;
					<jsp:include page="timezone.jsp" /></div>
			</div>
			<br>
			<div>
				<div id="foo">
					&nbsp;
					<!--<span class="glyphicon glyphicon-plus-sign"></span>-->
					About Me<br>
				</div>
				&nbsp;
				<p align="justify">
					ThemeBridge is an interface layer which is used to communicate
					between the TI Plus and External systems. <br> <br> This
					is specially specially designed and devloped for Kotak Mahindra
					Bank Pvt. Ltd., trade services.
				</p>
			</div>
			<br>
			<div>
				<div id="foo">
					&nbsp;
					<!--<span class="glyphicon glyphicon-plus-sign"></span>-->
					Version
				</div>
				&nbsp;
				<p align="justify"></p>
				<!-- <p align="justify">ThemeBridge 2.0 is developed to support
					UAEZONE, QATARZONE, SINGAPOREZONE trade services.</p> -->
				<ul style="list-style-type: square">

					<li><b>BuildVersion :- <%=aHashMap.get("BuildVersion")%></b></li>
					<li><b>BuildSequence :- <%=aHashMap.get("BuildSequence")%></b></li>
					<!--<li>Developed By :- <%=aHashMap.get("BuildBy")%></li>-->
				</ul>
			</div>
			<br>
			<div>
				<div id="foo">
					&nbsp;
					<!--<span class="glyphicon glyphicon-plus-sign"></span>-->
					ThemeBridge Architecture
				</div>
				<div id="archimage">
					<img src="images/custom/themebridge-arch.png" alt="Mountain View"
						style="width: 600px; height: 200px; margin-left: 200px;">
				</div>
			</div>
		</div>
	</div>
</body>
</html>
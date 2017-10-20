<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: error text
--%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="TIPlus Interface">
<meta name="author" content="Themebridge">
<title>Error </title>
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

</head>
<body>
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
		<div id="nav-menu">
			<span class="glyphicon glyphicon-user"></span> <a href="/tiplus2-global/pages/frames.jsp" class="navbar-link"> <%=request.getRemoteUser()%></a><br>
			<a href="/tiplus2-global/pages/frames.jsp"><span class="glyphicon glyphicon-off"></span> Logout</a><br> <br>
			
			ThemeBridge 1.0<br> 
			<a href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a><br>
			<a href="dashboard.jsp"><span class="glyphicon glyphicon-th"></span> Dashboard</a><br> 
			<a href="staticdatalog.jsp"><span class="glyphicon glyphicon-list-alt"></span> Static Log</a><br> 
			<a href="servicelog.jsp"><span class="glyphicon glyphicon-list-alt"></span>	Service Log</a> <br> 
			<a href="transactionlog.jsp"><span class="glyphicon glyphicon-list-alt"></span> Transaction Log</a><br>
			<a href="eodpostingrequest.jsp"><span class="fa fa-list-alt"></span> Eod Postings log</a><br>
			<!--<a href="index.jsp"><span class="glyphicon glyphicon-gift"></span> Bridge Properties</a><br>-->
			<a href="settings.jsp"><span class="fa fa-wrench"></span> Bridge Properties</a><br>
			
			<!--  Enquiry
			Services <br> <a id="fd" href="tbfetchfd.jsp"> FD</a> | <a
				id="collateral" href="tbcollateralenq.jsp"> Collateral</a> | <a
				id="sign" href="tbfetchsignature.jsp"> Signature</a><br> -->
			
			<br> 
			<img src="../images/custom/tileicon.png" alt="#" style="width: 15px; height: 15px;"> Trade Innovation Plus 2.7	<br> 
			<a id="ind" href="#"> TI Plus</a> <br> <br>
			
			ThemeBridge Miscellaneous<br>
			<!--<a href=""><span class="glyphicon glyphicon-info-sign"></span> About</a><br>-->
			<a href="tiejbclient.jsp"><span class="fa fa-paw"></span> EJB Client</a><br> 
			<a href="cbsclient.jsp"><span class="fa fa-pagelines"></span> CBS Client</a><br> 
			<a href="bridgegateway.jsp"><span class="fa fa-pagelines"></span> Bridge Gateway</a> <br> 
			<a href="about.jsp"><span class="glyphicon glyphicon-info-sign"></span> About</a>
		</div>
	</div>
	<div class="col-lg-12 col-md-12 col-sm-12">
		<div id="section">
			<div class="col-lg-12 col-md-12 col-sm-12 row">
				<div class="col-lg-2 col-md-2 col-sm-2">
					<img src="../images/custom/themelogo3.png" alt="bridgeview"
						style="width: 100px; height: 50px;">
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2">
					<h4>THEMEBRIDGE</h4>
				</div>
			</div>
			<div>
				<legend></legend>
			</div>
			<h4>Page is under developement!!!</h4>
		</div>
	</div>

</body>
</html>
<!-- Changes done by PRASATH -->
<head>
<%-- <%
	String signedInUser = request.getRemoteUser();
%> --%>
<script type="text/javascript">
	// Simply Superb!! by Prasath @Kotak 

	var protocolName = window.location.protocol; // https
	// var hostPort = window.location.host; // webappuat2:8884
	var hostname = window.location.hostname; // webappuat2

	var globalName = "";
	var zoneName = "?zone=ZONE1";
	var port = window.location.port;

	if (hostname == "10.10.7.137") {
		globalName = "/tiplus2-global";// Preprod Webserver

	} else if (hostname == "10.10.20.136") {
		globalName = "/tiplus2-global";//SIT Webserver

	} else if (hostname == "10.10.20.165") {
		globalName = "/tiplus2-global";// UTA3 Webserver

	} else if (hostname == "10.10.20.183") {
		globalName = "/tiplus2-global";// UTA2 Webserver

		//} else if (hostname == "misyswebuat2" || hostname == "10.10.20.182") {
		//	globalName = ":8883/tiplus2-global";// UAT2 Appserver

	} else if (hostname == "misyswebappmig1" || hostname == "10.10.20.164") {
		globalName = ":8883/migration-global";// Migration Appserver

	} else {
		globalName = ":8883/tiplus2-global";
	}
	var tiUrl = protocolName + "//" + hostname + globalName + zoneName;

	$(document).ready(function() {
		$("#tiplus").attr("href", tiUrl);
	});

	// var tiUrl = schemename + "//" + hostname + ":8884/tiplus2-deploy1/content/index.jsf"; // direct browser
	// var tiUrl = schemename + "//misyswebuat2:8883/tiplus2-global";
	// var tiUrl = "https://misyswebuat2:8883/tiplus2-global?zone=ZONE1";
</script>

<script language="JavaScript">
	function calcTime() {
		d = new Date();
		utc = d.getTime() + (d.getTimezoneOffset() * 60000);

		var nd = new Date(utc + (3600000 * 5.5));
		document.getElementById('time_ind').innerHTML = nd.toLocaleString();

		setTimeout(calcTime, 1000);
		return "The local time is " + nd.toLocaleString();
	}
</script>
<%-- <script type="text/javascript">
var signedInUser = "<%=request.getRemoteUser()%>";
	// alert("Welcome to ThemeBridge User: " + signedInUser)
	/* if (!checkUserPrivileges(signedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	} */

	/* $(document).ready(function() {
		$("#signedInUser").attr("href", signedInUser);
	}); */

	$(document).ready(function() {
		$("#signedInUser").text(signedInUser);
	});
</script> --%>
</head>
<body onload="calcTime()">
	<div class="col-md-12"
		style="top: 0px; left: 0px; position: fixed; z-index: 1;">
		<div class="row" style="height: 1px; background-color: lightgreen"></div>
		<div>
			<div class="row patch">
				<div class="col-sm-3 col-md-3">
					<h3 class="heading" style="color: lightblue; font-family: verdana;">
						<img src="../images/custom/themelogo3.png" width="35" height="30">
						THEMEBRIDGE
					</h3>
					<%-- <h2 class="heading" style="color: lightgreen; font-family: courier;">
						THEMEBRIDGE</h2> --%>
				</div>

				<!-- <div class="col-sm-1 col-md-1" >
					<h6><i>THEMEBRIDGE</i></h6>
					<a href="#" id="time_ind"></a>
				</div> -->

				<div class="col-sm-9 col-md-9">
					<ul class="nav nav-pills font">

						<!-- <li id="time_ind"></li> -->

						<li id="index"><a href="index.jsp"> <span
								class="glyphicon glyphicon-home"> </span> Home
						</a></li>

						<!-- <li id="dash"><a href="dashboard.jsp"> <span
								class="glyphicon glyphicon-dashboard"> </span> Dash
						</a></li> -->

						<li id="settings"><a href="bridgeproperties.jsp"> <span
								class="glyphicon glyphicon-cog"> </span> Properties
						</a></li>

						<li id="stagingdatalog"><a href="postingstaginglog.jsp">
								<span class="glyphicon glyphicon-list-alt"> </span> Staging
						</a></li>

						<li id="staticdatalog"><a href="staticdatalog.jsp"> <span
								class="glyphicon glyphicon-list-alt"> </span> Static
						</a></li>

						<li id="servicelog"><a href="servicelog.jsp"> <span
								class="glyphicon glyphicon-list-alt"> </span> Service
						</a></li>

						<li id="transactionlog"><a href="transactionlog.jsp"> <span
								class="glyphicon glyphicon-list-alt"> </span> Postings
						</a></li>

						<!-- <li id="eodpostinglog"><a href="eodpostingstatus.jsp"> <span
								class="glyphicon glyphicon-list-alt"> </span> EOD
						</a></li> -->

						<li id="eodposting" class="btn-group"><a
							data-hover="dropdown" data-toggle="dropdown"> <span
								class="glyphicon glyphicon-list-alt"> </span> EOD<span
								class="caret"> </span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="eodpostingstatus.jsp"> EOD Posting Status
								</a><a href="eodpostinglog.jsp"> EOD Posting APILog </a></li>
							</ul></li>

						<!-- <li id="notificationslog"><a href="notificationslog.jsp">
								<span class="glyphicon glyphicon-list-alt"> </span> Notify
						</a></li> -->

						<!-- <li id="themestaginglog"><a href="themestaginglog.jsp"> <span
								class="glyphicon glyphicon-list-alt"> </span> Theme
						</a></li> -->

						<!-- <li id="ind"><a href="#"> <span
								class="glyphicon glyphicon-hdd"> </span> TI Plus
						</a></li> -->

						<li id="lookup" class="btn-group"><a data-hover="dropdown"
							data-toggle="dropdown"> <span
								class="glyphicon glyphicon-eye-open"> </span> Lookup <span
								class="caret"> </span>
						</a>
							<ul class="dropdown-menu">
								<li id="lookupacctype.jsp"><a href="lookupglacc.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> GL Account
										Lookup
								</a> <a href="lookupacctype.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> Account Type
										Lookup
								</a> <a href="lookupccycode.jsp"> <span id="Account"
										class="glyphicon glyphicon-eye-open"> </span> Currency Code
										Lookup
								</a> <a href="lookupcusttype.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> Customer Type
										Lookup
								</a><a href="lookupswiftdesc.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> Swift Type Desc
										Lookup
								</a> <a href="lookupfundedeliab.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> Funded Liability
										Lookup
								</a> <!-- <a href="lookupfierrorcode.jsp"> <span
										class="glyphicon glyphicon-eye-open"> </span> FI ErrorCode
										Type Lookup
								</a> --></li>
							</ul></li>

						<li><a id="tiplus" href="#"><img
								src="../images/custom/tileicon.png" alt="#"
								style="width: 15px; height: 15px;"> TIPLUS</a></li>

						<%-- <li id=""><a href="#"><span
								class="glyphicon glyphicon-user"
								style="width: 50px; height: 10px;"><%=signedInUser%></span></a></li> --%>

					</ul>
				</div>
			</div>
		</div>
		<div class="row" style="height: 2px; background-color: lightgreen"></div>
		<!-- <div id="row" style="height: 2px; background-color: black"></div> -->
	</div>
	<br>
	<br>
	<br>
</body>

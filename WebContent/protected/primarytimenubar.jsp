<!-- Changes done by PRASATH -->
<head>

<%
	String signedInUser = "Admin";
	if (request.getRemoteUser() != null) {
		signedInUser = "" + request.getRemoteUser();
	}
%>
</head>

<body onload="calcTime()">
	<div class="col-md-12"
		style="top: 0px; left: 0px; position: fixed; z-index: 1;">
		<div class="row" style="height: 1px; background-color: lightgreen"></div>
		<div>
			<div class="row patch">
				<div class="col-sm-3 col-md-3">
					<h3 class="heading" style="color: lightblue; font-family: verdana;">
						<!-- <img src="../images/custom/themelogo3.png" width="35" height="30"> -->
						<!-- <img src="/themelogo3.png" width="35" height="30"> -->
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

						<!-- <li id="tiplus"><a href="https://10.10.7.137/tiplus2-global">
								<span class="glyphicon glyphicon-hdd"> </span> TI Plus
						</a></li> -->

						<!-- <li><a id="tiplus" href="#"><img
								src="../images/custom/tileicon.png" alt="#"
								style="width: 15px; height: 15px;"> TI Plus</a></li> -->

						<%-- <li id="#"><a href="#"><span
								class="glyphicon glyphicon-user"> </span> <%=signedInUser%></a></li> --%>

						<li><a href="javascript:close();"> X</a></li>

					</ul>
				</div>

			</div>
		</div>
		<div class="row" style="height: 2px; background-color: lightgreen"></div>
	</div>
	<br>
	<br>
	<br>
</body>

<%@page import="java.lang.String"%>
<!--@author Prasath	Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<script language="JavaScript">
	function calcTime() {
		d = new Date();
		utc = d.getTime() + (d.getTimezoneOffset() * 60000);

		var nd = new Date(utc + (3600000 * 4));
		document.getElementById('time_uae').innerHTML = nd.toLocaleString();

		var nd2 = new Date(utc + (3600000 * 8));
		document.getElementById('time_singapore').innerHTML = nd2
				.toLocaleString();

		var nd3 = new Date(utc + (3600000 * 3));
		document.getElementById('time_qatar').innerHTML = nd3.toLocaleString();

		setTimeout(calcTime, 1000);
		return "The local time is " + nd.toLocaleString();
	}
</script>
<body onload="calcTime()">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">			
				<label style="color: Black">QTRZONE</label> 
				<label style="color: Black" id="time_qatar"></label>
				&nbsp;&nbsp;| &nbsp;&nbsp;
				<label style="color: Black">UAEZONE</label>
				<label style="color: Black" id="time_uae"></label>
				&nbsp;&nbsp;| &nbsp;&nbsp; 
				<label style="color: Black">SNGZONE</label> 
				<label style="color: Black" id="time_singapore"></label>
		</div>
	</div>
	<!-- <div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="navbar-text navbar-left" style="color: lightgrey">QTRZONE</label>
				<label class="navbar-text navbar-left" style="color: lightgrey"
					id="time_qatar"></label>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="navbar-text navbar-left" style="color: lightgrey">UAEZONE</label>
				<label class="navbar-text navbar-left" style="color: lightgrey"
					id="time_uae"></label>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="navbar-text navbar-left" style="color: lightgrey">SNGZONE</label>
				<label class="navbar-text navbar-left" style="color: lightgrey"
					id="time_singapore"></label>
			</div>
		</div>
	</div> -->
</body>

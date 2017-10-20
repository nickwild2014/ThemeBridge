<%@page import="java.lang.String"%>
<!--@author Prasath	Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<script language="JavaScript">
	function calcTime() {
		d = new Date();
		utc = d.getTime() + (d.getTimezoneOffset() * 60000);

		var nd = new Date(utc + (3600000 * 5.5));
		document.getElementById('time_india').innerHTML = nd.toLocaleString();

		setTimeout(calcTime, 1000);
		return "The local time is " + nd.toLocaleString();
	}
</script>
<body onload="calcTime()">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<label style="color: darkgreen">INDIA</label> <label
				style="color: darkgreen" id="time_india"></label>
		</div>
	</div>
</body>

<%-- 
Copyright (c) 2008, Martin W. Kirst
All rights reserved.

Redistribution and use in source and binary forms, with or without 
modification, are permitted provided that the following conditions are met: 

* Redistributions of source code must retain the above copyright notice, 
  this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.

* Neither the name of the Martin W. Kirst nor the names of its 
  contributors may be used to endorse or promote products derived from 
  this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS 
IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED 
TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER 
OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS 
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
--%>
<%@page import="java.lang.String"%>
<%
	String signedInUser = request.getRemoteUser();
	// String addr = request.getRemoteAddr();
	// String host = request.getRemoteHost();
	// int port = request.getRemotePort();
	// out.println("/" + addr + "/" + host + "/" + port + "/"
	// 		+ request.getUserPrincipal() + "/");
	// if (request.getRemoteUser() != null) {
	//	signedInUser = "" + request.getRemoteUser();
	// } else {
	//	signedInUser = "LogIn";
	// }
%>
<script language="JavaScript">
	function calcTime() {
		d = new Date();
		utc = d.getTime() + (d.getTimezoneOffset() * 60000);

		var nd = new Date(utc + (3600000 * 5.5));
		document.getElementById('time_ind').innerHTML = nd.toLocaleString();

		//var nd2 = new Date(utc + (3600000 * 8));
		//document.getElementById('time_singapore').innerHTML = nd2
		//		.toLocaleString();

		//var nd3 = new Date(utc + (3600000 * 3));
		//document.getElementById('time_qatar').innerHTML = nd3.toLocaleString();

		setTimeout(calcTime, 1000);
		return "The local time is " + nd.toLocaleString();
	}
</script>
<body onload="calcTime()">
	<div class="row">
		<div class="col-sm-10 col-md-10">
			<!-- <div class="col-sm-4 col-md-4">
				<p class="navbar-text navbar-left" style="color: Black">QTRZONE</p>
				<p class="navbar-text navbar-left" style="color: Black"
					id="time_qatar" />
			</div> -->
			<!-- <div class="col-sm-4 col-md-4">
				<p class="navbar-text navbar-left" style="color: darkgreen">INDIA</p>
				<p class="navbar-text navbar-left" style="color: darkgreen"
					id="time_ind" />
			</div> -->
			<!-- 
			<div class="col-sm-4 col-md-4">
				<p class="navbar-text navbar-left" style="color: Black">SNGZONE</p>
				<p class="navbar-text navbar-left" style="color: Black"
					id="time_singapore" />
			</div> -->
		</div>
		<%-- <div class="col-sm-8 col-md-8">
		<ul class="nav nav-pills font">
			<li id="tiplus" class="btn-group"><a data-hover="dropdown"
				data-toggle="dropdown"><i class="fa fa-external-link"></i> TI
					Plus <span class="caret"></span> </a>
				<ul class="dropdown-menu">
					<li><a id="uae"
						href="https://tiuat.fgb.ae/tiplus2-global?zone=UAEZONE"><img
							src="images/custom/tileicon.png" alt="#"
							style="width: 15px; height: 15px;"> UAE ZONE</a></li>
					<li><a id="sng"
						href="https://tiuat.fgb.ae/tiplus2-global?zone=QATARZONE"><img
							src="images/custom/tileicon.png" alt="#"
							style="width: 15px; height: 15px;"> SNG ZONE</a></li>
					<li><a id="qatar"
						href="https://tiuat.fgb.ae/tiplus2-global?zone=SNGZONE"><img
							src="images/custom/tileicon.png" alt="#"
							style="width: 15px; height: 15px;"> QATAR ZONE</a></li>
				</ul></li>
		</ul>
	</div> --%>
		<div class="col-sm-2 col-md-2">
			<p class="navbar-text navbar-right">
				<%-- <i class="icon-user"></i><a href="/tiplus2-global/pages/frames.jsp" class="navbar-link">UAEZONE</a> --%>
				<span class="glyphicon glyphicon-user"></span> <a href="#"
					class="navbar-link"> <%=signedInUser%></a>
				<%--| <span class="glyphicon glyphicon-info-sign"></span><a
					href="about.jsp" class="navbar-link"> About</a> --%>
			</p>
		</div>
	</div>
</body>

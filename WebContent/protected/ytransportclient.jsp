<%-- <%@page import="com.bs.theme.transport.client.ThemeTransportClient"%> --%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>TransportClient Request Handler</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<%
	String bool = "";
	// ThemeTransportClient ttc = new ThemeTransportClient();
	// out.println(request.getParameter("input"));
	if (request.getParameter("input") != null) {
		// bool = ttc.invoke("BackOffice", "Batch", request.getParameter("input"));
	}
	// out.println("123456A " + bool);
%>
</head>
<body>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>TransportClient Request Handler</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<form method="POST" action="">
						<div class="col-sm-5 col-sm-offset-1 ">
							<h4>TransportClient Request</h4>
							<!-- <h4 style="color:#00aed7;"><font face="Times new roman">Request</font></h4> -->
							<textarea name="input" rows="10" cols="100" spellcheck="false"
								class="form-control"></textarea>
						</div>
						<div class="col-sm-1 ">
							<input class="btn btn-warning butpos" type="submit"
								value="Submit" />
						</div>
						<div class=" col-sm-5">
							<h4>TransportClient Response</h4>
							<textarea name="response" rows="10" cols="100" spellcheck="false"
								class="form-control"><%=bool%></textarea>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- <div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<h4>Request</h4>
					<form method="POST" action="">
						<div>
							<textarea name="input" rows="10" cols="100" spellcheck="false"></textarea>
							&nbsp;&nbsp;&nbsp;&nbsp; <input class="btn btn-primary"
								type="submit" value="Submit" />
						</div>
					</form>
				</div>
				<div class="row">
					<h4>Response</h4>
					<textarea name="response" rows="10" cols="100" spellcheck="false"><%=bool%></textarea>
				</div>
			</div>
		</div> -->
	</div>
</body>
</html>
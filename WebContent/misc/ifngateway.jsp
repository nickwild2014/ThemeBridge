<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: SFMS incoming Gateway testing
--%>
<%@page import="java.util.UUID"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.bs.theme.bob.adapter.sfms.SFMSInwardMessageAdaptee"%>
<%@page import="com.bs.themebridge.entity.servlet.util.VerificationAdapterImpl"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--@author RaviPrasath	@date 2015-SEP-26 @IBL-->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Request Handler From TIPlus</title>
<!-- <link rel="shortcut icon" href="../images/custom/browserlogo.png"> -->
<link rel="shortcut icon" href="../images/custom/themelogo3.png">
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet"
	href="../css/daterangepicker-bs3.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery.dataTables.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery-ui.datepicker.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dataTables.bootstrap.css" rel="stylesheet">
<link href="../css/customized.css" rel="stylesheet">

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("misc");
	});
</script>
<script>
	// this not used in this page
	function updateSettingRow() {
		alert('test');
		var r = confirm("Are you sure?");
		if (r == true) {
			var pswd = document.getElementById("pswd").value;
			alert('pswd->' + pswd);
			//requesthandler();
			if (requesthandler(pswd)) {
				alert('s true');
				alert('next' + next);
				var x = "do";
				//document.getElementById("form1").submit();}else{
				alert('8989');
				var x = "dont";
			}
		} else {
			alert("Updation canceled!");
		}
	}
</script>
<%
	boolean error = false;
	String bool = "";
	String requestInput = request.getParameter("input");
	// out.println("requestInput ->" + requestInput);
	if (requestInput == null) {
		requestInput = "";
	}
	if (requestInput != null && !requestInput.isEmpty()) {
		String pswd = request.getParameter("pswd");
		// out.println("pswd ->" + pswd);
		boolean psd = VerificationAdapterImpl.verify(pswd);
		// boolean psd = true;
		if (psd) {
			error = false;			
			SFMSInwardMessageAdaptee anAdaptee = new SFMSInwardMessageAdaptee();
			boolean result = anAdaptee.processSFMSInMessages(requestInput, "$", "TB");
		} else {
			error = true;
		}
	}
%>
</head>
<body>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->
	<div class="col-md-12">
		<%@ include file="primarymenubar.jsp"%>
	</div>
	<div class="container">
		<!-- <div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>Request Handler</h3>
			</div>
		</div>   -->
		<%
			if (error) {
		%>
		<br>
		<div class="row">
			<div class="alert alert-danger col-sm-11 col-sm-offset-1 ">Invalid
				password!</div>
		</div>
		<%
			}
		%>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<form method="POST" action="">
						<div class="col-sm-5">
							<!-- <h4>Gateway Request</h4>-->
							<h3 style="color: #00aed7;">
								<font face="Times new roman">IFN Gateway Message</font>
							</h3>
							<textarea name="input" rows="24" cols="60" spellcheck="false"
								class="form-control"><%=requestInput%></textarea>
						</div>
						<div class="col-sm-1">
							<input class="btn btn-primary butpos" type="submit"
								value="Submit" /> <br> <br> <input
								class="form-control" type="password" name="pswd" id="pswd"
								placeholder="paswd" required/> <br> <input class="btn btn-danger"
								type="reset" value="ClearAll" />
						</div>
						<div class=" col-sm-5">
							<!-- <h4>Gateway Response</h4> -->
							<h3 style="color: #00aed7;">
								<font face="Times new roman">IFN Gateway Message</font>
							</h3>
							<textarea name="response" rows="24" cols="60" spellcheck="false"
								class="form-control"><%=bool%></textarea>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%-- <div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<h4>Request</h4>
					<form method="POST" action="" name="form1" id="form1">
						<div>
							<textarea name="input" rows="10" cols="100" spellcheck="false"></textarea>
							&nbsp;&nbsp;&nbsp;&nbsp; <input class="form-control"
								type="password" name="pswd" id="pswd" />
								&nbsp;&nbsp;&nbsp;&nbsp; <input
								class="btn btn-primary" type="submit" value="Submit" />
						</div>
					</form>
				</div>
				<div class="row">
					<h4>Response</h4>
					<textarea name="response" rows="10" cols="100" spellcheck="false"><%=bool%></textarea>
				</div>
			</div>
		</div> --%>
	</div>
	<%-- <div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div> --%>
</body>
</html>
<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,  
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Eodposting"%>
<%@page import="com.bs.themebridge.entity.adapter.EodpostingAdapter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Eod Posting Data</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/fgbbrowserlogo.png">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/daterangepicker-bs3.css" rel="stylesheet"
	type="text/css" />
<link href="../css/jquery.dataTables.css" rel="stylesheet"
	type="text/css" />
<link href="../css/jquery-ui.datepicker.css" rel="stylesheet"
	type="text/css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="../css/customized.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/font-awesome.min.css">

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript" src="../js/consolelog.js"></script>
<script type="text/javascript">
var loggedInUser = "<%=request.getRemoteUser()%>";
	if (!checkUserPrivileges(loggedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	}
	
	function goBack() {
		window.history.back();
	};
</script>

<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("eodposting");
	});
</script>

</head>
<body>
	<!-- Primary Menu bar HTML -->
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Eod Posting Data</h3>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-5">
				<jsp:include page="timezone.jsp" />
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 daterangeoutstyle">
				<!-- <button class="btn btn-info" onclick="saveTextAsFile()">Download</button> -->
				<a class="btn btn-warning" onclick="goBack();">Back</a>
				<!-- <a href="servicelogtest.jsp" class="btn btn-default">Back</a> -->
			</div>
		</div>
		<!-- Body content HTML -->
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="container">
					<%
						if (request.getParameter("id") != null) {
							String id = request.getParameter("id");
							EodpostingAdapter sda = new EodpostingAdapter();
							Eodposting tl = sda.getKeyProperty(id);
					%>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="row">
											<div class="col-sm-4 col-md-4 col-lg-4">
												<h4>TI Request</h4>
											</div>
											<%-- <div
												class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-5 col-md-5 col-lg-5 consoleTime">
												<span>Time : <%=ThemeBridgeUtil.getValidStringValue(
												tl.getTiRequesttime(), "-")%></span>
											</div> --%>
										</div>
										<textarea class="form-control" cols="80" rows="14"
											spellcheck="false" readonly><%=tl.getTirequest()%></textarea>
									</div>

									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="row">
											<div class="col-sm-4 col-md-4 col-lg-4">
												<h4>Bank Request</h4>
											</div>
											<%-- <div
												class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-5 col-md-5 col-lg-5 consoleTime">
												<span>Time : <%=ThemeBridgeUtil.getValidStringValue(
												tl.getEsbRequesttime(), "-")%></span>
											</div> --%>
										</div>
										<textarea class="form-control" cols="80" rows="14"
											spellcheck="false" readonly="readonly"><%=tl.getTirequest()%></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>

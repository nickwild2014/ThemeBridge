<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: View Themestaging log   
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.DateTimeUtil"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Themetransportclientlog"%>
<%@page
	import="com.bs.themebridge.entity.adapter.ThemetransportclientAdapter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>TransportClient Data</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
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
<!--<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script> -->
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
var loggedInUser = "<%=request.getRemoteUser()%>";
	if (!checkUserPrivileges(loggedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("themestaginglog");
	});
</script>

<script type="text/javascript">
	function goBack() {
		window.history.back(-1);
	};
</script>

<!-- <script>
	function colortextbox() {
		//alert('OnLoadEventTriggered');
		var empt = document.getElementById("status").value;		
		if (empt == "SUCCEEDED") {
			//alert('Code has accepted : you can try another');
			document.getElementById("status").style.borderColor = "GREEN";
			//document.getElementById("tirequest").style.borderColor = "GREEN";
			//document.getElementById("tiresponse").style.borderColor = "GREEN";
			//document.getElementById("bankrequest").style.borderColor = "GREEN";
			//document.getElementById("bankresponse").style.borderColor = "GREEN";
			return true;
		} else if (empt == "FAILED") {
			//alert('Code has accepted : you can try another');
			document.getElementById("status").style.borderColor = "RED";
			//document.getElementById("tirequest").style.borderColor = "RED";
			//document.getElementById("tiresponse").style.borderColor = "RED";
			//document.getElementById("bankrequest").style.borderColor = "RED";
			//document.getElementById("bankresponse").style.borderColor = "RED";			
			return true;
		} else {
			//alert('Code has accepted : you can try another');
			document.getElementById("status").style.borderColor = "ORANGE";
			//document.getElementById("tirequest").style.borderColor = "RED";
			//document.getElementById("tiresponse").style.borderColor = "RED";
			//document.getElementById("bankrequest").style.borderColor = "RED";
			//document.getElementById("bankresponse").style.borderColor = "RED";			
			return true;
		}
	}
</script> -->
</head>
<body>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-5 col-md-5 col-sm-5">
				<h3>ThemeTransportClient staging data</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
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
			<div class="container">
				<%
					if (request.getParameter("id") != null) {
						String id = request.getParameter("id");
						ThemetransportclientAdapter sda = new ThemetransportclientAdapter();
						Themetransportclientlog tl = sda.getKeyProperty(id);
				%>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-lg-2">
							<h5>SourceSystem</h5>
							<input type="text" class="form-control" id="source"
								spellcheck="false" readonly="readonly" value="TI Plus" />
						</div>
						<div class="col-lg-2">
							<h5>Service</h5>
							<input type="text" class="form-control" id="service"
								spellcheck="false" readonly="readonly"
								value="<%=tl.getService()%>" />
						</div>

						<div class="col-lg-2">
							<h5>Operation</h5>
							<input type="text" class="form-control" id="operation"
								spellcheck="false" readonly="readonly"
								value="<%=tl.getOperation()%>" />
						</div>

						<div class="col-lg-2">
							<h5>Status</h5>
							<input type="text" class="form-control" id="status"
								spellcheck="false" readonly="readonly"
								value="<%=tl.getStatus()%>" />
						</div>
					</div>
				</div>
				<BR>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="row">
								<div class="col-sm-4 col-md-4 col-lg-4">
									<h5>TI Request</h5>
								</div>
								<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
									<h5>
										<span>Request Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getReceivedtime(), "yyyy-MM-dd HH:mm:ss")%></span>
									</h5>
								</div>
							</div>
							<textarea id="tirequest" class="form-control" cols="80" rows="10"
								spellcheck="false" readonly><%=tl.getTirequest()%></textarea>
						</div>

						<div class="col-sm-6 col-md-6 col-lg-6">
							<div class="row">
								<div class="col-sm-4 col-md-4 col-lg-4">
									<h5>TI Response</h5>
								</div>
								<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
									<h5>
										<span>Response Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getReceivedtime(), "yyyy-MM-dd HH:mm:ss")%></span>
									</h5>
								</div>
							</div>
							<textarea id="tiresponse" class="form-control" cols="80"
								rows="10" spellcheck="false" readonly="readonly"><%=tl.getTiresponse()%></textarea>
						</div>
					</div>
				</div>
				<!-- <br> -->
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="row">
								<div class="col-sm-4 col-md-4 col-lg-4">
									<h5>Description</h5>
								</div>
								<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
									<h5>
										<span>Process Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getProcesstime(), "yyyy-MM-dd HH:mm:ss")%></span>
									</h5>
								</div>
							</div>
							<textarea id="tirequest" class="form-control" cols="180" rows="5"
								spellcheck="false" readonly><%=tl.getDescription()%></textarea>
						</div>
					</div>
				</div>
				<!-- <div class="row">
						<button class="btn btn-default" onclick="saveTextAsFile()">SaveAs
							File</button>
					</div> -->
				<br> <br>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>

	<script type='text/javascript'>
		function saveTextAsFile() {
			//alert('Start downloading');
			var textToWrite = "Source : ThemeBridge\n" + "\nZONE ID: "
					+ document.getElementById("source").value + "\nStatus : "
					+ document.getElementById("status").value + "\nService : "
					+ document.getElementById("service").value
					+ "\nOperation : "
					+ document.getElementById("operation").value
					+ "\n\nTI Resquest : \n"
					+ document.getElementById("tirequest").value
					+ "\n\n\n\nTI Response :\n"
					+ document.getElementById("tiresponse").value;
			// alert('0');
			var textFileAsBlob = new Blob([ textToWrite ], {
				type : 'text/xml'
			});
			//var fileNameToSaveAs = document.getElementById("inputFileNameToSaveAs").value;
			//var everefer = ""; 
			//if(document.getElementById("eventref").value == null){everefer="EOD";}else{everefer=document.getElementById("eventref").value;}	
			//var fileNameToSaveAs = document.getElementById("masterref").value+"-"+everefer;
			// alert('1');
			var fileNameToSaveAs = document.getElementById("service").value
					+ "-" + document.getElementById("operation").value;

			var downloadLink = document.createElement("a");
			downloadLink.download = fileNameToSaveAs;
			downloadLink.innerHTML = "Download File";
			if (window.webkitURL != null) {
				// Chrome allows the link to be clicked
				// without actually adding it to the DOM.
				downloadLink.href = window.webkitURL
						.createObjectURL(textFileAsBlob);
			} else {
				// Firefox requires the link to be added to the DOM
				// before it can be clicked.
				downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
				downloadLink.onclick = destroyClickedElement;
				downloadLink.style.display = "none";
				document.body.appendChild(downloadLink);
			}

			downloadLink.click();
		}

		function destroyClickedElement(event) {
			document.body.removeChild(event.target);
		};

		//Below code for the load file
		function loadFileAsText() {
			var fileToLoad = document.getElementById("fileToLoad").files[0];
			var fileReader = new FileReader();
			fileReader.onload = function(fileLoadedEvent) {
				var textFromFileLoaded = fileLoadedEvent.target.result;
				document.getElementById("inputTextToSave").value = textFromFileLoaded;
			};
			fileReader.readAsText(fileToLoad, "UTF-8");
		};
	</script>
</body>
</html>

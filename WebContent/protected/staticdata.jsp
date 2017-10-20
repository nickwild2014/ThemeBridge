<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: View staicdata log   
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.DateTimeUtil"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Staticdatalog"%>
<%@page import="com.bs.themebridge.entity.adapter.StaticdatalogAdapter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Static Data</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/daterangepicker-bs3.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery.dataTables.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery-ui.datepicker.css"
	rel="stylesheet" />
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
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
		addActiveMenu("staticdatalog");
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
</script>-->
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
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Static data</h3>
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
			<%
				if (request.getParameter("id") != null) {
					String id = request.getParameter("id");
					StaticdatalogAdapter sda = new StaticdatalogAdapter();
					Staticdatalog tl = sda.getKeyProperty(id);
			%>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<%-- <div class="col-lg-2">
										<h5>SourceSystem</h5>
										<input type="text" class="form-control" id="source"
											spellcheck="false" readonly="readonly"
											value="<%=tl.getSource()%>" />
									</div> --%>
					<div class="col-lg-2">
						<h5>Service</h5>
						<input type="text" class="form-control" id="service"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getService()%>" />
					</div>
					<div class="col-lg-2">
						<h5>Entity</h5>
						<input type="text" class="form-control" id="service"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getEntitytype()%>" />
					</div>
					<div class="col-lg-2">
						<h5>Narrative1</h5>
						<input type="text" class="form-control" id="eventref"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getNarrative1()%>" />
					</div>
					<div class="col-lg-2">
						<h5>Narrative2</h5>
						<input type="text" class="form-control" id="eventref"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getNarrative2()%>" />
					</div>
					<div class="col-lg-2">
						<h5>Narrative3</h5>
						<input type="text" class="form-control" id="eventref"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getNarrative3()%>" />
					</div>
					<%-- <div class="col-lg-3">
										<h5>ProcessTime</h5>
										<input type="text" class="form-control" id="eventref"
											spellcheck="false" readonly="readonly"
											value="<%=DateTimeUtil.getStringDateByDateInFormat(tl.getProcesstime(), "yyyy-MM-dd HH:mm:ss")%>" />
									</div> --%>
					<div class="col-lg-2">
						<h5>Status</h5>
						<input type="text" class="form-control" id="status"
							spellcheck="false" readonly="readonly"
							value="<%=tl.getStatus()%>" />
					</div>
				</div>
				<%-- <BR>
							<div class="row">
								<div class="col-sm-6 col-sm-6 col-sm-6">
									<h5>Input Message</h5>
									<textarea id="inputmessage" class="form-control" cols="120"
										rows="14" spellcheck="false" readonly="readonly"><%=tl.getInputmsg()%></textarea>
								</div>
							</div> --%>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6 col-sm-6 col-sm-6">
					<div class="row">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<h5>TI Request</h5>
						</div>
						<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
							<h5>
								<span>Response Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getProcesstime(), "yyyy-MM-dd HH:mm:ss")%></span>
							</h5>
						</div>
					</div>
					<textarea id="tirequest" class="form-control" cols="120" rows="14"
						spellcheck="false" readonly="readonly"><%=tl.getTirequest()%></textarea>
				</div>
				<div class="col-sm-6 col-sm-6 col-sm-6">
					<div class="row">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<h5>TI Response</h5>
						</div>
						<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
							<h5>
								<span>Response Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getProcesstime(), "yyyy-MM-dd HH:mm:ss")%></span>
							</h5>
						</div>
					</div>
					<textarea id="tiresponse" class="form-control" cols="120" rows="14"
						spellcheck="false" readonly="readonly"><%=tl.getTiresponse()%></textarea>
				</div>
			</div>
			<br>
			<%-- <div class="row">
				<div class="col-sm-6 col-sm-6 col-sm-6">
					<div class="row">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<h5>Input Message</h5>
						</div>
						<div class="col-sm-8 col-md-8 col-lg-8 consoleTime">
							<h5>
								<span>Response Time : <%=DateTimeUtil.getStringDateByDateInFormat(tl.getReceivedtime(), "yyyy-MM-dd HH:mm:ss")%></span>
							</h5>
						</div>
					</div>
					<textarea id="inputmessage" class="form-control" cols="120"
						rows="10" spellcheck="false" readonly="readonly"><%=tl.getInputmsg()%></textarea>
				</div>
			</div> --%>
			<!-- <br> -->
			<div class="row">
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
					<%
						if (tl.getDescription() != null) {
					%>
					<textarea id="tirequest" class="form-control" cols="180" rows="5"
						spellcheck="false" readonly><%=tl.getDescription()%></textarea>
					<%
						} else {
					%>
					<textarea id="tirequest" class="form-control" cols="180" rows="5"
						spellcheck="false" readonly></textarea>
					<%
						}
					%>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
	<script type='text/javascript'>
		function saveTextAsFile() {
			// alert('Start downloading');
			var textToWrite = "Source : ThemeBridge\n" + "\nZONE ID: "
					+ document.getElementById("source").value + "\nStatus : "
					+ document.getElementById("status").value + "\nService : "
					+ document.getElementById("service").value
					+ "\nMaster Reference : "
					+ document.getElementById("masterref").value
					+ "\nEvent Reference : "
					+ document.getElementById("eventref").value
					//+ "\nOperation : "
					//+ document.getElementById("operation").value
					+ "\n\nInput Message : \n"
					+ document.getElementById("inputmessage").value
					+ "\n\n\n\nTI Request :\n"
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
			var fileNameToSaveAs = document.getElementById("masterref").value
					+ "-" + document.getElementById("eventref").value;

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

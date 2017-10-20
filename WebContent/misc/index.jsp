<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Dashboard  
--%>
<%@page import="com.bs.themebridge.dashboard.DashboardService"%>
<%@page import="com.bs.themebridge.dashboard.InterfaceStatusReport"%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>ThemeBridge</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="../css/daterangepicker-bs3.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery.dataTables.css" />
<link type="text/css" rel="stylesheet" href="../css/jquery-ui.min.css" />
<link type="text/css" rel="stylesheet" href="../css/customized.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery-ui.datepicker.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.peity.js"></script>
<script type="text/javascript" src="../js/raphael.2.1.0.min.js"></script>
<script type="text/javascript" src="../js/justgage.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("dash");
	});
</script>
<!-- //do ext javascript function -->
</head>
<body>
	<%
		InterfaceStatusReport aReport = DashboardService.getInterfaceStatusReport("", "");
	
		String stagingdatatypes = String.valueOf(aReport.getStagingDataReport().getSuccededCount()
				+ aReport.getStagingDataReport().getReceivedCount() + aReport.getStagingDataReport().getErrorCount()
				+ aReport.getStagingDataReport().getFailureCount()
				+ aReport.getStagingDataReport().getQueuedCount());

		String staticdatatypes = String.valueOf(aReport.getStaticDataReport().getSuccededCount()
				+ aReport.getStaticDataReport().getReceivedCount() + aReport.getStaticDataReport().getErrorCount()
				+ aReport.getStaticDataReport().getFailureCount()
				+ aReport.getStagingDataReport().getQueuedCount());

		String servicedatatypes = String.valueOf(aReport.getServiceLogReport().getSuccededCount()
				+ aReport.getServiceLogReport().getReceivedCount() + aReport.getServiceLogReport().getErrorCount()
				+ aReport.getServiceLogReport().getFailureCount()
				+ aReport.getStagingDataReport().getQueuedCount());

		String transactiondatatypes = String.valueOf(aReport.getTransactionLogReport().getSuccededCount()
				+ aReport.getTransactionLogReport().getReceivedCount()
				+ aReport.getTransactionLogReport().getErrorCount()
				+ aReport.getTransactionLogReport().getFailureCount()
				+ aReport.getStagingDataReport().getQueuedCount());
	%>
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" />  --%>
	</div>

	<!-- Main content HTML -->
	<div class="col-md-12">

		<div class="container">

			<!-- <div class="row horizontal-line">
				<div class="col-lg-8 col-md-8 col-sm-8">
					<h3>Dashboard</h3>
				</div>
			</div> -->

			<br>
			<div class=row>
				<div class="panel panel-primary">
					<div class="panel-heading">Dash Board</div>
					<div class="panel-body">
						<div class="col-sm-3 col-md-3">
							<!-- <div id="chart2" class="10x10px"></div> -->
							<div id="chart1" style="width: 175px; height: 175px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<!-- <div id="chart2" class="10x10px"></div> -->
							<div id="chart2" style="width: 175px; height: 175px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<div id="chart3" style="width: 175px; height: 175px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<!-- <div id="chart2" class="10x10px"></div> -->
							<div id="chart4" style="width: 175px; height: 175px"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-12">
				<div class="row">

					<div class="col-sm-3 col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">StagingData</div>
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="row">
											<div class="col-md-5 layout">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>QUEUED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getQueuedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>ERROR</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-warning"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getErrorCount()%>
												</span>
											</div>
										</div>
										<br>
										<div class="row">
											<div class="col-md-5 layout">
												<b>TOTAL</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-primary"
													style="font-size: 15px; border-radius: 0px;"><%=stagingdatatypes%>
												</span>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-3 col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">StaticData</div>
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="row">
											<div class="col-md-5 layout">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getReceivedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>ERROR</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-warning"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getErrorCount()%>
												</span>
											</div>
										</div>
										<br>
										<div class="row">
											<div class="col-md-5 layout">
												<b>TOTAL</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-primary"
													style="font-size: 15px; border-radius: 0px;"><%=staticdatatypes%>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-3 col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">ServiceData</div>
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="row">
											<div class="col-md-5 layout">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getReceivedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>ERROR</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-warning"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getErrorCount()%>
												</span>
											</div>
										</div>
										<br>
										<div class="row">
											<div class="col-md-5 layout">
												<b>TOTAL</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-primary"
													style="font-size: 15px; border-radius: 0px;"><%=servicedatatypes%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-3 col-md-3">
						<div class="panel panel-primary">
							<div class="panel-heading">TransactionData</div>
							<div class="panel-body">
								<div class="container">
									<div class="row">
										<div class="row">
											<div class="col-md-5 layout">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getReceivedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 layout">
												<b>ERROR</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-warning"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getErrorCount()%>
												</span>
											</div>
										</div>
										<BR>
										<div class="row">
											<div class="col-md-5 layout">
												<b>TOTAL</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-primary"
													style="font-size: 15px; border-radius: 0px;"><%=transactiondatatypes%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<br>


		</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var cb = function(start, end, label) {
								console.log(start.toISOString(), end
										.toISOString(), label);
								$('#reportrange span').html(
										start.format('MMMM D, YYYY') + ' - '
												+ end.format('MMMM D, YYYY'));
								//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
							}

							var optionSet1 = {
								startDate : moment().subtract('days', 29),
								endDate : moment(),
								minDate : '01/01/1950',
								maxDate : '12/31/2099',
								dateLimit : {
									days : 60
								},
								showDropdowns : true,
								showWeekNumbers : true,
								timePicker : false,
								timePickerIncrement : 1,
								timePicker12Hour : true,
								ranges : {
									'Today' : [ moment(), moment() ],
									'Yesterday' : [
											moment().subtract('days', 1),
											moment().subtract('days', 1) ],
									'Last 7 Days' : [
											moment().subtract('days', 6),
											moment() ],
									'Last 30 Days' : [
											moment().subtract('days', 29),
											moment() ],
									'This Month' : [ moment().startOf('month'),
											moment().endOf('month') ],
									'Last Month' : [
											moment().subtract('month', 1)
													.startOf('month'),
											moment().subtract('month', 1)
													.endOf('month') ]
								},
								opens : 'left',
								buttonClasses : [ 'btn btn-default' ],
								applyClass : 'btn-small btn-primary',
								cancelClass : 'btn-small',
								format : 'MM/DD/YYYY',
								separator : ' to ',
								locale : {
									applyLabel : 'Submit',
									cancelLabel : 'Clear',
									fromLabel : 'From',
									toLabel : 'To',
									customRangeLabel : 'Custom',
									daysOfWeek : [ 'Su', 'Mo', 'Tu', 'We',
											'Th', 'Fr', 'Sa' ],
									monthNames : [ 'January', 'February',
											'March', 'April', 'May', 'June',
											'July', 'August', 'September',
											'October', 'November', 'December' ],
									firstDay : 1
								}
							};

							var optionSet2 = {
								startDate : moment().subtract('days', 7),
								endDate : moment(),
								opens : 'left',
								ranges : {
									'Today' : [ moment(), moment() ],
									'Yesterday' : [
											moment().subtract('days', 1),
											moment().subtract('days', 1) ],
									'Last 7 Days' : [
											moment().subtract('days', 6),
											moment() ],
									'Last 30 Days' : [
											moment().subtract('days', 29),
											moment() ],
									'This Month' : [ moment().startOf('month'),
											moment().endOf('month') ],
									'Last Month' : [
											moment().subtract('month', 1)
													.startOf('month'),
											moment().subtract('month', 1)
													.endOf('month') ]
								}
							};

							$('#reportrange span').html(
									moment().subtract('days', 29).format(
											'MMMM D, YYYY')
											+ ' - '
											+ moment().format('MMMM D, YYYY'));

							$('#reportrange').daterangepicker(optionSet1, cb);

							$('#reportrange').on('show.daterangepicker',
									function() {
										console.log("show event fired");
									});
							$('#reportrange').on('hide.daterangepicker',
									function() {
										console.log("hide event fired");
									});
							$('#reportrange')
									.on(
											'apply.daterangepicker',
											function(ev, picker) {
												console
														.log("apply event fired, start/end dates are "
																+ picker.startDate
																		.format('MMMM D, YYYY')
																+ " to "
																+ picker.endDate
																		.format('MMMM D, YYYY'));
											});
							$('#reportrange').on('cancel.daterangepicker',
									function(ev, picker) {
										console.log("cancel event fired");
									});
						});

		function selectAll1(source) {
			checkboxes = document.getElementsByName('colors1[]');
			for ( var i in checkboxes)
				checkboxes[i].checked = source.checked;
		}

		function selectAll2(source) {
			checkboxes = document.getElementsByName('colors2[]');
			for ( var i in checkboxes)
				checkboxes[i].checked = source.checked;
		}

		window.onload = function() {

			var stagingDataCount =
	<%=aReport.getStagignDataLogChartValue()%>
		;
			var g1 = new JustGage({
				id : "chart1",
				title : "STAGING DATA",
				value : isNaN(stagingDataCount) ? 0 : stagingDataCount,
				min : 0,
				max : 100,
				relativeGaugeSize : true,
				donut : true
			});

			var staticDataCount =
	<%=aReport.getStaticDataLogChartValue()%>
		;
			var g2 = new JustGage({
				id : "chart2",
				title : "STATIC DATA",
				value : isNaN(staticDataCount) ? 0 : staticDataCount,
				min : 0,
				max : 100,
				customSectors : [ {
					"lo" : 0,
					"hi" : 25,
					"color" : "#a9d70b"
				}, {
					"lo" : 26,
					"hi" : 50,
					"color" : "#f9c802"
				}, {
					"lo" : 51,
					"hi" : 75,
					"color" : "#ff0000"
				}, {
					"lo" : 76,
					"hi" : 100,
					"color" : "#ff0005"
				} ],
				levelColorsGradient : false,
				relativeGaugeSize : true,
				donut : true
			});

			var serviceDataCount =
	<%=aReport.getServiceLogChartValue()%>
		;
			var g3 = new JustGage({
				id : "chart3",
				title : "SERVICE DATA",
				value : isNaN(serviceDataCount) ? 0 : serviceDataCount,
				min : 0,
				max : 100,
				relativeGaugeSize : true,
				donut : true
			});

			var transactionCount =
	<%=aReport.getTransactionLogChartValue()%>
		;
			var g4 = new JustGage({
				id : "chart4",
				title : "TRANSACTION DATA",
				value : isNaN(transactionCount) ? 0 : transactionCount,
				min : 0,
				max : 100,
				relativeGaugeSize : true,
				donut : true
			});
		};
	</script>
	<%-- <jsp:include page="include_footer.jsp" /> --%>
</body>
</html>

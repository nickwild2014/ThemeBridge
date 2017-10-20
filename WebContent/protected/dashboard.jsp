<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Dashboard  
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var cb = function(start, end, label) {
							$('#reportrange span').html(
									start.format('DD-MMM-YYYY') + ' - '
											+ end.format('DD-MMM-YYYY'));
						};

						var optionSet1 = {
							startDate : moment(),
							endDate : moment(),
							minDate : '01/01/1900',
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
								'Yesterday' : [ moment().subtract('days', 1),
										moment().subtract('days', 1) ],
								'Last 7 Days' : [ moment().subtract('days', 6),
										moment() ],
								'Last 30 Days' : [
										moment().subtract('days', 29), moment() ],
								'This Month' : [ moment().startOf('month'),
										moment().endOf('month') ],
								'Last Month' : [
										moment().subtract('month', 1).startOf(
												'month'),
										moment().subtract('month', 1).endOf(
												'month') ]
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
								daysOfWeek : [ 'Su', 'Mo', 'Tu', 'We', 'Th',
										'Fr', 'Sa' ],
								monthNames : [ 'January', 'February', 'March',
										'April', 'May', 'June', 'July',
										'August', 'September', 'October',
										'November', 'December' ],
								firstDay : 1
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
									// console.log("show event fired");
								});
						$('#reportrange').on('hide.daterangepicker',
								function() {
									// console.log("hide event fired");
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
									// console.log("cancel event fired");
								});

						$('#reportrange span').html(
								moment().format('DD-MMM-YYYY') + ' - '
										+ moment().format('DD-MMM-YYYY'));

					});
</script>
</head>
<body>
	<%
		String fromDate = request.getParameter("fromdaterange");
		String toDate = request.getParameter("todaterange");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fromdaterange = "";
		String todaterange = "";
		Date fromdaterange_date = new Date();
		Date todaterange_date = new Date();

		if (fromDate == null || fromDate.trim().equals("")) {
			fromDate = formatter.format(new Date());
		} else {
			fromDate = request.getParameter("fromdaterange");
			//out.println("fDate" + fromDate);
		}
		if (toDate == null || toDate.trim().equals("")) {
			toDate = formatter.format(new Date());
		} else {
			toDate = request.getParameter("todaterange");
			//out.println("tDate" + toDate);
		}
		// out.println("From To Date : " + fromDate + " / " + toDate);

		InterfaceStatusReport aReport = DashboardService.getInterfaceStatusReport(fromDate, toDate);

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
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="col-md-12">

		<div class="container">

			<!-- <div class="row horizontal-line">				
				<div class="col-lg-8 col-md-8 col-sm-8">
					<h3>Dashboard</h3>
				</div>

				<div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
					<div id="reportrange" class="pull-right daterangeinstyle">
						<span></span> <b class="caret"></b>
					</div>
				</div>
			</div> -->

			<br>
			<div class=row>
				<div class="panel panel-primary">
					<div class="panel-heading">Dash Board</div>
					<div class="panel-body">
						<div class="col-sm-3 col-md-3">
							<!-- <div id="chart2" class="10x10px"></div> -->
							<div id="chart1" style="width: 150px; height: 150px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<div id="chart2" style="width: 150px; height: 150px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<div id="chart3" style="width: 150px; height: 150px"></div>
						</div>
						<div class="col-sm-3 col-md-3">
							<div id="chart4" style="width: 150px; height: 150px"></div>
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
											<div class="col-md-5">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>QUEUED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getQueuedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>TRANSMITTED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStagingDataReport().getTransmittedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
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
											<div class="col-md-5">
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
											<div class="col-md-5">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getFailureCount()%></span>
											</div>
										</div>
										<%-- <div class="row">
											<div class="col-md-5 layout">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getReceivedCount()%></span>
											</div>
										</div> --%>
										<div class="row">
											<div class="col-md-5">
												<b>UNAVAILABLE</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getUnavailableCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>TRANSMITTED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getStaticDataReport().getTransmittedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
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
											<div class="col-md-5">
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
											<div class="col-md-5">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getFailureCount()%></span>
											</div>
										</div>
										<%-- <div class="row">
											<div class="col-md-5 layout">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getReceivedCount()%></span>
											</div>
										</div> --%>
										<div class="row">
											<div class="col-md-5">
												<b>SUPPRESSED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getSuppressedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>TRANSMITTED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getServiceLogReport().getTransmittedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
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
											<div class="col-md-5">
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
											<div class="col-md-5">
												<b>SUCCEEDED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-success"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getSuccededCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>FAILED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-danger"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getFailureCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>RECEIVED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getReceivedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
												<b>TRANSMITTED</b>
											</div>
											<div class="col-md-7 layout">
												<span class="badge alert-info"
													style="font-size: 15px; border-radius: 0px;"><%=aReport.getTransactionLogReport().getTransmittedCount()%></span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5">
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
											<div class="col-md-5">
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
		$(document).ready(

		window.onload = function() {
			var stagingDataCount =
	<%=aReport.getStagignDataLogChartValue()%>
		;
			var g1 = new JustGage({
				id : "chart1",
				min : 0,
				max : 100,
				label : "%",
				title : "STAGING DATA",
				gaugeWidthScale : 0.6,
				value : isNaN(stagingDataCount) ? 0 : stagingDataCount,
				levelColors : [ "#ff5050", "#a9d70b" ],
				// levelColors : [ "#ff5050", "#1200ff", "#f9c802", "#a9d70b" ],
				// levelColorsGradient : false,
				relativeGaugeSize : true,
				donut : true
			//				customSectors : [ {
			//				"lo" : 0,
			//			"hi" : 25,
			//		"color" : "#ff5050" // red
			// }, {
			// "lo" : 26,
			// "hi" : 50,
			//	"color" : "#1200ff" // rose
			//	}, {
			//		"lo" : 51,
			//		"hi" : 75,
			//		"color" : "#f9c802" // orange
			//	}, {
			//		"lo" : 76,
			//		"hi" : 100,
			//		"color" : "#a9d70b" //green
			//	} ],
			});

			var staticDataCount =
	<%=aReport.getStaticDataLogChartValue()%>
		;
			var g2 = new JustGage({
				id : "chart2",
				min : 0,
				max : 100,
				label : "%",
				title : "STATIC DATA",
				gaugeWidthScale : 0.6,
				value : isNaN(staticDataCount) ? 0 : staticDataCount,
				levelColors : [ "#ff5050", "#a9d70b" ],
				// levelColors : [ "#ff5050", "#1200ff", "#f9c802", "#a9d70b" ],
				// levelColorsGradient : false,
				relativeGaugeSize : true,
				donut : true
			});

			var serviceDataCount =
	<%=aReport.getServiceLogChartValue()%>
		;
			var g3 = new JustGage({
				id : "chart3",
				min : 0,
				max : 100,
				label : "%",
				title : "SERVICE DATA",
				gaugeWidthScale : 0.6,
				value : isNaN(serviceDataCount) ? 0 : serviceDataCount,
				levelColors : [ "#ff5050", "#a9d70b" ],
				// levelColors : [ "#ff5050", "#1200ff", "#f9c802", "#a9d70b" ],
				// levelColorsGradient : false,
				relativeGaugeSize : true,
				donut : true
			});

			var transactionCount =
	<%=aReport.getTransactionLogChartValue()%>
		;
			var g4 = new JustGage({
				id : "chart4",
				min : 0,
				max : 100,
				label : "%",
				title : "TRANSACTION DATA",
				gaugeWidthScale : 0.6,
				value : isNaN(transactionCount) ? 0 : transactionCount,
				levelColors : [ "#ff5050", "#a9d70b" ],
				// levelColors : [ "#ff5050", "#1200ff", "#f9c802", "#a9d70b" ],
				// levelColorsGradient : false,
				relativeGaugeSize : true,
				donut : true
			});
		});
	</script>
	<%-- <jsp:include page="include_footer.jsp" /> --%>
</body>
</html>

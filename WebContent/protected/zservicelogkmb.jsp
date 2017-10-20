<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra implementation
  - Description: Get list of files in a directory
  --%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.DateTimeUtil"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Servicelog"%>
<%@page import="com.bs.themebridge.entity.adapter.ServicelogAdapter"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Service Data</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<!-- <link rel="shortcut icon" href="images/custom/browserlogo.png"> -->
<link rel="shortcut icon" href="../images/custom/themelogo3.png">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/daterangepicker-bs3.css" rel="stylesheet"
	type="text/css">
<link href="../css/jquery.dataTables.css" rel="stylesheet"
	type="text/css">
<link href="../css/jquery-ui.datepicker.css" rel="stylesheet"
	type="text/css">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../css/customized.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("servicelog");
	});
	$(document)
			.ready(
					function() {

						$('#configuration')
								.dataTable(
										{
											"sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
											"iDisplayLength" : 50,
											"bFilter" : false,
											"bSortClasses" : false,
											"order" : [ [ 5, "desc" ] ]
										});

						var cb = function(start, end, label) {

							$('#reportrange span').html(
									start.format('DD-MMM-YYYY') + ' - '
											+ end.format('DD-MMM-YYYY'));
							$('#fromdaterange').val(start.format('DD-MM-YYYY'));
							$('#todaterange').val(end.format('DD-MM-YYYY'));
							//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
						};

						var optionSet1 = {
							startDate : moment(),
							endDate : moment(),
							minDate : '01/01/2000',
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

						var optionSet2 = {
							startDate : moment().subtract('days', 7),
							endDate : moment(),
							opens : 'left',
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
							}
						};

						/*
						$('#reportrange span').html(
								moment().subtract('days', 29).format(
										'MMMM D, YYYY')
										+ ' - '
										+ moment().format('MMMM D, YYYY'));
						 */

						$('#reportrange span').html(
								moment().format('DD-MMM-YYYY') + ' - '
										+ moment().format('DD-MMM-YYYY'));

						$('#reportrange').daterangepicker(optionSet1, cb);

						$('#reportrange').on('show.daterangepicker',
								function() {
									//console.log("show event fired");
								});
						$('#reportrange').on('hide.daterangepicker',
								function() {
									//console.log("hide event fired");
								});
						$('#reportrange').on('apply.daterangepicker',
								function(ev, picker) {

								});
						$('#reportrange').on('cancel.daterangepicker',
								function(ev, picker) {
									//console.log("cancel event fired");
								});

						$('#options1').click(
								function() {
									$('#reportrange').data('daterangepicker')
											.setOptions(optionSet1, cb);
								});

						$('#options2').click(
								function() {
									$('#reportrange').data('daterangepicker')
											.setOptions(optionSet2, cb);
								});

						$('#destroy').click(function() {
							$('#reportrange').data('daterangepicker').remove();
						});

					});
</script>

<script type="text/javascript" language="javascript">
	function dropdownlist(listindex) {
		document.search.operation.options.length = 0;
		switch (listindex) {
		case "":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			break;

		case "Account":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("Avail Balance",
					"AvailBal");
			break;

		case "BackOffice":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("Batch", "Batch");
			document.search.operation.options[2] = new Option("Verify",
					"Verify");
			break;

		case "Limit":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("Facilities",
					"Facilities");
			document.search.operation.options[2] = new Option("Reservations",
					"Reservations");
			document.search.operation.options[3] = new Option(
					"ReservationsReversal", "ReservationsReversal");
			document.search.operation.options[4] = new Option(
					"ExposureReservation", "ExposureReservation");
			document.search.operation.options[5] = new Option(
					"ExposureReversal", "ExposureReversal");
			break;

		case "GATEWAY":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("SMS", "SMS");
			document.search.operation.options[2] = new Option("NCIF", "NCIF%");
			document.search.operation.options[3] = new Option("RTGS", "RTGS%");
			document.search.operation.options[4] = new Option("NEFT", "NEFT%");
			document.search.operation.options[5] = new Option("EMAIL", "EMAIL");
			document.search.operation.options[6] = new Option("SwiftMailer",
					"SWIFTMailer");
			document.search.operation.options[7] = new Option("e-BG",
					"EBGISSUE");
			break;

		case "TI":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("SwiftIn",
					"SwiftIn");
			document.search.operation.options[2] = new Option("SFMSIn",
					"SFMSIn");
			break;

		case "SFMS":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("SFMSOut",
					"SFMSOut");
			document.search.operation.options[2] = new Option("SFMSIn",
					"SFMSIn");
			break;

		case "BusinessSupport":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option(
					"FXOptionsSearch", "FXOptionsSearch");
			break;

		case "TIEODJOB":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");			
			document.search.operation.options[1] = new Option("ProcessStart",
					"ProcessStart");
			document.search.operation.options[2] = new Option("ProcessEnd",
					"ProcessEnd");
			document.search.operation.options[3] = new Option("FXRATE",
					"FXRATE");
			document.search.operation.options[4] = new Option("BASERATE",
					"BASERATE");
			document.search.operation.options[5] = new Option("REPORTS",
					"REPORTS");
			break;

		case "EODJOB":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("ProcessStart",
					"ProcessStart");
			document.search.operation.options[2] = new Option("ProcessEnd",
					"ProcessEnd");
			break;

		case "SWIFT":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("SwiftOut",
					"SwiftOut");
			document.search.operation.options[2] = new Option("SFMSOut",
					"SFMSOut");
			break;

		case "Notifications":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("event-step",
					"event-step");
			break;

		case "Customization":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("FD LienMark",
					"FDLienMark");
			document.search.operation.options[2] = new Option("FD LienEnquiry",
					"FDLienEnquiry");
			document.search.operation.options[3] = new Option("FD LienRemoval",
					"FDLienRemoval");
			break;

		}
		return true;
	}
</script>

<style>
th { font-size: 12px; }
td { font-size: 12px; }
</style>

</head>
<body>
	<%-- <h1> Start : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1> --%>
	<%
		ServicelogAdapter sda = new ServicelogAdapter();
		//List<Servicelog> serviceLog =  new ArrayList<Servicelog>();
		ThemeBridgeEntityManager tbe = new ThemeBridgeEntityManager();

		String masterReferenceValue = request.getParameter("masterreference");
		String eventReferenceValue = request.getParameter("eventreference");
		if (masterReferenceValue == null)
			masterReferenceValue = "";
		if (eventReferenceValue == null)
			eventReferenceValue = "";

		//handle selected for service
		String serviceParameter = request.getParameter("service");
		String accountSelected = "";
		String customizationSelected = "";
		String gatewaySelected = "";
		String NotificationsSelected = "";
		String tiSelected = "";
		String BusinessSupportSelected = "";
		String BackOfficeSelected = "";
		String SWIFTSelected = "";
		String tieodjobSelected = "";
		String eodjobSelected = "";
		String SfmsSelected = "";
		String LimitSelected = "";
		String CustomisationSelected = "";

		if (serviceParameter == null)
			serviceParameter = "";
		if (serviceParameter.trim().equals("TIEODJOB"))
			tieodjobSelected = "SELECTED";
		if (serviceParameter.trim().equals("EODJOB"))
			eodjobSelected = "SELECTED";
		if (serviceParameter.trim().equals("BusinessSupport"))
			BusinessSupportSelected = "SELECTED";
		if (serviceParameter.trim().equals("BackOffice"))
			BackOfficeSelected = "SELECTED";
		if (serviceParameter.trim().equals("Account"))
			accountSelected = "SELECTED";
		if (serviceParameter.trim().equals("CUSTOMISATION"))
			customizationSelected = "SELECTED";
		if (serviceParameter.trim().equals("GATEWAY"))
			gatewaySelected = "SELECTED";
		if (serviceParameter.trim().equals("Notifications"))
			NotificationsSelected = "SELECTED";
		if (serviceParameter.trim().equals("TI"))
			tiSelected = "SELECTED";
		if (serviceParameter.trim().equals("SWIFT"))
			SWIFTSelected = "SELECTED";
		if (serviceParameter.trim().equals("SFMS"))
			SfmsSelected = "SELECTED";
		if (serviceParameter.trim().equals("Limit"))
			LimitSelected = "SELECTED";
		if (serviceParameter.trim().equals("Customization"))
			CustomisationSelected = "SELECTED";

		//Handle selected for LimitSelected

		//Handle selected for operation
		String operationParameter = request.getParameter("operation");
		String availBalSelected = "";
		String FETCHFDSelected = "";
		String FETCHSIGNATURESelected = "";
		String CCSFDPS1Selected = "";
		String CCSFDPS2Selected = "";
		String CCSRM1Selected = "";
		String CCSRM2Selected = "";
		String CCSRM3Selected = "";
		String EXTDMSSelected = "";
		String FacilitiesSelected = "";
		String ReservationsSelected = "";
		String ReservationsReversalSelected = "";
		String ExposureReservationSelected = "";
		String ExposureReversalSelected = "";
		String SwiftInSelected = "";
		String FXContractsSelected = "";
		String BatchSelected = "";
		String VerifySelected = "";
		String SMSBGISS01Selected = "";
		String SMSBGCAN1Selected = "";
		String SMSBGCLM01Selected = "";
		String SMSBGREN01Selected = "";
		String SMSBGSET01Selected = "";
		String SMSTRF01Selected = "";
		String SMSTRF02Selected = "";
		String SMSBGISS02Selected = "";
		String RTGSSelected = "";
		String RTGS01Selected = "";
		String IGTRTGS1Selected = "";
		String NEFTSelected = "";
		String CurrencySpotRateSelected = "";
		String CustomerSelected = "";
		String FXRateSelected = "";
		String TFINVNEWSelected = "";
		String SwiftOutSelected = "";
		String eventstepSelected = "";
		String EmailSelected = "";
		String SFMSInSelected = "";
		String MailerAdviceSelected = "";
		String SCFAdviceSelected = "";
		String SFMSOutSelected = "";
		String ExposureSelected = "";
		String FXOptionsSearchSelected = "";
		String FXRateServiceSelected = "";
		String FDLienAddSelected = "";
		String FDLienModSelected = "";

		if (operationParameter == null)
			operationParameter = "";

		if (operationParameter.trim().equals("SFMSIN"))
			SFMSInSelected = "SELECTED";
		if (operationParameter.trim().equals("SFMSOUT"))
			SFMSOutSelected = "SELECTED";
		if (operationParameter.trim().equals("EMAIL"))
			EmailSelected = "SELECTED";
		if (operationParameter.trim().equals("event-step"))
			eventstepSelected = "SELECTED";
		if (operationParameter.trim().equals("SwiftOut"))
			SwiftOutSelected = "SELECTED";
		if (operationParameter.trim().equals("TFINVNEW"))
			TFINVNEWSelected = "SELECTED";
		if (operationParameter.trim().equals("FXRate"))
			FXRateSelected = "SELECTED";
		if (operationParameter.trim().equals("Customer"))
			CustomerSelected = "SELECTED";
		if (operationParameter.trim().equals("CurrencySpotRate"))
			CurrencySpotRateSelected = "SELECTED";
		if (operationParameter.trim().equals("NEFT"))
			NEFTSelected = "SELECTED";
		if (operationParameter.trim().equals("RTGS01"))
			RTGS01Selected = "SELECTED";
		if (operationParameter.trim().equals("RTGS"))
			RTGSSelected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGISS02"))
			SMSBGISS02Selected = "SELECTED";
		if (operationParameter.trim().equals("IGTRTGS1"))
			IGTRTGS1Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSTRF02"))
			SMSTRF02Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSTRF01"))
			SMSTRF01Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGSET01"))
			SMSBGSET01Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGREN01"))
			SMSBGREN01Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGCLM01"))
			SMSBGCLM01Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGCAN1"))
			SMSBGCAN1Selected = "SELECTED";
		if (operationParameter.trim().equals("SMSBGISS01"))
			SMSBGISS01Selected = "SELECTED";
		if (operationParameter.trim().equals("Verify"))
			VerifySelected = "SELECTED";
		if (operationParameter.trim().equals("Batch"))
			BatchSelected = "SELECTED";
		if (operationParameter.trim().equals("FXContracts"))
			FXContractsSelected = "SELECTED";
		if (operationParameter.trim().equals("AvailBal"))
			availBalSelected = "SELECTED";
		if (operationParameter.trim().equals("FETCHFD"))
			FETCHFDSelected = "SELECTED";
		if (operationParameter.trim().equals("FETCHSIGNATURE"))
			FETCHSIGNATURESelected = "SELECTED";
		if (operationParameter.trim().equals("CCSFDPS1"))
			CCSFDPS1Selected = "SELECTED";
		if (operationParameter.trim().equals("CCSFDPS2"))
			CCSFDPS2Selected = "SELECTED";
		if (operationParameter.trim().equals("CCSRM1"))
			CCSRM1Selected = "SELECTED";
		if (operationParameter.trim().equals("CCSRM2"))
			CCSRM2Selected = "SELECTED";
		if (operationParameter.trim().equals("CCSRM3"))
			CCSRM3Selected = "SELECTED";
		if (operationParameter.trim().equals("EXTDMS"))
			EXTDMSSelected = "SELECTED";
		if (operationParameter.trim().equals("Exposure"))
			ExposureSelected = "SELECTED";
		if (operationParameter.trim().equals("Facilities"))
			FacilitiesSelected = "SELECTED";
		if (operationParameter.trim().equals("Reservations"))
			ReservationsSelected = "SELECTED";
		if (operationParameter.trim().equals("ReservationsReversal"))
			ReservationsReversalSelected = "SELECTED";
		if (operationParameter.trim().equals("ExposureReservation"))
			ExposureReservationSelected = "SELECTED";
		if (operationParameter.trim().equals("ExposureReversal"))
			ExposureReversalSelected = "SELECTED";
		if (operationParameter.trim().equals("SwiftIn"))
			SwiftInSelected = "SELECTED";
		if (operationParameter.trim().equals("MailerAdvice"))
			MailerAdviceSelected = "SELECTED";
		if (operationParameter.trim().equals("SCFAdvice"))
			SCFAdviceSelected = "SELECTED";
		if (operationParameter.trim().equals("FXOptionsSearch"))
			FXOptionsSearchSelected = "SELECTED";
		if (operationParameter.trim().equals("FXRateService"))
			FXRateServiceSelected = "SELECTED";
		if (operationParameter.trim().equals("FDLienAdd"))
			FDLienAddSelected = "SELECTED";
		if (operationParameter.trim().equals("FDLienMod"))
			FDLienModSelected = "SELECTED";
		// FDLienAddSelected
		// FDLienModSelected

		// handle selected for status		
		String statusParameter = request.getParameter("status");
		String errorSelected = "";
		String failedSelected = "";
		String receivedSelected = "";
		String submittedSelected = "";
		String processedSelected = "";
		String succeededSelected = "";
		String suppressedSelected = "";
		String resubmittedSelected = "";
		String awaitingSelected = "";
		String queuedSelected = "";

		if (statusParameter == null)
			statusParameter = "";
		if (statusParameter.trim().equals("SUCCEEDED"))
			succeededSelected = "SELECTED";
		if (statusParameter.trim().equals("FAILED"))
			failedSelected = "SELECTED";
		if (statusParameter.trim().equals("RECEIVED"))
			receivedSelected = "SELECTED";
		if (statusParameter.trim().equals("PROCESSED"))
			processedSelected = "SELECTED";
		if (statusParameter.trim().equals("ERROR"))
			errorSelected = "SELECTED";
		if (statusParameter.trim().equals("SUBMITTED"))
			submittedSelected = "SELECTED";
		if (statusParameter.trim().equals("SUPPRESSED"))
			suppressedSelected = "SELECTED";
		if (statusParameter.trim().equals("RESUBMITTED"))
			resubmittedSelected = "SELECTED";
		if (statusParameter.trim().equals("AWAITING"))
			awaitingSelected = "SELECTED";
		if (statusParameter.trim().equals("QUEUED"))
			queuedSelected = "SELECTED";
		//----------------------------------------------------------

		Enumeration<String> parameterNames = request.getParameterNames();
		String prefix = "slog";
		String whereCondition = " Where " + prefix + "." + "processtime" + " <= " + ":rangeEnd" + " and " + prefix
				+ "." + "processtime" + " >= " + ":rangeStart";
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			if (!paramName.endsWith("daterange") && paramValue.trim().length() > 0)
				whereCondition = whereCondition + " and " + prefix + "." + paramName + " like '" + paramValue + "'";
			// whereCondition = whereCondition + " and " + prefix + "." + paramName + " = '" + paramValue + "'";
		}
	%>

	<!-- <%=whereCondition%> -->

	<%-- <h1> Before Query  : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1>--%>
	<%
		//Query searchQuery = tbe.entityManager.createQuery(
		//"SELECT OBJECT(slog) FROM Servicelog slog " + whereCondition );

		Query searchQuery = tbe.entityManager.createQuery(
				"SELECT slog.id,slog.service,slog.operation,slog.masterreference,slog.eventreference,slog.status,slog.processtime,slog.narrative1 FROM Servicelog slog "
						+ whereCondition);
		//out.println(searchQuery);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String fromdaterange = "";
		String todaterange = "";
		Date fromdaterange_date = new Date();
		Date todaterange_date = new Date();
		String fDate = "";
		if (request.getParameter("fromdaterange") == null
				|| request.getParameter("fromdaterange").trim().equals("")) {
			fDate = formatter.format(new Date());
		} else {
			fDate = request.getParameter("fromdaterange");
			//out.println("fDate"+fDate);
		}
		String tDate = "";
		if (request.getParameter("todaterange") == null || request.getParameter("todaterange").trim().equals("")) {
			tDate = formatter.format(new Date());
		} else {
			tDate = request.getParameter("todaterange");
			//out.println("tDate"+tDate);
		}

		if (request.getParameter("fromdaterange") != null
				&& !request.getParameter("fromdaterange").trim().equals("")) {
			fromdaterange_date = formatter.parse(request.getParameter("fromdaterange"));
		}

		if (request.getParameter("todaterange") != null && !request.getParameter("todaterange").trim().equals("")) {
			todaterange_date = formatter.parse(request.getParameter("todaterange"));
		}

		Calendar cal = Calendar.getInstance();

		cal.setTime(fromdaterange_date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		//cal.set(Calendar.HOUR,23);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		fromdaterange_date = cal.getTime();

		cal.setTime(todaterange_date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 59);
		//cal.set(Calendar.HOUR,23);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		todaterange_date = cal.getTime();
	%>

	<!--<%=fromdaterange_date%> - <%=todaterange_date%>	-->

	<%
		searchQuery.setParameter("rangeStart", fromdaterange_date);
		searchQuery.setParameter("rangeEnd", todaterange_date);
		// serviceLog = searchQuery.getResultList();
		List<Object[]> serviceLogList = searchQuery.getResultList();
		// out.println(serviceLogList.size());
	%>
	<%--<h1> End  Query  : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1> --%>
	<div>
		<a name="top"></a>
	</div>
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Service Data</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<jsp:include page="timezone.jsp" />
			</div>
			<!-- <legend></legend> -->
			<div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
				<div id="reportrange" class="pull-right daterangeinstyle">
					<span></span> <b class="caret"></b>
				</div>
			</div>
		</div>
		<%
			if (serviceLogList != null && serviceLogList.size() == 0) {
		%>
		<div class="row">
			<div class="alert alert-danger">No record found</div>
		</div>
		<%
			}
		%>
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1" style="color: green">Service</th>
								<th class="col-md-1" style="color: green">Operation</th>
								<th class="col-md-1" style="color: green">MasterRef</th>
								<th class="col-md-1" style="color: green">EventRef</th>
								<th class="col-md-1" style="color: green">Narrative1</th>
								<th class="col-md-1" style="color: green">Status</th>
								<th class="col-md-2" style="color: green">ProcessTime</th>
								<th class="col-md-1" style="color: green">Action</th>
							</tr>
						</thead>
						<tbody class="content">
							<%
								String masterRef = "";
								String eventRef = "";
								String narrative1 = "";
								for (Object[] sd : serviceLogList) {
									if (sd[3] == null)
										masterRef = "N/A";
									else
										masterRef = sd[3].toString();

									if (sd[4] == null)
										eventRef = "N/A";
									else
										eventRef = sd[4].toString();
									
									if (sd[7] == null)
										narrative1 = "";
									else
										narrative1 = sd[7].toString();
							%>
							<tr>
								<td><%=sd[1]%></td>
								<td><%=sd[2]%></td>
								<td><%=masterRef%></td>
								<td><%=eventRef%></td>
								<td><%=narrative1%></td>
								<td><%=sd[5]%></td>
								<td><%=DateTimeUtil.getStringDateByDateInFormat((Date) sd[6], "yyyy-MM-dd HH:mm:ss")%></td>
								<td><a href="service.jsp?id=<%=sd[0]%>"
									class="btn btn-success btn-xs">View</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<!-- -----------------------search container start------------------------------------ -->
			<form id="search" name="search" method="post">
				<!-- <div class="col-lg-3 col-md-3 col-sm-3 daterangeoutstyle">
					<div id="reportrange" class="pull-right daterangeinstyle">
						<span></span> <b class="caret"></b>
					</div>
				</div> -->
				<div class="col-lg-3 col-md-3 col-sm-3">
					<div class="form-horizontal filter-search-layout" role="form">
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label"
								style="text-align: left;">Service </label> -->
							<div class="col-md-8">
								<select name="service" class="form-control" id="service"
									onchange="javascript:dropdownlist(this.options[this.selectedIndex].value);">
									<option value="" selected="selected"><----service----></option>
									<option value="TI" <%=tiSelected%>>TI</option>
									<option value="Limit" <%=LimitSelected%>>Limit</option>
									<%-- <option value="SFMS" <%=SfmsSelected%>>SFMS</option> --%>
									<option value="SWIFT" <%=SWIFTSelected%>>SWIFT</option>									
									<option value="Account" <%=accountSelected%>>Account</option>									
									<option value="GATEWAY" <%=gatewaySelected%>>Gateway</option>
									 <option value="TIEODJOB" <%=tieodjobSelected%>>TIEODJOB</option>
									<option value="BackOffice" <%=BackOfficeSelected%>>Backoffice</option>									      
									<option value="Notifications" <%=NotificationsSelected%>>Notifications</option>
									<option value="Customization" <%=CustomisationSelected%>>Customization</option>
									<option value="BusinessSupport" <%=BusinessSupportSelected%>>BusinessSupport</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label"
								style="text-align: left;">Operation </label> -->
							<div class="col-md-8">
								<select name="operation" class="form-control" id="operation">
									<option value=""><---operation---></option>
								</select>
								<!--  <input type="text" class="form-control" id="" placeholder="">-->
							</div>
						</div>
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label"
								style="text-align: left;">Status </label> -->
							<div class="col-md-8">
								<select name="status" class="form-control" id="status">
									<option value="" selected="selected"><----status-----></option>
									<%--<option value="PROCESSED" <%=processedSelected%>>PROCESSED</option>--%>
									<option value="FAILED" <%=failedSelected%>>FAILED</option>
									<option value="ERROR" <%=errorSelected%>>ERROR</option>
									<option value="QUEUED" <%=queuedSelected%>>QUEUED</option>
									<option value="AWAITING" <%=awaitingSelected%>>AWAITING</option>
									<option value="RECEIVED" <%=receivedSelected%>>RECEIVED</option>
									<option value="SUBMITTED" <%=submittedSelected%>>SUBMITTED</option>
									<option value="SUCCEEDED" <%=succeededSelected%>>SUCCEEDED</option>
									<option value="PROCESSED" <%=processedSelected%>>PROCESSED</option>
									<option value="SUPPRESSED" <%=suppressedSelected%>>SUPPRESSED</option>
									<option value="RESUBMITTED" <%=resubmittedSelected%>>RESUBMITTED</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label">MasterRef </label> -->
							<div class="col-md-8">
								<input type="text" class="form-control" id="masterreference"
									name="masterreference" value="<%=masterReferenceValue%>"
									placeholder="MasterRef" spellcheck="false">
							</div>
						</div>
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label">EventRef </label> -->
							<div class="col-md-8">
								<input type="text" class="form-control" id="eventreference"
									name="eventreference" value="<%=eventReferenceValue%>"
									placeholder="EventRef" spellcheck="false">
								<!-- onblur="this.value=this.value.toUpperCase() -->
								<!-- style="text-transform:lowercase" -->
								<!-- style="text-transform: uppercase"  -->
								<!-- onchange="upperMe()" -->
							</div>
						</div>
						<!-- -----------------------date------------------------------------ -->
						<!-- <div class="col-lg-12 col-md-3 col-sm-3 daterangeoutstyle">
							<div id="reportrange" class="pull-right daterangeinstyle">
								<span></span> <b class="caret"></b>
							</div>
						</div> -->
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label">FromDate</label> -->
							<div class="col-md-8">
								<!-- <div class="col-sm-offset-1 col-md-10 control-label"> -->
								<input type="text" class="form-control" id="fromdaterange"
									name="fromdaterange" placeholder="dd-mm-yyyy" value=<%=fDate%>>
							</div>
						</div>
						<div class="form-group">
							<!-- <label for="" class="col-md-4 control-label">ToDate</label> -->
							<div class="col-md-8">
								<!-- <div class="col-sm-offset-1 col-md-10 control-label"> -->
								<input type="text" class="form-control" id="todaterange"
									name="todaterange" placeholder="dd-mm-yyyy" value=<%=tDate%>>
							</div>
						</div>
						<!-- --------------------------date--------------------------------- -->
						<!-- <div class="row command">
							<div
								class="col-lg-offset-4 col-sm-offset-4 col-sm-offset-4 col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-success btn-sm" type="Submit">Search</button>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-danger btn-sm" type="reset">Clear</button>
							</div>
						</div> -->
						<div class="row command">
							<div
								class="col-lg-offset-4 col-sm-offset-4 col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-primary btn-sm" type="Submit">
									<span class="glyphicon glyphicon-search"></span> Search
								</button>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-lg-offset-1">
								<button class="btn btn-danger btn-sm" type="reset">
									<span class="glyphicon glyphicon-remove-circle"></span> Clear
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div>
			<a href="#top">Back to top of page</a>
		</div>
	</div>
	<%-- <div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div> --%>
</body>
</html>
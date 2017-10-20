<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Staicdata log   
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
<%@page import="com.bs.themebridge.entity.model.Staticdatalog"%>
<%@page import="com.bs.themebridge.entity.adapter.StaticdatalogAdapter"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<!DOCTYPE html>
<html>
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

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<!-- <script src="../js/jquery-ui.datepicker.js" type="text/javascript"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("staticdatalog");
	});
	function goBack() {
		window.history.back();
	};
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						//removeAllActiveMenu();
						//addActiveMenu("staticdata");

						$('#configuration')
								.dataTable(
										{
											"sDom" : "<'row'<'col-xs-6'><'col-xs-6'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
											"iDisplayLength" : 50,
											"bFilter" : false,
											"bSortClasses" : false,
											"order" : [ [ 6, "desc" ] ]
										});

						var cb = function(start, end, label) {
							//$('#reportrange span').html(
							//		start.format('MMMM D, YYYY') + ' - '
							//				+ end.format('MMMM D, YYYY'));
							$('#reportrange span').html(
									start.format('DD-MMM-YYYY') + ' - '
											+ end.format('DD-MMM-YYYY'));
							$('#fromdaterange').val(start.format('DD-MM-YYYY'));
							$('#todaterange').val(end.format('DD-MM-YYYY'));
							//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
						};

						var optionSet1 = {
							//startDate : moment().subtract('days', 29),
							startDate : moment(),
							endDate : moment(),
							minDate : '01/01/1950',
							maxDate : '12/31/2100',
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
</head>
<body>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->
	<%
		StaticdatalogAdapter sda = new StaticdatalogAdapter();
		//List<Staticdatalog> staticdatalog = sda.getAllProperties();	
		ThemeBridgeEntityManager tbe = new ThemeBridgeEntityManager();

		String narrative1Value = request.getParameter("narrative1");
		String narrative2Value = request.getParameter("narrative2");
		String narrative3Value = request.getParameter("narrative3");
		if (narrative1Value == null)
			narrative1Value = "";
		if (narrative2Value == null)
			narrative2Value = "";
		if (narrative3Value == null)
			narrative3Value = "";

		//handle selected for entitytype
		String entityParameter = request.getParameter("entitytype");
		String accountSelected = "";
		String customerdataSelected = "";
		String customerrateSelected = "";
		String baserateSelected = "";
		String accountdataSelected = "";
		String spotrateSelected = "";
		String relationshipmanagerSelected = "";
		String fxrateSelected = "";
		if (entityParameter == null)
			entityParameter = "";
		if (entityParameter.trim().equals("BaseRate"))
			baserateSelected = "SELECTED";
		if (entityParameter.trim().equals("SpotRate"))
			spotrateSelected = "SELECTED";
		if (entityParameter.trim().equals("FxRate"))
			fxrateSelected = "SELECTED";
		if (entityParameter.trim().equals("AccountData"))
			accountSelected = "SELECTED";
		if (entityParameter.trim().equals("CustomerData"))
			customerdataSelected = "SELECTED";

		// handle selected for status		
		String statusParameter = request.getParameter("status");
		String succeededSelected = "";
		String processedSelected = "";
		String failedSelected = "";
		String errorSelected = "";
		String unAvailableSelected = "";
		if (statusParameter == null)
			statusParameter = "";
		if (statusParameter.trim().equals("SUCCEEDED"))
			succeededSelected = "SELECTED";
		if (statusParameter.trim().equals("FAILED"))
			failedSelected = "SELECTED";
		if (statusParameter.trim().equals("UNAVAILABLE"))
			unAvailableSelected = "SELECTED";
		if (statusParameter.trim().equals("PROCESSED"))
			processedSelected = "SELECTED";
		if (statusParameter.trim().equals("ERROR"))
			errorSelected = "SELECTED";

		Enumeration<String> parameterNames = request.getParameterNames();
		String prefix = "stdlog";
		String whereCondition = " Where " + prefix + "." + "processtime" + " <= " + ":rangeEnd" + " and " + prefix
				+ "." + "processtime" + " >= " + ":rangeStart";
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			if (!paramName.endsWith("daterange") && paramValue.trim().length() > 0)
				whereCondition = whereCondition + " and " + prefix + "." + paramName + " like '" + paramValue + "'";
			// whereCondition = whereCondition + " and " + prefix + "." + paramName + "= '" + paramValue + "'" ;
			// + " and " + prefix + "." + "narrative1 like '%" + narrative3Value + "%'";
		}
	%>

	<%=whereCondition%>

	<%
		//Query searchQuery = tbe.entityManager.createQuery(
		//"SELECT OBJECT(slog) FROM Staticdatalog slog " + whereCondition );	
		Query searchQuery = tbe.entityManager.createQuery(
				"Select stdlog.id, stdlog.service, stdlog.entitytype, stdlog.status, stdlog.processtime, stdlog.narrative1, stdlog.narrative2, stdlog.narrative3 from Staticdatalog stdlog "
						+ whereCondition);
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
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		fromdaterange_date = cal.getTime();

		cal.setTime(todaterange_date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 59);
		//cal.set(Calendar.HOUR,23);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		todaterange_date = cal.getTime();
	%>
	<!-- <%=fromdaterange_date%> - <%=todaterange_date%> -->
	<%
		searchQuery.setParameter("rangeStart", fromdaterange_date);
		searchQuery.setParameter("rangeEnd", todaterange_date);
		//staticdatalog = searchQuery.getResultList();		
		List<Object[]> staticLogList = searchQuery.getResultList();
		//out.println("staticLogList.size()"+staticLogList.size());
	%>
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
				<h3>Static Data</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<jsp:include page="timezone.jsp" />
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
				<div id="reportrange" class="pull-right daterangeinstyle">
					<span></span> <b class="caret"></b>
				</div>
			</div>
		</div>

		<!-- start -->
		<!-- <button class="btn btn-success btn-sm" type="Submit" onclick ="javascript:ShowHide('HiddenDiv')">Search Tab</button> -->
		<!-- <div class="row" id="HiddenDiv" style="DISPLAY: none"> -->
		<!-- <form id="search" action="staticdata.jsp" method="get"> -->
		<form id="search" name="search" method="get">
			<div class="row" class="form-horizontal filter-search-layout">
				<!--<div class="border">-->
				<div class="row">
					<!-- <label for="" class="col-md-1 control-label">SourceSystem</label> -->
					<label for="" class="col-md-2 control-label">EntityType </label> <label
						for="" class="col-md-2 control-label">Narrative1 </label>
					<!-- <label for="" class="col-md-2 control-label">Narrative2 </label> -->
					<label for="" class="col-md-2 control-label">Status </label> <label
						for="" class="col-md-2 control-label">FromDate </label> <label
						for="" class="col-md-2 control-label">ToDate </label>
				</div>
				<div class="row">
					<!-- <div class="col-md-1">
						<select name="sourceSystem" class="form-control" id="sourceSystem">
							<option value="">--SourceSystem--</option>
							<option value="ZONE1" SELECTED>TI</option>
						</select>
					</div> -->
					<div class="col-md-2">
						<select name="entitytype" class="form-control" id="entitytype">
							<option value=""><----service----></option>
							<option value="FxRate" <%=fxrateSelected%>>FX Rate</option>
							<option value="SpotRate" <%=spotrateSelected%>>Spot Rate</option>
							<option value="BaseRate" <%=baserateSelected%>>Base Rate</option>
							<option value="AccountData" <%=accountSelected%>>Account
								Data</option>
							<option value="CustomerData" <%=customerdataSelected%>>Customer
								Data</option>
						</select>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="narrative1"
							name="narrative1" value="<%=narrative1Value%>"
							placeholder="Narrative">
					</div>
					<div class="col-md-2">
						<select name="status" class="form-control" id="status">
							<option value="" selected="selected"><----status-----></option>
							<option value="FAILED" <%=failedSelected%>>FAILED</option>
							<option value="SUCCEEDED" <%=succeededSelected%>>SUCCEEDED</option>
							<option value="UNAVAILABLE" <%=unAvailableSelected%>>UNAVAILABLE</option>
						</select>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="fromdaterange"
							name="fromdaterange" placeholder="DD-MM-YYYY" value="<%=fDate%>">
						<!-- style="font-size: 7pt"> -->
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="todaterange"
							name="todaterange" placeholder="DD-MM-YYYY" value="<%=tDate%>">
						<!-- style="font-size: 7pt"> -->
					</div>
					<div class="col-md-1">
						<!-- added by Prasath, 2016-04-26 -->
						<button class="btn btn-success btn-sm" type="Submit">Search</button>
					</div>

					<!-- toggle  close -->
					<!-- </div> -->
				</div>
			</div>
		</form>
		<br>
		<div class="row">
			<legend></legend>
		</div>
		<!-- stop -->

		<form id="staticdatalog" method="post" onsubmit="staticdata.jsp">
			<%
				if (staticLogList != null && staticLogList.size() == 0) {
			%>
			<div class="row">
				<div class="alert alert-danger">No record found</div>
			</div>
			<%
				}
			%>
			<div class="row">
				<!-- <div class="col-md-9"> -->
				<div class="col-md-12">
					<div class="row">
						<table id="configuration" class="display" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th class="col-md-1" style="color: green">Service</th>
									<th class="col-md-1" style="color: green">EntityType</th>
									<th class="col-md-1" style="color: green">Narrative1</th>
									<th class="col-md-1" style="color: green">Narrative2</th>
									<th class="col-md-1" style="color: green">Narrative3</th>
									<th class="col-md-1" style="color: green">Status</th>
									<th class="col-md-1" style="color: green">ProcessTime</th>
									<th class="col-md-1" style="color: green">Action</th>
								</tr>
							</thead>
							<tbody class="content">
								<%
									for (Object[] sd : staticLogList) {
								%>
								<tr>
									<td><%=sd[1]%></td>
									<td><%=sd[2]%></td>
									<td><%=sd[5]%></td>
									<td><%=sd[6]%></td>
									<td><%=sd[7]%></td>
									<td><%=sd[3]%></td>
									<td><%=DateTimeUtil.getStringDateByDateInFormat((Date) sd[4], "yyyy-MM-dd HH:mm:ss")%></td>
									<%-- <td><%=ThemeBridgeUtil.getDateInFormat((Date) sd[4],
						"yyyy-MM-dd HH:mm:ss")%></td> --%>
									<td><a href="staticdata.jsp?id=<%=sd[0]%>"
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
				<%-- <form id="search" name="search" method="post">
				<!-- <div class="col-lg-3 col-md-3 col-sm-3 daterangeoutstyle">
					<div id="reportrange" class="pull-right daterangeinstyle">
						<span></span> <b class="caret"></b>
					</div>
				</div> -->
				<div class="col-lg-3 col-md-3 col-sm-3">
					<div class="form-horizontal filter-search-layout" role="form">
						<div class="form-group">
							<label for="" class="col-md-4 control-label"
								style="text-align: left;"> EntityType </label>
							<div class="col-md-8">
								<select name="entitytype" class="form-control" id="entitytype">
									<option value=""><----service----></option>
									<option value="FxRate" <%=fxrateSelected%>>FX Rate</option>
									<option value="SpotRate" <%=spotrateSelected%>>Spot
										Rate</option>
									<option value="BaseRate" <%=baserateSelected%>>Base
										Rate</option>
									<option value="AccountData" <%=accountSelected%>>Account
										Data</option>
									<option value="CustomerData" <%=customerdataSelected%>>Customer
										Data</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label"
								style="text-align: left;">Status </label>
							<div class="col-md-8">
								<select name="status" class="form-control" id="status">
									<option value="" selected="selected"><----status-----></option>
									<option value="FAILED" <%=failedSelected%>>FAILED</option>
									<option value="SUCCEEDED" <%=succeededSelected%>>SUCCEEDED</option>
									<option value="UNAVAILABLE" <%=unAvailableSelected%>>UNAVAILABLE</option>
								</select>
							</div>
						</div>
						<!-- ----------------------- others ------------------------------------ -->
						<div class="form-group">
							<label for="" class="col-md-4 control-label">Narrative1 </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="narrative1"
									name="narrative1" value="<%=narrative1Value%>"
									spellcheck="false">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label">Narrative2 </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="narrative2"
									name="narrative2" value="<%=narrative2Value%>"
									spellcheck="false">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label">Narrative3 </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id="narrative3"
									name="narrative3" value="<%=narrative3Value%>"
									spellcheck="false">
							</div>
						</div>
						<!-- -----------------------date------------------------------------ -->
						<div class="form-group">
							<label for="" class="col-md-4 control-label">FromDate</label>
							<div class="col-md-8">
								<!-- <div class="col-sm-offset-1 col-md-10 control-label"> -->
								<input type="text" class="form-control" id="fromdaterange"
									name="fromdaterange" placeholder="dd-mm-yyyy" value=<%=fDate%>>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label">ToDate</label>
							<div class="col-md-8">
								<!-- <div class="col-sm-offset-1 col-md-10 control-label"> -->
								<input type="text" class="form-control" id="todaterange"
									name="todaterange" placeholder="dd-mm-yyyy" value=<%=tDate%>>
							</div>
						</div>
						<!-- --------------------------date--------------------------------- -->
						<div class="row command">
							<div
								class="col-lg-offset-4 col-sm-offset-4 col-sm-offset-4 col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-success btn-sm" type="Submit">Apply</button>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-danger btn-sm" type="reset">Clear</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			 --%>
			</div>
		</form>
		<div>
			<a href="#top">Back to top of page</a>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>

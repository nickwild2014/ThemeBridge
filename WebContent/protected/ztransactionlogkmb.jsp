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
<%@page import="com.bs.themebridge.entity.model.Transactionlog"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<%@page import="com.bs.themebridge.entity.adapter.TransactionlogAdapter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Transaction Data</title>
<!--@author Prasath	Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<!-- <link rel="shortcut icon" href="../images/custom/browserlogo.png"> -->
<link rel="shortcut icon" href="../images/custom/themelogo3.png">
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
<!-- <script src="js/jquery-ui.datepicker.js" type="text/javascript"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("transactionlog");
	});

	$(document)
			.ready(
					function() {

						//removeAllActiveMenu();
						//addActiveMenu("transactionlog");

						$('#configuration')
								.dataTable(
										{
											"sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
											"iDisplayLength" : 50,
											"bFilter" : false,
											"bSortClasses" : false,
											"order" : [ [ 6, "desc" ] ]
										});

						var cb = function(start, end, label) {
							$('#reportrange span').html(
									start.format('DD-MM-YYYY') + ' - '
											+ end.format('DD-MM-YYYY'));
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

	function resubmitTransaction() {
		var idList = new Array();
		var id = '';
		var checkboxlist = $("input[id^='resubmitCheck']");
		for (var checkscount = 0; checkscount < checkboxlist.length; checkscount++) {
			if (checkboxlist[checkscount].checked == true) {
				idList.push(checkboxlist[checkscount].value);
			}
		}
		if (idList != null && idList.length > 0) {
			var answer = confirm("Do you want to resubmit?");
			if (answer) {
				id = idList.join(',');
				// var url = "transactionhistory?id=" + id;
				var url = "transactionresubmit.jsp?id=" + id;
				$(location).attr('href', url);
			} else {
				//do nothing
			}
		} else {
			alert("Choose any FAILURE transaction");
		}
	}

	function checkAll() {
		var checkboxlist = $("input[id^='resubmitCheck']");
		for (var checkscount = 0; checkscount < checkboxlist.length; checkscount++) {
			if (checkboxlist[checkscount].checked == false
					&& checkboxlist[checkscount].disabled == false) {
				checkboxlist[checkscount].checked = true;
			}
		}
		$('#selectAll').hide();
		$('#unSelectAll').show();
	}

	function unCheckAll() {
		var checkboxlist = $("input[id^='resubmitCheck']");
		for (var checkscount = 0; checkscount < checkboxlist.length; checkscount++) {
			if (checkboxlist[checkscount].checked == true) {
				checkboxlist[checkscount].checked = false;
			}
		}
		$('#selectAll').show();
		$('#unSelectAll').hide();
	}
</script>
<script type="text/javascript" language="javascript">
	function dropdownlist(listindex) {

		document.search.operation.options.length = 0;
		switch (listindex) {
		case "":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			break;

		//case "BackOffice":
		//document.search.operation.options[0] = new Option(
		//	"<----operation----->", "");
		//document.search.operation.options[1] = new Option("Batch", "Batch");
		//break;

		case "BackOffice":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("Batch", "Batch");
			break;

		/*case "SWIFT":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("SwiftOut",
					"SwiftOut");
			break;

		case "TI":
			document.search.operation.options[0] = new Option(
					"<----operation----->", "");
			document.search.operation.options[1] = new Option("TFEOD", "TFEOD");
			break;*/
		}
		return true;
	}
</script>
</head>
<body>
	<%
		if (request.getParameter("id") != null) {
			String id = request.getParameter("id");
			//TransactionPostingCustomHandler.doResubmitPosting(id);			
			response.sendRedirect("transactionlog.jsp");
		}
	%>

	<%
		TransactionlogAdapter sda = new TransactionlogAdapter();
		//List<Transactionlog> transactionlog = sda.getAllProperties();
		ThemeBridgeEntityManager tbe = new ThemeBridgeEntityManager();

		String masterReferenceValue = request.getParameter("masterreference");
		String eventReferenceValue = request.getParameter("eventreference");
		if (masterReferenceValue == null)
			masterReferenceValue = "";
		if (eventReferenceValue == null)
			eventReferenceValue = "";

		/*String frmdate = request.getParameter("fromdaterange");
		if(frmdate == null) frmdate = "";
		String tdate = request.getParameter("todaterange");
		if(tdate == null) tdate = "";*/

		//handle selected for service
		String serviceParameter = request.getParameter("service");
		String BackOfficeSelected = "";
		String SWIFTSelected = "";
		String tiSelected = "";
		if (serviceParameter == null)
			serviceParameter = "";
		if (serviceParameter.trim().equals("BackOffice"))
			BackOfficeSelected = "SELECTED";
		if (serviceParameter.trim().equals("SWIFT"))
			SWIFTSelected = "SELECTED";
		if (serviceParameter.trim().equals("TI"))
			tiSelected = "SELECTED";

		//Handle selected for operation
		String operationParameter = request.getParameter("operation");
		String BatchSelected = "";
		String SwiftOutSelected = "";
		String TFEODSelected = "";
		if (operationParameter == null)
			operationParameter = "";
		if (serviceParameter.trim().equals("Batch"))
			BatchSelected = "SELECTED";
		if (serviceParameter.trim().equals("SwiftOut"))
			SwiftOutSelected = "SELECTED";
		if (serviceParameter.trim().equals("TFEOD"))
			TFEODSelected = "SELECTED";

		// handle selected for status		
		String statusParameter = request.getParameter("status");
		String succeededSelected = "";
		String processedSelected = "";
		String failedSelected = "";
		String errorSelected = "";
		String submittedSelected = "";
		String resubmittedSelected = "";
		if (statusParameter == null)
			statusParameter = "";
		if (statusParameter.trim().equals("SUCCEEDED"))
			succeededSelected = "SELECTED";
		if (statusParameter.trim().equals("FAILED"))
			failedSelected = "SELECTED";
		if (statusParameter.trim().equals("PROCESSED"))
			processedSelected = "SELECTED";
		if (statusParameter.trim().equals("ERROR"))
			errorSelected = "SELECTED";
		if (statusParameter.trim().equals("SUBMITTED"))
			submittedSelected = "SELECTED";
		if (statusParameter.trim().equals("RESUBMITTED"))
			resubmittedSelected = "SELECTED";

		Enumeration<String> parameterNames = request.getParameterNames();
		String prefix = "tslog";
		String whereCondition = " Where " + prefix + "." + "processtime" + " <= " + ":rangeEnd" + " and " + prefix
				+ "." + "processtime" + " >= " + ":rangeStart"
				//" and (tslog.eventreference is not null and substr(tslog.eventreference,1,3) not in ('EOD','TRC','EXP','PCH','SRF'))";
				+ " and " + prefix + "." + "eventreference is not null";
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			if (!paramName.endsWith("daterange") && paramValue.trim().length() > 0)
				whereCondition = whereCondition + " and " + prefix + "." + paramName + " like '" + paramValue + "'";
			// whereCondition = whereCondition + " and " + prefix + "." + paramName + " = '" + paramValue + "'";
		}
	%>

	<!-- <%=whereCondition%> -->

	<%
		Query searchQuery = tbe.entityManager.createQuery(
				"select tslog.id, tslog.service,tslog.operation, tslog.masterreference,tslog.eventreference,tslog.status,tslog.processtime from Transactionlog  tslog "
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
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		//cal.set(Calendar.HOUR,0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		fromdaterange_date = cal.getTime();

		cal.setTime(todaterange_date);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 59);
		//cal.set(Calendar.HOUR,23);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		todaterange_date = cal.getTime();
	%>

	<!-- <%=fromdaterange_date%> - <%=todaterange_date%>  -->

	<%
		searchQuery.setParameter("rangeStart", fromdaterange_date);
		searchQuery.setParameter("rangeEnd", todaterange_date);
		// transactionlog = searchQuery.getResultList();
		List<Object[]> transactionLogList = searchQuery.getResultList();
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
				<h3>Transaction Data</h3>
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
		<%
			if (transactionLogList != null && transactionLogList.size() == 0) {
		%>
		<div class="row">
			<div class="alert alert-danger">No record found</div>
		</div>
		<%
			}
		%>
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-9">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="row">
							<div class="col-lg-2 col-md-2 col-sm-2">
								<a href="#" id="selectAll" onclick="checkAll()"
									class="btn btn-success">Select All</a> <a href="#"
									id="unSelectAll" onclick="unCheckAll()" class="btn btn-danger"
									style="display: none;">Deselect All</a>
							</div>
							<!-- <div class="col-lg-2 col-md-2 col-sm-2">
							</div> -->
							<div class="col-lg-2 col-md-2 col-sm-2">
								<a href="#" onclick="resubmitTransaction()" role="button"
									class="btn btn-warning" data-toggle="modal">Resubmit</a>
								<!-- <input type="button" class="btn btn-primary" onClick="history.go(0)" value="Refresh"> -->
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="row">
							<table id="configuration" class="display" cellspacing="0"
								width="100%">
								<thead>
									<tr>
										<th class="col-md-1"></th>
										<th class="col-md-1">Service</th>
										<th class="col-md-1">Operation</th>
										<th class="col-md-1">MasterRef</th>
										<th class="col-md-1">EventRef</th>
										<th class="col-md-1">Status</th>
										<th class="col-md-2">ProcessTime</th>
										<th class="col-md-1">Action</th>
									</tr>
								</thead>
								<tbody class="content">
									<%
										for (Object[] sd : transactionLogList) {
									%>
									<tr>
										<td>
											<%
												if ((sd[5].toString().equalsIgnoreCase("FAILED") || sd[5].toString().equalsIgnoreCase("UNAVAILABLE"))) {
											%> <input type="checkbox" name="resub" value='<%=sd[0]%>'
											id='resubmitCheck<%=sd[0]%>' /> <%
 	} else {
 %> <input disabled="true" type="checkbox" name="resub"
											value='<%=sd[0]%>' id='resubmitCheck<%=sd[0]%>' /> <%
 	}
 		String eventRef = "";
 		if (sd[4] == null)
 			eventRef = "N/A";
 		else
 			eventRef = sd[4].toString();
 %>
										</td>
										<td><%=sd[1]%></td>
										<td><%=sd[2]%></td>
										<td><%=sd[3]%></td>
										<td><%=eventRef%></td>
										<td><%=sd[5]%></td>
										<td><%=DateTimeUtil.getStringDateByDateInFormat((Date) sd[6], "yyyy-MM-dd HH:mm:ss")%></td>
										<td><a href="transaction.jsp?id=<%=sd[0]%>"
											class="btn btn-success btn-xs">View</a>
									</tr>
									<%
										}
									%>
								
							</table>
						</div>
					</div>
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
							<label for="" class="col-md-4 control-label"
								style="text-align: left;">Service </label>
							<div class="col-md-8">
								<select name="service" class="form-control" id="service"
									onchange="javascript:dropdownlist(this.options[this.selectedIndex].value);">
									<option value=""><----service----></option>
									<option value="BackOffice" <%=BackOfficeSelected%>>BackOffice</option>
									<%--<option value="SWIFT" <%=SWIFTSelected%>>Swift</option>
									<option value="TI" <%=tiSelected%>>TI</option>--%>
								</select>
								<!-- <input type="text" class="form-control" id="" placeholder=""> -->
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label"
								style="text-align: left;">Operation </label>
							<div class="col-md-8">
								<select name="operation" class="form-control" id="operation">
									<option value=""><---operation---></option>
								</select>
								<!-- <input type="text" class="form-control" id="" placeholder=""> -->
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label"
								style="text-align: left;">Status </label>
							<div class="col-md-8">
								<select name="status" class="form-control" id="status">
									<option value="" selected="selected"><----status-----></option>
									<option value="SUCCEEDED" <%=succeededSelected%>>SUCCEEDED</option>
									<%--<option value="PROCESSED" <%=processedSelected%>>PROCESSED</option>  --%>
									<option value="FAILED" <%=failedSelected%>>FAILED</option>
									<option value="ERROR" <%=errorSelected%>>ERROR</option>
									<option value="SUBMITTED" <%=submittedSelected%>>SUBMITTED</option>
									<option value="RESUBMITTED" <%=resubmittedSelected%>>RESUBMITTED</option>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label">MasterRef </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id=""
									name="masterreference" value="<%=masterReferenceValue%>"
									placeholder="MasterRef">
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-4 control-label">EventRef </label>
							<div class="col-md-8">
								<input type="text" class="form-control" id=""
									name="eventreference" value="<%=eventReferenceValue%>"
									placeholder="EventRef">
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
						<!-- <div class="row command">
							<div
								class="col-lg-offset-4 col-sm-offset-4 col-sm-offset-4 col-lg-3 col-md-3 col-sm-3">
								<button class="btn btn-success btn-sm" type="submit">Apply</button>
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
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>

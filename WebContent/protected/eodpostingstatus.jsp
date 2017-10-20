<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: EOD Posting Logging  
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.DateTimeUtil"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.theme.bob.impl.eodjobs.TIEodPostingBean"%>
<%@page import="com.bs.theme.bob.impl.eodjobs.TIEodPostingAdaptee"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<title>EOD Posting Status</title>
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
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
		addActiveMenu("eodposting");
	});

	$(document)
			.ready(
					function() {
						$('#configuration').dataTable({
							"iDisplayLength" : 50,
							"bFilter" : true,
							"bSortClasses" : false,
							"order" : [ [ 1, "asc" ] ]
						//"order" : [ [ 1, 'asc' ],[4, 'asc'] ]
						});

						var cb = function(start, end, label) {
							$('#reportrange span').html(
									start.format('DD-MMM-YYYY') + ' - '
											+ end.format('DD-MMM-YYYY'));
							$('#fromdaterange')
									.val(start.format('DD-MMM-YYYY'));
							$('#todaterange').val(end.format('DD-MMM-YYYY'));
							//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
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
	<%-- <h1> Start : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1> --%>
	<%-- <h1> Before Query  : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1>--%>
	<%
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
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
		String status = "";
		if (request.getParameter("status") != null && !request.getParameter("status").isEmpty()) {
			status = request.getParameter("status");
		}

		List<TIEodPostingBean> postingList = null;
		TIEodPostingAdaptee obj = new TIEodPostingAdaptee();
		try {
			postingList = obj.getEodPostingDetails(fDate, tDate, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// out.println("PostingList.Size()" + postingList.size());
		// out.println(serviceLogList.size());

		String statusParameter = request.getParameter("status");
		String failedSelected = "";
		String suceededSelected = "";
		String notProcessedSelected = "";
		String InitiatedSelected = "";
		if (statusParameter == null)
			statusParameter = "";
		if (statusParameter.trim().equals("E"))
			failedSelected = "SELECTED";
		if (statusParameter.trim().equals("Y"))
			suceededSelected = "SELECTED";
		if (statusParameter.trim().equals("N"))
			notProcessedSelected = "SELECTED";
		if (statusParameter.trim().equals("I"))
			InitiatedSelected = "SELECTED";
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
				<h3>Eod Posting status</h3>
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
		<!-- <br> -->
		<form id="search" name="search" method="get">
			<div class="row" class="form-horizontal filter-search-layout">
				<!--<div class="border">-->
				<div class="row">

					<div class="col-md-1">
						<label for="" class="col-md-2 control-label">FromDate </label>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="fromdaterange"
							name="fromdaterange" placeholder="DD-MM-YYYY" value="<%=fDate%>">
					</div>
					<div class="col-md-1">
						<label for="" class="col-md-2 control-label">ToDate </label>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" id="todaterange"
							name="todaterange" placeholder="DD-MM-YYYY" value="<%=tDate%>">
					</div>
					<div class="col-md-1">
						<label for="" class="col-md-2 control-label">Status </label>
					</div>
					<div class="col-md-2">
						<select name="status" class="form-control" id="status"
							onchange="javascript:dropdownlist(this.options[this.selectedIndex].value);">
							<option value="" selected="selected"><----service----></option>
							<option value="E" <%=failedSelected%>>E-FAILED</option>
							<option value="Y" <%=suceededSelected%>>Y-SUCCEEDED</option>
							<option value="I" <%=InitiatedSelected%>>I-PROCESSING</option>
							<option value="N" <%=notProcessedSelected%>>N-TRANSMITTED</option>
						</select>
					</div>
					<div class="col-md-2">
						<button class="btn btn-primary btn-sm" type="Submit">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</div>


				</div>
			</div>
		</form>
		<BR>
		<%
			if (postingList != null && postingList.size() == 0) {
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
								<th class="col-md-1">APP_ID</th>
								<th class="col-md-1">TRAN_ID</th>
								<th class="col-md-1">TRAN_DATE</th>
								<th class="col-md-1">MASTER_REF</th>
								<th class="col-md-1">LEG</th>
								<th class="col-md-1">DR/CR</th>
								<th class="col-md-1">TRAN_AMOUNT</th>
								<th class="col-md-1">TRAN_CCY</th>
								<th class="col-md-1">ACCT_NO</th>
								<th class="col-md-1">ACCT_CCY</th>
								<th class="col-md-1">RT_CODE</th>
								<th class="col-md-1">RATE</th>
								<th class="col-md-1">CREATED</th>
								<th class="col-md-1">STATUS</th>
								<th class="col-md-1">PROCESS_DTE</th>
								<th class="col-md-1">FIN_TRAN_ID</th>
								<th class="col-md-1">FIN_TRAN_DTE</th>
								<th class="col-md-1">HDR_ERROR</th>
								<th class="col-md-1">HDR_REMARKS</th>
								<th class="col-md-2">DTL_ERROR_REASON</th>
							</tr>
						</thead>
						<tbody class="content">
							<%
								for (TIEodPostingBean beanObj : postingList) {
							%>
							<tr>
								<td><%=beanObj.getApplication_id()%></td>
								<td><%=beanObj.getAp_tran_id()%></td>
								<%-- <td><%=beanObj.getAp_tran_date()%></td> --%>
								<td><%=DateTimeUtil.getDateTimeChangeFormat(beanObj.getAp_tran_date(), "yyyy-MM-dd", "yyyy-MM-dd")%></td>
								<td><%=beanObj.getAp_tran_particular()%></td>
								<td><%=beanObj.getTran_sr_no()%></td>
								<td><%=beanObj.getDrcr_flag()%></td>
								<td><%=beanObj.getTran_amount()%></td>
								<td><%=beanObj.getTran_ccy()%></td>
								<td><%=beanObj.getFin_acct_id()%></td>
								<td><%=beanObj.getAcct_currency()%></td>
								<td><%=beanObj.getRate_code()%></td>
								<td><%=beanObj.getConversion_rate()%></td>
								<%-- <td><%=beanObj.getCreated_date()%></td> --%>
								<td><%=DateTimeUtil.getDateTimeChangeFormat(beanObj.getCreated_date(), "yyyy-MM-dd", "yyyy-MM-dd")%></td>
								<td><%=beanObj.getHdr_status()%></td>
								<%-- <td><%=beanObj.getHdr_process_date()%></td> --%>
								<%-- <td><%=beanObj.getFin_tran_id()%></td> --%>
								<%-- <td><%=beanObj.getFin_tran_date()%></td> --%>
								<%-- <td><%=beanObj.getError_reason()%></td> --%>
								<%
									if (beanObj.getHdr_process_date() != null) {
								%>
								<td><%=beanObj.getHdr_process_date()%></td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (beanObj.getFin_tran_id() != null) {
								%>
								<td><%=beanObj.getFin_tran_id()%></td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (beanObj.getFin_tran_date() != null) {
								%>
								<td><%=beanObj.getFin_tran_date()%></td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>
								<td><%=beanObj.getHdr_error()%></td>
								<td><%=beanObj.getHdr_remarks()%></td>
								<%
									if (beanObj.getError_reason() != null) {
								%>
								<td><%=beanObj.getError_reason()%></td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>

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
				<div class="col-lg-3 col-md-3 col-sm-3">
					<div class="form-horizontal filter-search-layout" role="form">
						<div class="form-group">
							<label for="" class="col-md-4 control-label"
								style="text-align: left;">Status </label>
							<div class="col-md-8">
								<select name="status" class="form-control" id="status"
									onchange="javascript:dropdownlist(this.options[this.selectedIndex].value);">
									<option value="" selected="selected"><----service----></option>
									<option value="E" <%=failedSelected%>>FAILED</option>
									<option value="Y" <%=suceededSelected%>>SUCCEEDED</option>
									<option value="I" <%=InitiatedSelected%>>PROCESSING</option>
									<option value="N" <%=notProcessedSelected%>>TRANSMITTED</option>
								</select>
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
			</form> --%>
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
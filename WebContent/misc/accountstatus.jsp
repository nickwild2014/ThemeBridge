<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Get account balance.
--%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.theme.bob.adapter.util.AccountEnquiryUtil"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<title>Account Status</title>
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						removeAllActiveMenu();
						addActiveMenu("misc");
						$('#configuration')
								.dataTable(
										{
											"sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
											"iDisplayLength" : 50,
											"bFilter" : false,
											"bSortClasses" : false,
											"bSort" : true,
											"columnDefs" : [ {
												//"targets" : [ 0 ],
												"visible" : false,
												"searchable" : false
											} ],
											"order" : [ [ 0, "asc" ] ]
										});

						var cb = function(start, end, label) {
							console.log(start.toISOString(), end.toISOString(),
									label);
							$('#reportrange span').html(
									start.format('MMMM D, YYYY') + ' - '
											+ end.format('MMMM D, YYYY'));
							//alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
						}

						var optionSet1 = {
							startDate : moment().subtract('days', 29),
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

	<%
		AccountEnquiryUtil aC = new AccountEnquiryUtil();
		Map<String, String> respMapList = null;
		String accountCIF = "";
		accountCIF = request.getParameter("accountCIF");
		// out.println("accountCIF1 : " + accountCIF);
		if (accountCIF != "" && accountCIF != null) {
			//out.println("accountCIF2 : " + accountCIF);
			respMapList = aC.accountStatusCheck(accountCIF);
		} else {
			accountCIF = "";
		}

		// out.println("accountCIF3 : " + accountCIF);
	%>

	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<div class="container">

		<div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>Account status</h3>
			</div>
		</div>

		<br> <br>

		<form method="POST" action="">
			<div class="form-group">
				<label for="" class="col-md-2 control-label">Account Number</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="accountCIF"
						name="accountCIF" value="<%=accountCIF%>"
						placeholder="account number">
				</div>
			</div>
			<div class="col-md-3">
				<button class="btn btn-primary btn-sm" type="Submit">
					<span class="glyphicon glyphicon-search"></span> Search
				</button>
			</div>
			<br> <br> <br> <br>
			<%
				if (respMapList != null) {
			%>

			<%
				if (respMapList.get("status").equals("FAILED")) {
			%>
			<div class="row">
				<div class="alert alert-danger"><%=respMapList%></div>
			</div>
			<%
				} else if (respMapList.get("status").equals("SUCCEEDED")) {
			%>
			<div class="row">
				<div class="alert alert-success"><%=respMapList%></div>
			</div>
			<!--  -->

			<%-- <div class="col-md-9">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1" style="color: green">Acc Number</th>
								<th class="col-md-1" style="color: green">Status</th>
								<th class="col-md-1" style="color: green">Amount</th>
								<th class="col-md-2" style="color: green">Currency</th>
								<th class="col-md-1" style="color: green">ErrorCode</th>
								<th class="col-md-1" style="color: green">ErrorDesc</th>

							</tr>
						</thead>
						<tbody class="content">
							<tr>
								<td><%=respMapList.get("accountNumber")%></td>
								<td><%=respMapList.get("status")%></td>
								<td><%=respMapList.get("bankRespClearBalance")%></td>
								<td><%=respMapList.get("Currency")%></td>
								<td><%=respMapList.get("errorCode")%></td>
								<td><%=respMapList.get("errorMsg")%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div> --%>

			<!--  -->
			<%
				}
			%>

			<%
				}
			%>
		</form>
	</div>
</body>
</html>
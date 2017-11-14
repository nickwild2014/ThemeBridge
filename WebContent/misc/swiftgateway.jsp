<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: SWIFT/SFMS IN/OUT Gateway testing
--%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.listener.mq.MQMessageManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Push swift message MQ</title>
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
		// MQMessageManager mqmanagerObj = new MQMessageManager();
		String mqName = "";
		String swiftMessage = "";
		//String swiftOutJndiName = "";
		Boolean swiftoutQueuePostingStatus = false;
		if (request.getParameter("swiftMessage") != null) {
			mqName = request.getParameter("mqName");
			swiftMessage = request.getParameter("swiftMessage");
			//swiftOutJndiName = request.getParameter("swiftOutJndiName");
			swiftoutQueuePostingStatus = MQMessageManager.pushMqMessage("", mqName, swiftMessage);
		}
	%>

	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<div class="container">

		<div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>Push Swift Message - MQ</h3>
			</div>
		</div>

		<form method="POST" action="">

			<%-- <div class="form-group">
				<label for="" class="col-md-2 control-label">JNDI Name</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="swiftOutJndiName"
						name="swiftOutJndiName" value="<%=swiftOutJndiName%>"
						placeholder="JNDI-name" required>
				</div>
			</div> --%>

			<div class="form-group">
				<label for="" class="col-md-1 control-label">MQ Name</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="mqName" name="mqName"
						value="<%=mqName%>" placeholder="MQ-Name" required>
				</div>
			</div>

			<div class="col-md-1">
				<button class="btn btn-primary btn-sm" type="Submit">
					<span class="glyphicon"></span> Submit
				</button>
			</div>

			<div class="col-md-1">
				<button class="btn btn-danger btn-sm" type="reset">
					<span class="glyphicon"></span> Clear
				</button>
			</div>

			<br> <br> <br>
			<div class="form-group">
				<label for="" class="col-md-1 control-label">SwiftMessage </label>
				<textarea class="form-control" id="swiftMessage" name="swiftMessage"
					cols="30" rows="14" spellcheck="false" placeholder="SWIFT MESSAGE"
					required><%=swiftMessage%></textarea>
				<div class="col-md-3"></div>
			</div>
			<br>

			<%
				if (swiftMessage != null && !swiftMessage.isEmpty()) {
			%>

			<%
				if (swiftoutQueuePostingStatus) {
			%>
			<div class="row">
				<div class="alert alert-success">
					Pushing Message into MQ Succeeded
					<%=swiftoutQueuePostingStatus%></div>
			</div>
			<%
				} else if (!swiftoutQueuePostingStatus) {
			%>
			<div class="row">
				<div class="alert alert-danger">
					Pushing Message into MQ Failure
					<%=swiftoutQueuePostingStatus%></div>
			</div>
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
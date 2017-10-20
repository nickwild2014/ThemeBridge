<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Limit tree view search  
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.theme.bob.adapter.util.TIAccountEnquiryUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>AccountBalanceCheck</title>
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
		addActiveMenu("timenu");
	});
	function goBack() {
		window.history.back();
	};
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#configuration')
								.dataTable(
										{
											"sDom" : "<'row'<'col-xs-6'><'col-xs-6'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
											"iDisplayLength" : 50,
											"bFilter" : false,
											"bSortClasses" : false,
											"order" : [ [ 1, "asc" ] ]
										});

					});
</script>
</head>
<body>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->

	<%
		TIAccountEnquiryUtil aC = new TIAccountEnquiryUtil();
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
	%>
	<div>
		<a name="top"></a>
	</div>
	<div class="col-md-12">
		<jsp:include page="primarylimitmenu.jsp" />
		<%-- <jsp:include page="primarymenubar.jsp" /> --%>
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>
	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Account status</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<%-- 	<jsp:include page="timezone.jsp" /> --%>
			</div>
		</div>

		<!-- start -->
		<form id="search">
			<div class="row" class="form-horizontal filter-search-layout">

				<div class="col-md-2">
					<label for="" class="col-md-12 control-label">Account
						Number </label>
				</div>

				<div class="col-md-2">
					<input type="text" class="form-control" id="accountCIF"
						name="accountCIF" value="<%=accountCIF%>"
						placeholder="Account Number">
				</div>

				<div class="col-md-2">
					<button class="btn btn-success btn-sm" type="Submit">Search</button>
				</div>
			</div>
		</form>
		<br>
		<div class="row">
			<legend></legend>
		</div>
		<!-- stop -->
		<%-- 	<%
		if (respMapList.get("status").equals("FAILED")) {
		%>
		<div class="row">
			<div class="alert alert-danger"><%=respMapList%></div>
		</div>
		<%
			}
		%> --%>
		<div class="row">
			<!-- <div class="col-md-9"> -->
			<div class="col-md-12">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<tbody class="content">
							<%
								if (respMapList != null) {
									if (respMapList.get("status").contains("SUCCEEDED")) {
							%>
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">AccountNumber: <%=respMapList.get("accountNumber")%></strong></td>
							</tr>

							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Account Status: <%=respMapList.get("status")%></strong></td>
							</tr>

							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Bank Effective Balance: <%=respMapList.get("bankRespEffectiveBalance")%></strong></td>
							</tr>
							
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Sanction Limit: <%=respMapList.get("sanctionLimit")%></strong></td>
							</tr>
							
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Drawing Power: <%=respMapList.get("drawingPower")%></strong></td>
							</tr>
							
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">lien Amount: <%=respMapList.get("lien")%></strong></td>
							</tr>


							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Currency: <%=respMapList.get("currency")%></strong></td>
							</tr>
							<%
								}

									if (respMapList.get("status").contains("FAILED")) {
							%>
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">AccountNumber: <%=respMapList.get("accountNumber")%></strong></td>
							</tr>

							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">Account Status: <%=respMapList.get("status")%></strong></td>
							</tr>
							<tr>
								<td class="col-md-1"
									style="padding-left: 5px; padding-bottom: 3px;"><strong
									style="font-size: 17px;">ErrorMsg: <%=respMapList.get("errorMsg")%></strong></td>
							</tr>
							<%
								}
								}
							%>

						</tbody>
					</table>
				</div>
			</div>		
		</div>

	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>

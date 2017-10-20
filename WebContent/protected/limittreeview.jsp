<%-- <%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Limit tree view search  

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Staticdatalog"%>
<%@page import="com.bs.themebridge.entity.adapter.StaticdatalogAdapter"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<%@page
	import="com.bs.theme.bob.adapter.util.LimitFacilitiesTreeViewBean"%>
<%@page
	import="com.bs.theme.bob.adapter.adaptee.LimitFacilitiesTreeViewAdaptee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>LimitTreeView</title>
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
		String customerNumberValue = "";
		if (request.getParameter("customerNumber") != null && !request.getParameter("customerNumber").isEmpty()) {
			customerNumberValue = request.getParameter("customerNumber");
		}
		List<LimitFacilitiesTreeViewBean> bankrespMapList = null;
		//out.println("staticLogList.size()"+staticLogList.size());
		LimitFacilitiesTreeViewAdaptee obj = new LimitFacilitiesTreeViewAdaptee();
		try {
			//bankrespMapList = obj.process("6500073");
			if (request.getParameter("customerNumber") != null
					&& !request.getParameter("customerNumber").isEmpty()) {
				bankrespMapList = obj.process(request.getParameter("customerNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<div>
		<a name="top"></a>
	</div>
	<div class="col-md-12">
		<jsp:include page="primarylimitmenu.jsp" />
		<jsp:include page="primarymenubar.jsp" />
		<jsp:include page="include_header.jsp" />
	</div>
	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Limit Facilities Tree view</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
					<jsp:include page="timezone.jsp" />
			</div>
		</div>

		<!-- start -->
		<form id="search">
			<div class="row" class="form-horizontal filter-search-layout">

				<div class="col-md-2">
					<label for="" class="col-md-12 control-label">Customer CRN
					</label>
				</div>

				<div class="col-md-2">
					<input type="text" class="form-control" id="customerNumber"
						name="customerNumber" value="<%=customerNumberValue%>"
						placeholder="Customer Number">
				</div>

				<div class="col-md-2">
					<button class="btn btn-success btn-sm" type="Submit">Search
						Facilities</button>
				</div>
			</div>
		</form>
		<br>
		<div class="row">
			<legend></legend>
		</div>
		<!-- stop -->
		<%
			if (bankrespMapList != null && bankrespMapList.get(0).getCustomerMnemonic() == null) {
		%>
		<div class="row">
			<div class="alert alert-danger"><%=bankrespMapList.get(0).getFinacleErrorResponse()%></div>
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
								<th class="col-md-1" style="color: green">CustomerNumber</th>
								<th class="col-md-1" style="color: green">LimitId</th>
								<th class="col-md-1" style="color: green">Currency</th>
								<th class="col-md-1" style="color: green">ParentLimitID</th>
								<th class="col-md-1" style="color: green">ExpiryDate</th>
								<th class="col-md-1" style="color: green">RevolvingFlag</th>
								<th class="col-md-1" style="color: green">SanctionedLimit</th>
								<th class="col-md-1" style="color: green">UtilizedLimit</th>
								<th class="col-md-1" style="color: green">Liability</th>
								<th class="col-md-1" style="color: green">IsChildNode</th>
								<!-- <th class="col-md-1" style="color: green">CIF</th> -->
								<th class="col-md-1" style="color: green">AllowedCurrency</th>
								<th class="col-md-1" style="color: green">AllowedProduct</th>
							</tr>
						</thead>
						<tbody class="content">
							<%
								if (bankrespMapList != null && bankrespMapList.get(0).getCustomerMnemonic() != null) {
									for (LimitFacilitiesTreeViewBean object : bankrespMapList) {
										//for (Object[] sd : staticLogList) {
							%>
							<tr>
								<td><%=object.getCustomerMnemonic()%></td>
								<td><%=object.getLimitId()%></td>
								<td><%=object.getCrncyCode()%></td>
								<td><%=object.getParentLimitId()%></td>
								<td><%=object.getExpiryDateFormatted()%></td>
								<td><%=object.getRevolvingFlg()%></td>
								<td><%=object.getSanctionLimit()%></td>
								<td><%=object.getUtilizedLimit()%></td>
								<td><%=object.getLiability()%></td>
								<td><%=object.getChildNode()%></td>
								<td><%=object.getCif()%></td>
								<td><%=object.getAllowedCurrency()%></td>
								<td><%=object.getAllowedProduct()%></td>


								<td><%=ThemeBridgeUtil.getDateInFormat((Date) sd[4],
						"yyyy-MM-dd HH:mm:ss")%></td>

							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<!-- -----------------------search container start------------------------------------ -->			
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
 --%> --%>
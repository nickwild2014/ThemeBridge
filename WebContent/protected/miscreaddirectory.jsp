<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra implementation
  - Description: Get list of files in a directory
  --%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page
	import="com.bs.themebridge.entity.servlet.util.DirectoryReaderImpl"%>
<%@page import="com.bs.themebridge.entity.model.DirectoryReaderModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Service Data</title>
<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra implementation
  - Description: Get list of files in a directory
  --%>
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
		$('#configuration').dataTable({
			"sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
			"iDisplayLength" : 50,
			"bFilter" : false,
			"bSortClasses" : false,
			"order" : [ [ 3, "desc" ] ]
		});
	});
</script>
</head>
<body>
	<%
		String error = "";
		String directoryPath = "";
		//List<File> dirFileList = null;
		List<DirectoryReaderModel> dirFileList = null;
		// check input is not ull or empty
		if (request.getParameter("dirpath") != null) {
			directoryPath = request.getParameter("dirpath");
			// Check folder exist or not
			if (DirectoryReaderImpl.directoryExist(directoryPath)) {
				dirFileList = DirectoryReaderImpl.readDirectory(directoryPath);
				// check resultset is not empty
				if (dirFileList == null || dirFileList.size() == 0) {
					error = "Directory is empty!";
				}
			} else {
				// out.print("\tElse directoryPath : " + directoryPath);
				error = "Invalid directory!";
			}
			// out.print("\tElse directoryPath : " + dirFileList);
		}
	%>
	<div>
		<a name="top"></a>
	</div>
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<jsp:include page="include_header.jsp" />
	</div>
	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-8 col-md-8 col-sm-8">
				<h3>Directory Analysis</h3>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-offset-1 col-lg-10">
				<div class="row">
					<form method="POST" action="">
						<div class="col-sm-2">
							<label>Directory Path</label>
						</div>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="dirpath"
								id="dirpath" placeholder="AppServerPath" required
								value="<%=directoryPath%>" />
						</div>
						<div class="col-sm-2">
							<input class="btn btn-primary" type="submit" value="Process" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-offset-1 col-lg-10">
				<div class="row">
					<%
						if (!error.equals("")) {
					%>
					<div class="row">
						<div class="alert alert-danger"><%=error%></div>
					</div>
					<br>
					<%
						}
					%>
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1">Type</th>
								<th class="col-md-2">FileName</th>
								<th class="col-md-1">Size</th>
								<th class="col-md-2">CreationTime</th>
								<th class="col-md-3">FilePath</th>
							</tr>
						</thead>
						<%
							//out.println("Table body");
							if (dirFileList != null) {
						%>
						<tbody class="content">
							<%
								for (DirectoryReaderModel attrlist : dirFileList) {
										// convert btwn long time to regular java.util format
										SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										String lastModified = sdf1.format(attrlist.getLastModifiedTime());
							%>
							<tr>
								<td><%=attrlist.getIsDirectory()%></td>
								<td><%=attrlist.getFileName()%></td>
								<td><%=attrlist.getFilesize() / 1024%> KB</td>
								<%-- <td><%=attrlist.getLastModifiedTime()%></td> --%>
								<td><%=lastModified%></td>
								<td><%=attrlist.getFilePath()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
						<%
							}
						%>
					</table>
					<div>
						<a href="#top">Back to top of page</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>
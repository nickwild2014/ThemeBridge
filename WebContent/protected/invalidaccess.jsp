<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Invalid access error page  
--%>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="TIPlus Interface">
<meta name="author" content="Themebridge">
<title>Invalid Access</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/fgbbrowserlogo.png">
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../css/font-awesome.css" />
<link type="text/css" rel="stylesheet" href="../css/customized.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css">

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-md-12">
		<%-- <jsp:include page="include_header.jsp" /> --%>
		<jsp:include page="primarytimenubar.jsp" />
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<h2>
						<i class="fa fa-user-times fa-lg"></i><span> You have no
							privilege to view this pages. Click here to go back to
							application </span> <a href="/tiplus2-global.jsp">TIPlus</a>
					</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>
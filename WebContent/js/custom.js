/**
 * JS Constant
 */
var TB_DOMAIN_NAME = window.location.protocol + '//' + window.location.hostname
		+ ':' + window.location.port;
var TB_CUSTOMSEARCH_SERVLET_PATH = '/ThemeBridge/customsearch?';
var TB_SERVICE_SERVLET_PATH = '/ThemeBridge/servicecustom?';
var TB_SETTINGS_SERVLET_PATH = '/ThemeBridge/SettingsUpdateServlet?';
var TB_ATT_SERVLET_PATH = '/ThemeBridge/availticketdownload?';

/**
 * Checks value is empty
 * 
 * @param value
 * @returns boolean
 */
function isEmpty(value) {
	return (value === undefined || value == null || value.length <= 0) ? true
			: false;
}

/**
 * Checks value is valid
 * 
 * @param value
 * @returns boolean
 */
function isValid(value) {
	return (value != null && value.length >= 1) ? true : false;
}

function updateSettings(id) {

	// alert('Settings update !'+ id );
	var newValue = $("#bp_" + id).val();
	var ajaxURL = TB_DOMAIN_NAME + TB_SETTINGS_SERVLET_PATH + "id=" + id
			+ "&value=" + newValue;
	$.ajax({
		type : 'POST',
		url : ajaxURL,
		async : false,
		contentType : "text/plain",
		success : function(aData) {
			if (aData = 'true') {
				alert('Updated successfully!');
			} else if (aData = 'false') {
				alert('Updation failed');
			}
			$("#bp_" + id).val(value);
		},
		error : function(aData) {
			alert('Updated successfully!');
			// alert("Failed with error");
			// $("#alertText").html("System unavailable");
			// $("#alertMessage").show();
		}
	});

}

function getAvailTicket(mRef, eRef, eSerial) {
	var masterref = $('#masterref').val();
	var eventcode = $('#eventcode').val();
	var eventserial = $('#eventserial').val();
	var ajaxURL = TB_ATT_SERVLET_PATH + "masterref=" + masterref
			+ "&eventcode=" + eventcode + "&eventserial=" + eventserial;
	var fdDataTable = $('#documentEnquiryTable').dataTable();
	fdDataTable.fnClearTable();
	$
			.ajax({
				type : 'POST',
				url : ajaxURL,
				async : false,
				contentType : "application/json",
				success : function(data) {
					$
							.each(
									data,
									function(index, aData) {
										alert("Success2");
										alert(aData);
										alert("Success2");
										if (aData.COLLID != null) {
											fdDataTable
													.fnAddData([
															aData.DOCID,
															aData.DMSID,
															aData.DESCRIPTION,
															'<a	href="/ThemeBridge/retrieveDocument?docId='
																	+ aData.DOCID
																	+ '&dmsId='
																	+ aData.DMSID
																	+ '" class="btn btn-success btn-xs">Download Pdf </a>' ]);
											$("#alertMessage").hide();
										} else {
											var errCode = aData.ERRCODE;
											var errDesc = aData.ERRDESC;
											$("#alertText").html(
													errCode + " - " + errDesc);
											$("#alertMessage").show();
										}
									});
					$("#collLoaderDiv").hide();
				},
				error : function(data) {
					$("#alertText").html("System unavailable");
					$("#alertMessage").show();
					// $("#collLoaderDiv").hide();
				}
			});

}

function getCustomerAccount() {
	var customer = $("#customer").val();
	var ajaxURL = TB_CUSTOMSEARCH_SERVLET_PATH
			+ "service=accountsearch&customerid=" + customer;
	$.ajax({
		type : 'GET',
		url : ajaxURL,
		async : false,
		contentType : "application/json",
		success : function(data) {
			var optionVal = '';
			var index = 0;
			$.each(data, function(index, aData) {
				$.each(aData, function(key, value) {
					if (key == "BO_ACCTNO" && index == 0) {
						optionVal += '<option value="' + value + '" select>'
								+ value + '</option>';
						index++;
					} else if (key == "BO_ACCTNO") {
						optionVal += '<option value="' + value + '">' + value
								+ '</option>';
						index++;
					}
				});
			});
			$("#account").html(optionVal);
		},
		error : function(data) {
			alert("Error");
		}
	});
}

function getSignCustomerAccount() {
	var customer = $("#signCustomer").val();
	var ajaxURL = TB_CUSTOMSEARCH_SERVLET_PATH
			+ "service=accountsearch&customerid=" + customer;
	$("#loaderDiv").show();
	$.ajax({
		type : 'GET',
		url : ajaxURL,
		async : false,
		contentType : "application/json",
		success : function(data) {
			var optionVal = '';
			var index = 0;
			$.each(data, function(index, aData) {
				$.each(aData, function(key, value) {
					if (key == "BO_ACCTNO" && index == 0) {
						optionVal += '<option value="' + value
								+ '" selected="selected">' + value
								+ '</option>';
						index++;
					} else if (key == "BO_ACCTNO") {
						optionVal += '<option value="' + value + '">' + value
								+ '</option>';
						index++;
					}
				});
			});
			$("#signAccount").html(optionVal);
			$("#alertMessage").hide();
		},
		error : function(data) {
			$("#alertText").html("System unavailable");
			$("#alertMessage").show();
		}
	});
	$("#loaderDiv").hide();
}

function getCustomerFD() {
	$("#fetchLoaderDiv").show();
	var customer = $("#customer").val();
	var account = "";
	var ajaxURL = TB_CUSTOMSEARCH_SERVLET_PATH + "service=fdsearch&customerid="
			+ customer + "&accountnumber=" + account;
	var fdDataTable = $('#fdDataTable').dataTable();
	fdDataTable.fnClearTable();
	$.ajax({
		type : 'GET',
		url : ajaxURL,
		async : false,
		contentType : "application/json",
		success : function(data) {
			$.each(data, function(index, aData) {
				if (aData.FDID != null) {
					var id = aData.FDID;
					var acctNumber = "-";
					if (aData.DEBTACCNUMBER != null
							&& aData.DEBTACCNUMBER != "") {
						acctNumber = aData.DEBTACCNUMBER;
					}
					var amount = aData.AMOUNT;
					var amtCcy = aData.AMOUNTCURRENCY;
					fdDataTable.fnAddData([ id, acctNumber, amtCcy, amount ]);
					$("#alertMessage").hide();
				} else {
					var errCode = aData.ERRCODE;
					var errDesc = aData.ERRDESC;
					$("#alertText").html(errCode + " - " + errDesc);
					$("#alertMessage").show();
				}
			});
			$("#fetchLoaderDiv").hide();
		},
		error : function(data) {
			$("#alertText").html("System unavailable");
			$("#alertMessage").show();
			$("#fetchLoaderDiv").hide();
		}
	});
}

function getAccountSignature() {
	// alert("signature call happens ....");
	$("#signLoaderDiv").show();
	var customer = $("#signCustomer").val();
	var account = $("#signAccount>option:selected").text();
	var ajaxURL = TB_CUSTOMSEARCH_SERVLET_PATH
			+ "service=fetchsignature&customerid=" + customer
			+ "&accountnumber=" + account;
	var domainname = document.domain;
	var concaturl = "https://" + domainname + ajaxURL;

	var myPdf = new PDFObject({
		// url : "images/b.pdf",
		url : concaturl,
		id : "SignaturePDF",
		width : "800px",
		height : "400px",
		pdfOpenParams : {
			toolbar : '0',
			statusbar : '0',
			messages : '0',
			navpanes : '0'
		}
	}).embed("showSignature");
	// myPdf.embed("showSignature");
	$("#signLoaderDiv").hide();
}

function getCollateralEnquiry() {
	var customer = $("#customer").val();
	var ajaxURL = TB_CUSTOMSEARCH_SERVLET_PATH
			+ "service=collateralsearch&customerid=" + customer;
	var fdDataTable = $('#collateralEnquiryTable').dataTable();
	fdDataTable.fnClearTable();
	$("#collLoaderDiv").show();
	$.ajax({
		type : 'GET',
		url : ajaxURL,
		async : false,
		contentType : "application/json",
		success : function(data) {
			$.each(data, function(index, aData) {
				if (aData.COLLID != null) {
					fdDataTable.fnAddData([ aData.COLLID, aData.MATUREDATE,
							aData.EXECVALUE, aData.CURRVALUE ]);
					$("#alertMessage").hide();
				} else {
					var errCode = aData.ERRCODE;
					var errDesc = aData.ERRDESC;
					$("#alertText").html(errCode + " - " + errDesc);
					$("#alertMessage").show();
				}
			});
			$("#collLoaderDiv").hide();
		},
		error : function(data) {
			$("#alertText").html("System unavailable");
			$("#alertMessage").show();
			$("#collLoaderDiv").hide();
		}
	});
}

function reSendPosting(id) {
	// var id = $("#transactionId").val();
	var ajaxURL = TB_SERVICE_SERVLET_PATH + "service=resendposting&id=" + id;
	$.ajax({
		type : 'POST',
		url : ajaxURL,
		async : false,
		contentType : "application/json",
		success : function(data) {

		},
		error : function(data) {
			alert("Error");
		}
	});
}

function addActiveMenu(id) {
	$("#" + id).addClass("active");
}

function removeActiveMenu(id) {
	$("#" + id).removeClass("active");
}

function removeAllActiveMenu() {
	removeActiveMenu("index");
	removeActiveMenu("settings");
	removeActiveMenu("staticdata");
	removeActiveMenu("servicelog");
	removeActiveMenu("transactionlog");
	removeActiveMenu("lookup");
	removeActiveMenu("misc");
}

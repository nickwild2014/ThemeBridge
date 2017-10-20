package com.misys.tiplus2.apps.ti.service.messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "InvoiceUpload", propOrder = {
		    "ProgramId",
		    "CLFAccountNo",
		    "DealerCode",
		    "InvoiceNumber",
		    "InvoiceDate",
		    "InvoiceAmount",
		    "DueDate",
		    "Product"		    
		})
	public class InvoiceUpload{
		
		@XmlElement(name="ProgramId")
		String ProgramId;
		@XmlElement(name="CLFAccountNo")
		String CLFAccountNo;
		@XmlElement(name="DealerCode")
		String DealerCode;
		@XmlElement(name="InvoiceNumber")
		String InvoiceNumber;
		@XmlElement(name="InvoiceDate")
		String InvoiceDate;
		@XmlElement(name="InvoiceAmount")
		String InvoiceAmount;
		@XmlElement(name="DueDate")
		String DueDate;
		@XmlElement(name="Product")
		String Product;
		
	

		public String getProgramId() {
			return ProgramId;
		}
		
		public void setProgramId(String programId) {
			ProgramId = programId;
		}

		public String getCLFAccountNo() {
			return CLFAccountNo;
		}
		
		public void setCLFAccountNo(String cLFAccountNo) {
			CLFAccountNo = cLFAccountNo;
		}

		public String getDealerCode() {
			return DealerCode;
		}
		
		public void setDealerCode(String dealerCode) {
			DealerCode = dealerCode;
		}

		public String getInvoiceNumber() {
			return InvoiceNumber;
		}
		
		public void setInvoiceNumber(String invoiceNumber) {
			InvoiceNumber = invoiceNumber;
		}

		public String getInvoiceDate() {
			return InvoiceDate;
		}
		
		public void setInvoiceDate(String invoiceDate) {
			InvoiceDate = invoiceDate;
		}

		public String getInvoiceAmount() {
			return InvoiceAmount;
		}
		
		public void setInvoiceAmount(String invoiceAmount) {
			InvoiceAmount = invoiceAmount;
		}

		public String getDueDate() {
			return DueDate;
		}
		
		public void setDueDate(String dueDate) {
			DueDate = dueDate;
		}

		public String getProduct() {
			return Product;
		}
		
		public void setProduct(String product) {
			Product = product;
		}
		
	}
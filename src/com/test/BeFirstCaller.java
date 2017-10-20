package com.test;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.bs.themebridge.server.gateway.in.BridgeGateway;
import com.bs.themebridge.util.ThemeBridgeUtil;

public class BeFirstCaller {

	public static void main(String args[])
			throws ClassNotFoundException, ParserConfigurationException, SAXException, IOException, JAXBException {

		BridgeGateway bg = new BridgeGateway();
		String inputXML = "";
		String result = "";
		try {
			/***** AvailBal ********/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample_2016-07-16\\Account.AvailBal.xml");
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\Account.AvailBal3-NotAvail.xml");

			/******** BackofficeBatch & Exposure ********/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample_2016-07-16\\BackOffice.Batch.Posting.Exposure.only.xml");

			/******** EODPosting ********/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\BackOffice.Batch.Posting.xml");

			/****** LimitExposure *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\BackOffice.Batch.Posting.Exposure.xml");

			/****** GatewayDocuments *******/
			// inputXML = ThemeBridgeUtil.readFile("D:\\_Prasath\\task\\task
			// watchlist\\GATEWAY.NCIFBGIS03.XML");
			// inputXML = ThemeBridgeUtil.readFile("D:\\_Prasath\\task\\task
			// watchlist\\GATEWAY.NCIFBGIS01.XML");

			/****** LimitFacilities *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\Limit.Facilities-Failure.xml");//
			// Limit.Facilities-Failure.xml//Limit.Facilities.xml

			/****** LimitReservation *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\Limit.Reservations-Failure.xml");

			/****** WatchList *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample_2016-07-16\\GATEWAY.NCIF-WATCHLIST-01.xml");

			/****** WatchList *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\GATEWAY.SMS01.xml");

			/****** LimitReservation *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample_2016-07-16\\Limit.ReservationsReversal-F.xml");

			/****** FxOptions / LivRateTaking ******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\bsit\\TI-Sample-Otherbanks\\tirequest_sample\\BusinessSupport.FXOptionsSearch-REQUEST.xml");

			/****** FxOptions / LivRateTaking ******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\TI_sample_messages_req_res\\BusinessSupport.FXRateService-REQUEST.xml");

			/***** FxContracts / FxUtiliztion *******/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\bsit\\TI-Sample-Otherbanks\\tirequest_sample\\BusinessSupport.FXContracts.xml");

			/***** RTGS/NEFT *******/
			// inputXML =
			// ThemeBridgeUtil.readFile("D:\\_Prasath\\Filezilla\\new76.xml");

			/***** SwiftOut ******/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\Filezilla\\TI-Sample-Otherbanks\\tirequest_sample\\SWIFT.SwiftOut3.xml");

			/******* Health.Check *******/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\Kotak
			// Themebridge\\TI-Sample-Otherbanks\\tirequest_sample\\Health.Check.xml");

			/**************** RET *************/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\task\\task
			// RET\\BusinessSupport.fxrATEsERVICE.test.xml");

			/**************** FD Lien Add *************/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\Filezilla\\task\\task
			// LienMark\\LienMark_TIReq2_success.xml");

			/**************** FD Lien Mod *************/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\Filezilla\\task\\task
			// LienRelease\\LienReleas_TIReq2_success.xml");

			/**************** FD Lien Mod *************/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\Filezilla\\task\\task FD Reversal
			// Gateway\\FDBGOUTSTD-01.xml");

			/************* Limit Node Enquiry ***********/
			// inputXML = ThemeBridgeUtil.readFile(
			// "C:\\Users\\KXT51472\\Desktop\\Limit Node
			// Enquiry\\01.TI.Request.Limit.NodeFacilities.xml");

			/************ e-BG **************/
			// inputXML =
			// ThemeBridgeUtil.readFile("D:\\_Prasath\\Filezilla\\task\\task-sfms-e-BG\\e-BG760Test2.xml");

			/************ ELCPYR **************/
			// inputXML = ThemeBridgeUtil
			// .readFile("D:\\_Prasath\\Filezilla\\task\\task
			// GatewayLCBD\\Gateway.tfelcpyr.tirequest-2.xml");

			/************ EBIFN760CV **************/
			// inputXML = ThemeBridgeUtil.readFile(
			// "D:\\_Prasath\\Filezilla\\task\\task
			// 760COV\\TIRequest.IFN760COV-0958IGF160100168-corrections2.xml");

			/************ EBIFN760CV **************/
			// inputXML =
			// ThemeBridgeUtil.readFile("C:\\Users\\KXT51472\\Desktop\\EXTCUST.XML");

			/************ EBIFN760CV **************/
			// inputXML =
			// ThemeBridgeUtil.readFile("C:\\Users\\KXT51472\\Desktop\\LCBD.error.xml");

			/************ edpms **************/
			inputXML = ThemeBridgeUtil.readFile("C:\\Users\\KXT51472\\Desktop\\edpmsirm.XML");

			result = bg.process(inputXML);

		} catch (Exception e) {
			// logger.error("Service router exceptions! " + e.getMessage());
			e.printStackTrace();
		}

	}
}

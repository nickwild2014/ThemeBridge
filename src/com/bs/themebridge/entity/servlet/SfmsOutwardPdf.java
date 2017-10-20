package com.bs.themebridge.entity.servlet;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.sfms.SfmsAdviceHandler;
import com.bs.theme.bob.adapter.sfms.SfmsAdvicePDFCreator;
import com.bs.themebridge.entity.adapter.ServicelogAdapter;
import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.util.DatabaseUtility;
import com.bs.themebridge.util.SwiftFriendlyFormateAdaptee;

@WebServlet("/SfmsOutwardPdf")
public class SfmsOutwardPdf extends HttpServlet {

	private final static Logger logger = Logger.getLogger(SfmsOutwardPdf.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("SfmsId");
		ServicelogAdapter sda = new ServicelogAdapter();

		Servicelog tl = sda.getKeyProperty(id);
		String bankRequest = tl.getBankrequest();
		String sfmsMessage = removeUMACTagProcess(bankRequest);
		String msgType = getSFMSInMsgType(sfmsMessage);
		String printerFrndlySfmsMsg = null;
		try {
			printerFrndlySfmsMsg = SwiftFriendlyFormateAdaptee.getFriendlySWIFT(sfmsMessage, msgType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (printerFrndlySfmsMsg == null) {
			printerFrndlySfmsMsg = sfmsMessage;
		}
		// logger.debug("Friendly formatted : \n" + printerFrndlyMsg);
		logger.debug("Friendly formatted (:) ");

		/** Remove Header **/
		String messageBodyWithoutHearder = removeSFMSHeader(printerFrndlySfmsMsg, msgType);
		logger.debug("Removed Header (:) ");

		/** Message title **/
		String messageTitle = getMessageTitle(msgType);

		/** SFMS IFSC address **/
		String sfmsIFSCAddr = SfmsAdviceHandler.getSfmsIFSCAddrDetails(sfmsMessage, msgType);

		/** PDF Doc generator **/
		byte[] pdfByteArray = SfmsAdvicePDFCreator.pdfDocumentCreator(msgType, messageTitle, sfmsIFSCAddr,
				messageBodyWithoutHearder);
		logger.debug("PdfByteArray (:) " + pdfByteArray);

		System.out.println("PDFBytes " + pdfByteArray.length);
		response.setContentType("application/pdf");
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// "abc.pdf");
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// "test.pdf");
		// response.getOutputStream().write(pdfBytes);
		BufferedOutputStream fos1 = new BufferedOutputStream(response.getOutputStream());
		fos1.write(pdfByteArray);
		fos1.flush();
		fos1.close();
		// response.sendRedirect(request.getContextPath()+"/SFMSInwardservice.jsp?id="+Test2.id);

	}

	private String removeUMACTagProcess(String sfmsIncomingQueueMessage) {
		// logger.debug("Milestone RemoveUMACTageProcess started..!");
		String formatterMsg = "";
		try {
			int indexCode = sfmsIncomingQueueMessage.indexOf("{UMAC:");
			// logger.debug("indexCode : " + indexCode);
			if (indexCode > 0) {
				String UMACvale = sfmsIncomingQueueMessage.substring(indexCode);
				int index1 = UMACvale.indexOf("}");
				UMACvale = sfmsIncomingQueueMessage.substring(0, indexCode);
				formatterMsg = UMACvale;
				logger.debug("UMAC digital signature removed");
			} else {
				formatterMsg = sfmsIncomingQueueMessage;
				logger.debug("UMAC digital signature not available");
			}
		} catch (Exception e) {
			logger.error("Exception..! " + e.getMessage());
			e.printStackTrace();
		}
		// logger.debug("formatterMsg : " + formatterMsg);
		return formatterMsg;
	}

	public static String getSFMSInMsgType(String sfmsIncomingQueueMessage) {
		// logger.debug("Milestone getting SFMSInMsgType started..!");
		String swiftCode = "";
		int indexCode = sfmsIncomingQueueMessage.indexOf("A:");
		if (indexCode >= 0 && indexCode < sfmsIncomingQueueMessage.length()) {
			swiftCode = new StringBuffer(sfmsIncomingQueueMessage).substring(indexCode + 9, indexCode + 12);
			// logger.debug("Msg Type -> " + swiftCode);
		}
		return swiftCode;
	}

	public static String removeSFMSHeader(String tiswiftMessage, String messageType) {

		// logger.error("GetSFMSBody " + swiftMessage);
		String SFMSBody = "";
		try {
			SFMSBody = tiswiftMessage.substring(tiswiftMessage.indexOf('\n') + 1);
			System.out.println(SFMSBody);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("GetSFMSBody Exceptions! " + e.getMessage());
		}
		// logger.error("GetSFMSBody return " + SFMSBody);
		return SFMSBody;
	}

	public static String getMessageTitle(String msgType) {

		String messagedesc = "";
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			String query = "SELECT TRIM(MESSAGETYPE) as MESSAGETYPE, TRIM(TYPEDESCRIPTION) as TYPEDESCRIPTION FROM LOOKUP_SWIFT_TYPES WHERE MESSAGETYPE = ?  ";
			logger.debug("EmailSubjectBodyMapping : " + query);

			connection = DatabaseUtility.getThemebridgeConnection();
			pst = connection.prepareStatement(query);
			pst.setString(1, "MT" + msgType);
			rs = pst.executeQuery();
			while (rs.next()) {
				messagedesc = rs.getString("TYPEDESCRIPTION");
				logger.debug("Message Desc : " + messagedesc);
			}
		} catch (Exception e) {
			logger.debug("Exceptions e");
			e.printStackTrace();
		} finally {
			DatabaseUtility.surrenderConnection(connection, pst, rs);
		}
		return messagedesc;
	}

}

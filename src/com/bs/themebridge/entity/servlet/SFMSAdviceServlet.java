package com.bs.themebridge.entity.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.sfms.SfmsAdviceHandler;
import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.util.DatabaseUtility;
import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;

/**
 * Servlet implementation class SFMSAdviceServlet
 */
@WebServlet("/sfmsAdviceServlet")
public class SFMSAdviceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SFMSAdviceServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SFMSAdviceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("email doGet method initiated");
		String id = request.getParameter("id");
		String masterRef = request.getParameter("masref");
		String eventRef = request.getParameter("everef");
		logger.debug("ServiceLog ID : " + id + ", Master : " + masterRef + ", Event : " + eventRef);
		List<Servicelog> emailDetails = getTransactionStatus("mast", eventRef, id);
		logger.debug(emailDetails.get(0).getBankresponse());
		logger.debug(emailDetails.get(0).getNarrative1());
		logger.debug(emailDetails.get(0).getMasterreference());
		logger.debug(emailDetails.get(0).getEventreference());
		// Advice copy
		SfmsAdviceHandler.adviceHandler(emailDetails.get(0).getBankresponse(), emailDetails.get(0).getNarrative1(),
				masterRef, eventRef, "", "");

		getServletConfig().getServletContext().getRequestDispatcher("/protected/tztransactionstatus.jsp")
				.forward(request, response);
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		logger.debug("email doPost method initiated");

		String id = request.getParameter("id");
		String masterRef = request.getParameter("masref");
		String eventRef = request.getParameter("everef");
		logger.debug("ServiceLog ID : " + id + ", Master : " + masterRef + ", Event : " + eventRef);
		List<Servicelog> emailDetails = getTransactionStatus("mast", eventRef, id);
		logger.debug(emailDetails.get(0).getBankresponse());
		logger.debug(emailDetails.get(0).getNarrative1());
		logger.debug(emailDetails.get(0).getMasterreference());
		logger.debug(emailDetails.get(0).getEventreference());
		// Advice copy
		SfmsAdviceHandler.adviceHandler(emailDetails.get(0).getBankresponse(), emailDetails.get(0).getNarrative1(),
				masterRef, eventRef, SOURCE_SYSTEM, TARGET_SYSTEM);
		getServletConfig().getServletContext().getRequestDispatcher("/protected/tztransactionstatus.jsp")
				.forward(request, response);
		// response.sendRedirect("/protected/tztransactionstatus.jsp");
	}

	public List<Servicelog> getTransactionStatus(String masterRef, String eventRef, String id) {

		logger.debug("Service Log Regarding MasterReference Started");
		List<Servicelog> resultList = new ArrayList<Servicelog>();

		String sendEmailQuery = "SELECT ID, SERVICE, OPERATION, MASTERREFERENCE, EVENTREFERENCE, STATUS, "
				+ " TIREQUEST, BANKREQUEST, BANKRESPONSE, TIRESPONSE, NARRATIVE1 FROM SERVICELOG WHERE ID = ? ";

		logger.debug("ResendEmailQuery: " + sendEmailQuery);

		ResultSet rs = null;
		Connection aConnection = null;
		PreparedStatement aStatement = null;
		try {
			aConnection = DatabaseUtility.getThemebridgeConnection();
			aStatement = aConnection.prepareStatement(sendEmailQuery);
			aStatement.setString(1, id);
			rs = aStatement.executeQuery();
			while (rs.next()) {
				Servicelog aServicelogModel = new Servicelog();
				aServicelogModel.setId(rs.getBigDecimal("ID"));
				aServicelogModel.setService(rs.getString("SERVICE"));
				aServicelogModel.setOperation(rs.getString("OPERATION"));
				aServicelogModel.setMasterreference(rs.getString("MASTERREFERENCE"));
				aServicelogModel.setEventreference(rs.getString("EVENTREFERENCE"));
				aServicelogModel.setStatus(rs.getString("STATUS"));
				aServicelogModel.setTirequest(rs.getString("TIREQUEST"));
				aServicelogModel.setBankrequest(rs.getString("BANKREQUEST"));
				aServicelogModel.setBankresponse(rs.getString("BANKRESPONSE"));
				aServicelogModel.setTiresponse(rs.getString("TIRESPONSE"));
				aServicelogModel.setNarrative1(rs.getString("NARRATIVE1"));
				resultList.add(aServicelogModel);
			}
		} catch (SQLException e) {
			logger.error("SQL exception ! " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("Exception ! " + e.getMessage());
			e.printStackTrace();

		} finally {
			DatabaseUtility.surrenderConnection(aConnection, aStatement, rs);
		}

		logger.debug(resultList);
		return resultList;
	}
}

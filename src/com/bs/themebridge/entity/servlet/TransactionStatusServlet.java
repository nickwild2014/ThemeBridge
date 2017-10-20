package com.bs.themebridge.entity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.entity.servlet.util.TransactionDetailsProcessor;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * Servlet implementation class TransactionStatusServlet
 */
@WebServlet("/transactionStatusServlet")
public class TransactionStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TransactionStatusServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionStatusServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// logger.debug("doGet message initiated");
		TransactionDetailsProcessor obj = new TransactionDetailsProcessor();
		String eventRef = null;
		String masterRef = null;
		masterRef = request.getParameter("masRefNo");
		eventRef = request.getParameter("eventRefNo");
		// logger.debug("Transtatus >> Master Refence : >>" + masterRef + "<<");
		// logger.debug("Transtatus >> Event Reference : >>" + eventRef + "<<");

		if (ValidationsUtil.isValidString(masterRef) && ValidationsUtil.isValidString(eventRef)) {
			List<Servicelog> transactionStatusList = obj.getTransactionStatus(masterRef, eventRef);
			logger.debug("List Size : " + transactionStatusList.size());
			request.setAttribute("tranStatusList", transactionStatusList);
			request.setAttribute("masterref", masterRef);
			request.setAttribute("eventref", eventRef);
			getServletConfig().getServletContext().getRequestDispatcher("/protected/tztransactionstatus.jsp")
					.forward(request, response);
			// getServletConfig().getServletContext().getRequestDispatcher("/protected/transtatus.jsp").forward(request,
			// response);
			/*
			 * response.sendRedirect("/ThemeBridge/protected/transtatus.jsp");
			 * response.sendRedirect("/transtatus.jsp?");
			 */
		} else {
			List<Servicelog> transactionStatusList = obj.getTransactionStatus(masterRef);
			logger.debug("List Size : " + transactionStatusList.size());
			request.setAttribute("tranStatusList", transactionStatusList);
			request.setAttribute("masterref", masterRef);
			request.setAttribute("eventref", "");
			getServletConfig().getServletContext().getRequestDispatcher("/protected/tztransactionstatus.jsp")
					.forward(request, response);
			// getServletConfig().getServletContext().getRequestDispatcher("/protected/transtatus.jsp").forward(request,
			// response);
		}
		// logger.debug("doGet message ended");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("doPost message initiated");

		// doGet(request, response);
	}

}

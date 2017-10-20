package com.bs.themebridge.entity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.FDEnquiryModel;
import com.bs.themebridge.entity.servlet.util.FDEnquiryAdapterImpl;

/**
 * Servlet implementation class FDEnquiryServlet
 */
@WebServlet("/FDEnquiryServlet")
public class FDEnquiryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FDEnquiryServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FDEnquiryServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("doGet message initiated");
		FDEnquiryAdapterImpl obj = new FDEnquiryAdapterImpl();
		String eventRef = null;
		String masterRef = null;
		String customerCIF = null;
		masterRef = request.getParameter("masRefNo");
		eventRef = request.getParameter("eventRefNo");
		customerCIF = request.getParameter("customerCIF");
		logger.debug("CustAccEnq >> Customer : >>" + customerCIF + "<<");
		logger.debug("CustAccEnq >> Master Refence : >>" + masterRef + "<<");
		logger.debug("CustAccEnq >> Event Reference : >>" + eventRef + "<<");
		List<FDEnquiryModel> accDetailsList = obj.getCRNAccData(masterRef, eventRef, customerCIF);
		request.setAttribute("accDetailsList", accDetailsList);
		request.setAttribute("masterref", masterRef);
		request.setAttribute("eventref", eventRef);
		getServletConfig().getServletContext().getRequestDispatcher("/protected/custaccenquiry.jsp").forward(request,
				response);
		logger.debug("doGet message ended");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		logger.debug("doPost message initiated");
	}
}

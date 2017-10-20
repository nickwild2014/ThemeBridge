package com.bs.themebridge.entity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.themebridge.listener.mq.MQMessageManager;

/**
 * Servlet implementation class SwiftOutServlet
 */
@WebServlet("/SwiftOutServlet")
public class SwiftOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(SwiftOutServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SwiftOutServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(request, response);
		MQMessageManager mqmanagerObj = new MQMessageManager();

		String swiftOutJndiName = request.getParameter("jndiname");
		String mqName = request.getParameter("mqname");
		String swiftMessage = request.getParameter("swiftMessage");

		Boolean swiftoutQueuePostingStatus = mqmanagerObj.pushMqMessage(swiftOutJndiName, mqName, swiftMessage);

		request.setAttribute("status", swiftoutQueuePostingStatus);
		logger.debug("swiftoutQueuePostingStatus : " + swiftoutQueuePostingStatus);
		getServletConfig().getServletContext().getRequestDispatcher("/swiftout.jsp").forward(request, response);

		// response.sendRedirect("transactionlog.jsp");
	}

}

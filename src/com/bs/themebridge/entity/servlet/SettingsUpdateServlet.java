package com.bs.themebridge.entity.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.BridgepropertiesAdapter;
import com.bs.themebridge.entity.model.Bridgeproperties;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * Servlet implementation class SettingsUpdateServlet
 */
@WebServlet("/SettingsUpdateServlet")
public class SettingsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(SettingsUpdateServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettingsUpdateServlet() {
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
		logger.debug("Test 1 do");

		logger.debug("Settings update Post method initiated!!");
		String id = "";
		String value = "";
		String jsonResult = "false";
		if (ValidationsUtil.isValidString(request.getParameter("id"))) {
			id = request.getParameter("id");
		}
		if (ValidationsUtil.isValidString(request.getParameter("value"))) {
			value = request.getParameter("value");
		}
		logger.debug("Modified value " + value + " @ " + id);
		try {
			Bridgeproperties aBridgeProperties = new Bridgeproperties();
			BridgepropertiesAdapter bpa = new BridgepropertiesAdapter();
			aBridgeProperties = bpa.getPropertyById(id);
			if (aBridgeProperties != null) {
				bpa = new BridgepropertiesAdapter();
				BigDecimal decimalId = new BigDecimal(id);
				aBridgeProperties.setId(decimalId);
				aBridgeProperties.setValue(value);
				bpa.updateProperty(aBridgeProperties);
				jsonResult = "true";
			}
			logger.debug("Modified successfully and response returned");
			// ConfigurationUtil.configMap = null;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonResult = "false";
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonResult);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		logger.debug("Settings update Post method initiated!!");
		String id = "";
		String value = "";
		String jsonResult = "false";
		if (ValidationsUtil.isValidString(request.getParameter("id"))) {
			id = request.getParameter("id");
		}
		if (ValidationsUtil.isValidString(request.getParameter("value"))) {
			value = request.getParameter("value");
		}
		logger.debug("Modified value " + value + " @ " + id);
		try {
			Bridgeproperties aBridgeProperties = new Bridgeproperties();
			BridgepropertiesAdapter bpa = new BridgepropertiesAdapter();
			aBridgeProperties = bpa.getPropertyById(id);
			if (aBridgeProperties != null) {
				bpa = new BridgepropertiesAdapter();
				BigDecimal decimalId = new BigDecimal(id);
				aBridgeProperties.setId(decimalId);
				aBridgeProperties.setValue(value);
				bpa.updateProperty(aBridgeProperties);
				jsonResult = "true";
			}
			// ConfigurationUtil.configMap = null;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			jsonResult = "false";
		}
		logger.debug("SettingsUpdateServlet successfully and response returned");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonResult);
	}

}

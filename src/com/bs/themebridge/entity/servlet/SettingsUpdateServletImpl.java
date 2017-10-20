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
 * @author BSIT-THEMEBRIDGE(RaviPrasath)
 */
@WebServlet("/SettingsUpdateServletImpl")
public class SettingsUpdateServletImpl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(SettingsUpdateServletImpl.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Settings update initiated");
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
}

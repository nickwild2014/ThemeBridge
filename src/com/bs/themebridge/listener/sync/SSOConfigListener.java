package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.themebridge.token.util.ConfigurationUtil;

public class SSOConfigListener implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(SSOConfigListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("SSOConfigListener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.debug("SSOConfigListener intialized");
		// TODO Auto-generated method stub
		String casServerLoginUrl = ConfigurationUtil.getValueFromKey("CasServerLoginUrl");
		String casServerUrlPrefix = ConfigurationUtil.getValueFromKey("CasServerUrlPrefix");
		String serverName = ConfigurationUtil.getValueFromKey("ServerName");
		String proxyCallbackUrl = ConfigurationUtil.getValueFromKey("ProxyCallbackUrl");

		// logger.debug("CasServerLoginUrl : " + casServerLoginUrl);
		// logger.debug("CasServerUrlPrefix : " + casServerUrlPrefix);
		// logger.debug("ProxyCallbackUrl : " + proxyCallbackUrl);
		// logger.debug("ServerName : " + serverName);

		arg0.getServletContext().setInitParameter("casServerLoginUrl", casServerLoginUrl);
		arg0.getServletContext().setInitParameter("casServerUrlPrefix", casServerUrlPrefix);
		arg0.getServletContext().setInitParameter("serverName", serverName);
		arg0.getServletContext().setInitParameter("proxyCallbackUrl", proxyCallbackUrl);
	}

}

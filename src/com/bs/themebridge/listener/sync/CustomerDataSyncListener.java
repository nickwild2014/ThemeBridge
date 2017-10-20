package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.staticdata.adapter.CustomerDataServiceAdapter;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class CustomerDataSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(CustomerDataSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("CustomerDataSyncListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("CustomerDataSyncListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {
							
							customerDataProcessor();

						} catch (NullPointerException e) {
							logger.debug("CustomerDataSyncListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("CustomerDataSyncListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.CUSTOMERDATA_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);
					}
				} catch (NullPointerException e) {
					logger.debug("Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();
	}

	public static void customerDataProcessor() {

		logger.debug("******** CustomerDataSyncListener *******");
		CustomerDataServiceAdapter customerDataOjb = new CustomerDataServiceAdapter();
		String result = customerDataOjb.pushCustomerDataService();
	}

}

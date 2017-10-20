package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.util.RETSyncAdapterUtil;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class RETSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(RETSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("RETSyncListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("RETFXDEALSyncListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {

							retDealDataProcessor();

						} catch (NullPointerException e) {
							logger.debug("RETSyncListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("RETSyncListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(10 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.RET_STAGING_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);
					}

				} catch (NullPointerException e) {
					logger.debug("RETFXDEALSyncListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	public static void retDealDataProcessor() {

		logger.debug("******** RETFXDEALSyncListener *******");
		RETSyncAdapterUtil retSyncObj = new RETSyncAdapterUtil();
		boolean result = retSyncObj.processFtrtDeals();
	}
}

package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.staticdata.adapter.FXRateServiceAdapter;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class FXRateSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(FXRateSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("FXRateSyncListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("FXRateSyncListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {

							fxRateProcessor();

						} catch (NullPointerException e) {
							logger.debug("FXRateSyncListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("FXRateSyncListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(3 * 60 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long
								.parseLong(ConfigurationUtil.getValueFromKey(ThemeConstant.FX_RATE_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);
					}
				} catch (NullPointerException e) {
					logger.debug("FXRateSyncListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("FXRateSyncListener Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	public static void fxRateProcessor() {

		logger.debug("******** FXRateSyncListener *******");
		FXRateServiceAdapter fxRateObj = new FXRateServiceAdapter();
		String fxstatus = fxRateObj.pushTIFxRateService();

	}

}

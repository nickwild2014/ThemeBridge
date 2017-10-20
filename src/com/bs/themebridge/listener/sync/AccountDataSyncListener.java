package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.staticdata.adapter.AccountDataServiceAdapter;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class AccountDataSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(AccountDataSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("AccountDataSyncListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("AccountDataSyncListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {

							accountDataProcessor();

						} catch (NullPointerException e) {
							logger.debug("AccountDataSyncListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("AccountDataSyncListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(15 * 60 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.ACCOUNTDATA_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);
					}
				} catch (NullPointerException e) {
					logger.debug("AccountDataSyncListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("AccountDataSyncListener Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	public static void accountDataProcessor() {

		logger.debug("******** AccountDataSyncListener *******");
		AccountDataServiceAdapter accountDataOjb = new AccountDataServiceAdapter();
		String result = accountDataOjb.pushAccountDataService();
	}
}

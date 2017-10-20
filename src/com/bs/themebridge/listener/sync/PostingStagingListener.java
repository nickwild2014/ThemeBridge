package com.bs.themebridge.listener.sync;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.PostingStagingAdaptee;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class PostingStagingListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(PostingStagingListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("PostingStagingListener destroyed..!");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("PostingStagingListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {

							postingStagingProcessor();

						} catch (NullPointerException e) {
							logger.debug("PostingStagingListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("PostingStagingListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(2 * 60 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.POSTING_STAGING_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);
					}
				} catch (NullPointerException e) {
					logger.debug("PostingStagingListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("PostingStagingListener Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	public static void postingStagingProcessor() {

		logger.debug("******** PostingStagingListener *******");
		PostingStagingAdaptee anAdaptee = new PostingStagingAdaptee();
		boolean result = anAdaptee.process();

	}
}

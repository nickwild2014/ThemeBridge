package com.bs.themebridge.listener.sync;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.listener.mq.MQMessageManager;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class SwiftInSyncListener implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(SwiftInSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("SwiftIncomingListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("SwiftIncomingListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {
							processMqSwiftMessages();

						} catch (NullPointerException e) {
							logger.debug("SwiftIncomingListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("SwiftIncomingListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(10 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long
								.parseLong(ConfigurationUtil.getValueFromKey(ThemeConstant.SWIFTIN_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);

					}
				} catch (NullPointerException e) {
					logger.debug("SwiftIncomingListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("SwiftIncomingListener Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	public static void processMqSwiftMessages() throws Exception {

		logger.debug("******** SwiftIncomingSyncListener *******");
		MQMessageManager mqMessageManagerObj = new MQMessageManager();
		try {
			String swiftInMqJndiName = ConfigurationUtil.getValueFromKey("SwiftInMQJndiName");
			String swiftInQueueName = ConfigurationUtil.getValueFromKey("SwiftInMQName");

			String mqQueueMessage = null;
			mqQueueMessage = mqMessageManagerObj.pullMqMessage(swiftInMqJndiName, swiftInQueueName); // TI.INCOMING
			// logger.debug("SwiftIn MQ Message -->" + mqQueueMessage);

			if (!mqQueueMessage.isEmpty() && mqQueueMessage != null) {
				SWIFTSwiftInAdaptee aSwiftInAdaptee = new SWIFTSwiftInAdaptee();
				boolean isProcessed = aSwiftInAdaptee.processSwiftInMessages(mqQueueMessage, "$", swiftInQueueName);
			}

		} catch (IOException e) {
			logger.error("SwiftIn Listener IOException! " + e.getMessage(), e);
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("SwiftIn Listener Exception! " + e.getMessage(), e);
			e.printStackTrace();

		} finally {

		}
	}

}

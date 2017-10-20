package com.bs.themebridge.listener.sync;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.sfms.SFMSInwardMessageAdaptee;
import com.bs.themebridge.listener.mq.MQMessageManager;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeConstant;

public class SFMSInIlcMqSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(SFMSInIlcMqSyncListener.class.getName());

	public static Thread thread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("SFMSIncomingListener destroyed..!");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// logger.debug("SFMSIncomingListener..!");

		thread = new Thread(new Runnable() {
			public void run() {
				try {
					boolean flag = true;
					while (flag) {
						try {
							processMqSwiftMessagesILC("ILC");

						} catch (NullPointerException e) {
							logger.debug("SFMSIncomingILCListener Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("SFMSIncomingILCListener Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(10 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.SFMSIN_ILCMQ_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);

					}
				} catch (NullPointerException e) {
					logger.debug("SFMSIncomingILCListener Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("SFMSIncomingILCListener Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}

	/**
	 * To listen the directory poller for incoming swift messages
	 * 
	 * @throws Exception
	 */
	public static void processMqSwiftMessagesILC(String incomingQueueName) throws Exception {

		logger.debug("******** SFMSIncomingILCMQSyncListener *******");
		MQMessageManager mqMessageManagerObj = new MQMessageManager();
		try {
			String SfmsInMQJndiName = ConfigurationUtil.getValueFromKey("SfmsInMQJndiName");
			String SfmsInMQName = ConfigurationUtil.getValueFromKey("SfmsInMQNameIlc");
			logger.debug("SfmsInMQJndiName : " + SfmsInMQJndiName + "\t" + "SfmsInMQName : " + SfmsInMQName);

			String mqQueueMessage = null;
			mqQueueMessage = mqMessageManagerObj.pullMqMessage(SfmsInMQJndiName, SfmsInMQName);
			// logger.debug("SwiftIn MQ Message -->" + mqQueueMessage);

			if (!mqQueueMessage.isEmpty() && mqQueueMessage != null) {
				SFMSInwardMessageAdaptee aSfmsInAdaptee = new SFMSInwardMessageAdaptee();
				boolean isProcessed = aSfmsInAdaptee.processSFMSInMessages(mqQueueMessage, "$", incomingQueueName);
			}

		} catch (IOException e) {
			logger.error("SFMS Incoming ILC IOException! " + e.getMessage(), e);
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("SFMS Incoming ILC Exception! " + e.getMessage(), e);
			e.printStackTrace();

		} finally {

		}
	}

}

package com.bs.themebridge.listener.sync;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.sfms.SFMSInwardMessageAdaptee;
import com.bs.themebridge.listener.mq.MQMessageManager;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ThemeConstant;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSession;
import com.ibm.msg.client.wmq.WMQConstants;

public class SFMSInBgMqSyncListener implements ServletContextListener {
	private final static Logger logger = Logger.getLogger(SFMSInBgMqSyncListener.class.getName());

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
							processMqSFMSInMessages();

						} catch (NullPointerException e) {
							logger.debug("SFMSIncomingBGCMQSync Null Pointer exceptions! " + e.getMessage());
							e.printStackTrace();

						} catch (Exception e) {
							logger.debug("SFMSIncomingBGCMQSync Exceptions! " + e.getMessage());
							e.printStackTrace();
						}
						// Thread.sleep(10 * 1000);
						// Thread.sleep(TimeUnit.SECONDS.toMillis(30));
						long timeInterval = Long.parseLong(
								ConfigurationUtil.getValueFromKey(ThemeConstant.SFMSIN_BGMQ_LISTNER_FREQUENCY));
						Thread.sleep(timeInterval);

					}
				} catch (NullPointerException e) {
					logger.debug("SFMSIncomingBGCMQSync Null Pointer exceptions! " + e.getMessage());
					e.printStackTrace();

				} catch (Exception e) {
					logger.debug("SFMSIncomingBGCMQSync Exceptions! " + e.getMessage());
					e.printStackTrace();

				}
			}
		});
		thread.start();

	}
	
	public static MQQueueConnectionFactory getConntionFactory() {
		MQQueueConnectionFactory cf = null;
		logger.info("To started connection factory to   MQ Server");
		cf = new MQQueueConnectionFactory();
		try {
			int port = ThemeBridgeUtil.StringtoInt(ConfigurationUtil.getValueFromKey("SfmsInMQPort"));
			String hostname = ConfigurationUtil.getValueFromKey("SfmsInMQHostName");
			String channel = ConfigurationUtil.getValueFromKey("SfmsInMQChannelName");
			String qManager = ConfigurationUtil.getValueFromKey("SfmsInMQManagerName");
			cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);

			cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, hostname);
			cf.setIntProperty(WMQConstants.WMQ_PORT, port);
			cf.setStringProperty(WMQConstants.WMQ_CHANNEL, channel);
			cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE,
					WMQConstants.WMQ_CM_CLIENT);
			cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, qManager);

			logger.info("-->" + cf.getChannel());
		} catch (JMSException e) {
			logger.info("JMSException -->" + e.getMessage());
			e.printStackTrace();
		}
		logger.info("To ended connection factory to   MQ Server");
		return cf;
	}

	
	public static String SFMSInProcess(String RESPONSE_QUEUE) {

		MQQueueConnectionFactory cf = getConntionFactory();
		MQQueueConnection connection = null;
		String message = "";
		MessageConsumer consumer = null;
		try {
			connection = (MQQueueConnection) cf.createQueueConnection();
			logger.info("MQConnection Response --->" + connection);
			if (connection != null) {
				MQQueueSession sessionMqQueueSession = (MQQueueSession) connection
						.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

				connection.start();

				MQQueue queue = new MQQueue();

				queue = (MQQueue) sessionMqQueueSession.createQueue("queue:///"+ RESPONSE_QUEUE);

				logger.info("IN Comming Queue>>>>>>>>>" + RESPONSE_QUEUE);
				consumer = sessionMqQueueSession.createConsumer(queue);
				logger.info("To starting MQ consumer the message ");

				Message msg = consumer.receive();
				logger.info("To sended MQ consumer the message ");

				TextMessage tmessage = (TextMessage) msg;

				message = tmessage.getText();
				tmessage.setJMSType("8");

				logger.info("Swift In  response msg: " + message);
			}
			logger.info("------------------MQ listener Ended------------------");

			// }
		} catch (JMSException jmex) {
			jmex.printStackTrace();
			logger.info("JMS Exception Response " + jmex);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Std Exception Response" + ex);
		} finally {
			try {

				connection.close();
			} catch (JMSException e) {

			}
		}
		return message;
	}


	/**
	 * To listen the directory poller for incoming swift messages
	 * 
	 * @throws Exception
	 */
	public static void processMqSFMSInMessages() throws Exception {

		logger.debug("******** SFMSIncomingBGCMQSyncListener *******");
		try {
			String SfmsInMQName = ConfigurationUtil.getValueFromKey("SfmsInMQName");
			logger.debug("  \t" + "SfmsInMQName : " + SfmsInMQName);

			String mqQueueMessage = null;
			//mqQueueMessage = mqMessageManagerObj.pullMqMessage(SfmsInMQJndiName, SfmsInMQName);
			mqQueueMessage = SFMSInProcess(SfmsInMQName);
			// logger.debug("SwiftIn MQ Message -->" + mqQueueMessage);

			if (!mqQueueMessage.isEmpty() && mqQueueMessage != null) {
				SFMSInwardMessageAdaptee aSfmsInAdaptee = new SFMSInwardMessageAdaptee();
				boolean isProcessed = aSfmsInAdaptee.processSFMSInMessages(mqQueueMessage, "$", SfmsInMQName);
				logger.info("SFMSIn processed ? "+isProcessed);
			}
		} catch (IOException e) {
			logger.error("SFMS Incoming BG IOException! " + e.getMessage(), e);
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("SFMS Incoming BG Exception! " + e.getMessage(), e);
			e.printStackTrace();

		} finally {

		}
	}

}

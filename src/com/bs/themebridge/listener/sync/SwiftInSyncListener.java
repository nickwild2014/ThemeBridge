package com.bs.themebridge.listener.sync;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.ibm.mq.jms.MQQueue;
import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.listener.mq.MQMessageManager;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ThemeConstant;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSession;
import com.ibm.msg.client.wmq.WMQConstants;
import javax.jms.Session;
import javax.jms.TextMessage;

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
	
	public static MQQueueConnectionFactory getConntionFactory() {
		MQQueueConnectionFactory cf = null;
		logger.info("To started connection factory to   MQ Server");
		cf = new MQQueueConnectionFactory();
		try {
			int port = ThemeBridgeUtil.StringtoInt(ConfigurationUtil.getValueFromKey("SwiftInMQPort"));
			String hostname = ConfigurationUtil.getValueFromKey("SwiftInMQHostName");
			String channel = ConfigurationUtil.getValueFromKey("SwiftInMQChannelName");
			String qManager = ConfigurationUtil.getValueFromKey("SwiftInMQManagerName");
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


	
	public static String SwiftInProcess(String RESPONSE_QUEUE) {

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

	
	public static void processMqSwiftMessages() throws Exception {

		logger.debug("******** SwiftIncomingSyncListener *******");
		try {
			String swiftInQueueName = ConfigurationUtil.getValueFromKey("SwiftInMQName");

			String mqQueueMessage = null;
			//mqQueueMessage = mqMessageManagerObj.pullMqMessage(swiftInMqJndiName, swiftInQueueName); // TI.INCOMING
			mqQueueMessage = SwiftInProcess(swiftInQueueName);
			// logger.debug("SwiftIn MQ Message -->" + mqQueueMessage);

			if (!mqQueueMessage.isEmpty() && mqQueueMessage != null) {
				SWIFTSwiftInAdaptee aSwiftInAdaptee = new SWIFTSwiftInAdaptee();
				boolean isProcessed = aSwiftInAdaptee.processSwiftInMessages(mqQueueMessage, "$", swiftInQueueName);
				logger.info("Swiftin processed ? "+isProcessed);
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

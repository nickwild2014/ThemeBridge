package com.bs.themebridge.listener.mq;

import java.io.BufferedReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftOutAdapteeStaging;
import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.ibm.mq.jms.MQQueue;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class MQMessageManager {

	private final static Logger logger = Logger.getLogger(MQMessageManager.class.getName());

	/**
	 * 
	 * @param jndiName
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 */
	public static Connection getMQJNDIConnection(String jndiName) {

		Connection connection = null;
		try {
			InitialContext init = new InitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory) init.lookup(jndiName);
			logger.info("MQ JNDI connectionfatory successfully created");

			connection = connectionFactory.createConnection();
			// logger.info("MQ JNDI connection for..." + jndiName + " {" +
			// connection + "}");

		} catch (NamingException e) {
			logger.error("MQ JNDI Connection NamingException e! " + e.getMessage(), e);
			e.printStackTrace();

		} catch (JMSException e) {
			logger.error("MQ JNDI Connection JMSException e! " + e.getMessage(), e);
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("MQ JNDI connection Exception e-->" + e.getMessage(), e);
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
	 * @param jndiName
	 *            {@code allows }{@link String}
	 * @param queueName
	 *            {@code allows }{@link String}
	 * @param swiftMessage
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 */
	@SuppressWarnings("finally")
	public static boolean pushMqMessage(String jndiName, String queueName, String swiftMessage) {
		boolean result = false;

		if (queueName != null && !queueName.isEmpty()
				&& (queueName.contains("swift") || queueName.equalsIgnoreCase("swift"))) {
			logger.info("swift in message getting process ");
			String swiftInQueueName = ConfigurationUtil.getValueFromKey("SwiftInMQName");
			int port = ThemeBridgeUtil.StringtoInt(ConfigurationUtil.getValueFromKey("SwiftInMQPort"));
			String hostname = ConfigurationUtil.getValueFromKey("SwiftInMQHostName");
			String channel = ConfigurationUtil.getValueFromKey("SwiftInMQChannelName");
			String qManager = ConfigurationUtil.getValueFromKey("SwiftInMQManagerName");
			result = 	SWIFTSwiftOutAdapteeStaging.writeMQMessage(swiftMessage, port, hostname, channel, qManager, swiftInQueueName);
		}
		if (queueName != null && !queueName.isEmpty()
				&& (queueName.contains("sfms") || queueName.equalsIgnoreCase("sfms"))) {
			logger.info("sfms-In message getting process ");
			String SfmsInMQName = ConfigurationUtil.getValueFromKey("SfmsInMQName");
			int port = ThemeBridgeUtil.StringtoInt(ConfigurationUtil.getValueFromKey("SfmsInMQPort"));
			String hostname = ConfigurationUtil.getValueFromKey("SfmsInMQHostName");
			String channel = ConfigurationUtil.getValueFromKey("SfmsInMQChannelName");
			String qManager = ConfigurationUtil.getValueFromKey("SfmsInMQManagerName");
			result = SWIFTSwiftOutAdapteeStaging.writeMQMessage(swiftMessage, port, hostname, channel, qManager, SfmsInMQName);
		}

		// SWIFTSwiftOutAdapteeStaging.writeMQMessage( "",12,"","","","");

		// logger.debug("Entering into Post message into MQ Queue");
		// logger.debug("JNDI Name : " + jndiName + "\tQueue Name :" + queueName
		// + "\tSwiftMessage : " + swiftMessage);
		logger.debug("Queue Name :" + queueName);

		
//		Session session = null;
//		Connection connection = null;
//
//		try {
//			connection = getMQJNDIConnection(jndiName);
//			// create a queue session
//			session = connection.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
//			Queue queue = session.createQueue("queue:///" + queueName);
//			// TODO While writing MQ Queue using JMS must declare client
//			((MQQueue) queue).setTargetClient(1);
//			// Create a MessageProducer from the Session to the Queue
//			MessageProducer producer = session.createProducer(queue);
//			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//			// Create a message
//			TextMessage message = session.createTextMessage(swiftMessage);
//			// Tell the producer to send the message
//			producer.send(message);
//			result = true;
//			producer.close();
//			session.close();
//
//		} catch (JMSException e) {
//			logger.error("Push MQ Message JNDI JMSException..! " + e.getMessage(), e);
//			e.printStackTrace();
//			result = false;
//
//		} catch (Exception e) {
//			logger.error("Push MQ Message MQ Exception..! " + e.getMessage(), e);
//			e.printStackTrace();
//			result = false;
//
//		} finally {
//			// close the queue connection
//			surrenderMQ(connection, null, session);
//		}
		logger.debug("Pushing message into MQ Queue status : " + result);
		return result;
	}

	/**
	 * 
	 * @param jndiName
	 *            {@code allows }{@link String}
	 * @param queueName
	 *            {@code allows }{@link String}
	 * @return
	 */
	public String pullMqMessage(String jndiName, String queueName) {

		// logger.debug("Enter into getMessage from MQ Queue");
		logger.debug("JNDI Name : " + jndiName + "\tQueue Name :" + queueName);
		Session session = null;
		String queueMessage = "";
		Connection connection = null;
		MessageConsumer consumer = null;

		try {
			Queue responseMQueue;
			connection = getMQJNDIConnection(jndiName);
			session = connection.createSession(false, 1);
			responseMQueue = session.createQueue("queue:///" + queueName);
			// TODO While writing MQ Queue using JMS must declare client
			((MQQueue) responseMQueue).setTargetClient(1); // MQSTR Format
			// logger.debug("Queue Name -> : " + responseMQueue.getQueueName());
			consumer = session.createConsumer(responseMQueue);
			// logger.debug("Milestone 01");
			connection.start();
			// logger.debug("Milestone 02");
			Message msg = consumer.receive();
			// logger.debug("Milestone 03");
			if (msg != null) {
				// logger.info("Consuming Messages from MQ ");
				TextMessage tmessage = (TextMessage) msg;
				logger.info("Consuming Messages from MQ1 >>>");
				// logger.info("Consuming Messages>>>" + tmessage + "<<<");
				if (tmessage != null) {
					queueMessage = tmessage.getText();
					// logger.info("1st loop in Consuming Messages from MQ2 >>>"
					// + queueMessage + "<<<");
					if ((queueMessage != null) && (!queueMessage.isEmpty())) {
						// logger.info("MQ incoming Queue message ... => " +
						// queueMessage);
					}
					// logger.info("2nd if end");
				}
				// logger.info("1st if end");
			}
			// logger.debug("Incomig MQ Queue...no more messages!");
		} catch (JMSException jmsex) {
			logger.error("processSwiftIn JMSException -->" + jmsex.getMessage());
			jmsex.printStackTrace();

		} catch (Exception ex) {
			logger.error("processSwiftIn Exception -->" + ex.getMessage());
			ex.printStackTrace();

		} finally {
			surrenderMQ(connection, consumer, session);
		}
		// logger.debug("return Q message >--> " + queueMessage);
		return queueMessage;
	}

	/**
	 * 
	 * @param connection
	 *            {@code allows }{@link String}
	 * @param consumer
	 *            {@code allows }{@link String}
	 * @param session
	 *            {@code allows }{@link String}
	 */
	public static void surrenderMQ(javax.jms.Connection connection, MessageConsumer consumer, Session session) {

		try {
			if (consumer != null)
				consumer.close();

			if (session != null)
				session.close();

			if (connection != null)
				connection.close();

		} catch (JMSException e1) {
			logger.error("Surrender JMSException -->" + e1.getMessage());

		}
	}

	/**
	 * 
	 * @param tiSwiftMsg
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 */
	public static String formatSwiftMsg(String tiSwiftMsg) {

		// logger.debug("format> swift file initiated");
		String formattedSwift = "";

		try {
			StringBuilder stringBuilder = new StringBuilder();
			InputStreamReader isr = null;
			BufferedReader bufferedReader = null;
			String line = null;
			isr = new InputStreamReader(new ByteArrayInputStream(tiSwiftMsg.getBytes()));
			bufferedReader = new BufferedReader(isr);
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\r\n");
			}
			formattedSwift = stringBuilder.toString();
			// logger.debug("formattedSwift >>->>\n\n" + formattedSwift +
			// "<<-<<\n\n");

		} catch (IOException e) {
			logger.error(e.getMessage(), e);

		} finally {

		}
		return formattedSwift;
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		logger.debug("TEST Queue Connection : ");
		// Connection conn = getMQJNDIConnection("jms/kmblswiftout");

		MQMessageManager v = new MQMessageManager();
		// v.pushMqMessage("jms/kmblswiftout", "TI.OUT", "POSTTESTSWIFTMSG");
		v.pushMqMessage("jms/kmblswiftinQCF", "TI.INCOMING", "POSTTESTSWIFTMSG");
		// pullMqMessage("jms/kmblswiftout", "TI.IN");
	}
}

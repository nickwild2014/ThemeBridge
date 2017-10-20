package com.bs.themebridge.listener.mq;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import com.bs.themebridge.server.gateway.in.BridgeGateway;

/**
 * Message-Driven Bean implementation class for: WatchListListener
 */
//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class WatchListListener implements MessageListener {

	private final static Logger logger = Logger.getLogger(WatchListListener.class.getName());

	/**
	 * Default constructor.
	 */
	public WatchListListener() {
		// TODO Auto-generated constructor stub
	}

	public void onMessage(Message message) {
		try {
			if (message != null) {
				// logger.debug("Consume WatchList Messages start:: ");

				TextMessage tmessage = (TextMessage) message;
				if (tmessage != null) {

					String msgText = tmessage.getText();
					if ((msgText != null) && (!msgText.isEmpty())) {
						logger.debug("\nWatchListQueueMessage(*_*) :- " + msgText);

						BridgeGateway bridgeGateway = new BridgeGateway();
						bridgeGateway.process(msgText);
					}
				}
			}
			// logger.debug("WatchList queue no more messages....");

		} catch (JMSException jmsex) {
			logger.error("processMQGatewayRequest JMSException -->" + jmsex.getMessage());
			jmsex.printStackTrace();

		} catch (Exception ex) {
			logger.error("processMQGatewayRequest Exception -->" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
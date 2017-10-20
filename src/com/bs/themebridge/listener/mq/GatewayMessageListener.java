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
 * Message-Driven Bean implementation class for: GatewayMessageListener
 */
//@MessageDriven(activationConfig = {
//		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class GatewayMessageListener implements MessageListener {

	private final static Logger logger = Logger.getLogger(GatewayMessageListener.class.getName());

	/**
	 * Default constructor.
	 */
	public GatewayMessageListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		try {
			if (message != null) {
				// logger.debug("Consume Gateway Messages start: ");

				TextMessage tmessage = (TextMessage) message;
				if (tmessage != null) {

					String msgText = tmessage.getText();
					if ((msgText != null) && (!msgText.isEmpty())) {
						logger.debug("\nGatewayQueueMessage(*_*) :- " + msgText);

						BridgeGateway bridgeGateway = new BridgeGateway();
						bridgeGateway.process(msgText);
					}
				}
			}
			// logger.debug("Gateway queue no more messages....");

		} catch (JMSException jmsex) {
			logger.error("processMQGatewayRequest JMSException -->" + jmsex.getMessage());
			jmsex.printStackTrace();

		} catch (Exception ex) {
			logger.error("processMQGatewayRequest Exception -->" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
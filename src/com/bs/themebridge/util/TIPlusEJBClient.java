package com.bs.themebridge.util;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.bs.themebridge.token.util.ConfigurationUtil;
import com.misys.tiplus2.service.access.UnrecognisedServiceName;
import com.misys.tiplus2.service.access.ejb.EnigmaServiceAccess;
import com.misys.tiplus2.service.access.ejb.EnigmaServiceAccessHome;

public class TIPlusEJBClient {

	private static Logger logger = Logger.getLogger(TIPlusEJBClient.class);

	public static void main(String[] args) throws Exception {
		process("Test Message");
	}

	/**
	 * To process message via EJB
	 * 
	 * @param message
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 * @throws Exception
	 */
	public static String process(String message) {

		String result = "";
		// logger.debug("TIPlus EJBClient Request:" + message);

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");

		// String bootstarpUrl = "iiop://localhost:" + bootstrapAddr;
		String bootstarpUrl = ConfigurationUtil.getValueFromKey("BootstrapUrl");
		logger.debug("BootstrapUrl >> " + bootstarpUrl);

		env.put(Context.PROVIDER_URL, bootstarpUrl);

		try {
			Context ctx = new InitialContext(env);
			Object ejbObject = ctx.lookup("ejb/EnigmaServiceAccess");
			EnigmaServiceAccessHome accessBeanHome = (EnigmaServiceAccessHome) javax.rmi.PortableRemoteObject
					.narrow(ejbObject, EnigmaServiceAccessHome.class);
			EnigmaServiceAccess accessB = accessBeanHome.create();
			result = accessB.process(message);

		} catch (RemoteException e) {
			logger.error("RemoteException! " + e.getMessage());
			e.printStackTrace();
			// throw new Exception(e.getMessage());
			return result = "RemoteException!";

		} catch (NamingException e) {
			logger.error("NamingException! " + e.getMessage());
			e.printStackTrace();
			// throw new Exception(e.getMessage());
			return result = "NamingException!";

		} catch (CreateException e) {
			logger.error("CreateException!" + e.getMessage());
			e.printStackTrace();
			// throw new Exception(e.getMessage());
			return result = "CreateException!";

		} catch (UnrecognisedServiceName e) {
			logger.error("UnrecognisedServiceName!" + e.getMessage());
			e.printStackTrace();
			// throw new Exception(e.getMessage());
			return result = "UnrecognisedServiceName!";

		} catch (Exception e) {
			logger.error("Exception!" + e.getMessage());
			e.printStackTrace();
			// throw new Exception(e.getMessage());
			return result = "Exception!";
		}

		return result;
	}

}

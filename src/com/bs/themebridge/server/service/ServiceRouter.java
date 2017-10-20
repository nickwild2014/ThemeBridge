package com.bs.themebridge.server.service;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.bs.themebridge.server.adapter.IServiceExtractor;
import com.bs.themebridge.server.adapter.IServiceProcessor;
import com.bs.themebridge.util.ServiceProcessorUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;

/**
 * ServiceRouter class routes the message from TI to the corresponding Adapter
 * using the message service + operation name. ServiceRouter Implements
 * IServiceProcessor.
 * 
 * @author Bluescope
 * 
 */
public class ServiceRouter extends ServiceProcessorUtil implements IServiceProcessor {

	static Logger logger = Logger.getLogger(ServiceRouter.class);
	IServiceExtractor aInterfaceExtractor;
	String implementationClass = "";

	// Testing purpose only
	public static void main(String[] args)
			throws ClassNotFoundException, ParserConfigurationException, SAXException, JAXBException, Exception {
		ServiceRouter service = new ServiceRouter(ThemeBridgeUtil.readFile("C:\\temp\\sample_3.txt"));
		String result = service.process(ThemeBridgeUtil.readFile("C:\\temp\\sample_2.txt"));
		logger.debug(result);
	}

	/**
	 * Constructor ServiceRouter
	 * 
	 * Based on the header information create an instance of the corresponding
	 * service implementation.
	 * 
	 * @param inputXml
	 *            : passing the input Service for routing based on the Service
	 *            Name.
	 * @throws JAXBException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public ServiceRouter(String inputXml) throws ParserConfigurationException, SAXException, IOException, JAXBException,
			ClassNotFoundException, InstantiationException, IllegalAccessException {
		super(inputXml);

		// logger.info("*** ServiceRouter initiated! ***");
		logger.info("ServiceRouter <<--<<(-_-)>>-->> ServiceOperation " + getReqServiceOperation());
		// getReqService();
		Class instanceClass = null;

		if (getReqServiceOperation().equalsIgnoreCase("Notificationsevent-step")) {
			instanceClass = Class.forName("com.bs.themebridge.adapter.impl.NotificationsEventStepAdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl.NotificationsEventStepAdapterImpl";

			// TODO GATEWAY document separation with operation name
		} else if (getReqService().equalsIgnoreCase("GATEWAY")) {

			if (getReqServiceOperation().startsWith("GATEWAYNCIF")) {
				instanceClass = Class.forName("com.bs.themebridge.adapter.impl.WatchListCheckerAdapterImpl");
				implementationClass = "com.bs.themebridge.adapter.impl.WatchListCheckerAdapterImpl";

			} else if (getReqServiceOperation().startsWith("GATEWAYRTGS")
					|| getReqServiceOperation().startsWith("GATEWAYRTG")
					|| getReqServiceOperation().startsWith("GATEWAYNEFT")
					|| getReqServiceOperation().startsWith("GATEWAYNFT")) {
				instanceClass = Class.forName("com.bs.themebridge.adapter.impl.GATEWAYNEFTRTGSAdapterImpl");
				implementationClass = "com.bs.themebridge.adapter.impl.GATEWAYNEFTRTGSAdapterImpl";

			} else if (getReqServiceOperation().startsWith("GATEWAYSMS")) {
				instanceClass = Class.forName("com.bs.themebridge.adapter.impl.GATEWAYSmsAdapterImpl");
				implementationClass = "com.bs.themebridge.adapter.impl.GATEWAYSmsAdapterImpl";

			} else if (getReqServiceOperation().startsWith("GATEWAYLCBD")
					|| getReqServiceOperation().startsWith("GATEWAYFD") // processing
					|| getReqServiceOperation().startsWith("GATEWAYTFELC") // DOUBT
					|| getReqServiceOperation().startsWith("GATEWAYEBGISSUE")
					|| getReqServiceOperation().startsWith("GATEWAYBGIFN760CV")
					|| getReqServiceOperation().startsWith("GATEWAYBGIFN767CV")
					|| getReqServiceOperation().startsWith("GATEWAYBGIFN769CV")
					|| getReqServiceOperation().startsWith("GATEWAYPRESHIP")
					|| getReqServiceOperation().startsWith("GATEWAYEXT")
					|| getReqServiceOperation().startsWith("GATEWAYEXC")
					|| getReqServiceOperation().startsWith("GATEWAYEXX")
					|| getReqServiceOperation().startsWith("GATEWAYEDPMS")
					|| getReqServiceOperation().startsWith("GATEWAYFXNP")) {
				instanceClass = Class.forName("com.bs.themebridge.adapter.impl.GatewayDocumentsAdapterImpl");
				implementationClass = "com.bs.themebridge.adapter.impl.GatewayDocumentsAdapterImpl";
			}

		} else if (getReqServiceOperation().equalsIgnoreCase("CustomizationFDLienAdd")) {
			instanceClass = Class.forName("com.bs.themebridge.adapter.impl.CustomizationFDLienMarkAdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl.CustomizationFDLienMarkAdapterImpl";

		} else if (getReqServiceOperation().equalsIgnoreCase("CustomizationFDLienModify")) {
			instanceClass = Class.forName("com.bs.themebridge.adapter.impl.CustomizationFDLienModifyAdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl.CustomizationFDLienModifyAdapterImpl";

		} else if (getReqServiceOperation().equalsIgnoreCase("CustomizationFDLienRemoval")) {
			instanceClass = Class.forName("com.bs.themebridge.adapter.impl.CustomizationFDLienModifyAdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl.CustomizationFDLienModifyAdapterImpl";

		} else if (getReqService().equalsIgnoreCase("EOD") || getReqService().equalsIgnoreCase("TIEODJOB")) {
			instanceClass = Class.forName("com.bs.themebridge.adapter.impl.CustomizationEodAdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl.CustomizationEodAdapterImpl";

		} else {
			instanceClass = Class
					.forName("com.bs.themebridge.adapter.impl." + getReqServiceOperation() + "AdapterImpl");
			implementationClass = "com.bs.themebridge.adapter.impl." + getReqServiceOperation() + "AdapterImpl";
		}

		aInterfaceExtractor = (IServiceExtractor) instanceClass.newInstance();
		// logger.debug("Impl class name : " + implementationClass);
	}

	/**
	 * Method invoke
	 * 
	 * Based on the header information route the message to the corresponding
	 * service for implementation.
	 * 
	 * @param aClass
	 *            {@code allows object is }{@link String}
	 * @param aMethod
	 *            {@code allows object is }{@link String}
	 * @param params
	 *            {@code allows object is }{@link ClassArray}
	 * @param args
	 *            {@code allows object is }{@link ObjectArray}
	 * @return
	 */
	private static String invoke(String aClass, String aMethod, Class[] params, Object[] args) {

		String result = "";
		try {
			// logger.debug("ServiceRouter invoke process call initiated!");
			// logger.debug(" instantiate class --- > " + aClass);
			Class c = Class.forName(aClass);
			Method m = c.getDeclaredMethod(aMethod, params);
			Object i = c.newInstance();
			Object r = m.invoke(i, args);
			result = r.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		// logger.debug("ServiceRouter Process called");
		String finalResult = "";
		finalResult = invoke(implementationClass,
				// "com.bs.themebridge.adapterinterface.IServiceExtractor",
				"process", new Class[] { String.class }, new Object[] { inputXml });
		// logger.debug("Final Result *** : ServiceRouter ends here\n"
		// + finalResult);
		// logger.info("*** ServiceRouter ended! ***");
		return finalResult;
	}

	/**
	 * Method isActive
	 * 
	 * Check for active services according to ServiceManagement.jsp
	 * 
	 * @param ServiceOperation
	 *            : service +operation names of incoming services.
	 * @return mode of active services.
	 */
	public Boolean isActive(String ServiceOperation) {

		return true;

	}
}

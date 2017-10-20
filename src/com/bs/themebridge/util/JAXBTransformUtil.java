package com.bs.themebridge.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.ThemeBridgeStatusEnum;
import com.misys.tiplus2.services.control.ServiceResponse;

public class JAXBTransformUtil {

	public static Logger logger = Logger.getLogger(JAXBTransformUtil.class);

	/**
	 * To do JAXB Object marshalling
	 * 
	 * @param context
	 *            {@code allows object of } {@link JAXBContext}
	 * @param toDoObject
	 *            {@code allows object of } {@link ServiceRequest}
	 * @return {@link String}
	 */
	public static String doMarshalling(JAXBContext context, Object toDoObject) {
		String result = "";
		if (ValidationsUtil.isValidObject(toDoObject)) {
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ThemeBridgeStatusEnum statusEnum = ThemeBridgeStatusEnum.FAILED;
			try {
				Marshaller jaxbMarshaller = context.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(toDoObject, outStream);
				result = outStream.toString();
			} catch (Exception exp) {
				logger.error(exp.getMessage(), exp);
			} finally {
				try {
					outStream.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		} else {
			logger.debug("Marshalling object is not valid");
		}
		return result;
	}

	/**
	 * To do marshalling of JAXBObject and returns as string
	 * 
	 * @param context
	 *            {@code allows object of } {@link JAXBContext}
	 * @param toDoObject
	 *            {@code allows object of } {@link ServiceRequest}
	 * @return {@link String}
	 */
	public static String doMarshalling(ServiceResponse serviceResponse) {

		String resultXML = "";
		JAXBContext jaxbContext = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			jaxbContext = JAXBInstanceInitialiser.getResponseContext();
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(serviceResponse, baos);
			resultXML = baos.toString();

		} catch (JAXBException e) {
			logger.error("JAXBException -> " + e.getMessage(), e);

		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				logger.error("IOException -> " + e.getMessage(), e);
			}
		}
		return resultXML;
	}
}

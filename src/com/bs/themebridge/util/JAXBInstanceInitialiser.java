package com.bs.themebridge.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.misys.tiplus2.services.control.ServiceRequest;
import com.misys.tiplus2.services.control.ServiceResponse;

public class JAXBInstanceInitialiser {

	private final static Logger logger = Logger.getLogger(JAXBInstanceInitialiser.class);

	private static JAXBContext availBalContext_Req = null;
	private static JAXBContext availBalContext_Res = null;
	private static JAXBContext limitFacilityContext_Req = null;
	private static JAXBContext limitFacilityContext_Res = null;
	private static JAXBContext limitReservationContext_Req = null;
	private static JAXBContext limitReservationContext_Res = null;
	private static JAXBContext limitReservationReversalContext_Req = null;
	private static JAXBContext limitReservationReversalContext_Res = null;
	private static JAXBContext backOfficeBatchContext_Req = null;
	private static JAXBContext backOfficeBatchContext_Res = null;
	private static JAXBContext backOfficeVerification_Req = null;
	private static JAXBContext backOfficeVerification_Res = null;
	private static JAXBContext backOfficeFXUtilization_Req = null;
	private static JAXBContext backOfficeFXUtilization_Res = null;
	private static JAXBContext businessSupportFXContracts_Req = null;
	private static JAXBContext businessSupportFXContracts_Res = null;
	private static JAXBContext swiftOutContext_Req = null;
	private static JAXBContext swiftOutContext_Res = null;
	private static JAXBContext swiftInContext_Req = null;
	private static JAXBContext swiftInContext_Res = null;
	private static JAXBContext backOfficeBulkService_Req = null;
	private static JAXBContext backOfficeBulkService_Res = null;
	private static JAXBContext serviceRequest = null;
	private static JAXBContext serviceResponse = null;
	private static JAXBContext watchListContext_Res = null;
	private static JAXBContext responseContext_Res = null;

	// for static data
	private static JAXBContext fxRate_StaticData = null;
	private static JAXBContext spotRate_StaticData = null;
	private static JAXBContext biRate_StaticData = null;
	private static JAXBContext biRateCode_StaticData = null;
	private static JAXBContext relationManager_StaticData = null;
	private static JAXBContext customer_StaticData = null;
	private static JAXBContext account_StaticData = null;
	private static JAXBContext searchMasters_RequestData = null;
	private static JAXBContext strBicIbanContext_Req = null;
	private static JAXBContext strSwiftAddressContext_Req = null;
	private static JAXBContext strCountryCalendarContext_Req = null;
	private static JAXBContext strCurrencyCalendarContext_Req = null;

	/**
	 * Get instance of JAXBContext for AvailBal request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getAvailBalRequestContext() {
		if (availBalContext_Req == null) {
			// logger.debug("availBalContext_Req is null, so creating new
			// context");
			synchronized (JAXBContext.class) {
				if (availBalContext_Req == null) {
					// logger.debug("Context is null, so creating new context
					// inside SYNCHRONISED");
					try {
						availBalContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.AvailBal.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return availBalContext_Req;
	}

	/**
	 * Get instance of JAXBContext for AvailBal request
	 *
	 * @return {@link JAXBContext}
	 */
	@SuppressWarnings("unused")
	public static JAXBContext getNotificationRequestContext() {
		JAXBContext Notifications_Req = null;
		if (Notifications_Req == null) {
			// logger.debug("NotificationsContext_Req is null, so creating new
			// context");
			synchronized (JAXBContext.class) {
				if (Notifications_Req == null) {
					// logger.debug("Context is null, so creating new context
					// inside SYNCHRONISED");
					try {
						Notifications_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.Notifications.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		} else {
			// logger.info("Context is not null, so creating new context inside
			// SYNCHRONISED");
			try {
				Notifications_Req = JAXBContext
						.newInstance(com.misys.tiplus2.apps.ti.service.messages.Notifications.class);
			} catch (JAXBException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return Notifications_Req;
	}

	/**
	 * Get instance of JAXBContext for AccountAvailBal Response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getAvailBalResponseContext() {
		if (availBalContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (availBalContext_Res == null) {
					// logger.debug("availBalContext_Res is null, so creating
					// new context inside SYNCHRONISED");
					try {
						availBalContext_Res = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.AvailBalResponse.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return availBalContext_Res;
	}

	/**
	 * Get instance of JAXBContext for limitFacility request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getlimitFacilityRequestContext() {
		if (limitFacilityContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (limitFacilityContext_Req == null) {
					// logger.debug("limitFacilityContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						limitFacilityContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.FacilityRequest.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitFacilityContext_Req;
	}

	/**
	 * Get instance of JAXBContext for LimitFacility response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getLimitFacilityResponseContext() {
		if (limitFacilityContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (limitFacilityContext_Res == null) {
					// logger.debug("limitFacilityContext_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						limitFacilityContext_Res = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.FacilityResponse.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitFacilityContext_Res;
	}

	/**
	 * Get instance of JAXBContext for LimitReservation request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getLimitReservationRequestContext() {
		if (limitReservationContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (limitReservationContext_Req == null) {
					// logger.debug("limitReservationContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						limitReservationContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.ReservationRequest.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitReservationContext_Req;
	}

	/**
	 * Get instance of JAXBContext for LimitReservation response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getLimitReservationResponseContext() {
		if (limitReservationContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (limitReservationContext_Res == null) {
					// logger.debug("limitReservationContext_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						limitReservationContext_Res = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.ReservationResponse.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitReservationContext_Res;
	}

	/**
	 * Get instance of JAXBContext for LimitReservationReversal request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getLimitReservationReversalRequestContext() {
		if (limitReservationReversalContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (limitReservationReversalContext_Req == null) {
					// logger.debug(
					// "limitReservationReversalContext_Req is null, so creating
					// new context inside SYNCHRONISED");
					try {
						limitReservationReversalContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.ReservationReversal.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitReservationReversalContext_Req;
	}

	/**
	 * Get instance of JAXBContext for LimitReservationReversal response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getLimitReservationReversalResponseContext() {
		if (limitReservationReversalContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (limitReservationReversalContext_Res == null) {
					// logger.debug(
					// "limitReservationReversalContext_Res is null, so creating
					// new context inside SYNCHRONISED");
					try {
						limitReservationReversalContext_Res = JAXBContext.newInstance(
								com.misys.tiplus2.apps.ti.service.messages.ReservationReversalResponse.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return limitReservationReversalContext_Res;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeBatch request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeBatchRequestContext() {
		if (backOfficeBatchContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeBatchContext_Req == null) {
					// logger.debug("backOfficeBatchContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeBatchContext_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeBatchContext_Req;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeBatch response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeBatchResponseContext() {
		if (backOfficeBatchContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeBatchContext_Res == null) {
					// logger.debug("backOfficeBatchContext_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeBatchContext_Res = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeBatchContext_Res;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeVerification request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeRequestVerification() {
		if (backOfficeVerification_Req == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeVerification_Req == null) {
					// logger.debug("backOfficeVerification_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeVerification_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeVerification_Req;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeVerification response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeResponseVerification() {
		if (backOfficeVerification_Res == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeVerification_Res == null) {
					// logger.debug("backOfficeVerification_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeVerification_Res = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeVerification_Res;
	}

	/**
	 * Get instance of JAXBContext for SwiftOut Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSwiftOutRequestContext() {
		if (swiftOutContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (swiftOutContext_Req == null) {
					// logger.debug("swiftOutContext_Req is null, so creating
					// new context inside SYNCHRONISED");
					try {
						swiftOutContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.SWOPF.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return swiftOutContext_Req;
	}

	/**
	 * Get instance of JAXBContext for SwiftOut Response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSwiftOutResponseContext() {
		if (swiftOutContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (swiftOutContext_Res == null) {
					// logger.debug("swiftOutContext_Res is null, so creating
					// new context inside SYNCHRONISED");
					try {
						swiftOutContext_Res = JAXBContext.newInstance(ServiceResponse.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return swiftOutContext_Res;
	}

	/**
	 * Get instance of JAXBContext for ServiceRequest
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getServiceRequestContext() {
		if (serviceRequest == null) {
			// logger.debug("serviceRequest is null, so creating new context");
			synchronized (JAXBContext.class) {
				if (serviceRequest == null) {
					// logger.debug("Context is null, so creating new context
					// inside SYNCHRONISED");
					try {
						serviceRequest = JAXBContext.newInstance(ServiceRequest.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return serviceRequest;
	}

	/**
	 * Get instance of JAXBContext for ServiceResponse
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getServiceResponseContext() {
		if (serviceResponse == null) {
			// logger.debug("serviceResponse is null, so creating new context");
			synchronized (JAXBContext.class) {
				if (serviceResponse == null) {
					// logger.debug("Context is null, so creating new context
					// inside SYNCHRONISED");
					try {
						serviceResponse = JAXBContext.newInstance(ServiceResponse.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return serviceResponse;
	}

	/**
	 * Get instance of JAXBContext for STRFXRate
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getFXRateRequestContext() {
		if (fxRate_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (fxRate_StaticData == null) {
					// logger.debug("fxRate_StaticData is null, so creating new
					// context inside SYNCHRONISED");
					try {
						fxRate_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRFXRate.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return fxRate_StaticData;
	}

	/**
	 * Get instance of JAXBContext for STRSpotRate
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSpotRateRequestContext() {
		if (spotRate_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (spotRate_StaticData == null) {
					// logger.debug("spotRate_StaticData is null, so creating
					// new context inside SYNCHRONISED");
					try {
						spotRate_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRCurrencySpotRate.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return spotRate_StaticData;
	}

	/**
	 * Get instance of JAXBContext for STRBaseRate
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBaseRateRequestContext() {
		if (biRate_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (biRate_StaticData == null) {
					// logger.debug("biRate_StaticData is null, so creating new
					// context inside SYNCHRONISED");
					try {
						biRate_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRBaseRate.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return biRate_StaticData;
	}

	/**
	 * Get instance of JAXBContext for STRBaseRate
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBaseRateCodeRequestContext() {
		if (biRateCode_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (biRateCode_StaticData == null) {
					// logger.debug("biRateCode_StaticData is null, so creating
					// new context inside SYNCHRONISED");
					try {
						biRateCode_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRBaseRateCode.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return biRateCode_StaticData;
	}

	/**
	 * Get instance of JAXBContext for STRAccountOfficer
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getAccountOfficerRequestContext() {
		if (relationManager_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (relationManager_StaticData == null) {
					// logger.debug("relationManager_StaticData is null, so
					// creating new context inside SYNCHRONISED");
					try {
						relationManager_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRAccountOfficer.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return relationManager_StaticData;
	}

	/**
	 * Get instance of JAXBContext for Customer
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getCustomerRequestContext() {
		if (customer_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (customer_StaticData == null) {
					// logger.debug("customer_StaticData is null, so creating
					// new context inside SYNCHRONISED");
					try {
						customer_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.Customer.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return customer_StaticData;
	}

	/**
	 * Get instance of JAXBContext for STRAccount
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getAccountRequestContext() {
		if (account_StaticData == null) {
			synchronized (JAXBContext.class) {
				if (account_StaticData == null) {
					// logger.debug("account_StaticData is null, so creating new
					// context inside SYNCHRONISED");
					try {
						account_StaticData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRAccount.class);
					} catch (JAXBException jaxbExp) {
						logger.error(jaxbExp);
					}
				}
			}
		}
		return account_StaticData;
	}

	/**
	 * Get instance of JAXBContext for SwiftIn Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSwiftInRequestContext() {
		if (swiftInContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (swiftInContext_Req == null) {
					// logger.debug("swiftInContext_Req is null, so creating new
					// context inside SYNCHRONISED");
					try {
						swiftInContext_Req = JAXBContext.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return swiftInContext_Req;
	}

	/**
	 * Get instance of JAXBContext for SwiftIn Response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSwiftInResponseContext() {
		if (swiftInContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (swiftInContext_Res == null) {
					// logger.debug("swiftInContext_Res is null, so creating new
					// context inside SYNCHRONISED");
					try {
						swiftInContext_Res = JAXBContext.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return swiftInContext_Res;
	}

	/**
	 * Get instance of JAXBContext for SwiftIn Response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSearchMasterRequestContext() {
		if (searchMasters_RequestData == null) {
			synchronized (JAXBContext.class) {
				if (searchMasters_RequestData == null) {
					// logger.debug("searchMasters_RequestData is null, so
					// creating new context inside SYNCHRONISED");
					try {
						searchMasters_RequestData = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.SearchMastersRequest.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return searchMasters_RequestData;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeFXUtilization request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeFXUtilizationRequestContext() {
		if (backOfficeFXUtilization_Req == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeFXUtilization_Req == null) {
					// logger.debug("backOfficeFXUtilization_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeFXUtilization_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeFXUtilization_Req;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeFXUtilization response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeFXUtilizationResponseContext() {
		if (backOfficeFXUtilization_Res == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeBatchContext_Res == null) {
					// logger.debug("backOfficeBatchContext_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeBatchContext_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeFXUtilization_Res;
	}

	/**
	 * Get instance of JAXBContext for BusinessSupportFXContracts request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBusinessSupportFXRateRequestContext() {
		if (businessSupportFXContracts_Req == null) {
			synchronized (JAXBContext.class) {
				if (businessSupportFXContracts_Req == null) {
					// logger.debug("businessSupportFXContracts_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						businessSupportFXContracts_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return businessSupportFXContracts_Req;
	}

	/**
	 * Get instance of JAXBContext for BusinessSupportFXContracts response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBusinessSupportFXRateResponseContext() {
		if (businessSupportFXContracts_Res == null) {
			synchronized (JAXBContext.class) {
				if (businessSupportFXContracts_Res == null) {
					// logger.debug("businessSupportFXContracts_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						businessSupportFXContracts_Res = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return businessSupportFXContracts_Res;
	}

	/**
	 * Get instance of JAXBContext for SwiftBicIban Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSTRBicIbanRequestContext() {
		if (strBicIbanContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (strBicIbanContext_Req == null) {
					// logger.debug("swiftInContext_Req is null, so creating new
					// context inside SYNCHRONISED");
					try {
						strBicIbanContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRBICPlusIBAN.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return strBicIbanContext_Req;
	}

	/**
	 * Get instance of JAXBContext for SWIFTAddress Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSTRSwiftAddressRequestContext() {
		if (strSwiftAddressContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (strSwiftAddressContext_Req == null) {
					// logger.debug("strSwiftAddressContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						strSwiftAddressContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRSwiftAddress.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return strSwiftAddressContext_Req;
	}

	/**
	 * Get instance of JAXBContext for SWIFTAddress Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSTRCountryCalendarRequestContext() {
		if (strCountryCalendarContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (strCountryCalendarContext_Req == null) {
					// logger.debug("strCountryCalendarContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						strCountryCalendarContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRCountryCalendar.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return strCountryCalendarContext_Req;
	}

	/**
	 * Get instance of JAXBContext for SWIFTAddress Request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getSTRCurrencyCalendarRequestContext() {
		if (strCurrencyCalendarContext_Req == null) {
			synchronized (JAXBContext.class) {
				if (strCurrencyCalendarContext_Req == null) {
					// logger.debug("strCurrencyCalendarContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						strCurrencyCalendarContext_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRCurrencyCalendar.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return strCurrencyCalendarContext_Req;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeBulkService request
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeBulkRequestContext() {
		if (backOfficeBulkService_Req == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeBulkService_Req == null) {
					// logger.debug("backOfficeBatchContext_Req is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeBulkService_Req = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeBulkService_Req;
	}

	/**
	 * Get instance of JAXBContext for BackOfficeBulkService response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getBackOfficeBulkResponseContext() {
		if (backOfficeBulkService_Res == null) {
			synchronized (JAXBContext.class) {
				if (backOfficeBulkService_Res == null) {
					// logger.debug("backOfficeBatchContext_Res is null, so
					// creating new context inside SYNCHRONISED");
					try {
						backOfficeBulkService_Res = JAXBContext
								.newInstance("com.misys.tiplus2.apps.ti.service.messages");
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return backOfficeBulkService_Res;
	}

	private static JAXBContext STRCustomer_Req = null;

	public static JAXBContext getSTRCustomerRequestContext() {
		if (STRCustomer_Req == null) {
			synchronized (JAXBContext.class) {
				if (STRCustomer_Req == null) {
					// logger.debug("STRCustomer_Req is null, so creating new
					// context inside SYNCHRONISED");
					try {
						STRCustomer_Req = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.STRCustomer.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return STRCustomer_Req;
	}

	public static JAXBContext getWatchListResponseContext() {
		if (watchListContext_Res == null) {
			synchronized (JAXBContext.class) {
				if (watchListContext_Res == null) {
					// logger.debug("watchlistContext_Res is null, so creating
					// new context inside SYNCHRONISED");
					try {
						watchListContext_Res = JAXBContext
								.newInstance(com.misys.tiplus2.apps.ti.service.messages.GWRIWLC.class);
					} catch (JAXBException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return watchListContext_Res;
	}

	/**
	 * ONETIME INITALIZATION OF JAXB CONTEXT WHEN THEMEBRIDGE STARTED
	 */
	public static void initializeAllContext() {
		// logger.debug("Starting initialising Context");
		getAvailBalRequestContext();
		getAvailBalResponseContext();
		getlimitFacilityRequestContext();
		getLimitFacilityResponseContext();
		getLimitReservationRequestContext();
		getLimitReservationResponseContext();
		getLimitReservationReversalRequestContext();
		getLimitReservationReversalResponseContext();
		getSwiftOutRequestContext();
		getSwiftOutResponseContext();
		getBackOfficeBatchRequestContext();
		getBackOfficeBatchResponseContext();
		getBackOfficeRequestVerification();
		getBackOfficeResponseVerification();
		getBackOfficeFXUtilizationRequestContext();
		getBackOfficeFXUtilizationResponseContext();
		getBusinessSupportFXRateRequestContext();
		getBusinessSupportFXRateResponseContext();
		getServiceResponseContext();
		getFXRateRequestContext();
		getBaseRateRequestContext();
		getAccountRequestContext();
		getCustomerRequestContext();
		getAccountOfficerRequestContext();
		getSwiftInRequestContext();
		getSwiftInResponseContext();
		getSTRBicIbanRequestContext();
		getSTRCountryCalendarRequestContext();
		getSTRCurrencyCalendarRequestContext();
		getSTRCustomerRequestContext();
		getWatchListResponseContext();
	}

	/**
	 * Get instance of JAXBContext for CustomerSearch response
	 * 
	 * @return {@link JAXBContext}
	 */
	public static JAXBContext getResponseContext() {
		if (responseContext_Res == null) {
			// logger.debug("responseContext_Res is null, so creating new
			// context");
			synchronized (JAXBContext.class) {
				if (responseContext_Res == null) {
					// logger.debug("Context is null, so creating new context
					// inside SYNCHRONISED");
					try {
						responseContext_Res = JAXBContext.newInstance("com.misys.tiplus2.apps.ti.service.messages");

					} catch (JAXBException e) {
						logger.error("JAXBException -> " + e.getMessage(), e);
					}
				}
			}
		}
		return responseContext_Res;
	}

}

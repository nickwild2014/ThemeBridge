package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupCurrencyCode;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupCurrencyCodeAdapter extends ThemeBridgeEntityManager {

	public LookupCurrencyCodeAdapter() {
		super();
	}

	/**
	 * To add a LookupCurrencyCode log data object
	 * 
	 * @param lookupaccounttype
	 */
	public void addProperty(LookupCurrencyCode lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCurrencyCode log added successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.error("Entity manager is null");
		}
	}

	/**
	 * To get all LookupCurrencyCode log data values
	 * 
	 * @return List<LookupCurrencyCode>
	 */
	public List<LookupCurrencyCode> getAllProperties() {
		List<LookupCurrencyCode> lookupCurrencyCodeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCurrencyCode.findAll");
				lookupCurrencyCodeList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupCurrencyCodeList;
	}

	/**
	 * To get LookupCurrencyCode log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public LookupCurrencyCode getKeyProperty(String id) {
		LookupCurrencyCode lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupAccountType = entityManager.find(LookupCurrencyCode.class, new BigDecimal(id));
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupAccountType;
	}

	/**
	 * To update a LookupCurrencyCode log data value
	 * 
	 * @param lookupaccounttype
	 */
	public void updateProperty(LookupCurrencyCode lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCurrencyCode log data modified
				// successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
	}

	/**
	 * To remove a LookupCurrencyCode log data value
	 * 
	 * @param lookupaccounttype
	 */
	public void removeProperty(LookupCurrencyCode lookupaccounttype) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupaccounttype)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupaccounttype);
				entityManager.getTransaction().commit();
				// logger.debug("LookupCurrencyCode log data removed
				// successfully");
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
	}

	/**
	 * To get limited count of service values
	 * <p>
	 * {@code Default limit count is 200}
	 * </p>
	 * 
	 * @return List<LookupCurrencyCode>
	 */
	public List<LookupCurrencyCode> getLimitCountProperties() {
		List<LookupCurrencyCode> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCurrencyCode.findAll");
				query.setMaxResults(200);
				serviceList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return serviceList;
	}

	/**
	 * To get service log data values with masterReference, eventReference,
	 * operation
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link LookupCurrencyCode}
	 */
	public LookupCurrencyCode getLookupCurrencyCodeByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupCurrencyCode lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("LookupCurrencyCode.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupAccountType = (LookupCurrencyCode) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupCurrencyCode log missing mandatory field(s)");
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupAccountType;
	}

	/**
	 * To get logging page LookupCurrencyCode log data values
	 * 
	 * @return List<LookupCurrencyCode>
	 */
	public List<LookupCurrencyCode> getLoggingListTransactionProperties() {
		List<LookupCurrencyCode> lookupcurrencytypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupCurrencyCode.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					lookupcurrencytypeList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupcurrencytypeList;
	}

}

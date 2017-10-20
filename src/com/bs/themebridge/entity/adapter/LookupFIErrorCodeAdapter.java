package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupFinacleErrorCode;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupFIErrorCodeAdapter extends ThemeBridgeEntityManager {

	public LookupFIErrorCodeAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param lookupfinacleerrcode
	 */
	public void addProperty(LookupFinacleErrorCode lookupfinacleerrcode) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfinacleerrcode)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupfinacleerrcode);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFinacleErrorCode log added
				// successfully");
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
	 * To get all service log data values
	 * 
	 * @return List<LookupFinacleErrorCode>
	 */
	public List<LookupFinacleErrorCode> getAllProperties() {
		List<LookupFinacleErrorCode> lookupAccountTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFinacleErrorCode.findAll");
				lookupAccountTypeList = query.getResultList();
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}

		return lookupAccountTypeList;
	}

	/**
	 * To get service log data value of primary key
	 * 
	 * @param id
	 * @return Object
	 */
	public LookupFinacleErrorCode getKeyProperty(String id) {
		LookupFinacleErrorCode lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupAccountType = entityManager.find(LookupFinacleErrorCode.class, new BigDecimal(id));
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
	 * To update a service log data value
	 * 
	 * @param lookupfinacleerrcode
	 */
	public void updateProperty(LookupFinacleErrorCode lookupfinacleerrcode) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfinacleerrcode)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupfinacleerrcode);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFinacleErrorCode log data modified
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
	 * To remove a service log data value
	 * 
	 * @param lookupfinacleerrcode
	 */
	public void removeProperty(LookupFinacleErrorCode lookupfinacleerrcode) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupfinacleerrcode)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupfinacleerrcode);
				entityManager.getTransaction().commit();
				// logger.debug("LookupFinacleErrorCode log data removed
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
	 * @return List<LookupFinacleErrorCode>
	 */
	public List<LookupFinacleErrorCode> getLimitCountProperties() {
		List<LookupFinacleErrorCode> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFinacleErrorCode.findAll");
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
	 * @return {@link LookupFinacleErrorCode}
	 */
	public LookupFinacleErrorCode getLookupAccountTypeByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupFinacleErrorCode lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager
							.createNamedQuery("LookupFinacleErrorCode.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupAccountType = (LookupFinacleErrorCode) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupFinacleErrorCode log missing mandatory field(s)");
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
	 * To get logging page service log data values
	 * 
	 * @return List<LookupFinacleErrorCode>
	 */
	public List<LookupFinacleErrorCode> getLoggingListTransactionProperties() {
		List<LookupFinacleErrorCode> lookupaccounttypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupFinacleErrorCode.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					lookupaccounttypeList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupaccounttypeList;
	}

}

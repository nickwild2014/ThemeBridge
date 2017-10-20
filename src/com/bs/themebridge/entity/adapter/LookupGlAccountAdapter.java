package com.bs.themebridge.entity.adapter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.bs.themebridge.entity.model.LookupGlAccount;
import com.bs.themebridge.entity.util.ThemeBridgeEntityManager;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class LookupGlAccountAdapter extends ThemeBridgeEntityManager {

	public LookupGlAccountAdapter() {
		super();
	}

	/**
	 * To add a service log data object
	 * 
	 * @param lookupglaccount
	 */
	public void addProperty(LookupGlAccount lookupglaccount) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupglaccount)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(lookupglaccount);
				entityManager.getTransaction().commit();
				// logger.debug("LookupGlAccount log added successfully");
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
	 * @return List<LookupGlAccount>
	 */
	public List<LookupGlAccount> getAllProperties() {
		List<LookupGlAccount> lookupAccountTypeList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupGlAccount.findAll");
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
	public LookupGlAccount getKeyProperty(String id) {
		LookupGlAccount lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidString(id)) {
			try {
				if (ValidationsUtil.isValidString(id)) {
					entityManager.getTransaction().begin();
					lookupAccountType = entityManager.find(LookupGlAccount.class, new BigDecimal(id));
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
	 * @param lookupglaccount
	 */
	public void updateProperty(LookupGlAccount lookupglaccount) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupglaccount)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(lookupglaccount);
				entityManager.getTransaction().commit();
				// logger.debug("LookupGlAccount log data modified
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
	 * @param lookupglaccount
	 */
	public void removeProperty(LookupGlAccount lookupglaccount) {
		if (ValidationsUtil.isValidObject(entityManager) && ValidationsUtil.isValidObject(lookupglaccount)) {
			try {
				entityManager.getTransaction().begin();
				entityManager.remove(lookupglaccount);
				entityManager.getTransaction().commit();
				// logger.debug("LookupGlAccount log data removed
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
	 * @return List<LookupGlAccount>
	 */
	public List<LookupGlAccount> getLimitCountProperties() {
		List<LookupGlAccount> serviceList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupGlAccount.findAll");
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
	 * @return {@link LookupGlAccount}
	 */
	public LookupGlAccount getLookupGlAccountByMasterEventReferenceOperation(String masterReference,
			String eventReference, String operation) {
		LookupGlAccount lookupAccountType = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				if (ValidationsUtil.isValidString(operation) && ValidationsUtil.isValidString(masterReference)
						&& ValidationsUtil.isValidString(eventReference)) {
					entityManager.getTransaction().begin();
					Query query = entityManager.createNamedQuery("LookupGlAccount.findByTIEventReferenceOperation");
					query.setParameter("masterreference", masterReference);
					query.setParameter("eventreference", eventReference);
					query.setParameter("operation", operation);
					if (ValidationsUtil.isValidList(query.getResultList())) {
						lookupAccountType = (LookupGlAccount) query.getResultList().get(0);
					}
				} else {
					logger.error("LookupGlAccount log missing mandatory field(s)");
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
	 * @return List<LookupGlAccount>
	 */
	public List<LookupGlAccount> getLoggingListTransactionProperties() {
		List<LookupGlAccount> lookupglaccountList = null;
		if (ValidationsUtil.isValidObject(entityManager)) {
			try {
				entityManager.getTransaction().begin();
				Query query = entityManager.createNamedQuery("LookupGlAccount.findByLogList");
				if (ValidationsUtil.isValidList(query.getResultList())) {
					lookupglaccountList = query.getResultList();
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} finally {
				entityManager.close();
			}
		} else {
			logger.debug("Entity Manager is null");
		}
		return lookupglaccountList;
	}

}
